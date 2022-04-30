package com.opentext.axcelerate.adp.kotlin.model

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.opentext.axcelerate.adp.kotlin.client.Client
import com.opentext.axcelerate.adp.kotlin.task.*

class Service {
    companion object {
        private lateinit var client: Client

        @JvmStatic
        fun asyncOutput(resp: TaskResponse): String {
            return jacksonObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false)
                .writeValueAsString(resp)
        }

        @JvmStatic
        fun initialize(endpoint: String, user: String, password: String, taskAccessKey: String?) {
            client = Client(endpoint, user, password, taskAccessKey)
        }

        @JvmStatic
        fun listEntities(req: ListEntitiesRequest): String {
            val resp = client.executeTask(req)
            if ( req.isAsync() ) { return asyncOutput(resp) }

            if (resp.executionStatus != "success") throw Exception("ADP Task ${resp.taskDisplayName}: ${resp.errorMessage}")
            return jacksonObjectMapper().readTree(
                    resp.executionMetaData!!.get("adp_entities_json_output").asText()
                )
                .toPrettyString()
        }

        @JvmStatic
        fun taxonomyStatistic(req: TaxonomyStatisticRequest): String {
            val resp = client.executeTask(req)
            if ( req.isAsync() ) { return asyncOutput(resp) }

            if (resp.executionStatus != "success") throw Exception("ADP Task ${resp.taskDisplayName}: ${resp.errorMessage}")
            return jacksonObjectMapper().readTree(
                    resp.executionMetaData!!
                        .get("adp_taxonomy_statistics_json_output")
                        .asText()
                )
                .toPrettyString()
        }

        @JvmStatic
        fun queryEngine(req: QueryEngineRequest): String {
            val resp = client.executeTask(req)
            if ( req.isAsync() ) { return asyncOutput(resp) }

            if (resp.executionStatus != "success") throw Exception("ADP Task ${resp.taskDisplayName}: ${resp.errorMessage}")
            return resp.executionMetaData!!.toPrettyString()
        }

        @JvmStatic
        fun createCustodian(req: CreateCustodianRequest): String {
            val resp = client.executeTask(req)
            if ( req.isAsync() ) { return asyncOutput(resp) }

            if (resp.executionStatus != "success") throw Exception("ADP Task ${resp.taskDisplayName}: ${resp.errorMessage}")
            return resp.executionMetaData!!.toPrettyString()
        }

        @JvmStatic
        fun createDataSource(req: CreateDataSourceRequest): String {
            val resp = client.executeTask(req)
            if ( req.isAsync() ) { return asyncOutput(resp) }

            if (resp.executionStatus != "success") throw Exception("ADP Task ${resp.taskDisplayName}: ${resp.errorMessage}")
            return resp.executionMetaData!!.toPrettyString()
        }

        @JvmStatic
        fun queryPostgresqlDB(req: QueryPostgresqlDBRequest): String {
            val resp = client.executeTask(req)
            if ( req.isAsync() ) { return asyncOutput(resp) }

            if (resp.executionStatus != "success") throw Exception("ADP Task ${resp.taskDisplayName}: ${resp.errorMessage}")
            return jacksonObjectMapper().readTree(
                resp.executionMetaData!!
                    .get("adp_querydb_outputjson")
                    .asText()
                )
                .toPrettyString()
        }

        @JvmStatic
        fun startApplication(req: StartApplicationRequest): String {
            val resp = client.executeTask(req)
            if ( req.isAsync() ) { return asyncOutput(resp) }

            if (resp.executionStatus != "success") throw Exception("ADP Task ${resp.taskDisplayName}: ${resp.errorMessage}")
            return resp.executionMetaData!!.toPrettyString()
        }
    }
}