package com.nmodus.demo.configs;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableJpaRepositories(basePackages = "com.nmodus.demo.entities", entityManagerFactoryRef = "demoEntityManager", transactionManagerRef = "demoTransactionManager")
public class DbConfig {

    @Autowired
    private Environment env;

    @Bean
    @Primary
    @ConfigurationProperties("demo.datasource")
    public DataSourceProperties demoDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("demo.datasource")
    public DataSource demoDataSource(){
        return demoDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean(name = "demoEntityManager")
    @Primary
    public LocalContainerEntityManagerFactoryBean demoEntityManagerFactory(){

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(demoDataSource());
        em.setPackagesToScan("com.nmodus.demo.entities");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        em.setJpaPropertyMap(properties);
        em.setPersistenceUnitName("sscDemo");

        return em;
    }

    @Bean(name = "demoTransactionManager")
    public PlatformTransactionManager demoTransactionManager() {

        return new JpaTransactionManager(demoEntityManagerFactory().getObject());
    }

}
