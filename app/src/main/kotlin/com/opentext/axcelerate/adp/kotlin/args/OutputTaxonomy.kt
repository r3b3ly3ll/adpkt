package com.opentext.axcelerate.adp.kotlin.args

import com.fasterxml.jackson.annotation.JsonProperty

data class OutputTaxonomy (
    @JsonProperty("Taxonomy")
    val taxonomy: String,
    @JsonProperty("Mode")
    val mode: String = "Category counts",
    @JsonProperty("Maximum number of categories")
    val maximumNumberOfCategories: Int = 1000
)
