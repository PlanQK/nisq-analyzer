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

package org.planqk.nisq.analyzer.core.services;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.planqk.nisq.analyzer.core.listener.EntityCreatedEvent;
import org.planqk.nisq.analyzer.core.model.Implementation;
import org.planqk.nisq.analyzer.core.repository.ImplementationRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ImplementationServiceImpl implements ImplementationService {

    private final ApplicationEventPublisher applicationEventPublisher;

    private final ImplementationRepository implementationRepository;

    @Override
    public Implementation save(Implementation implementation) {
        Implementation savedImplementation = implementationRepository.save(implementation);

        applicationEventPublisher.publishEvent(new EntityCreatedEvent<>(savedImplementation));

        return savedImplementation;
    }

    @Override
    public List<Implementation> findAll() {
        return implementationRepository.findAll();
    }

    @Override
    public Page<Implementation> findAll(Pageable pageable) {
        return implementationRepository.findAll(pageable);
    }

    @Override
    public Optional<Implementation> findById(Long implId) {
        return implementationRepository.findById(implId);
    }

    @Override
    public List<Implementation> findByImplementedAlgorithm(Long algorithm) {
        return implementationRepository.findByImplementedAlgorithm(algorithm);
    }
}
