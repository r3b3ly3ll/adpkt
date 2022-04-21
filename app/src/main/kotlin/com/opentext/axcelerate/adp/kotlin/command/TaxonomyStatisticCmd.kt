package com.opentext.axcelerate.adp.kotlin.command

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option
import com.opentext.axcelerate.adp.kotlin.args.Util
import com.opentext.axcelerate.adp.kotlin.model.Service
import com.opentext.axcelerate.adp.kotlin.task.TaxonomyStatisticConfiguration
import com.opentext.axcelerate.adp.kotlin.task.TaxonomyStatisticRequest

class TaxonomyStatisticCmd: CliktCommand(name = "taxonomyStatistic") {
    private val engineTaxonomies : String? by option("-t", "--engineTaxonomies",
        help = "engine taxonomies")
    private val outputTaxonomies : String? by option("-o", "--outputTaxonomies",
        help = "output taxonomies")
    private val application: String by option("-a", "--application",
        help = "application identifier")
        .default("")
    private val engine: String by option("-e", "--engine",
        help = "engine identifier")
        .default("")
    private val engineQuery: String? by option("-q", "--engineQuery",
        help = "engine query")
    private val engineUserName: String? by option("-u", "--engineUserName",
        help = "engine user name")
    private val engineUserPassword: String? by option("-p", "--engineUserPassword",
        help = "engine user password")
    private val async by option("--async").flag("--sync", default = false)

    override fun run() {
        val arrayOfEngineTaxonomies = Util.stringToEngineTaxonomies(engineTaxonomies)
        val arrayOfOutputTaxonomies = Util.stringToOutputTaxonomies(outputTaxonomies)

        val req = TaxonomyStatisticRequest(
            taskDisplayName = "Taxonomy Statistic (cli)",
            taskDescription = "Taxonomy Statistic (cli)",
            taskConfiguration = TaxonomyStatisticConfiguration(
                adpTaxonomyStatisticEngineTaxonomies = arrayOfEngineTaxonomies,
                adpTaxonomyStatisticOutputTaxonomies = arrayOfOutputTaxonomies,
                adpTaxonomyStatisticApplicationIdentifier = application,
                adpTaxonomyStatisticEngineName = engine,
                adpTaxonomyStatisticEngineQuery = engineQuery,
                adpTaxonomyStatisticEngineUserName = engineUserName,
                adpTaxonomyStatisticEngineUserPassword = engineUserPassword,
            )
        )

        println(Service.taxonomyStatistic(req, async))
    }
}
