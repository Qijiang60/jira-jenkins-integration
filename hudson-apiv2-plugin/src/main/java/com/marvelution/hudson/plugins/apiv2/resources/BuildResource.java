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

import com.marvelution.hudson.plugins.apiv2.resources.exceptions.NoSuchBuildException;
import com.marvelution.hudson.plugins.apiv2.resources.exceptions.NoSuchJobException;
import com.marvelution.hudson.plugins.apiv2.resources.model.Build;

/**
 * Build Resource Endpoint interface
 * 
 * @author <a href="mailto:markrekveld@marvelution.com">Mark Rekveld<a/>
 */
public interface BuildResource {

	/**
	 * Get a single {@link Build} for a Jobname identified by the build number and job name combination
	 * 
	 * @param jobName the Job name to get the build for
	 * @param buildNumber the build number of the build to get
	 * @return the {@link Build}, may not be <code>null</code>
	 * @throws NoSuchJobException in case the job identified by the jobName doesn't exist
	 * @throws NoSuchBuildException in case the build identified by the buildNumber doesn't exist
	 */
	Build getBuild(String jobName, Integer buildNumber) throws NoSuchJobException, NoSuchBuildException;

	/**
	 * Get all the builds for a specific Job
	 * 
	 * @param jobName the Job name to get all the builds for
	 * @return a {@link List} of {@link Build} objects, may be an <code>empty</code> {@link List}
	 * @throws NoSuchJobException in case the job identified by the jobName doesn't exist
	 */
	List<Build> getBuilds(String jobName) throws NoSuchJobException;

	/**
	 * Get the first {@link Build} of a Job
	 * 
	 * @param jobName the Job name to get the {@link Build} for
	 * @return the first {@link Build} of the Job
	 * @throws NoSuchJobException in case the job identified by the jobName doesn't exist
	 * @throws NoSuchBuildException in case the Job doesn't have a first build doesn't exist
	 */
	Build getFirstBuild(String jobName) throws NoSuchJobException, NoSuchBuildException;

	/**
	 * Get the last {@link Build} of a Job
	 * 
	 * @param jobName the Job name to get the {@link Build} for
	 * @return the last {@link Build} of the Job
	 * @throws NoSuchJobException in case the job identified by the jobName doesn't exist
	 * @throws NoSuchBuildException in case the Job doesn't have a last  build doesn't exist
	 */
	Build getLastBuild(String jobName) throws NoSuchJobException, NoSuchBuildException;

	/**
	 * Get the last successful {@link Build} of a Job
	 * 
	 * @param jobName the Job name to get the {@link Build} for
	 * @return the last successful {@link Build} of the Job
	 * @throws NoSuchJobException in case the job identified by the jobName doesn't exist
	 * @throws NoSuchBuildException in case the Job doesn't have a last successful build doesn't exist
	 */
	Build getLastSuccessfulBuild(String jobName) throws NoSuchJobException, NoSuchBuildException;

	/**
	 * Get the last completed {@link Build} of a Job
	 * 
	 * @param jobName the Job name to get the {@link Build} for
	 * @return the last completed {@link Build} of the Job
	 * @throws NoSuchJobException in case the job identified by the jobName doesn't exist
	 * @throws NoSuchBuildException in case the Job doesn't have a last completed build doesn't exist
	 */
	Build getLastCompletedBuild(String jobName) throws NoSuchJobException, NoSuchBuildException;

	/**
	 * Get the last failed {@link Build} of a Job
	 * 
	 * @param jobName the Job name to get the {@link Build} for
	 * @return the last failed {@link Build} of the Job
	 * @throws NoSuchJobException in case the job identified by the jobName doesn't exist
	 * @throws NoSuchBuildException in case the Job doesn't have a last failed build doesn't exist
	 */
	Build getLastFailedBuild(String jobName) throws NoSuchJobException, NoSuchBuildException;

	/**
	 * Get the last unstable {@link Build} of a Job
	 * 
	 * @param jobName the Job name to get the {@link Build} for
	 * @return the last unstable {@link Build} of the Job
	 * @throws NoSuchJobException in case the job identified by the jobName doesn't exist
	 * @throws NoSuchBuildException in case the Job doesn't have a last unstable build doesn't exist
	 */
	Build getLastUnstableBuild(String jobName) throws NoSuchJobException, NoSuchBuildException;

	/**
	 * Get the last stable {@link Build} of a Job
	 * 
	 * @param jobName the Job name to get the {@link Build} for
	 * @return the last stable {@link Build} of the Job
	 * @throws NoSuchJobException in case the job identified by the jobName doesn't exist
	 * @throws NoSuchBuildException in case the Job doesn't have a last stable build doesn't exist
	 */
	Build getLastStableBuild(String jobName) throws NoSuchJobException, NoSuchBuildException;

}
