package com.opentext.axcelerate.adp.kotlin.task

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.opentext.axcelerate.adp.kotlin.args.EngineTaxonomy
import org.junit.Test
import kotlin.test.assertEquals

class QueryEngineRequestTest {
    @Test
    fun testQueryEngineRequest() {
        var taxonomies: ArrayList<EngineTaxonomy> = ArrayList(0)

        // reset displayName and description
        val req = QueryEngineRequest(
            taskDisplayName = "Query Engine",
            taskDescription = "Query Engine",
            taskConfiguration = QueryEngineConfiguration(
                adpQueryEngineEngineTaxonomies = taxonomies,
                adpQueryEngineEngineName = "singleMindServer.G0001",
            )
        )

        val expected = """{"taskType":"Query Engine","taskDescription":"Query Engine","taskDisplayName":"Query Engine","taskConfiguration":{"adp_queryEngine_engineTaxonomies":[],"adp_queryEngine_engineName":"singleMindServer.G0001"}}"""
        assertEquals(expected, jacksonObjectMapper().writeValueAsString(req))
    }

    @Test
    fun testQueryEngineRequestWithEngineTaxonomies() {
        val engineTaxonomies = "rm_custodian!=John Doe,rm_copy=Native"
        val taxonomies: ArrayList<EngineTaxonomy> = ArrayList(0)

        if (engineTaxonomies.isNotEmpty()) {
            for (taxonomy in engineTaxonomies.split(",")) {
                try {
                    taxonomies += EngineTaxonomy(taxonomy)
                } catch(e: Exception) {
                    continue
                }
            }
        }
        // reset displayName and description
        val req = QueryEngineRequest(
            taskDisplayName = "Query Engine",
            taskDescription = "Query Engine",
            taskConfiguration = QueryEngineConfiguration(
                adpQueryEngineEngineTaxonomies = taxonomies,
                adpQueryEngineEngineName = "singleMindServer.G0001",
            )
        )

        val expected = """{"taskType":"Query Engine","taskDescription":"Query Engine","taskDisplayName":"Query Engine","taskConfiguration":{"adp_queryEngine_engineTaxonomies":[{"Taxonomy":"rm_custodian","Negation":true,"Query":"John Doe"},{"Taxonomy":"rm_copy","Negation":false,"Query":"Native"}],"adp_queryEngine_engineName":"singleMindServer.G0001"}}"""
        assertEquals(expected, jacksonObjectMapper().writeValueAsString(req))
    }
}