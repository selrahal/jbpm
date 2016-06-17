/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package org.jbpm.services.task.persistence;

import javax.persistence.EntityManager;

import org.drools.persistence.jpa.AbstractPersistenceContextManager;
import org.kie.api.runtime.Environment;
import org.kie.api.runtime.EnvironmentName;
import org.kie.internal.task.api.TaskPersistenceContext;
import org.kie.internal.task.api.TaskPersistenceContextManager;

public class JPATaskPersistenceContextManager extends
		AbstractPersistenceContextManager implements
		TaskPersistenceContextManager {
	
	public JPATaskPersistenceContextManager(Environment environment) {
		super(environment);
	}

	@Override
	public TaskPersistenceContext getPersistenceContext() {
		Boolean locking = (Boolean) env.get(EnvironmentName.USE_PESSIMISTIC_LOCKING);
        if( locking == null ) { 
            locking = false;
        }
        
        boolean useJTA = true; 
		EntityManager em = getCommandScopedEntityManager();
		return new JPATaskPersistenceContext(em, useJTA, locking);
	}

	@Override
	public void beginCommandScopedEntityManager() {
		getCommandScopedEntityManager();
	}

}
