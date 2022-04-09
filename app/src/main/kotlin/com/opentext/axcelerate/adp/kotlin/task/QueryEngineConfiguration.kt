package com.opentext.axcelerate.adp.kotlin.task

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.opentext.axcelerate.adp.kotlin.args.EngineTaxonomy

/*
"taskConfiguration": {
    "adp_progressTaskTimeout": 0,
    "adp_queryEngine_fieldName": "virtual_filesize",
    "adp_queryEngine_engineName": "{adp_engineName}",
    "adp_taskActive": true,
    "adp_executionPersistent": true,
    "adp_queryEngine_engineUserPassword": "",
    "adp_abortWfOnFailure": true,
    "adp_loggingEnabled": true,
    "adp_queryEngine_engineTaxonomies": [],
    "adp_queryEngine_engineUserName": "{adp_user}",
    "adp_queryEngine_engineType": "true",
    "adp_queryEngine_saveVariable": "{engine_save}",
    "adp_queryEngine_categoryToDelete": "",
    "adp_queryEngine_activateCategoryDeletion": false,
    "adp_queryEngine_applicationIdentifier": "",
    "adp_queryEngine_taxonomyToDelete": "",
    "adp_queryEngine_successIfCountIs": "{adp_expectedDsDoccount}",
    "adp_queryEngine_category": "",
    "adp_queryEngine_activateTagging": false,
    "adp_queryEngine_globalSearchId": "",
    "adp_queryEngine_aggregatedValue": "adp_query_engine_aggregated_value",
    "adp_queryEngine_AdvancedRestrictions": [],
    "adp_queryEngine_taxonomy": "",
    "adp_queryEngine_globalSearchJson": "",
    "adp_queryEngine_saveCompareString": "true",
    "adp_cleanUpHistory": false,
    "adp_queryEngine_numberOfDocuments": "adp_query_engine_documents_count",
    "adp_queryEngine_engineQuery": "*",
    "adp_queryEngine_mainQueryType": null,
    "adp_queryEngine_waitForResult": false,
    "adp_queryEngine_categoryDisplayName": "",
    "adp_queryEngine_waitWhileCountIs": "{adp_oldDsDoccount}",
    "adp_taskTimeout": 0,
    "adp_queryEngine_applicationType": "",
    "adp_queryEngine_exitOnValueChanged": true
}
*/

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class QueryEngineConfiguration (
    @JsonProperty("adp_queryEngine_engineTaxonomies")
    val adpQueryEngineEngineTaxonomies: ArrayList<EngineTaxonomy>? = null,

    @JsonProperty("adp_queryEngine_applicationIdentifier")
    val adpQueryEngineApplicationIdentifier: String? = null,

    @JsonProperty("adp_queryEngine_engineName")
    val adpQueryEngineEngineName: String? = null,

    @JsonProperty("adp_queryEngine_engineQuery")
    val adpQueryEngineEngineQuery: String? = null,

    @JsonProperty("adp_queryEngine_engineUserName")
    val adpQueryEngineEngineUserName: String? = null,

    @JsonProperty("adp_queryEngine_engineUserPassword")
    val adpQueryEngineEngineUserPassword: String? = null,

    @JsonProperty("adp_loggingEnabled")
    val adpLoggingEnabled: String? = null
)