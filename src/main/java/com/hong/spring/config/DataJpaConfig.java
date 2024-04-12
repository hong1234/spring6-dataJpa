package com.hong.spring.config;

import javax.sql.DataSource;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.PlatformTransactionManager;

import lombok.AllArgsConstructor;
// import lombok.extern.slf4j.Slf4j;


@Configuration
@AllArgsConstructor
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {DataJpaConfig.JPA_REPO_LOCATION}) // or @EnableJpaRepositories(basePackages = HibernateConfig.JPA_REPO_LOCATION) 
public class DataJpaConfig {

    public static final String JPA_REPO_LOCATION = "com.hong.spring.repo"; // location of the custom repository-interfaces
    public static final String JPA_ENTITY_LOCATION = "com.hong.spring.entity"; // location of the entities where persistence metadata can be found

    private final DataSource dataSource;
    private final HibernateConfig hibernateConfig;
    
    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        HibernateJpaVendorAdapter jpaVendor = new HibernateJpaVendorAdapter();
        Properties jpaProperties = hibernateConfig.hibernateProperties();

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource);
        factory.setJpaVendorAdapter(jpaVendor);
        factory.setJpaProperties(jpaProperties);
        factory.setPackagesToScan(JPA_ENTITY_LOCATION); 
        // factory.setPersistenceUnitName("persistenceUnit1");
        
        return factory;
    }

}