package com.hong.spring.config;

import lombok.AllArgsConstructor;
// import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

// @Slf4j
@Configuration
@AllArgsConstructor
public class HibernateConfig {

    // public static final String JPA_REPO_LOCATION = "com.hong.spring.repo";

    private final DatabaseProperties dbProperties;

    public Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", dbProperties.getShowSql());
        properties.put("hibernate.hbm2ddl.auto", dbProperties.getHbm2ddlAuto());
        // properties.put("hibernate.format_sql", dbProperties.getFormatSql());
         // properties.put("hibernate.dialect", dbProperties.getDialect());
        // properties.put("hibernate.hbm2ddl.import_files", dbProperties.getImportFile());
        // properties.put("hibernate.generate_statistics", dbProperties.getGenerateStats());

        return properties;
    }

}