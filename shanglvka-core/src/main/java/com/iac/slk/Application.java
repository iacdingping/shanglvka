package com.iac.slk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * If your Main-Class or Configuration annotated by @EnableAutoConfiguration is
 * stored in a subpackage(like sample.data.jpa.config) and not in the root
 * package (sample.data.jpa) spring-data-jpa is not able to find your repository
 * interfaces, even if you define the base packages parameter for the @ComponentScan
 * annotation.
 * 
 * @author IAC-DINGPING
 * 
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
