/*
 * Copyright 2012-2014 the original author or authors.
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

package io.spring.initializr.web

import com.gargoylesoftware.htmlunit.html.HtmlPage
import io.spring.initializr.web.support.HomePage
import io.spring.initializr.web.support.StsHomePage

import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Form based tests for the "legacy" home page that STS is still using.
 *
 * @author Stephane Nicoll
 */
@SpringApplicationConfiguration(classes = LegacyStsConfig.class)
class LegacyStsControllerFormIntegrationTests extends AbstractInitializerControllerFormIntegrationTests {

	@Override
	void createSimpleGradleProject() {
		createSimpleGradleProject('gradle.zip')
	}

	@Override
	protected String homeContext() {
		'/sts'
	}

	@Override
	protected HomePage createHomePage(HtmlPage home) {
		new StsHomePage(home)
	}

	@Configuration
	static class LegacyStsConfig {

		@Bean
		@SuppressWarnings("deprecation")
		LegacyStsController legacyStsController() {
			new LegacyStsController()
		}
	}

}
