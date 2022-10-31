package com.rvcode.pdfinvo.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rvcode.pdfinvo.ApplicationLauncher;

/*
 * DOC:@Configuration
 * Spring needs a configuration class in order to construct an ApplicationContext
 * 
 * Spring reads in your @Configuration class and is smart enough to construct your beans/services, 
 * that it can give back to you whenever you call ctx.getBean(someClass).
 */

/*
 * DOC:@EnableWebMvc
 * This annotation makes sure that Spring Web MVC gets initialized with a sane default configuration.
 */

@Configuration
@ComponentScan(basePackageClasses = ApplicationLauncher.class)
@PropertySource("classpath:/application.properties")
@PropertySource(value = "classpath:/application-${spring.profiles.active}.properties", ignoreResourceNotFound = true)
@EnableWebMvc
public class ApplicationConfiguration {
	
	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor() {
		return new MethodValidationPostProcessor();
	}
	
    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}
