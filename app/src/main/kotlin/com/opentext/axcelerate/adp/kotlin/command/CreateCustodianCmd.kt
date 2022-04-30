package com.opentext.axcelerate.adp.kotlin.command

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option
import com.opentext.axcelerate.adp.kotlin.model.Service
import com.opentext.axcelerate.adp.kotlin.task.CreateCustodianConfiguration
import com.opentext.axcelerate.adp.kotlin.task.CreateCustodianRequest
import com.opentext.axcelerate.adp.kotlin.task.ExecutionMode

class CreateCustodianCmd: CliktCommand(name = "createCustodian"){
    private val application: String? by option("-a", "--application",
        help="application identifier")
    private val engine: String? by option("-e", "--engine",
        help="engine identifier")
    private val update by option("-d", "--update",
        help="update existing custodians")
        .flag(default = false)
    private val async by option("--async").flag("--sync", default = false )

    override fun run() {
        val req = CreateCustodianRequest(
            taskDisplayName = "Create Custodian (cli)",
            taskDescription = "Create Custodian (cli)",
            taskConfiguration = CreateCustodianConfiguration(
                adpCreateCustodianApplicationIdentifier = application,
                adpCreateCustodianEngineIdentifier = engine,
                adpCreateCustodianUpdateExistingCustodians = update
            )
        )

        if (async) {
           req.executionMode = ExecutionMode.ASYNCHRONOUS
        }

        println(Service.createCustodian(req))
    }
}