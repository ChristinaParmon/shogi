package com.example.shogi;

import com.example.shogi.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class ShogiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShogiApplication.class, args);
    }

}
