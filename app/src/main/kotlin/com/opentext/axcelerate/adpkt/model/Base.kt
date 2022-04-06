package com.opentext.axcelerate.adpkt.model

import com.opentext.axcelerate.adpkt.task.ListEntitiesConfiguration
import com.opentext.axcelerate.adpkt.task.ListEntitiesRequest

open class Base(val id: String) {

    open fun getEcaApplications(): String {
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

    open fun getRnaApplications(): String {
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

    open fun getSingleMindServers(): String {
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

    open fun getDataSources(): String {
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