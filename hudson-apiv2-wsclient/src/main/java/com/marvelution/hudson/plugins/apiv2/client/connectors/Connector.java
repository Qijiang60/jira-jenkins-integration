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

package com.marvelution.hudson.plugins.apiv2.client.connectors;

import com.marvelution.hudson.plugins.apiv2.client.services.Query;
import com.marvelution.hudson.plugins.apiv2.resources.model.Model;

/**
 * Connector interface.
 * 
 * @author <a href="mailto:markrekveld@marvelution.com">Mark Rekveld<a/>
 */
public interface Connector {

	/**
	 * Method to execute a {@link Query} for a specific {@link Model} identified by the MODEL type
	 * 
	 * @param <MODEL> the type of {@link Model} class the {@link Query} can request
	 * @param query the {@link Query} implementation for a specific {@link Model} to execute
	 * @return the {@link ConnectorResponse} that gives access to the response of the {@link Query}
	 */
	<MODEL extends Model> ConnectorResponse execute(Query<MODEL> query);

}
