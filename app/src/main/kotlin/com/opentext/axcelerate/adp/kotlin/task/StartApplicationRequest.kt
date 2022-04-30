package com.opentext.axcelerate.adp.kotlin.task

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonIgnoreProperties(ignoreUnknown = true, value = ["executionMode"])
@JsonInclude(JsonInclude.Include.NON_NULL)
data class StartApplicationRequest (
    override var executionMode: ExecutionMode = ExecutionMode.SYNCHRONOUS,
    val taskType: String = "Start Application",
    val taskDescription: String = "Start Application (description)",
    val taskDisplayName: String = "Start Application (displayName)",
    val taskConfiguration: StartApplicationConfiguration
) : TaskRequest