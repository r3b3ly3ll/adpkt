package com.opentext.axcelerate.adp.kotlin.task

import org.junit.Test
import kotlin.test.assertEquals

class ListEntitiesCmdRequestTest {
    @Test
    fun testListEntitiesRequest() {

        // reset displayName and description
        val req = ListEntitiesRequest(
            taskDisplayName = "List Datasource",
            taskDescription = "List Datasource",
            taskConfiguration = ListEntitiesConfiguration(
                adpListEntitiesRelatedEntity = "singleMindServer.G0001",
                adpListEntitiesType = "dataSource",
            )
        )

        val expected = """{"taskType":"List Entities","taskDescription":"List Datasource","taskDisplayName":"List Datasource","taskConfiguration":{"adp_listEntities_whiteList":"id,displayName,processStatus,hostName","adp_listEntities_relatedEntity":"singleMindServer.G0001","adp_listEntities_type":"dataSource"}}"""
        assertEquals(expected, req.toJson())
    }

}