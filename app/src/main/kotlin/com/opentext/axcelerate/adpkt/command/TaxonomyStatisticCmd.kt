package com.opentext.axcelerate.adpkt.command

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.option
import com.opentext.axcelerate.adpkt.model.Service
import com.opentext.axcelerate.adpkt.task.TaxonomyStatisticConfiguration
import com.opentext.axcelerate.adpkt.task.TaxonomyStatisticRequest

class TaxonomyStatisticCmd: CliktCommand(name = "taxonomyStatistic") {
    private val engineTaxonomies : String? by option("--engineTaxonomies", help = "engine taxonomies")
    private val outputTaxonomies : String? by option("--outputTaxonomies", help = "output taxonomies")
    private val applicationIdentifier: String? by option("--applicationIdentifier", help = "application identifier")
    private val engineName: String? by option("--engineName", help = "engine identifier")
    private val engineQuery: String? by option("--engineQuery", help = "engine query")
    private val engineUserName: String? by option("--engineUserName", help = "engine user name")
    private val engineUserPassword: String? by option("--engineUserPassword", help = "engine user password")

    override fun run() {

        val req = TaxonomyStatisticRequest(
            taskDisplayName = "Taxonomy Statistic (cli)",
            taskDescription = "Taxonomy Statistic (cli)",
            taskConfiguration = TaxonomyStatisticConfiguration(
                adpTaxonomyStatisticApplicationIdentifier = applicationIdentifier,
                adpTaxonomyStatisticEngineName = engineName,
                adpTaxonomyStatisticEngineQuery = engineQuery,
                adpTaxonomyStatisticEngineUserName = engineUserName,
                adpTaxonomyStatisticEngineUserPassword = engineUserPassword,
            )
        )

        println(Service.taxonomyStatistic(req))
    }
}
