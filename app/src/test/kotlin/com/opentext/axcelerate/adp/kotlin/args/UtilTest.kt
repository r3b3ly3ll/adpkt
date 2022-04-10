package com.opentext.axcelerate.adp.kotlin.args

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.Test
import kotlin.test.assertEquals


class UtilTest {
    @Test
    fun testEngineTaxonomies() {
        // reset displayName and description
        val taxonomies = Util.stringToEngineTaxonomies("rm_custodian!=John Doe,rm_mimetype=pdf")
        val expected = """[{"Taxonomy":"rm_custodian","Negation":true,"Query":"John Doe"},{"Taxonomy":"rm_mimetype","Negation":false,"Query":"pdf"}]"""
        assertEquals(expected, jacksonObjectMapper().writeValueAsString(taxonomies))
    }

    @Test
    fun testEngineTaxonomiesWithNull() {
        val taxonomies = Util.stringToEngineTaxonomies(null)
        val expected = "[]"
        assertEquals(expected, jacksonObjectMapper().writeValueAsString(taxonomies))
    }

    @Test
    fun testOutputTaxonomies() {
        val taxonomies = Util.stringToOutputTaxonomies("rm_copy,rm_custodian")
        val expected = """[{"Taxonomy":"rm_copy","Mode":"Category counts","Maximum number of categories":1000},{"Taxonomy":"rm_custodian","Mode":"Category counts","Maximum number of categories":1000}]"""
        assertEquals(expected, jacksonObjectMapper().writeValueAsString(taxonomies))
    }

    @Test
    fun testOutputTaxonomiesWithNull() {
        val taxonomies = Util.stringToOutputTaxonomies(null)
        val expected = "[]"
        assertEquals(expected, jacksonObjectMapper().writeValueAsString(taxonomies))
    }
}