package com.iodeslykos.cdktf

import com.hashicorp.cdktf.App
import com.hashicorp.cdktf.TerraformStack
import com.hashicorp.cdktf.Testing
import com.hashicorp.cdktf.providers.docker.container.Container
import com.hashicorp.cdktf.providers.docker.image.Image
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class AppTemplateTest {
    private val stack: TerraformStack = AppTemplateStack(App(), "AppTemplateStack")
    private val synthesized: String = Testing.synth(stack)

    @Test
    // Ensure that the synthesized template is valid Terraform.
    fun isValidTerraform() {
        Assertions.assertTrue(Testing.toBeValidTerraform(Testing.fullSynth(stack)))
    }

    @Test
    // Ensure that synthesized stack contains a Docker container.
    fun hasDockerContainer() {
        Assertions.assertTrue(Testing.toHaveResource(synthesized, Container.TF_RESOURCE_TYPE))
    }

    @Test
    // Ensure that Docker container is using the latest version of Nginx.
    fun dockerImageUsesLatestNginx() {
        Assertions.assertTrue(
            Testing.toHaveResourceWithProperties(
                synthesized, Image.TF_RESOURCE_TYPE, mapOf("name" to "nginx:latest")
            )
        )
    }

    @Test
    // Ensure that Docker Container is configured as expected.
    fun ensureDockerContainerConfiguration() {
        Assertions.assertTrue(
            Testing.toHaveResourceWithProperties(
                synthesized, Container.TF_RESOURCE_TYPE, mapOf(
                    "ports" to listOf(
                        mapOf(
                            "external" to 8000, "internal" to 80
                        )
                    )
                )
            )
        )
    }
}
