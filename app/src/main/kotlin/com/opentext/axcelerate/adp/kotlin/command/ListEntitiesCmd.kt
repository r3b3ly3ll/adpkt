package com.opentext.axcelerate.adp.kotlin.command

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option
import com.opentext.axcelerate.adp.kotlin.model.Service
import com.opentext.axcelerate.adp.kotlin.task.ListEntitiesConfiguration
import com.opentext.axcelerate.adp.kotlin.task.ListEntitiesRequest

class ListEntitiesCmd: CliktCommand(name = "listEntities") {
    private val id: String? by option("-i", "--id",
        help="identifier")
    private val relatedEntity: String? by option("-r", "--relatedEntity",
        help="related entity identifier")
    private val status: String? by option("-s", "--status",
        help="process status")
    private val whiteList: String by option("-w", "--whiteList",
        help="white list of output fields")
        .default("id,displayName,processStatus,hostName")
    private val type: String? by option("-t", "--type",
        help="type of component. e.g., dataSource")
    private val async by option("--async").flag("--sync", default = false)

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

        println(Service.listEntities(req, async))
    }
}