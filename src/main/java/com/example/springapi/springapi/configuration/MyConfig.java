package com.example.springapi.springapi.configuration;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.example.springapi.springapi")
@EnableWebMvc
@EnableTransactionManagement

public class MyConfig {

    @Bean
    public DataSource dataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDataSourceName("mysql");
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/shift"); //!!!
            dataSource.setUser("root");
            dataSource.setPassword("password");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return  dataSource;
    }
    @Bean
    public LocalSessionFactoryBean sessionFactoryBean(){
        LocalSessionFactoryBean sessionFactoryBean= new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan("com.example.springapi.springapi.api.model");

        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        return sessionFactoryBean;
    }
    @Bean
    public Properties hibernateProperties(){
        Properties hibernateProperties = new Properties();
        //  hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
        hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
        hibernateProperties.setProperty("hibernate.show-sql","true");
        hibernateProperties.setProperty("hibernate.ddl-auto","create");
        return hibernateProperties;
    }

    @Bean
    public HibernateTransactionManager transactionManager(){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();

        transactionManager.setSessionFactory(sessionFactoryBean().getObject());

        return transactionManager;
    }
}
