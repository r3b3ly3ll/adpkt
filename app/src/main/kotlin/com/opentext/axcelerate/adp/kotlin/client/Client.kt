package com.opentext.axcelerate.adp.kotlin.client

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.opentext.axcelerate.adp.kotlin.task.TaskResponse
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException
import javax.net.ssl.SSLContext

class Client(private val endpoint: String, private val user: String, private val password: String ) {
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

    fun run(jsonBody: String): String {
        val req: Request = Request.Builder()
            .url(this.endpoint + "/adp/rest/api/task/executeAdpTask")
            .addHeader("Auth-Username", this.user)
            .addHeader("Auth-Password", this.password)
            .put(jsonBody
                .toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())
            )
            .build()

        this.okHttpClient.newCall(req).execute().use  { resp ->
            if (!resp.isSuccessful)  throw IOException("Unexpected code $resp")

            val mapper = jacksonObjectMapper()
            val taskResp =  mapper.readValue<TaskResponse>(resp.body!!.string())
            if (taskResp.executionStatus != "success") throw Exception("ADP Task ${taskResp.taskDisplayName} failed")

            return taskResp.executionMetaData.toString()
        }
    }
}
