package com.opentext.axcelerate.adp.kotlin.command

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.option
import com.opentext.axcelerate.adp.kotlin.args.Util
import com.opentext.axcelerate.adp.kotlin.model.Service
import com.opentext.axcelerate.adp.kotlin.task.TaxonomyStatisticConfiguration
import com.opentext.axcelerate.adp.kotlin.task.TaxonomyStatisticRequest

class TaxonomyStatisticCmd: CliktCommand(name = "taxonomyStatistic") {
    private val engineTaxonomies : String? by option("--engineTaxonomies", help = "engine taxonomies")
    private val outputTaxonomies : String? by option("--outputTaxonomies", help = "output taxonomies")
    private val application: String? by option("--application", help = "application identifier")
    private val engine: String? by option("--engine", help = "engine identifier")
    private val engineQuery: String? by option("--engineQuery", help = "engine query")
    private val engineUserName: String? by option("--engineUserName", help = "engine user name")
    private val engineUserPassword: String? by option("--engineUserPassword", help = "engine user password")

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

        println(Service.taxonomyStatistic(req))
    }
}
