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

package com.marvelution.hudson.plugins.apiv2.resources;

import java.util.List;

import com.marvelution.hudson.plugins.apiv2.resources.exceptions.NoSuchJobException;
import com.marvelution.hudson.plugins.apiv2.resources.model.Job;

/**
 * Job Resource Endpoint interface
 * 
 * @author <a href="mailto:markrekveld@marvelution.com">Mark Rekveld<a/>
 */
public interface JobResource {

	/**
	 * Get the {@link Job} identified by the given name
	 * 
	 * @param name the name of the {@link Job} to get
	 * @return the {@link Job}
	 * @throws NoSuchJobException in case the job identified by the jobName doesn't exist
	 */
	Job getJob(String name) throws NoSuchJobException;

	/**
	 * Get all the {@link Job} objects on the Hudson server
	 * 
	 * @return {@link List} of all the {@link Job} objects
	 */
	List<Job> getJobs();

	/**
	 * Get all {@link Job} objects on the Hudson server, but with minimal data
	 * 
	 * @return {@link List} of all the {@link Job} objects with minimal data
	 */
	List<Job> listJobs();

}
