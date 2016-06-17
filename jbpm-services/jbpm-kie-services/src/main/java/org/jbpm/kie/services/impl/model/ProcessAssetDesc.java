/*
 * Copyright 2012 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jbpm.kie.services.impl.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jbpm.services.api.model.ProcessDefinition;

/**
 *
 */
public class ProcessAssetDesc implements ProcessDefinition {
    
    private static final long serialVersionUID = -9059086115873165296L;
    
    private String id;
    private String name;
    private String version;
    private String packageName;
    private String type;
    private String knowledgeType;
    private String namespace;
    private String originalPath;
    private String deploymentId;
    private String encodedProcessSource;
    private Map<String, String> forms = new HashMap<String, String>();
    private List<String> roles = new ArrayList<String>();
    
    private Map<String, Collection<String>> associatedEntities;
    private Map<String, String> serviceTasks;
    private Map<String, String> processVariables;
    private Collection<String> reusableSubProcesses;
    
    private boolean active = true;

	public ProcessAssetDesc() {
    }

    
    public ProcessAssetDesc(String id, String name, String version, String packageName, String type, String knowledgeType, String namespace, String deploymentId) {
        this.id = safeValue(id);
        this.name = safeValue(name);
        this.version = safeValue(version);
        this.packageName = safeValue(packageName);
        this.type = safeValue(type);
        this.knowledgeType = safeValue(knowledgeType);
        this.namespace = safeValue(namespace);
        this.deploymentId = safeValue(deploymentId);
    }
    
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getType() {
        return type;
    }

    public String getKnowledgeType() {
        return knowledgeType;
    }

    public String getNamespace() {
        return namespace;
    }
 
    @Override
    public String toString() {
        return "ProcessDesc{id=" + id + ", name=" + name + ", version=" + version + ", packageName=" + packageName 
        		+ ", type=" + type + ", knowledgeType=" + knowledgeType + ", namespace=" + namespace + "active=" + active + "}";
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getOriginalPath() {
        return originalPath;
    }

    public void setOriginalPath(String originalPath) {
        this.originalPath = originalPath;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 17 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 17 * hash + (this.version != null ? this.version.hashCode() : 0);
        hash = 17 * hash + (this.packageName != null ? this.packageName.hashCode() : 0);
        hash = 17 * hash + (this.type != null ? this.type.hashCode() : 0);
        hash = 17 * hash + (this.knowledgeType != null ? this.knowledgeType.hashCode() : 0);
        hash = 17 * hash + (this.namespace != null ? this.namespace.hashCode() : 0);    
        hash = 17 * hash + (this.originalPath != null ? this.originalPath.hashCode() : 0);
        hash = 17 * hash + (this.deploymentId != null ? this.deploymentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProcessAssetDesc other = (ProcessAssetDesc) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.version == null) ? (other.version != null) : !this.version.equals(other.version)) {
            return false;
        }
        if ((this.packageName == null) ? (other.packageName != null) : !this.packageName.equals(other.packageName)) {
            return false;
        }
        if ((this.type == null) ? (other.type != null) : !this.type.equals(other.type)) {
            return false;
        }
        if ((this.knowledgeType == null) ? (other.knowledgeType != null) : !this.knowledgeType.equals(other.knowledgeType)) {
            return false;
        }
        if ((this.namespace == null) ? (other.namespace != null) : !this.namespace.equals(other.namespace)) {
            return false;
        }
        if ((this.originalPath == null) ? (other.originalPath != null) : !this.originalPath.equals(other.originalPath)) {
            return false;
        }
        if ((this.deploymentId == null) ? (other.deploymentId != null) : !this.deploymentId.equals(other.deploymentId)) {
            return false;
        }
        return true;
    }


    public String getDeploymentId() {
        return deploymentId;
    }


    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }


    public String getEncodedProcessSource() {
        return encodedProcessSource;
    }


    public void setEncodedProcessSource(String processString) {
        this.encodedProcessSource = processString;
    }


    public Map<String, String> getForms() {
        return forms;
    }


    public void setForms(Map<String, String> forms) {
        this.forms = forms;
    }

    public void addForm(String id, String formContent) {
        this.forms.put(id, formContent);
    }

	public List<String> getRoles() {
		return roles;
	}


	public void setRoles(List<String> roles) {
		this.roles = roles;
	}


	@Override
	public Map<String, Collection<String>> getAssociatedEntities() {
		return associatedEntities;
	}


	@Override
	public Map<String, String> getServiceTasks() {
		return serviceTasks;
	}


	@Override
	public Map<String, String> getProcessVariables() {
		return processVariables;
	}


	@Override
	public Collection<String> getReusableSubProcesses() {
		return reusableSubProcesses;
	}


	public void setAssociatedEntities(
			Map<String, Collection<String>> associatedEntities) {
		this.associatedEntities = associatedEntities;
	}


	public void setServiceTasks(Map<String, String> serviceTasks) {
		this.serviceTasks = serviceTasks;
	}


	public void setProcessVariables(Map<String, String> processVariables) {
		this.processVariables = processVariables;
	}


	public void setReusableSubProcesses(Collection<String> reusableSubProcesses) {
		this.reusableSubProcesses = reusableSubProcesses;
	}
    
    private String safeValue(String value) {
    	if (value == null) {
    		return "";
    	}
    	
    	return value;
    }


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}
}
