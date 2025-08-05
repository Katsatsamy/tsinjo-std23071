package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class VolaConfig {
  @Value("${vola.api.key}")
  private String apiKey;

  @Value("${vola.api.base-url}")
  private String baseUrl;

  @Bean
  public WebClient volaWebClient() {
    return WebClient.builder().baseUrl(baseUrl).defaultHeader("X-API-KEY", apiKey).build();
  }
}
