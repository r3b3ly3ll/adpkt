package com.opentext.axcelerate.adp.kotlin.command

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.required
import com.opentext.axcelerate.adp.kotlin.model.Service
import com.opentext.axcelerate.adp.kotlin.task.QueryPostgresqlDBConfiguration
import com.opentext.axcelerate.adp.kotlin.task.QueryPostgresqlDBRequest

/*
Usage:
    java -jar .\app-all.jar -k adm1n -p * queryPostgresqlDB -c jdbc:postgresql://db-host:5432/db -q "select * from app.mrs_application_descriptions" -u postgres -p *"
 */
class QueryPostgresqlDBCmd: CliktCommand(name = "queryPostgresqlDB") {
    private val query: String by option("-q", "--query", help = "query")
        .required()
    private val connectionURL: String by option("-c", "--connectionURL",
        help = "connectionURL e.g., jdbc:postgresql://localhost:5432/db")
        .required()
    private val dbUser: String by option("-u", "--dbUser", help = "database user")
        .default("postgres")
    private val dbPassword: String by option("-p", "--dbPassword", help = "database user password")
        .default("")
    private val rootCertPath: String by option("-r", "--rootCertPath", help = "root cert path")
        .default("S:/Projects/ProcessControl/security/postgres/root.billing.crt")
    private val clientKeyPath: String by option("-x", "--clientKeyPath", help = "client key path")
        .default("S:/Projects/ProcessControl/security/postgres/client.billing.key")
    private val clientCertPath: String by option("-y", "--clientCertPath", help = "client cert path")
        .default("S:/Projects/ProcessControl/security/postgres/client.billing.crt")

    override fun run() {
        val req = QueryPostgresqlDBRequest(
            taskDisplayName = "Query Postgresql DB (cli)",
            taskDescription = "Query Postgresql DB (cli)",
            taskConfiguration = QueryPostgresqlDBConfiguration(
                adpQpgdbDbUser = dbUser,
                adpQpgdbDbPassword = dbPassword,
                adpQpgdbOutputJson = "adp_querydb_outputjson",
                adpQpgdbDbConnectionPoolRootCertPath = rootCertPath,
                adpQpgdbDbConnectionPoolClientCertPath = clientCertPath,
                adpQpgdbDbConnectionPoolClientKeyPath = clientKeyPath,
                adpQpgdbSqlQuery = query,
                adpQpgdbDbConnectionUrl = connectionURL
            )
        )
        println(Service.queryPostgresqlDB(req))
    }
}