package com.opentext.axcelerate.adp.kotlin.command

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option
import com.opentext.axcelerate.adp.kotlin.model.Service
import com.opentext.axcelerate.adp.kotlin.task.CreateCustodianConfiguration
import com.opentext.axcelerate.adp.kotlin.task.CreateCustodianRequest

class CreateCustodianCmd: CliktCommand(name = "createCustodian"){
    private val application: String? by option("--application", help="application identifier")
    private val engine: String? by option("--engine", help="engine identifier")
    private val update by option("--update", help="update existing custodians").flag(default = false)

    override fun run() {
        val req = CreateCustodianRequest(
            taskDisplayName = "Create Custodian (cli)",
            taskDescription = "Create Custodian (cli)",
            taskConfiguration = CreateCustodianConfiguration(
                adp_createCustodian_applicationIdentifier = application,
                adp_createCustodian_engineIdentifier = engine,
                adp_createCustodian_updateExistingCustodians = update
            )
        )

        println(Service.createCustodian(req))
    }
}