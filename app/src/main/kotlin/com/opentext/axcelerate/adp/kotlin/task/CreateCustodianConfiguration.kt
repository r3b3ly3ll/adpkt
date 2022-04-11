package com.opentext.axcelerate.adp.kotlin.task
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.opentext.axcelerate.adp.kotlin.args.Custodian

/*
"taskConfiguration": {
    "adp_progressTaskTimeout": 0,
    "adp_taskActive": true,
    "adp_executionPersistent": true,
    "adp_createCustodian_engineUser": "{adp_user}",
    "adp_abortWfOnFailure": true,
    "adp_cleanUpHistory": false,
    "adp_createCustodian_applicationType": "",
    "adp_createCustodian_engineIdentifier": "",
    "adp_loggingEnabled": true,
    "adp_createCustodian_custodians": [],
    "adp_createCustodian_custodianTaxonomy": "rm_custodian",
    "adp_taskTimeout": 0,
    "adp_createCustodian_applicationIdentifier": "",
    "adp_createCustodian_engineType": "true",
    "adp_createCustodian_engineUserPassword": "",
    "adp_createCustodian_updateExistingCustodians": true
}
*/

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class CreateCustodianConfiguration (
    @JsonProperty("adp_createCustodian_custodians")
    val adpCreateCustodianCustodians: ArrayList<Custodian>? = null,
    @JsonProperty("adp_createCustodian_applicationIdentifier")
    val adpCreateCustodianApplicationIdentifier: String? = null,
    @JsonProperty("adp_createCustodian_engineIdentifier")
    val adpCreateCustodianEngineIdentifier: String?  = null,
    @JsonProperty("adp_createCustodian_updateExistingCustodians")
    val adpCreateCustodianUpdateExistingCustodians: Boolean = true,
    @JsonProperty("adp_loggingEnabled")
    val adpLoggingEnabled: Boolean = false
)