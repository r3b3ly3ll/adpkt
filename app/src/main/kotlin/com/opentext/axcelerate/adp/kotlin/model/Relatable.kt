package com.opentext.axcelerate.adp.kotlin.model

import com.opentext.axcelerate.adp.kotlin.task.ListEntitiesConfiguration
import com.opentext.axcelerate.adp.kotlin.task.ListEntitiesRequest

interface Relatable {
    val id: String

    fun getEcaApplications(): String {
        val req = ListEntitiesRequest(
            taskDisplayName = "List Entities",
            taskDescription = "List Entities",
            taskConfiguration = ListEntitiesConfiguration(
                adpListEntitiesRelatedEntity = id,
                adpListEntitiesType = "documentHold"
            )
        )
        return Service.listEntities(req)
    }

    fun getRnaApplications(): String {
        val req = ListEntitiesRequest(
            taskDisplayName = "List Entities",
            taskDescription = "List Entities",
            taskConfiguration = ListEntitiesConfiguration(
                adpListEntitiesRelatedEntity = id,
                adpListEntitiesType = "axcelerate"
            )
        )
        return Service.listEntities(req)
    }

    fun getSingleMindServers(): String {
        val req = ListEntitiesRequest(
            taskDisplayName = "List Entities",
            taskDescription = "List Entities",
            taskConfiguration = ListEntitiesConfiguration(
                adpListEntitiesRelatedEntity = id,
                adpListEntitiesType = "singleMindServer"
            )
        )
        return Service.listEntities(req)
    }

    fun getDataSources(): String {
        val req = ListEntitiesRequest(
            taskDisplayName = "List Entities",
            taskDescription = "List Entities",
            taskConfiguration = ListEntitiesConfiguration(
                adpListEntitiesRelatedEntity = id,
                adpListEntitiesType = "dataSource"
            )
        )
        return Service.listEntities(req)
    }
}