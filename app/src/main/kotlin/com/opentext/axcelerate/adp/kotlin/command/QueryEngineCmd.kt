package com.opentext.axcelerate.adp.kotlin.command

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.option
import com.opentext.axcelerate.adp.kotlin.args.EngineTaxonomy
import com.opentext.axcelerate.adp.kotlin.model.Service
import com.opentext.axcelerate.adp.kotlin.task.QueryEngineConfiguration
import com.opentext.axcelerate.adp.kotlin.task.QueryEngineRequest

class QueryEngineCmd: CliktCommand(name = "queryEngine") {
    private val engineTaxonomies : String? by option("--engineTaxonomies", help = "engine taxonomies")
    private val applicationIdentifier: String? by option("--applicationIdentifier", help = "application identifier")
    private val engineName: String? by option("--engineName", help = "engine identifier")
    private val engineQuery: String? by option("--engineQuery", help = "engine query")
    private val engineUserName: String? by option("--engineUserName", help = "engine user name")
    private val engineUserPassword: String? by option("--engineUserPassword", help = "engine user password")

    override fun run() {
        val taxonomies: ArrayList<EngineTaxonomy> = ArrayList(0)

        if (engineTaxonomies?.isNotEmpty() == true) {
            for (taxonomy in engineTaxonomies!!.split(",")) {
                try {
                    taxonomies += EngineTaxonomy(taxonomy)
                } catch (e: Exception) {
                    continue
                }
            }
        }

        val req = QueryEngineRequest(
            taskDisplayName = "Query Engine (cli)",
            taskDescription = "Query Engine (cli)",
            taskConfiguration = QueryEngineConfiguration(
                adpQueryEngineEngineTaxonomies = taxonomies,
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