package com.opentext.axcelerate.adp.kotlin.command

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.option
import com.opentext.axcelerate.adp.kotlin.model.Service
import com.opentext.axcelerate.adp.kotlin.task.CreateDataSourceConfiguration
import com.opentext.axcelerate.adp.kotlin.task.CreateDataSourceRequest

class CreateDataSourceCmd: CliktCommand(name = "createDataSource"){
    private val dataSource: String? by option("--datasource", help="datasource name (normalized)")
    private val application: String? by option("--application", help="application identifier")
    private val engine: String? by option("--engine", help="engine identifier")
    private val host: String? by option("--host", help="host identifier")
    private val template: String? by option("--template", help="datasource template")


    override fun run() {
        val req = CreateDataSourceRequest(
            taskDisplayName = "Create Data Source (cli)",
            taskDescription = "Create Data Source (cli)",
            taskConfiguration = CreateDataSourceConfiguration(
                adpCreateDataSourceDataSourceName = dataSource,
                adpCreateDataSourceApplicationIdentifier = application,
                adpCreateDataSourceEngineIdentifier = engine,
                adpCreateDataSourceDataSourceTemplate = template,
                adpCreateDataSourceHostIdentifier = host,
            )
        )

        println(Service.createDataSource(req))
    }
}