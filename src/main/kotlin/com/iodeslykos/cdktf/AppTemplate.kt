package com.iodeslykos.cdktf

import com.hashicorp.cdktf.App

object AppTemplate {
    @JvmStatic
    fun main(args: Array<String>) {
        val app = App()
        AppTemplateStack(app, "cdktf.KotlinAppTemplate")
        app.synth()
    }
}