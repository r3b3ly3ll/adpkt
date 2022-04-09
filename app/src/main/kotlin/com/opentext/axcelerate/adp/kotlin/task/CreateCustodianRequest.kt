package com.opentext.axcelerate.adp.kotlin.task

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class CreateCustodianRequest (
    val taskType: String = "Create Custodian",
    val taskDescription: String = "Create Custodian (description)",
    val taskDisplayName: String = "Create Custodian (displayName)",
    val taskConfiguration: CreateCustodianConfiguration
)