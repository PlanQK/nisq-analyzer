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

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;

public class CompilationJobListDto extends RepresentationModel<CompilationJobListDto> {

    @Getter
    private final List<CompilationJobDto> compilationJobList = new ArrayList<>();

    public void add(final List<CompilationJobDto> compilationJobDtos) {
        this.compilationJobList.addAll(compilationJobDtos);
    }

    public void add(final CompilationJobDto compilationJobDto) {
        this.compilationJobList.add(compilationJobDto);
    }
}
