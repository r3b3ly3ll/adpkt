package com.opentext.axcelerate.adp.kotlin.task

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonIgnoreProperties(ignoreUnknown = true, value = ["executionMode"])
@JsonInclude(JsonInclude.Include.NON_NULL)
data class TaxonomyStatisticRequest (
    override var executionMode: ExecutionMode = ExecutionMode.SYNCHRONOUS,
    val taskType: String = "Taxonomy Statistic",
    val taskDescription: String = "Taxonomy Statistic (description)",
    val taskDisplayName: String = "Taxonomy Statistic (displayName)",
    val taskConfiguration: TaxonomyStatisticConfiguration
): TaskRequest