package com.rvcode.pdfinvo.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rvcode.pdfinvo.ApplicationLauncher;
import com.rvcode.pdfinvo.service.InvoiceService;
import com.rvcode.pdfinvo.service.UserService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackageClasses = ApplicationLauncher.class)
@PropertySource("classpath:/application.properties")
@PropertySource(value = "classpath:/application-${spring.profiles.active}.properties", ignoreResourceNotFound = true)
public class PdfInvoicesApplicationConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
