package com.opentext.axcelerate.adp.kotlin.task

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonIgnoreProperties(ignoreUnknown = true, value = ["executionMode"])
@JsonInclude(JsonInclude.Include.NON_NULL)
data class CreateDataSourceRequest (
    override var executionMode: ExecutionMode = ExecutionMode.SYNCHRONOUS,
    val taskType: String = "Create Data Source",
    val taskDescription: String = "Create Data Source (description)",
    val taskDisplayName: String = "Create Data Source (displayName)",
    val taskConfiguration: CreateDataSourceConfiguration
): TaskRequest