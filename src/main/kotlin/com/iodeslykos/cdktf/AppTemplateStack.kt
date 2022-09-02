package com.iodeslykos.cdktf

import com.hashicorp.cdktf.TerraformStack
import com.hashicorp.cdktf.providers.docker.Container
import com.hashicorp.cdktf.providers.docker.ContainerPorts
import com.hashicorp.cdktf.providers.docker.DockerProvider
import com.hashicorp.cdktf.providers.docker.Image
import software.constructs.Construct


class AppTemplateStack(scope: Construct, id: String) : TerraformStack(scope, id) {
    init {
        DockerProvider.Builder.create(this, "docker")
            .build()
        val image: Image = Image.Builder.create(this, "nginxImage")
            .name("nginx:latest")
            .keepLocally(false)
            .build()
        Container.Builder.create(this, "nginxContainer")
            .image(image.name)
            .name("cdktf-kat_nginx")
            .ports(
                listOf(
                    ContainerPorts.builder()
                        .internal(80)
                        .external(8000)
                        .build()
                )
            )
            .build()
    }
}
