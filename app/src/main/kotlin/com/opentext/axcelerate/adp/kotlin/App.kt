/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package com.opentext.axcelerate.adp.kotlin

import com.github.ajalt.clikt.core.subcommands
import com.opentext.axcelerate.adp.kotlin.command.RootCmd
import com.opentext.axcelerate.adp.kotlin.command.ListEntitiesCmd
import com.opentext.axcelerate.adp.kotlin.command.QueryEngineCmd
import com.opentext.axcelerate.adp.kotlin.command.TaxonomyStatisticCmd

fun main(args: Array<String>) = RootCmd()
    .subcommands(
        ListEntitiesCmd(),
        QueryEngineCmd(),
        TaxonomyStatisticCmd()
    )
    .main(args)
