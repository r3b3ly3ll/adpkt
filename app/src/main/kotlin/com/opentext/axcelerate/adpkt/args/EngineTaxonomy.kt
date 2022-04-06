package com.opentext.axcelerate.adpkt.args

import com.fasterxml.jackson.annotation.JsonProperty

data class EngineTaxonomy (
    @JsonProperty("Taxonomy")
    val taxonomy: String,
    @JsonProperty("Negation")
    val negation: Boolean,
    @JsonProperty("Query")
    val query: String
)