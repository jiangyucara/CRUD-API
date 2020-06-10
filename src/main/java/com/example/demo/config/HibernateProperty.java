package com.example.demo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
public class HibernateProperty {

    @Value("${database.hibernate.url}")
    private String url;

    @Value("${database.hibernate.driver}")
    private String driver;

    @Value("root")
    private String username;

    @Value("Myown4498092589!")
    private String password;

    @Value("org.hibernate.dialect.MySQLDialect")
    private String dialect;

    @Value("true")
    private String showsql;

}
