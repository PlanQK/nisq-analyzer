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

package org.planqk.nisq.analyzer.core.listener;

import java.util.List;
import java.util.stream.Collectors;

import org.planqk.nisq.analyzer.core.knowledge.prolog.PrologFactUpdater;
import org.planqk.nisq.analyzer.core.model.Qpu;
import org.planqk.nisq.analyzer.core.model.Sdk;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class QpuEntityEventListener {

    private final PrologFactUpdater prologFactUpdater;

    public QpuEntityEventListener(PrologFactUpdater prologFactUpdater) {
        this.prologFactUpdater = prologFactUpdater;
    }

    @Async
    @EventListener
    public void onQpuCreatedEvent(EntityCreatedEvent<Qpu> event) {
        Qpu qpu = event.getEntity();
        List<String> sdkNames = qpu.getSupportedSdks().stream().map(Sdk::getName).collect(Collectors.toList());
        prologFactUpdater.handleQpuInsertion(qpu.getId(), qpu.getQubitCount(), sdkNames, qpu.getT1(), qpu.getMaxGateTime());
    }
}