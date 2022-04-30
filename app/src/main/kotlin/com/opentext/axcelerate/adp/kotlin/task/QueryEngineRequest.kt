package com.opentext.axcelerate.adp.kotlin.task

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonIgnoreProperties(ignoreUnknown = true, value = ["executionMode"])
@JsonInclude(JsonInclude.Include.NON_NULL)
data class QueryEngineRequest (
    override var executionMode: ExecutionMode = ExecutionMode.SYNCHRONOUS,
    val taskType: String = "Query Engine",
    val taskDescription: String = "Query Engine (description)",
    val taskDisplayName: String = "Query Engine (displayName)",
    val taskConfiguration: QueryEngineConfiguration
): TaskRequest