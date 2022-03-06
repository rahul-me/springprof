package com.rvcode.pdfinvo.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rvcode.pdfinvo.ApplicationLauncher;

@Configuration
@ComponentScan(basePackageClasses = ApplicationLauncher.class)
public class PdfInvoicesApplicationConfiguration {
	
    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}
