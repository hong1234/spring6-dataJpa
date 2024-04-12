package com.hong.spring.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@PropertySource("classpath:database.properties")
public class DatabaseProperties {

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
}