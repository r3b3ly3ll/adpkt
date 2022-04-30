package com.opentext.axcelerate.adp.kotlin.command

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option
import com.opentext.axcelerate.adp.kotlin.args.Util
import com.opentext.axcelerate.adp.kotlin.model.Service
import com.opentext.axcelerate.adp.kotlin.task.ExecutionMode
import com.opentext.axcelerate.adp.kotlin.task.QueryEngineConfiguration
import com.opentext.axcelerate.adp.kotlin.task.QueryEngineRequest

class QueryEngineCmd: CliktCommand(name = "queryEngine") {
    private val engineTaxonomies : String? by option("-t", "--engineTaxonomies",
        help = "engine taxonomies")
    private val application: String by option("-a","--application",
        help = "application identifier")
        .default("")
    private val engine: String by option("-e","--engine",
        help = "engine identifier")
        .default("")
    private val engineQuery: String? by option("-q", "--engineQuery",
        help = "engine query")
    private val engineUserName: String by option("-u", "--engineUserName",
        help = "engine user name")
        .default("")
    private val engineUserPassword: String? by option("-p", "--engineUserPassword",
        help = "engine user password")
    private val async by option("--async").flag("--sync", default = false)

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

        if (async) {
            req.executionMode = ExecutionMode.ASYNCHRONOUS
        }
        println(Service.queryEngine(req))
    }
}