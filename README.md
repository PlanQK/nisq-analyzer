# NISQ-Analyzer

[![Build Status](https://api.travis-ci.com/UST-QuAntiL/nisq-analyzer.svg?branch=master)](https://travis-ci.com/UST-QuAntiL/nisq-analyzer)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

## Build

1. Run `mvn package -DskipTests` inside the root folder.
2. When completed, the built product can be found in `org.planqk.nisq.analyzer.core/target`.

## Setup via Docker

* For running the QuAntiL environment with all its components use the docker-compose of [quantil-docker](https://github.com/UST-QuAntiL/quantil-docker).  

* Otherwise, clone repository:
```
git clone https://github.com/UST-QuAntiL/nisq-analyzer.git   
git clone git@github.com:UST-QuAntiL/nisq-analyzer.git
```

* Start NISQ Analyzer and PostgreSQL containers:
```
docker-compose pull
docker-compose up
```

* Additionally, the [Qiskit Service](https://github.com/UST-QuAntiL/qiskit-service/) can be started by adapting the command:
```
docker-compose -f docker-compose.yml -f ../qiskit-service/docker-compose.yml pull
docker-compose -f docker-compose.yml -f ../qiskit-service/docker-compose.yml up
```

Now the NISQ Analyzer is available on http://localhost:8081/.  
If you also started the Qiskit Service, it is available on http://localhost:5000/.
	
## Running on Tomcat

Build the project and deploy the WAR file located at `org.planqk.nisq.analyzer.core/target` to Tomcat.

Make sure you have an accessibly Postgres database and configure the application correspondingly.

Prerequisites:

- [SWI Prolog](https://www.swi-prolog.org/) is installed on the machine where the Tomcat runs and the Path is configured correspondingly

## Sample Data

Suitable sample data in JSON format can be found in [nisq-analyzer-content](https://github.com/UST-QuAntiL/nisq-analyzer-content/tree/master/objects).

## Usage via API

Use the [HAL Browser](http://localhost:8081/nisq-analyzer/browser/index.html#http://localhost:8081/nisq-analyzer/) or [Swagger-UI](http://localhost:8081/nisq-analyzer/swagger-ui/index.html?configUrl=/nisq-analyzer/v3/api-docs/swagger-config#/).

### Data Creation  
1. create a SDK via `POST /nisq-analyzer/sdks/`
2. create an implementation via `POST /nisq-analyzer/implementations/` (via API, an arbitrary UUID for the implementedAlgorithm attribute can be used for implementations of one quantum algorithm)

### Implementation and QPU Selection & Execution Mechanism of NISQ Analyzer + Qiskit Service
Get the required selection parameters via `GET /nisq-analyzer/selection-params` with {algoId}.  

For using the selection mechanism use  
`POST /nisq-analyzer/selection`
```
{
  "algorithmId": "UUID-OF-DESIRED-QUANTUM-ALGORITHM",
  "parameters": {
    "SELECTION-PARAM-1": "YOUR-VALUE-1",
    ...
    "SELECTION-PARAM-N": "YOUR-VALUE-N",
    "token": "YOUR-IBMQ-TOKEN"
  }
}
```

Get analysis results via `GET /nisq-analyzer/results/algorithm/{algoId}`.  
Start the execution of an implementation and its analysis result via `POST /nisq-analyzer/results/{resId}/execute`.  
Get execution results of an implementation via `POST /nisq-analyzer/implementations/{implId}/results/`.  

### Compiler Selection & Circuit Execution Mechanism of NISQ Analyzer  

* For running the compiler-selection with all its components use the docker-compose in [nisq-analyzer-content/compiler-selection](https://github.com/UST-QuAntiL/nisq-analyzer-content/tree/master/compiler-selection). 

For using the compiler selection mechanism use  
`POST /nisq-analyzer/compiler-selection`
```
{
  "providerName": "NAME-OF-PROVIDER",
  "qpuName": "QPU-NAME",
  "token": "YOUR-IBMQ-TOKEN",
  "circuitLanguage": "LANGUAGE-OF-CIRCUIT",
  "circuitName": "NAME-OF-CIRCUIT",
  "circuitUrl: "URL-OF-RAW-CIRCUIT"
}
```
**Note**: Instead of the URL, also a file can be uploaded containing the quantum circuit.  
Get compiler analysis results via `GET /nisq-analyzer/compiler-results/jobs/{resId}`.  
Start the execution of a certain compiled circuit via `POST /nisq-analyzer/compiler-results/{resId}/execute`.  
Get execution result of the circuit via `POST /nisq-analyzer/execution-results/{resultId}`.  

## Haftungsausschluss

Dies ist ein Forschungsprototyp.
Die Haftung für entgangenen Gewinn, Produktionsausfall, Betriebsunterbrechung, entgangene Nutzungen, Verlust von Daten und Informationen, Finanzierungsaufwendungen sowie sonstige Vermögens- und Folgeschäden ist, außer in Fällen von grober Fahrlässigkeit, Vorsatz und Personenschäden, ausgeschlossen.

## Disclaimer of Warranty

Unless required by applicable law or agreed to in writing, Licensor provides the Work (and each Contributor provides its Contributions) on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied, including, without limitation, any warranties or conditions of TITLE, NON-INFRINGEMENT, MERCHANTABILITY, or FITNESS FOR A PARTICULAR PURPOSE.
You are solely responsible for determining the appropriateness of using or redistributing the Work and assume any risks associated with Your exercise of permissions under this License.
