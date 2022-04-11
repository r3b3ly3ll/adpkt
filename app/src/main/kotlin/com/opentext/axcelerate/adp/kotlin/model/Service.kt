package com.opentext.axcelerate.adp.kotlin.model

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.opentext.axcelerate.adp.kotlin.client.Client
import com.opentext.axcelerate.adp.kotlin.task.*

class Service {
    companion object {

        private lateinit var client: Client

        @JvmStatic
        fun initialize(endpoint: String, user: String, password: String) {
            client = Client(endpoint, user, password)
        }

        @JvmStatic
        fun listEntities(req: ListEntitiesRequest): String {
            val mapper = jacksonObjectMapper()
            val meta = client.run(mapper.writeValueAsString(req))

            val root = mapper.readTree(meta)
            return mapper.readTree(
                root.get("adp_entities_json_output").asText()
            )
                .toPrettyString()
        }

        @JvmStatic
        fun taxonomyStatistic(req: TaxonomyStatisticRequest): String {
            val mapper = jacksonObjectMapper()
            val meta = client.run(mapper.writeValueAsString(req))

            val root = mapper.readTree(meta)
            return mapper.readTree(
                root.get("adp_taxonomy_statistics_json_output").asText()
            )
                .toPrettyString()
        }

        @JvmStatic
        fun queryEngine(req: QueryEngineRequest): String {
            val mapper = jacksonObjectMapper()
            val meta = client.run(mapper.writeValueAsString(req))

            val root = mapper.readTree(meta)
            return root.toPrettyString()
        }

        @JvmStatic
        fun createCustodian(req: CreateCustodianRequest): String {
            val mapper = jacksonObjectMapper()
            val meta = client.run(mapper.writeValueAsString(req))

            val root = mapper.readTree(meta)
            return root.toPrettyString()
        }

        @JvmStatic
        fun createDataSource(req: CreateDataSourceRequest): String {
            val mapper = jacksonObjectMapper()
            val meta = client.run(mapper.writeValueAsString(req))

            val root = mapper.readTree(meta)
            return root.toPrettyString()
        }
    }
}

