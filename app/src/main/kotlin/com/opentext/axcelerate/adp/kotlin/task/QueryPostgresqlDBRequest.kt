package com.opentext.axcelerate.adp.kotlin.task

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class QueryPostgresqlDBRequest (
    val taskType: String = "Query Postgresql DB",
    val taskDescription: String = "Query Postgresql DB (description)",
    val taskDisplayName: String = "Query Postgresql DB (displayName)",
    val taskConfiguration: QueryPostgresqlDBConfiguration
): TaskRequest