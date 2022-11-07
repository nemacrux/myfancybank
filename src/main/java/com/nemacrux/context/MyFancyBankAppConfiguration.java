package com.nemacrux.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nemacrux.service.TransactionsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFancyBankAppConfiguration {

    @Bean
    public TransactionsService getTransactionsService() {
        return  new TransactionsService();
    }

    @Bean
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper().registerModule(new JavaTimeModule());
    }

}