package com.ifi.trainer_ui.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class RestConfiguration {

    @Value("${spring.security.user.name}")
    private String username;

    @Value("${spring.security.user.password}")
    private String password;




    @Bean
    RestTemplate trainerApiRestTemplate(){
        RestTemplate r =  new RestTemplate();
        r.getInterceptors().add(new BasicAuthenticationInterceptor("username", "password"));
        return r;
    }

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

}