package com.opentext.axcelerate.adp.kotlin.model

import com.opentext.axcelerate.adp.kotlin.task.ListEntitiesConfiguration
import com.opentext.axcelerate.adp.kotlin.task.ListEntitiesRequest

class Axcelerate(override val id: String): Relatable{
    override fun getEcaApplications(): String {
        throw Exception("method: getEcaApplication not applicable")
    }

    override fun getRnaApplications(): String {
        val req = ListEntitiesRequest(
           taskConfiguration = ListEntitiesConfiguration(
                adpListEntitiesID = id
           )
        )
        return Service.listEntities(req)
    }
}