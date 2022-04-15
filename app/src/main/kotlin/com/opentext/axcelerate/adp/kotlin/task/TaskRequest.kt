package com.opentext.axcelerate.adp.kotlin.task

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

interface TaskRequest {
    fun toJson(): String {
        return jacksonObjectMapper().writeValueAsString(this)
    }
}