package com.opentext.axcelerate.adp.kotlin.args

import com.fasterxml.jackson.annotation.JsonProperty

class EngineTaxonomy(engineTaxonomy: String) {
    @JsonProperty("Taxonomy")
    var taxonomy: String? = null
    @JsonProperty("Negation")
    var negation: Boolean? = null
    @JsonProperty("Query")
    var query: String? = null

    companion object {
        const val NE = "!="
        const val EQ = "="
    }

    init {
        val items: List<String> = if (engineTaxonomy.contains(NE)) engineTaxonomy.split(NE) else engineTaxonomy.split(EQ)
        val neg: Boolean = engineTaxonomy.contains(NE)
        if (items.size == 2) {
            taxonomy = items[0]
            negation = neg
            query = items[1]
        } else {
            throw Exception("not able to split $engineTaxonomy properly")
        }
    }
}