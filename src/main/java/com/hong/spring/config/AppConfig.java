package com.hong.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// @Import({DataSourceCfg.class, JpaConfiguration.class}) // DataJpaConfig
@Import({DataSourceConfig.class, DataJpaConfig.class, DatabaseProperties.class, HibernateConfig.class})
@Configuration
@ComponentScan(basePackages = {"com.hong.spring.service", "com.hong.spring.repo"})
public class AppConfig {
}
