package com.opentext.axcelerate.adp.kotlin.args

import com.fasterxml.jackson.annotation.JsonProperty

class OutputTaxonomy(outputTaxonomy: String) {
    @JsonProperty("Taxonomy")
    var taxonomy: String
    @JsonProperty("Mode")
    var mode: String = "Category counts"
    @JsonProperty("Maximum number of categories")
    var maximumNumberOfCategories: Int = 1000

    init {
        val items = outputTaxonomy.split("|")
        when (items.size) {
            1 -> taxonomy = items[0]
            3 -> {
                taxonomy = items[0]
                mode = items[1]
                maximumNumberOfCategories = items[2].toInt()
            }
            else -> throw Exception("not able to split $outputTaxonomy properly")
        }
    }
}
