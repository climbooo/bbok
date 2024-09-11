package com.bbok.restapi.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {"com.bbok.restapi"})
@EnableJpaRepositories(basePackages = "com.bbok.restapi")
public class JpaConfiguration {

}
