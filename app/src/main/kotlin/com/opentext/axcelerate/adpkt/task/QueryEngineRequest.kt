package com.opentext.axcelerate.adpkt.task

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class QueryEngineRequest (
    val taskType: String = "Query Engine",
    val taskConfiguration: QueryEngineConfiguration,
    val taskDescription: String = "Query Engine (description)",
    val taskDisplayName: String = "Query Engine (displayName)"
)