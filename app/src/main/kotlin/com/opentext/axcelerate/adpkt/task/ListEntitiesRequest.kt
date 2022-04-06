package com.opentext.axcelerate.adpkt.task

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class ListEntitiesRequest(
    val taskType: String = "List Entities",
    val taskDescription: String = "List Entities (description)",
    val taskDisplayName: String = "List Entities (displayName)",
    val taskConfiguration: ListEntitiesConfiguration
)