package com.bcmw.flash_card.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Retrieve the environment and origin values from system environment variables
        String environment = System.getenv("AWS_EB_ENVIRONMENT");
        String origin = System.getenv("AWS_EB_CORS_ORIGIN");

        // Set the allowed origin based on the environment and origin values
        if ("production".equals(environment)) {
            config.setAllowedOrigins(new ArrayList<>(Collections.singletonList(origin)));
        } else {
            config.addAllowedOriginPattern("*");
        }

        // Other CORS configuration settings
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}