package com.opentext.axcelerate.adp.kotlin.client

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.opentext.axcelerate.adp.kotlin.task.TaskRequest
import com.opentext.axcelerate.adp.kotlin.task.TaskResponse
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException
import javax.net.ssl.SSLContext

class Client(private val endpoint: String, private val user: String, private val password: String, private val taskAccessKey: String?) {
    private var okHttpClient: OkHttpClient

    init {
        val trustAllCerts = arrayOf<CustomX509TrustManager> (CustomX509TrustManager())
        val sslContext: SSLContext = SSLContext.getInstance("SSL")
        sslContext.init(null, trustAllCerts, java.security.SecureRandom())

        okHttpClient = OkHttpClient.Builder()
            .sslSocketFactory(sslContext.socketFactory, trustAllCerts[0])
            .hostnameVerifier { _, _ -> true }
            .build()
    }

    fun executeTask(taskReq: TaskRequest): TaskResponse {
        var execPath = "/adp/rest/api/task/executeAdpTask"
        if ( taskReq.isAsync() ) { execPath += "Async" }

        val builder = Request.Builder()
            .url(this.endpoint + execPath)
            .addHeader("Auth-Username", this.user)
            .addHeader("Auth-Password", this.password)

        if (!this.taskAccessKey.isNullOrEmpty()) {
            builder.addHeader("Task-Access-Key", this.taskAccessKey)
        }

        val req: Request = builder
            .put(taskReq
                .toJson()
                .toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())
            )
            .build()

        this.okHttpClient.newCall(req).execute().use { resp ->
            if (!resp.isSuccessful) throw IOException("Unexpected code $resp")

            return jacksonObjectMapper().readValue(resp.body!!.string())
        }
    }
}
