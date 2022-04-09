package com.opentext.axcelerate.adp.kotlin.task
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

data class CreateCustodianConfiguration (
    val adp_createCustodian_custodians: ArrayList<Custodian>? = null,
    val adp_createCustodian_applicationIdentifier: String? = null,
    val adp_createCustodian_engineIdentifier: String?  = null,
    val adp_createCustodian_updateExistingCustodians: Boolean = true
)