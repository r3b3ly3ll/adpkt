package com.opentext.axcelerate.adp.kotlin.model

import com.opentext.axcelerate.adp.kotlin.task.ListEntitiesConfiguration
import com.opentext.axcelerate.adp.kotlin.task.ListEntitiesRequest

class DocumentHold(id: String) : Base(id){

    override fun getRnaApplications(): String {
        throw Exception("method: getRnaApplication not applicable")
    }

    override fun getEcaApplications(): String {
        val req = ListEntitiesRequest(
            taskDisplayName = "List Entities",
            taskDescription = "List Entities",
            taskConfiguration = ListEntitiesConfiguration(
                adpListEntitiesID = id
            )
        )
        return Service.listEntities(req)
    }
}