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

package com.marvelution.jira.plugins.hudson.api.model.triggers;

import com.thoughtworks.xstream.annotations.XStreamAlias;


/**
 * Remote {@link Trigger}. {@link Trigger} that indicates that a remote server triggered the build
 * 
 * @author <a href="mailto:markrekveld@marvelution.com">Mark Rekveld</a>
 */
@XStreamAlias("remoteTrigger")
public class RemoteTrigger implements Trigger {

	private String host;

	private String note;

	/**
	 * Default no-argument constructor for XStream
	 */
	public RemoteTrigger() {
	}

	/**
	 * Constructor
	 * 
	 * @param host the remote host
	 */
	public RemoteTrigger(String host) {
		setHost(host);
	}

	/**
	 * Constructor
	 * 
	 * @param host the remote host
	 * @param note the note
	 */
	public RemoteTrigger(String host, String note) {
		this(host);
		setNote(note);
	}

	/**
	 * Gets the remote host
	 * 
	 * @return the remote host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * Sets the remote host
	 * 
	 * @param host the remote host
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * Gets the note added by the remote host
	 * 
	 * @return the note added by the remote host
	 */
	public String getNote() {
		return note;
	}

	/**
	 * Sets the note added by the remote host
	 * 
	 * @param note the note added by the remote host
	 */
	public void setNote(String note) {
		this.note = note;
	}

}