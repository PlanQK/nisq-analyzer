/*******************************************************************************
 * Copyright (c) 2021 University of Stuttgart
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

package org.planqk.nisq.analyzer.core.web.dtos.entities;

import java.time.OffsetDateTime;
import java.util.UUID;

import org.planqk.nisq.analyzer.core.model.QpuSelectionResult;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Relation(itemRelation = "qpuSelectionResult", collectionRelation = "qpuSelectionResults")
@EqualsAndHashCode(callSuper = false)
@Data
public class QpuSelectionResultDto extends RepresentationModel<QpuSelectionResultDto> {

    UUID id;

    String provider;

    String qpu;

    int queueSize;

    private OffsetDateTime time;

    private String circuitName;

    String transpiledCircuit;

    String transpiledLanguage;

    String compiler;

    int analyzedDepth;

    int analyzedWidth;

    public static final class Converter {

        public static QpuSelectionResultDto convert(final QpuSelectionResult object) {
            QpuSelectionResultDto dto = new QpuSelectionResultDto();
            dto.setId(object.getId());
            dto.setProvider(object.getProvider());
            dto.setQpu(object.getQpu());
            dto.setQueueSize(object.getQueueSize());
            dto.setTime(object.getTime());
            dto.setCircuitName(object.getCircuitName());
            dto.setTranspiledCircuit(object.getTranspiledCircuit());
            dto.setTranspiledLanguage(object.getTranspiledLanguage());
            dto.setCompiler(object.getUsedCompiler());
            dto.setAnalyzedDepth(object.getAnalyzedDepth());
            dto.setAnalyzedWidth(object.getAnalyzedWidth());
            return dto;
        }
    }
}
