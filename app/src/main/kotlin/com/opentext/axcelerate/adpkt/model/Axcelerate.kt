package com.opentext.axcelerate.adpkt.model

import com.opentext.axcelerate.adpkt.model.Service
import com.opentext.axcelerate.adpkt.task.ListEntitiesConfiguration
import com.opentext.axcelerate.adpkt.task.ListEntitiesRequest

class Axcelerate(id: String): Base(id) {
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