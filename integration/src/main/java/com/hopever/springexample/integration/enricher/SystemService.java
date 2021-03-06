/*
 * Copyright 2002-2012 the original author or authors.
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
package com.hopever.springexample.integration.enricher;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Simple Service class for retrieving user information.
 *
 * @author Gunnar Hillert
 *
 */
public class SystemService {

	private static Logger logger = LoggerFactory.getLogger(SystemService.class);

	/** Default Constructor. */
	public SystemService() {
		super();
	}

	public User findUser(User user) {

		logger.info(String.format("Calling method 'findUser' with parameter %s", user));

		final User fullUser = new User(user.getUsername(),
									   "secret",
									   user.getUsername() + "@springintegration.org");
		return fullUser;
	}

	public User findUserByUsername(String username) {

		logger.info(String.format("Calling method 'findUserByUsername' with parameter: %s", username));

		return new User(username, "secret", username + "@springintegration.org");

	}

}
