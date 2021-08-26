package com.alea.pokeApi;

import com.alea.pokeApi.config.InitiationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PokeApiApplication {
    @Autowired
    private InitiationService initiationService;

    public static void main(final String[] args) {
        SpringApplication.run(PokeApiApplication.class, args);
    }

    @Bean
    public RestTemplate getresttemplate() {
        return new RestTemplate();
    }

    @Bean
    public void loadData() {
        initiationService.populateDataBase();
    }

}
