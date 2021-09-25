package com.wpk.configs;

import java.util.Properties;
import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

/**
 *
 * @author Admin
 */
@Configuration
@PropertySource("classpath:databases.properties")
public class HibernateConfig {
    @Autowired
    private Environment env;
     @Bean
     public LocalSessionFactoryBean getSessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
       
        sessionFactory.setPackagesToScan("com.wpk.pojos");
        
        sessionFactory.setDataSource(dataSource());
        
        sessionFactory.setHibernateProperties(hibernateProperties());
    
        return sessionFactory;
   }
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(); 
        dataSource.setUrl(env.getProperty("hibernate.connection.url"));
                dataSource.setDriverClassName(env.getProperty("hibernate.connection.driverClass"));

        dataSource.setUsername( env.getProperty("hibernate.connection.username"));
        dataSource.setPassword( env.getProperty("hibernate.connection.password"));
        return dataSource;
    }
    private Properties hibernateProperties() {
        Properties props = new Properties();
        props.setProperty(org.hibernate.cfg.Environment.DIALECT, env.getProperty("hibernate.dialect"));
        props.setProperty(org.hibernate.cfg.Environment.SHOW_SQL, env.getProperty("hibernate.showSql"));
        return props;
    }
    
    @Bean
    public HibernateTransactionManager transactionManager(){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        
        return transactionManager;
    }
}
