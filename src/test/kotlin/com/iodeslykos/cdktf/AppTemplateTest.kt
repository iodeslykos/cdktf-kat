package com.iodeslykos.cdktf

import com.hashicorp.cdktf.TerraformStack
import com.hashicorp.cdktf.Testing
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class AppTemplateTest {
    private val stack = TerraformStack(Testing.app(), "stack")

    @Test
    fun myAppTest() {
        Assertions.assertTrue(true)
    }

    @Test
    fun checkValidity() {
        Assertions.assertTrue(Testing.toBeValidTerraform(Testing.fullSynth(stack)))
    }
}