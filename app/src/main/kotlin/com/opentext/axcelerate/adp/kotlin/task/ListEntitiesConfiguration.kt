package com.opentext.axcelerate.adp.kotlin.task

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/*
"taskConfiguration": {
    "adp_progressTaskTimeout": 0,
    "adp_listEntities_file": "output.json",
    "adp_listEntities_numberOfEntities": "-1",
    "adp_listEntities_axcRequestTimeoutSeconds": 900,
    "adp_taskActive": true,
    "adp_listEntities_userHasAccess": "",
    "adp_listEntities_whiteList": "id,displayName",
    "adp_executionPersistent": true,
    "adp_abortWfOnFailure": true,
    "adp_listEntities_relatedEntity": "",
    "adp_listEntities_workspace": "",
    "adp_loggingEnabled": true,
    "adp_listEntities_status": "",
    "adp_listEntities_axcServiceCoreAddress": "",
    "adp_listEntities_relatedEntityType": "",
    "adp_listEntities_type": "",
    "adp_listEntities_httpsKeystoreFile": null,
    "adp_listEntities_httpsPassword": "",
    "adp_listEntities_axcConnectTimeoutSeconds": 300,
    "adp_listEntities_axcServicePassword": "",
    "adp_listEntities_startingEntity": "1",
    "adp_listEntities_outputJson": "adp_entities_json_output",
    "adp_cleanUpHistory": false,
    "adp_listEntities_descriptionSettingFilterValueDateFormat": "yyyy-MM-dd",
    "adp_listEntities_descriptionFilters": [],
    "adp_listEntities_axcServiceUser": "",
    "adp_listEntities_axcFields": "",
    "adp_taskTimeout": 0,
    "adp_listEntities_httpsTrustCertificate": "",
    "adp_listEntities_host": "",
    "adp_listEntities_outputFilename": "adp_entities_output_file_name",
    "adp_listEntities_id": "",
    "adp_listEntities_httpsAllowUntrustedHosts": "true"
}
*/

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class ListEntitiesConfiguration(
    @JsonProperty("adp_listEntities_id")
    val adpListEntitiesID: String? = null,
    @JsonProperty("adp_listEntities_whiteList")
    val adpListEntitiesWhiteList: String = "id,displayName,processStatus,hostName",
    @JsonProperty("adp_listEntities_relatedEntity")
    val adpListEntitiesRelatedEntity: String? = null,
    @JsonProperty("adp_listEntities_workspace")
    val adpListEntitiesWorkspace: String? = null,
    @JsonProperty("adp_listEntities_status")
    val adpListEntitiesStatus: String? = null,
    @JsonProperty("adp_listEntities_relatedEntityType")
    val adpListEntitiesRelatedEntityType: String? = null,
    @JsonProperty("adp_listEntities_type")
    val adpListEntitiesType: String? = null,
    @JsonProperty("adp_loggingEnabled")
    val adpLoggingEnabled: Boolean  = false
)