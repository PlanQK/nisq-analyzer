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

package org.planqk.nisq.analyzer.core.model;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Object to represent the result of a analysis for a certain qpu and implementation
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
public class AnalysisResult extends HasId {
    private UUID implementedAlgorithm;

    @ManyToOne
    private Qpu qpu;

    @ManyToOne
    private Implementation implementation;

    @ElementCollection
    private Map<String, String> inputParameters;

    private int analysedDepth;
    private int analysedWidth;
}
