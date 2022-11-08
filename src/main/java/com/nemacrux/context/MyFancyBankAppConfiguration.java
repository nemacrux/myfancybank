package com.nemacrux.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nemacrux.ApplicationLauncher;
import com.nemacrux.service.TransactionsService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackageClasses = ApplicationLauncher.class)
@PropertySource(value = "classpath:/application.properties")
//@PropertySource(value = "classpath:application.properties")
public class MyFancyBankAppConfiguration {

    @Bean
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper().registerModule(new JavaTimeModule());
    }

}