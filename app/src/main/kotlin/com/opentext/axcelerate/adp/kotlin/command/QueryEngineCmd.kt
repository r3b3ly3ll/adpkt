package com.opentext.axcelerate.adp.kotlin.command

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.option
import com.opentext.axcelerate.adp.kotlin.args.Util
import com.opentext.axcelerate.adp.kotlin.model.Service
import com.opentext.axcelerate.adp.kotlin.task.QueryEngineConfiguration
import com.opentext.axcelerate.adp.kotlin.task.QueryEngineRequest

class QueryEngineCmd: CliktCommand(name = "queryEngine") {
    private val engineTaxonomies : String? by option("--engineTaxonomies", help = "engine taxonomies")
    private val application: String? by option("--application", help = "application identifier")
    private val engine: String? by option("--engine", help = "engine identifier")
    private val engineQuery: String? by option("--engineQuery", help = "engine query")
    private val engineUserName: String? by option("--engineUserName", help = "engine user name")
    private val engineUserPassword: String? by option("--engineUserPassword", help = "engine user password")

    override fun run() {
        val arrayOfEngineTaxonomies = Util.stringToEngineTaxonomies(engineTaxonomies)

        val req = QueryEngineRequest(
            taskDisplayName = "Query Engine (cli)",
            taskDescription = "Query Engine (cli)",
            taskConfiguration = QueryEngineConfiguration(
                adpQueryEngineEngineTaxonomies = arrayOfEngineTaxonomies,
                adpQueryEngineApplicationIdentifier = application,
                adpQueryEngineEngineName = engine,
                adpQueryEngineEngineQuery = engineQuery,
                adpQueryEngineEngineUserName = engineUserName,
                adpQueryEngineEngineUserPassword = engineUserPassword,
            )
        )

        println(Service.queryEngine(req))
    }
}