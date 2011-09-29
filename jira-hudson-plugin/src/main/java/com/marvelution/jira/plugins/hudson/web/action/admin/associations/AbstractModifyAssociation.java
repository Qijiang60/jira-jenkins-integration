/*
 * Licensed to Marvelution under one or more contributor license 
 * agreements.  See the NOTICE file distributed with this work 
 * for additional information regarding copyright ownership.
 * Marvelution licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.marvelution.jira.plugins.hudson.web.action.admin.associations;

import java.util.Collection;

import org.apache.commons.lang.StringUtils;

import com.marvelution.jira.plugins.hudson.services.associations.HudsonAssociation;
import com.marvelution.jira.plugins.hudson.services.associations.HudsonAssociationFactory;
import com.marvelution.jira.plugins.hudson.services.associations.HudsonAssociationManager;
import com.marvelution.jira.plugins.hudson.services.servers.HudsonServerManager;
import com.marvelution.jira.plugins.hudson.web.action.admin.AbstractHudsonAdminWebActionSupport;
import com.marvelution.jira.plugins.hudson.web.action.admin.KeyValuePair;
import com.marvelution.jira.plugins.hudson.web.action.admin.ModifyActionType;

/**
 * Abstract Modify Server WebAction
 * 
 * @author <a href="mailto:markrekveld@marvelution.com">Mark Rekveld</a>
 */
@SuppressWarnings("unchecked")
public abstract class AbstractModifyAssociation extends AbstractHudsonAdminWebActionSupport {

	private static final long serialVersionUID = 1L;

	protected final HudsonAssociationFactory associationFactory;
	protected final HudsonAssociationManager associationManager;
	protected HudsonAssociation association;

	/**
	 * Constructor
	 * 
	 * @param serverManager the {@link HudsonServerManager} implementation
	 * @param associationFactory the {@link HudsonAssociationFactory} implementation
	 * @param associationManager the {@link HudsonAssociationManager} implementation
	 */
	protected AbstractModifyAssociation(HudsonServerManager serverManager, HudsonAssociationFactory associationFactory,
			HudsonAssociationManager associationManager) {
		super(serverManager);
		this.associationFactory = associationFactory;
		this.associationManager = associationManager;
		association = associationFactory.create();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doValidation() {
		if (getHudsonId() == 0) {
			addError("hudsonId", getText("hudson.association.server.required"));
		}
		if (getProjectId() == 0) {
			addError("projectId", getText("hudson.association.project.required"));
		}
		if (StringUtils.isBlank(getJobName())) {
			addError("jobname", getText("hudson.association.jobname.required"));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String doExecute() throws Exception {
		if (hasAnyErrors()) {
			return INPUT;
		}
		associationManager.addAssociation(association);
		return getRedirect(ADMINISTER_ASSOCIATIONS);
	}

	/**
	 * Getter for the action type eg: Add/Update
	 * 
	 * @return the {@link ModifyActionType} action
	 */
	public abstract ModifyActionType getActionType();

	/**
	 * Getter for a {@link Collection} of {@link KeyValuePair} objects to be added to the form in hidden inputs
	 * 
	 * @return the {@link Collection} of {@link KeyValuePair} objects
	 */
	public abstract Collection<KeyValuePair> getExtraHiddenInput();

	/**
	 * Getter for the Job Options available on the Hudson Server
	 * 
	 * @return the {@link Collection} of {@link String} options
	 */
	public abstract Collection<String> getJobOptions();

	/**
	 * Getter for associationId
	 * 
	 * @return the associationId
	 */
	public int getAssociationId() {
		return association.getAssociationId();
	}

	/**
	 * Setter for associationId
	 * 
	 * @param associationId the associationId to set
	 */
	public void setAssociationId(int associationId) {
		association.setAssociationId(associationId);
	}

	/**
	 * Getter for hudsonId
	 * 
	 * @return the hudsonId
	 */
	public int getHudsonId() {
		return association.getServerId();
	}

	/**
	 * Setter for hudsonId
	 * 
	 * @param hudsonId the hudsonId to set
	 */
	public void setHudsonId(int hudsonId) {
		association.setServerId(hudsonId);
	}

	/**
	 * Getter for projectId
	 * 
	 * @return the projectId
	 */
	public long getProjectId() {
		return association.getProjectId();
	}

	/**
	 * Setter for projectId
	 * 
	 * @param projectId the projectId to set
	 */
	public void setProjectId(long projectId) {
		association.setProjectId(projectId);
	}

	/**
	 * Getter for jobname
	 * 
	 * @return the jobname
	 */
	public String getJobName() {
		return association.getJobName();
	}

	/**
	 * Setter for jobname
	 * 
	 * @param jobname the jobname to set
	 */
	public void setJobName(String jobName) {
		association.setJobName(jobName);
	}

}