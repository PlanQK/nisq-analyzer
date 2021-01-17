/*******************************************************************************
 * Copyright (c) 2020 University of Stuttgart
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package org.planqk.nisq.analyzer.core.connector;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.planqk.nisq.analyzer.core.model.ExecutionResult;
import org.planqk.nisq.analyzer.core.model.ParameterValue;
import org.planqk.nisq.analyzer.core.model.Parameter;
import org.planqk.nisq.analyzer.core.model.Qpu;
import org.planqk.nisq.analyzer.core.repository.ExecutionResultRepository;

/**
 * Interface for the interaction with a certain SDK.
 */
public interface SdkConnector {

    /**
     * Execute the given quantum algorithm implementation with the given input parameters.
     *
     * @param algorithmImplementationURL the URL to the file containing the quantum algorithm implementation that should
     *                                   be executed
     * @param qpu                        the QPU to execute the implementation on
     * @param parameters                 the input parameters for the quantum algorithm execution
     * @param resultRepository           the object to update the current state of the long running task and to add the
     *                                   results after completion
     */
    void executeQuantumAlgorithmImplementation(URL algorithmImplementationURL, Qpu qpu, Map<String, ParameterValue> parameters, ExecutionResult executionResult, ExecutionResultRepository resultService);

    /**
     * Analyse the quantum algorithm implementation located at the given URL after transpiling it for the given QPU and
     * with the given input parameters.
     *
     * @param algorithmImplementationURL the URL to the file containing the quantum algorithm implementation that should
     *                                   be analyzed
     * @param qpu                        the QPU to analyze the implementation for
     * @param parameters                 he input parameters for the quantum algorithm implementation
     * @return the object containing all analysed properties of the quantum circuit
     */
    CircuitInformation getCircuitProperties(URL algorithmImplementationURL, Qpu qpu, Map<String, ParameterValue> parameters);

    /**
     * Returns the names of the Sdks that are supported by the connector
     *
     * @return the names of the supported SDKs
     */
    List<String> supportedSdks();

    /**
     * Returns the names of the providers that are supported by the connector
     *
     * @return the names of the supported providers
     */
    List<String> supportedProviders();

    /**
     * Get parameters which are required by the SDK to execute a quantum circuit and which are independent of
     * problem-specific input data
     *
     * @return a Set of required parameters
     */
    Set<Parameter> getSdkSpecificParameters();

    /**
     * Returns the unique name of the implemented SDK connector
     * @return
     */
    String getName();
}
