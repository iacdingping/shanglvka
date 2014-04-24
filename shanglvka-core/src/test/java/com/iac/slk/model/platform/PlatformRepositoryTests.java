/*
 * Copyright 2012-2013 the original author or authors.
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
package com.iac.slk.model.platform;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iac.slk.Application;

/**
 * Integration tests for {@link PlatformRepository}.
 * 
 * @author Oliver Gierke
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class PlatformRepositoryTests {

	@Autowired
	PlatformRepository repository;

	@Test
	public void pageList() {

		Page<PlatformUser> platformUsers = this.repository.findAll(new PageRequest(0, 10));
		assertThat(platformUsers.getTotalElements(), is(equalTo(0L)));
	}
	
	@Test
	public void getByPlatformCoding() {
		PlatformUser user = this.repository.getByPlatformCoding("xxx");
		assertThat(user, is(equalTo(null)));
	}
}
