package com.opentext.axcelerate.adpkt.model

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.opentext.axcelerate.adpkt.client.Client
import com.opentext.axcelerate.adpkt.task.ListEntitiesRequest
import com.opentext.axcelerate.adpkt.task.QueryEngineRequest
import com.opentext.axcelerate.adpkt.task.TaxonomyStatisticRequest

class Service() {
    companion object {

        private lateinit var client: Client

        fun initialize(endpoint: String, user: String, password: String) {
            client = Client(endpoint, user, password)
        }

        fun listEntities(req: ListEntitiesRequest): String {
            val mapper = jacksonObjectMapper()
            val meta = client.run(mapper.writeValueAsString(req))

            val root = mapper.readTree(meta)
            return mapper.readTree(
                root.get("adp_entities_json_output").asText()
            )
                .toPrettyString()
        }

        fun taxonomyStatistic(req: TaxonomyStatisticRequest): String {
            val mapper = jacksonObjectMapper()
            val meta = client.run(mapper.writeValueAsString(req))

            val root = mapper.readTree(meta)
            return mapper.readTree(
                root.get("adp_taxonomy_statistics_json_output").asText()
            )
                .toPrettyString()
        }

        fun queryEngine(req: QueryEngineRequest): String {
            val mapper = jacksonObjectMapper()
            val meta = client.run(mapper.writeValueAsString(req))

            val root = mapper.readTree(meta)
            return root.toPrettyString()
        }
    }
}

