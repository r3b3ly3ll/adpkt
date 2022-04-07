package com.opentext.axcelerate.adpkt.task

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.Test
import kotlin.test.assertEquals

class QueryEngineRequestTest {
    @Test
    fun testQueryEngineRequest() {

        // reset displayName and description
        val req = QueryEngineRequest(
            taskDisplayName = "Query Engine",
            taskDescription = "Query Engine",
            taskConfiguration = QueryEngineConfiguration(
                adpQueryEngineEngineName = "singleMindServer.G0001",
            )
        )

        val expected = """{"taskType":"Query Engine","taskConfiguration":{"adp_queryEngine_engineName":"singleMindServer.G0001"},"taskDescription":"Query Engine","taskDisplayName":"Query Engine"}"""
        assertEquals(expected, jacksonObjectMapper().writeValueAsString(req))
    }
}