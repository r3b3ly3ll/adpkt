package com.opentext.axcelerate.adp.kotlin.task

import com.opentext.axcelerate.adp.kotlin.args.EngineTaxonomy
import com.opentext.axcelerate.adp.kotlin.args.Util
import org.junit.Test
import kotlin.test.assertEquals

class QueryEngineRequestTest {
    @Test
    fun testQueryEngineRequest() {
        val taxonomies: ArrayList<EngineTaxonomy> = ArrayList(0)

        // reset displayName and description
        val req = QueryEngineRequest(
            taskDisplayName = "Query Engine",
            taskDescription = "Query Engine",
            taskConfiguration = QueryEngineConfiguration(
                adpQueryEngineEngineTaxonomies = taxonomies,
                adpQueryEngineEngineName = "singleMindServer.G0001",
            )
        )

        val expected = """{"taskType":"Query Engine","taskDescription":"Query Engine","taskDisplayName":"Query Engine","taskConfiguration":{"adp_queryEngine_engineTaxonomies":[],"adp_queryEngine_engineName":"singleMindServer.G0001","adp_loggingEnabled":false}}"""
        assertEquals(expected, req.toJson())
    }

    @Test
    fun testQueryEngineRequestWithEngineTaxonomies() {
        val arrayOfEngineTaxonomies = Util.stringToEngineTaxonomies("rm_custodian!=John Doe,rm_copy=Native")

        // reset displayName and description
        val req = QueryEngineRequest(
            taskDisplayName = "Query Engine",
            taskDescription = "Query Engine",
            taskConfiguration = QueryEngineConfiguration(
                adpQueryEngineEngineTaxonomies = arrayOfEngineTaxonomies,
                adpQueryEngineEngineName = "singleMindServer.G0001",
            )
        )

        val expected = """{"taskType":"Query Engine","taskDescription":"Query Engine","taskDisplayName":"Query Engine","taskConfiguration":{"adp_queryEngine_engineTaxonomies":[{"Taxonomy":"rm_custodian","Negation":true,"Query":"John Doe"},{"Taxonomy":"rm_copy","Negation":false,"Query":"Native"}],"adp_queryEngine_engineName":"singleMindServer.G0001","adp_loggingEnabled":false}}"""
        assertEquals(expected, req.toJson())
    }
}