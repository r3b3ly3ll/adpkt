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
        fun listEntities(req: ListEntitiesRequest, async: Boolean = false): String {
            val resp = client.run(req.toJson(), async)
            if (async) { return asyncOutput(resp) }

            if (resp.executionStatus != "success") throw Exception("ADP Task ${resp.taskDisplayName} failed")
            return jacksonObjectMapper().readTree(
                    resp.executionMetaData!!.get("adp_entities_json_output").asText()
                )
                .toPrettyString()
        }

        @JvmStatic
        fun taxonomyStatistic(req: TaxonomyStatisticRequest, async: Boolean = false): String {
            val resp = client.run(req.toJson(), async)
            if (async) { return asyncOutput(resp) }

            if (resp.executionStatus != "success") throw Exception("ADP Task ${resp.taskDisplayName} failed")
            return jacksonObjectMapper().readTree(
                    resp.executionMetaData!!
                        .get("adp_taxonomy_statistics_json_output")
                        .asText()
                )
                .toPrettyString()
        }

        @JvmStatic
        fun queryEngine(req: QueryEngineRequest, async: Boolean = false): String {
            val resp = client.run(req.toJson(), async)
            if (async) { return asyncOutput(resp) }

            if (resp.executionStatus != "success") throw Exception("ADP Task ${resp.taskDisplayName} failed")
            return resp.executionMetaData!!.toPrettyString()
        }

        @JvmStatic
        fun createCustodian(req: CreateCustodianRequest, async: Boolean = false): String {
            val resp = client.run(req.toJson(), async)
            if (async) { return asyncOutput(resp) }

            if (resp.executionStatus != "success") throw Exception("ADP Task ${resp.taskDisplayName} failed")
            return resp.executionMetaData!!.toPrettyString()
        }

        @JvmStatic
        fun createDataSource(req: CreateDataSourceRequest, async: Boolean = false): String {
            val resp = client.run(req.toJson(), async)
            if (async) { return asyncOutput(resp) }

            if (resp.executionStatus != "success") throw Exception("ADP Task ${resp.taskDisplayName} failed")
            return resp.executionMetaData!!.toPrettyString()
        }

        @JvmStatic
        fun queryPostgresqlDB(req: QueryPostgresqlDBRequest, async: Boolean = false): String {
            val resp = client.run(req.toJson(), async)
            if (async) { return asyncOutput(resp) }

            if (resp.executionStatus != "success") throw Exception("ADP Task ${resp.taskDisplayName} failed")
            return jacksonObjectMapper().readTree(
                resp.executionMetaData!!
                    .get("adp_querydb_outputjson")
                    .asText()
                )
                .toPrettyString()
        }
    }
}