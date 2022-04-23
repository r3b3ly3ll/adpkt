package com.opentext.axcelerate.adp.kotlin.command

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.required
import com.opentext.axcelerate.adp.kotlin.model.Service
import com.opentext.axcelerate.adp.kotlin.task.StartApplicationConfiguration
import com.opentext.axcelerate.adp.kotlin.task.StartApplicationRequest

class StartApplicationCmd : CliktCommand(name = "startApplication") {
        private val application: String by option("-a", "--application",
            help="application identifier")
            .required()
        private val applicationUrl: String by option("-l", "--applicationUrl",
            help="application url")
            .default("appURL")
        private val async by option("--async").flag("--sync", default = false )

        override fun run() {
            val req = StartApplicationRequest(
                taskDisplayName = "Start Application (cli)",
                taskDescription = "Start Application (cli)",
                taskConfiguration = StartApplicationConfiguration(
                    adpStartApplicationApplicationIdentifier =  application,
                    adpStartApplicationApplicationUrl = applicationUrl
                )
            )

            println(Service.startApplication(req, async))
        }
}