package com.opentext.axcelerate.adp.kotlin.command

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.required
import com.opentext.axcelerate.adp.kotlin.model.Service
import com.opentext.axcelerate.adp.kotlin.task.QueryPostgresqlDBConfiguration
import com.opentext.axcelerate.adp.kotlin.task.QueryPostgresqlDBRequest

class QueryPostgresqlDBCmd: CliktCommand(name = "queryPostgresqlDB") {
    private val query: String by option("--query", help = "query").required()
    private val connectionURL: String by option("--connectionURL", help = "connectionURL").required()

    override fun run() {
        val req = QueryPostgresqlDBRequest(
            taskDisplayName = "Query Postgresql DB (cli)",
            taskDescription = "Query Postgresql DB (cli)",
            taskConfiguration = QueryPostgresqlDBConfiguration(
                adpQpgdbSqlQuery = query,
                adpQpgdbDbConnectionUrl = connectionURL
            )
        )
        println(Service.queryPostgresqlDB(req))
    }
}