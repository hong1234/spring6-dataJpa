package com.hong.spring.config;

import javax.sql.DataSource;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.PlatformTransactionManager;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.hong.spring.repo"})  // where the custom repository interfaces have been declared
public class DataJpaConfig {

    private final DatabaseProperties dbProperties;

    public DataJpaConfig(DatabaseProperties dbProperties) {  // constructor injection
        this.dbProperties = dbProperties;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();

        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.show_sql", true);
        jpaProperties.put("hibernate.hbm2ddl.auto", "update"); // init or update Database per entities
        // jpaProperties.put("hibernate.hbm2ddl.auto", "create-drop");
        
        factory.setDataSource(dataSource());
        factory.setJpaVendorAdapter(jpaVendorAdapter);
        factory.setJpaProperties(jpaProperties);
        factory.setPackagesToScan("com.hong.spring.entity"); // where the persistence metadata can be found
        // factory.setPersistenceUnitName("persistenceUnit1");
        
        return factory;
    }

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

    // @Bean
    // public DataSourceInitializer dataSourceInitializer(DataSource dataSource) { 
	// 	ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
    //     databasePopulator.addScript(new ClassPathResource("data.sql")); // init Database per "data.sql"

    //     DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
    //     dataSourceInitializer.setDataSource(dataSource);
    //     dataSourceInitializer.setDatabasePopulator(databasePopulator);
    //     dataSourceInitializer.setEnabled(Boolean.parseBoolean(dbProperties.getInitDatabase()));
    //     return dataSourceInitializer;
    // }

}