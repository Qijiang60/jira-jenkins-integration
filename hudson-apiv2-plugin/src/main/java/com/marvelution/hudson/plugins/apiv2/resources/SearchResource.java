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

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.marvelution.hudson.plugins.apiv2.resources.exceptions.NoSuchJobException;
import com.marvelution.hudson.plugins.apiv2.resources.model.build.Build;
import com.marvelution.hudson.plugins.apiv2.resources.model.build.Builds;
import com.marvelution.hudson.plugins.apiv2.resources.model.job.Job;
import com.marvelution.hudson.plugins.apiv2.resources.model.job.Jobs;

/**
 * Search Resource Endpoint interface
 * 
 * @author <a href="mailto:markrekveld@marvelution.com">Mark Rekveld</a>
 */
public interface SearchResource {

	/**
	 * Search for {@link Job} objects on the Hudson instance.
	 * A {@link Job} is matched if the given query is found in the name or the description of the Job in Hudson
	 * 
	 * @param query the query to check against the name or description
	 * @param nameOnly flag to search in the name field only (<code>true</code>) or also in the description field
	 *        (<code>false</code>)
	 * @return the {@link Jobs} collection that matches the search query
	 */
	@GET
	@Path("jobs")
	Jobs searchForJobs(@QueryParam("query") String query, @QueryParam("nameOnly") @DefaultValue("false")
			boolean nameOnly);

	/**
	 * Search for {@link Build} objects on the Hudson instance
	 * A {@link Build} is matched if the given query is found in the change log of a build in Hudson
	 * 
	 * @param query the query to check against in the change log of a build
	 * @param jobName the name of the job to search within
	 * @return the {@link Builds} collection that matches the search query
	 * @throws NoSuchJobException in case the given Job name doesn't exist in Hudson
	 */
	@GET
	@Path("builds")
	Builds searchForBuilds(@QueryParam("query") String query, @QueryParam("jobname") @DefaultValue("") String jobName)
			throws NoSuchJobException;

}
