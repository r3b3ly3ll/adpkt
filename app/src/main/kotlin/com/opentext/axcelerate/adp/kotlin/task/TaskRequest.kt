package com.opentext.axcelerate.adp.kotlin.task

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

enum class ExecutionMode {
    SYNCHRONOUS, ASYNCHRONOUS
}

interface TaskRequest {
    var executionMode: ExecutionMode
    fun isAsync(): Boolean {
        return executionMode == ExecutionMode.ASYNCHRONOUS
    }
    fun toJson(): String {
        return jacksonObjectMapper().writeValueAsString(this)
    }
}