package com.example.soap.client.config;

import com.javatechie.spring.soap.api.loaneligibility.LoanEligibilityIndicator;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CxfClientConfiguration {

    @Bean
    public LoanEligibilityIndicator loanEligibilityClient() {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(LoanEligibilityIndicator.class);
        factory.setAddress("http://localhost:8080/ws");
        return (LoanEligibilityIndicator) factory.create();
    }
}
