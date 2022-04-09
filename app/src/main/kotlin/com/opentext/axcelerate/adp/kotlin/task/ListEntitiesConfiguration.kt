package com.opentext.axcelerate.adp.kotlin.task

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

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
    val adpLoggingEnabled: String? = null
)