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