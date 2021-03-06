/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package com.opentext.axcelerate.adp.kotlin

import com.github.ajalt.clikt.core.subcommands
import com.opentext.axcelerate.adp.kotlin.command.*

fun main(args: Array<String>) = RootCmd()
    .subcommands(
        CreateCustodianCmd(),
        CreateDataSourceCmd(),
        ListEntitiesCmd(),
        QueryEngineCmd(),
        QueryPostgresqlDBCmd(),
        StartApplicationCmd(),
        TaxonomyStatisticCmd()
    )
    .main(args)
