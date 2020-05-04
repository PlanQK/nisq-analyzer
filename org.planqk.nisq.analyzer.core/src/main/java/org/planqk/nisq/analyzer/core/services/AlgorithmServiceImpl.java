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

import java.util.Optional;

import org.planqk.nisq.analyzer.core.model.Algorithm;
import org.planqk.nisq.analyzer.core.repository.AlgorithmRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class AlgorithmServiceImpl implements AlgorithmService {

    private AlgorithmRepository algorithmRepository;

    public AlgorithmServiceImpl(AlgorithmRepository algorithmRepository) {
        this.algorithmRepository = algorithmRepository;
    }

    @Override
    public Algorithm save(Algorithm algorithm) {
        return algorithmRepository.save(algorithm);
    }

    @Override
    public Page<Algorithm> findAll(Pageable pageable) {
        return algorithmRepository.findAll(pageable);
    }

    @Override
    public Optional<Algorithm> findById(Long algoId) {
        return algorithmRepository.findById(algoId);
    }

    @Override
    public void deleteAlgorithm(Algorithm algorithm) {
        algorithmRepository.delete(algorithm);
    }
}
