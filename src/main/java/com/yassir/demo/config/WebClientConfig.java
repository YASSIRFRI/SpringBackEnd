package com.yassir.demo.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Configuration
@Data @NoArgsConstructor @AllArgsConstructor
public class WebClientConfig {

    @Autowired
    private WebClient.Builder builder;

    private WebClient webClient;

    @Bean
    WebClient webClient() {
        builder.baseUrl("https://dad-jokes.p.rapidapi.com/random/joke");
        builder.defaultHeader("X-RapidAPI-Key", "f56da3a3b2mshcc01852c8925443p12d1acjsn5d678193c7c5");
        builder.defaultHeader("X-RapidAPI-Host", "dad-jokes.p.rapidapi.com");
        webClient = builder.build();
        return webClient;
    }
}