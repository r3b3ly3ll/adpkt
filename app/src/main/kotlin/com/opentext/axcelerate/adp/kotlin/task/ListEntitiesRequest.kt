package com.opentext.axcelerate.adp.kotlin.task

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonIgnoreProperties(ignoreUnknown = true, value = ["executionMode"])
@JsonInclude(JsonInclude.Include.NON_NULL)
data class ListEntitiesRequest(
    override var executionMode: ExecutionMode = ExecutionMode.SYNCHRONOUS,
    val taskType: String = "List Entities",
    val taskDescription: String = "List Entities (description)",
    val taskDisplayName: String = "List Entities (displayName)",
    val taskConfiguration: ListEntitiesConfiguration
): TaskRequest