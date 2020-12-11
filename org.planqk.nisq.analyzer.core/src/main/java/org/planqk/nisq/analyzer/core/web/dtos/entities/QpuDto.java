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

package org.planqk.nisq.analyzer.core.web.dtos.entities;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.planqk.nisq.analyzer.core.model.Qpu;
import org.planqk.nisq.analyzer.core.model.Sdk;
import org.springframework.hateoas.RepresentationModel;

/**
 * Data transfer object for the model class {@link Qpu}.
 */
@ToString(callSuper = true, includeFieldNames = true)
public class QpuDto extends RepresentationModel<QpuDto> {

    @Getter
    @Setter
    private UUID id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private int numberOfQubits;

    @Getter
    @Setter
    @JsonProperty("avgT1Time")
    private float t1;

    @Getter
    @Setter
    private float maxGateTime;

    @Getter
    @Setter
    private boolean simulator;

    public static final class Converter {

        public static QpuDto convert(final Qpu object) {
            QpuDto dto = new QpuDto();
            dto.setId(object.getId());
            dto.setName(object.getName());
            dto.setNumberOfQubits(object.getQubitCount());
            dto.setT1(object.getT1());
            dto.setMaxGateTime(object.getMaxGateTime());
            return dto;
        }

        public static Qpu convert(final QpuDto object, final List<Sdk> supportedSdks) {
            Qpu qpu = new Qpu();
            qpu.setId(object.getId());
            qpu.setName(object.getName());
            qpu.setQubitCount(object.getNumberOfQubits());
            qpu.setSimulator(object.isSimulator());

            // Todo: currently the units do not match and are fixed with simple workaround
            qpu.setT1(object.getT1() * 1000);

            qpu.setMaxGateTime(object.getMaxGateTime());
            qpu.setSupportedSdks(supportedSdks);
            return qpu;
        }
    }
}
