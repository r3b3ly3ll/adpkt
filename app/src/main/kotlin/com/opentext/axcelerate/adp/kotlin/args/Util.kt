package com.opentext.axcelerate.adp.kotlin.args

class Util {
    companion object {
        @JvmStatic
        fun stringToEngineTaxonomies(s: String?): ArrayList<EngineTaxonomy> {
            val taxonomies: ArrayList<EngineTaxonomy> = ArrayList(0)
            if (s?.isNotEmpty() == true) {
                for (taxonomy in s.split(",")) {
                    try {
                        taxonomies += EngineTaxonomy(taxonomy)
                    } catch (e: Exception) {
                        continue
                    }
                }
            }
            return taxonomies
        }

        @JvmStatic
        fun stringToOutputTaxonomies(s: String?): ArrayList<OutputTaxonomy> {
            val taxonomies: ArrayList<OutputTaxonomy> = ArrayList(0)
            if (s?.isNotEmpty() == true) {
                for (taxonomy in s.split(",")) {
                    taxonomies += OutputTaxonomy(taxonomy)
                }
            }
            return taxonomies
        }
    }
}