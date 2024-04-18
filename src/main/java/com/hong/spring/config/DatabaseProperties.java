package com.hong.spring.config;

import lombok.Getter;
import lombok.Setter;
import java.util.Properties;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;


@Getter
@Setter
@Component
@PropertySource("classpath:database.properties")
public class DatabaseProperties {

    @Value("${url}")
    private String url;
    @Value("${driver}")
    private String driverClassName;
    @Value("${dbuser}")
    private String username;
    @Value("${dbpassword}")
    private String password;
    @Value("${init-db:false}")
    private String initDatabase;

    @Value("${hibernate.dialect}")
    private String dialect;
    @Value("${hibernate.show_sql}")
    private String showSql;
    @Value("${hibernate.format_sql}")
    private String formatSql;
    @Value("${hibernate.hbm2ddl.auto}")
    private String hbm2ddlAuto;
    @Value("${hibernate.hbm2ddl.import_files}")
    private String importFile;
    @Value("${hibernate.generate_statistics}")
    private String generateStats;

    public Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", getShowSql());
        properties.put("hibernate.hbm2ddl.auto", getHbm2ddlAuto());
        // properties.put("hibernate.format_sql", getFormatSql());
        // properties.put("hibernate.dialect", getDialect());
        // properties.put("hibernate.hbm2ddl.import_files", getImportFile());
        // properties.put("hibernate.generate_statistics", getGenerateStats());
        return properties;
    }
}