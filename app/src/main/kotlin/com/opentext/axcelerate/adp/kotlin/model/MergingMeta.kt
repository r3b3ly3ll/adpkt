package com.opentext.axcelerate.adp.kotlin.model

class MergingMeta(override val id: String): Relatable {
    override fun getRnaApplications(): String {
        throw Exception("MergingMeta only exists in ECA")
    }
}