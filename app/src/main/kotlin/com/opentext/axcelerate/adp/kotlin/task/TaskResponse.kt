package com.opentext.axcelerate.adp.kotlin.task

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.JsonNode

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class TaskResponse (
    val executionId: String,
    val taskType: String,
    val loggingEnabled: String,
    val progressMax: Int,
    val executionStatus: String,
    val executionRootDir: String,
    val contextId: String,
    val executionPersistent: String,
    val progressCurrent: Int,
    val progressPercentage: Float,
    val taskDisplayName: String,
    val executionMetaData: JsonNode
)