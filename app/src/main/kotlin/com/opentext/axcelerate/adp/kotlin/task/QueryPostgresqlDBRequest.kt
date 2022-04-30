package com.opentext.axcelerate.adp.kotlin.task

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonIgnoreProperties(ignoreUnknown = true, value = ["executionMode"])
@JsonInclude(JsonInclude.Include.NON_NULL)
data class QueryPostgresqlDBRequest (
    override var executionMode: ExecutionMode = ExecutionMode.SYNCHRONOUS,
    val taskType: String = "Query Postgresql DB",
    val taskDescription: String = "Query Postgresql DB (description)",
    val taskDisplayName: String = "Query Postgresql DB (displayName)",
    val taskConfiguration: QueryPostgresqlDBConfiguration
): TaskRequest