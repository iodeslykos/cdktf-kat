package com.iodeslykos.cdktf

import com.hashicorp.cdktf.TerraformStack
import com.hashicorp.cdktf.providers.docker.container.Container
import com.hashicorp.cdktf.providers.docker.container.ContainerPorts
import com.hashicorp.cdktf.providers.docker.image.Image
import com.hashicorp.cdktf.providers.docker.provider.DockerProvider
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
