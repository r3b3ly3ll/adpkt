package com.opentext.axcelerate.adp.kotlin.task

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/*
"taskConfiguration": {
    "adp_progressTaskTimeout": 0,
    "adp_loggingEnabled": true,
    "adp_taskActive": true,
    "adp_taskTimeout": 0,
    "adp_startApplication_useHttps": false,
    "adp_startApplication_applicationUrl": "adp_started_application_url",
    "adp_executionPersistent": true,
    "adp_abortWfOnFailure": true,
    "adp_cleanUpHistory": false,
    "adp_startApplication_applicationIdentifier": "{adp_create_application_application_identifier}"
}
*/

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class StartApplicationConfiguration (
    @JsonProperty("adp_startApplication_applicationUrl")
    val adpStartApplicationApplicationUrl: String = "appURL",
    @JsonProperty("adp_startApplication_applicationIdentifier")
    val adpStartApplicationApplicationIdentifier: String
)