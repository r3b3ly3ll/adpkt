package com.opentext.axcelerate.adpkt.command

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.option
import com.opentext.axcelerate.adpkt.model.Service
import com.opentext.axcelerate.adpkt.task.QueryEngineConfiguration
import com.opentext.axcelerate.adpkt.task.QueryEngineRequest

class QueryEngineCmd: CliktCommand() {
    private val engineTaxonomies : String? by option("--engineTaxonomies", help = "engine taxonomies")
    private val applicationIdentifier: String? by option("--applicationIdentifier", help = "application identifier")
    private val engineName: String? by option("--engineName", help = "engine identifier")
    private val engineQuery: String? by option("--engineQuery", help = "engine query")
    private val engineUserName: String? by option("--engineUserName", help = "engine user name")
    private val engineUserPassword: String? by option("--engineUserPassword", help = "engine user password")

    override fun run() {

        val req = QueryEngineRequest(
            taskDisplayName = "Taxonomy Statistic (cli)",
            taskDescription = "Taxonomy Statistic (cli)",
            taskConfiguration = QueryEngineConfiguration(
                adpQueryEngineEngineTaxonomies = null,
                adpQueryEngineApplicationIdentifier = applicationIdentifier,
                adpQueryEngineEngineName = engineName,
                adpQueryEngineEngineQuery = engineQuery,
                adpQueryEngineEngineUserName = engineUserName,
                adpQueryEngineEngineUserPassword = engineUserPassword,
            )
        )

        println(Service.queryEngine(req))
    }
}