# NISQ-Analyzer

[![Build Status](https://api.travis-ci.com/UST-QuAntiL/nisq-analyzer.svg?branch=master)](https://travis-ci.com/UST-QuAntiL/nisq-analyzer)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

## Build

1. Run `mvn package -DskipTests` inside the root folder.
2. When completed, the built product can be found in `org.planqk.nisq.analyzer.core/target`.

## Running via Docker

The easiest way to get started is using Docker-Compose: [planqk-docker](https://github.com/PlanQK/planqk-docker)

Alternatively you can build and run the NISQ-Analyzer Docker image by your own:

1. `docker build -t nisq-analyzer .`
   In case, there are issues, you can also try `docker build --no-cache -t nisq-analyzer .`
2. `docker run -p 8080:8080 nisq-analyzer` to run the NISQ-Analyzer on <http://localhost:8080>

You can also use the pre-built image:

    docker run -p 8080:8080 planqk/nisq-analyzer
	
## Running on Tomcat

Build the project and deploy the WAR file located at `org.planqk.nisq.analyzer.core/target` to Tomcat.

Make sure you have an accessibly Postgres database and configure the application correspondingly.

Prerequisites:

- [SWI Prolog](https://www.swi-prolog.org/) is installed on the machine where the Tomcat runs and the Path is configured correspondingly

## Haftungsausschluss

Dies ist ein Forschungsprototyp.
Die Haftung für entgangenen Gewinn, Produktionsausfall, Betriebsunterbrechung, entgangene Nutzungen, Verlust von Daten und Informationen, Finanzierungsaufwendungen sowie sonstige Vermögens- und Folgeschäden ist, außer in Fällen von grober Fahrlässigkeit, Vorsatz und Personenschäden, ausgeschlossen.

## Disclaimer of Warranty

Unless required by applicable law or agreed to in writing, Licensor provides the Work (and each Contributor provides its Contributions) on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied, including, without limitation, any warranties or conditions of TITLE, NON-INFRINGEMENT, MERCHANTABILITY, or FITNESS FOR A PARTICULAR PURPOSE.
You are solely responsible for determining the appropriateness of using or redistributing the Work and assume any risks associated with Your exercise of permissions under this License.
