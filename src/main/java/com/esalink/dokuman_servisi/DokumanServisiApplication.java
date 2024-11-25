package com.esalink.dokuman_servisi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.esalink.dokuman_servisi.repository")
@EntityScan("com.esalink.dokuman_servisi.model")
public class DokumanServisiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DokumanServisiApplication.class, args);
    }

}
