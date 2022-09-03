# CDK for Terraform - Kotlin App Template

## Overview:

This repository contains a template for an demo app created with [Cloud Development Kit for Terraform](https://www.terraform.io/cdktf) or `cdktf`. The project is written in [Kotlin](https://kotlinlang.org/), uses [Gradle](https://gradle.org) as a build tool, and utilizes the Java version of `cdktf`.

> At current, the application contains a single module that will deploy a Docker container running Nginx locally. Feel free to use it as a reference or a base for whatever you'd like to build.

## Requirements:

- **Docker** 
  - [Download](https://www.docker.com/products/docker-desktop/)
- **Node.js** (v16 LTS recommended)
  - [Download](https://nodejs.org/en/)
  - Homebrew (MacOS): `brew install node@16`
- **Terraform CLI**
  - [Download](https://www.terraform.io/downloads)
  - Homebrew (MacOS): `brew install terraform`
- **CDK for Terraform**
  - npm: `npm install --global cdktf-cli@latest` 
  - Homebrew (MacOS): `brew install cdktf`

## Roadmap:

- [X] Add a LICENSE (Mozilla Public License Version 2.0)
- [ ] Complete README.md and other relevant documentation.
- [ ] Include examples of proper unit testing.