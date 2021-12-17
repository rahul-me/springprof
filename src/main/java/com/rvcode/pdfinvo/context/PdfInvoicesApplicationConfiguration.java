package com.rvcode.pdfinvo.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rvcode.pdfinvo.service.InvoiceService;
import com.rvcode.pdfinvo.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PdfInvoicesApplicationConfiguration {
    @Bean
    public UserService userService(){
        return new UserService();
    }

    @Bean
    public InvoiceService invoiceService(UserService userService){
        return new InvoiceService(userService);
    }

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}