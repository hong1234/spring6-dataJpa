package com.hong.spring.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


// @Slf4j
@Configuration
@AllArgsConstructor
public class DataSourceConfig {

    private final DatabaseProperties dbProperties;

    @Bean
    public DataSource dataSource() {
        // log.info("Creating a datasource for {}", dbProperties.getDriverClassName());
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dbProperties.getDriverClassName());
        dataSource.setUrl(dbProperties.getUrl());
        dataSource.setUsername(dbProperties.getUsername());
        dataSource.setPassword(dbProperties.getPassword());
        return dataSource;
    }

}
