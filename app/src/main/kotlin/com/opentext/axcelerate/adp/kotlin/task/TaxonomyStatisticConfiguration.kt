package com.opentext.axcelerate.adp.kotlin.task

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.opentext.axcelerate.adp.kotlin.args.EngineTaxonomy
import com.opentext.axcelerate.adp.kotlin.args.OutputTaxonomy

/*
"taskConfiguration": {
    "adp_progressTaskTimeout": 0,
    "adp_taxonomyStatistic_outputJsonAbsFilePath": "adp_taxonomy_statistics_json_file_path",
    "adp_taxonomyStatistic_applicationIdentifier": "",
    "adp_taskActive": true,
    "adp_taxonomyStatistic_adp_taxonomyStatistic_mainQueryType": null,
    "adp_executionPersistent": true,
    "adp_taxonomyStatistic_engineUserName": "{adp_user}",
    "adp_abortWfOnFailure": true,
    "adp_taxonomyStatistic_applicationType": "",
    "adp_taxonomyStatistic_computeCounts": "true",
    "adp_loggingEnabled": true,
    "adp_taxonomyStatistic_outputJsonFilePath": null,
    "adp_taxonomyStatistic_engineTaxonomies": [],
    "adp_taxonomyStatistic_engineUserPassword": "",
    "adp_taxonomyStatistic_outputXmlAbsFilePath": "adp_taxonomy_statistics_xml_file_path",
    "adp_taxonomyStatistic_engineQuery": "*",
    "adp_taxonomyStatistic_listCategoryProperties": "false",
    "adp_taxonomyStatistic_outputTaxonomies": [],
    "adp_taxonomyStatistic_outputJson": "adp_taxonomy_statistics_json_output",
    "adp_taxonomyStatistic_engineType": "true",
    "adp_cleanUpHistory": false,
    "adp_taxonomyStatistic_outputXmlFilePath": null,
    "adp_taxonomyStatistic_outputFields": [],
    "adp_taxonomyStatistic_engineGlobalSearch": "",
    "adp_taxonomyStatistic_listDocuments": "false",
    "adp_taskTimeout": 0,
    "adp_taxonomyStatistic_engineName": "{adp_engine_name}"
}
*/

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class TaxonomyStatisticConfiguration (
    @JsonProperty("adp_taxonomyStatistic_engineTaxonomies")
    val adpTaxonomyStatisticEngineTaxonomies: ArrayList<EngineTaxonomy>? = null,
    @JsonProperty("adp_taxonomyStatistic_outputTaxonomies")
    val adpTaxonomyStatisticOutputTaxonomies: ArrayList<OutputTaxonomy>? = null,
    @JsonProperty("adp_taxonomyStatistic_applicationIdentifier")
    val adpTaxonomyStatisticApplicationIdentifier: String,
    @JsonProperty("adp_taxonomyStatistic_engineName")
    val adpTaxonomyStatisticEngineName: String,
    @JsonProperty("adp_taxonomyStatistic_engineQuery")
    val adpTaxonomyStatisticEngineQuery: String? = null,
    @JsonProperty("adp_taxonomyStatistic_engineUserName")
    val adpTaxonomyStatisticEngineUserName: String? = null,
    @JsonProperty("adp_taxonomyStatistic_engineUserPassword")
    val adpTaxonomyStatisticEngineUserPassword: String? = null,
    @JsonProperty("adp_loggingEnabled")
    val adpLoggingEnabled: Boolean = false
)