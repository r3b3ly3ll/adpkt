package com.opentext.axcelerate.adp.kotlin.model

class DataSource(override val id: String): Actionable {
    override fun getRnaApplications(): String {
        throw Exception("Datasource does not exist in RNA app")
    }
}
