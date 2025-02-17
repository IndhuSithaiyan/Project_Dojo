package com.cts.dojomvp.banking;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BankingApplication{



    public static void main(String args[]){
        SpringApplication.run(BankingApplication.class);
    }

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
