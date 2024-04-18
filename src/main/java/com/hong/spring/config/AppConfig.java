package com.hong.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Import({DataSourceConfig.class, DataJpaConfig.class, DatabaseProperties.class})
@Configuration
@ComponentScan(basePackages = {"com.hong.spring.service", "com.hong.spring.repo"})
public class AppConfig {
}
