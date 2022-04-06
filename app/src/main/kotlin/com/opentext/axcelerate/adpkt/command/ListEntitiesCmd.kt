package com.opentext.axcelerate.adpkt.command

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.option
import com.opentext.axcelerate.adpkt.model.Service
import com.opentext.axcelerate.adpkt.task.ListEntitiesConfiguration
import com.opentext.axcelerate.adpkt.task.ListEntitiesRequest

class ListEntitiesCmd: CliktCommand(name = "listEntities") {
    private val id: String? by option("--id", help="identifier")
    private val relatedEntity: String? by option("--relatedEntity", help="related entity identifier")
    private val status: String? by option("--status", help="process status")
    private val whiteList: String by option("--whiteList", help="white list of output fields")
        .default("id,displayName,processStatus,hostName")
    private val type: String? by option("--type", help="type of component. e.g., dataSource")

    override fun run() {
        val req = ListEntitiesRequest(
            taskDisplayName = "List Entities (cli)",
            taskDescription = "List Entities (cli)",
            taskConfiguration = ListEntitiesConfiguration(
                adpListEntitiesID = id,
                adpListEntitiesRelatedEntity = relatedEntity,
                adpListEntitiesStatus = status,
                adpListEntitiesWhiteList = whiteList,
                adpListEntitiesType = type,
            )
        )

        println(Service.listEntities(req))
    }
}