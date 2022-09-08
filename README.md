# CDK for Terraform - Kotlin App Template

## Overview:

This repository contains a template for a demo app created with [Cloud Development Kit for Terraform](https://www.terraform.io/cdktf) or `cdktf`. The project is written in [Kotlin](https://kotlinlang.org/), uses [Gradle](https://gradle.org) as a build tool, and utilizes the Java version of `cdktf`.

> At current, the application contains a single module that will deploy a Docker container running Nginx locally. Feel free to use it as a reference or a template for whatever you'd like to build.

## Requirements:

### Installation with [Homebrew](https://brew.sh/), package manager for macOS (or Linux).

```
brew install node@16 cdktf terraform docker
```

###  Manual installation:

- **Docker** 
  - [Download](https://www.docker.com/products/docker-desktop/)
- **Node.js** (v16 LTS recommended)
  - [Download](https://nodejs.org/en/)
- **Terraform CLI**
  - [Download](https://www.terraform.io/downloads)
- **CDK for Terraform**
  - npm: `npm install --global cdktf-cli@latest`

## Demonstration:

1. Clone this repository in the directory of your choice.

```
git clone https://github.com/iodeslykos/cdktf-kat.git
```

2. Navigate to base of repository.

```
cd cdktf-kat/
```

3. Ensure the Docker Desktop application (or daemon) is running.

4. Compile, then synthesize and deploy the app with `cdktf`.

```
./gradleW build && cdktf deploy
```

5. Navigate to [http://127.0.0.1:8000](http://127.0.0.1:8000) where you should be greeted with a "Welcome to Nginx!" prompt.

> You can also confirm that the `cdktf-kat_nginx` container is running with `docker ps`.

6. Celebrate your successful deployment! :partying_face:

7. Destroy the app.


```
cdktf destroy
```

## Roadmap:

- [X] Add a LICENSE (Mozilla Public License Version 2.0)
- [X] Complete README.md and other relevant documentation.
- [X] Include examples of unit testing.
