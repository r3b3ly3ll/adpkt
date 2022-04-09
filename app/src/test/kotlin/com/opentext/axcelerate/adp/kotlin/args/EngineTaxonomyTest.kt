package com.opentext.axcelerate.adp.kotlin.args

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.Test
import kotlin.test.assertEquals

class EngineTaxonomyTest {
    @Test
    fun testEngineTaxonomyWithNegation() {
        // reset displayName and description
        val et = EngineTaxonomy("rm_custodian!=John Doe")
        assertEquals("rm_custodian", et.taxonomy)
        assertEquals(true, et.negation)
        assertEquals("John Doe", et.query)
    }

    @Test
    fun testEngineTaxonomyJsonOutput() {
        val taxonomy = EngineTaxonomy("rm_custodian!=John Doe")
        val expected = """{"Taxonomy":"rm_custodian","Negation":true,"Query":"John Doe"}"""
        assertEquals(expected, jacksonObjectMapper().writeValueAsString(taxonomy))
    }
}
