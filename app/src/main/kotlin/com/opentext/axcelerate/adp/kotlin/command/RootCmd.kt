package com.opentext.axcelerate.adp.kotlin.command

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option
import com.opentext.axcelerate.adp.kotlin.model.Service

class RootCmd: CliktCommand() {
    private val endpoint by option("-e",
        help="adp rest service endpoint").default("https://localhost")
    private val user by option("-u",
        help="adp user")
        .default("adpuser")
    private val password by option("-p",
        help="adp user password")
        .default("adpus3r")
    private val taskAccessKey: String? by option("-k",
        help="taskAccessKey")

    override fun run() {
        Service.initialize( endpoint = endpoint, user = user, password = password, taskAccessKey = taskAccessKey )
    }
}