package com.opentext.axcelerate.adp.kotlin.task

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class StartApplicationRequest (
    val taskType: String = "Start Application",
    val taskDescription: String = "Start Application (description)",
    val taskDisplayName: String = "Start Application (displayName)",
    val taskConfiguration: StartApplicationConfiguration
) : TaskRequest