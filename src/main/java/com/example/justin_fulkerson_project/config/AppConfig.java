package com.example.justin_fulkerson_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class AppConfig {

    @Bean
    public FixedLengthFileConfiguration fixedLengthFileConfiguration() throws IOException {
        // Initialize and configure FixedLengthFileConfiguration object here
        return new FixedLengthFileConfiguration("/Users/justinfulkerson/dev/Revature_Project/justin_fulkerson_project-3/src/spec.json");
    }
}
