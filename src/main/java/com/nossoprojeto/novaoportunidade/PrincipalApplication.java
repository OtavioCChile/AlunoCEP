package com.nossoprojeto.novaoportunidade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories
public class PrincipalApplication {
    public static void main(String[] args) {
        SpringApplication.run(PrincipalApplication.class, args);
    }
}
