package com.orangecandle;

//import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration // This is a Spring config class
@EnableTransactionManagement // As <tx:annotation-config />
@EnableWebMvc  // As <mvc:component-scan .. />
@PropertySource("classpath:application.properties")
public class WebConfig //extends WebMvcConfigurerAdapter 
{
	private static final String PROPERTY_NAME_DATABASE_DRIVER   = "spring.datasource.driverClassName";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "spring.datasource.password";
    private static final String PROPERTY_NAME_DATABASE_URL      = "spring.datasource.url";
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "spring.datasource.username";
  
    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "spring.jpa.properties.hibernate.show_sql";
    private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";
     
 @Resource
 private Environment env;

    @Bean
    // Injectible Transaction Manager Bean
    public HibernateTransactionManager createTransactionManager(){

       HibernateTransactionManager transactionManager=new HibernateTransactionManager();
       transactionManager.setSessionFactory(createSessionFactoryBean().getObject());

        return transactionManager;

    }

    @Bean
    // Injectible Hibernate SessionFactory Bean
    public LocalSessionFactoryBean createSessionFactoryBean(){
        LocalSessionFactoryBean localSessionFactoryBean=new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource());
        localSessionFactoryBean.setPackagesToScan(env.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));
        localSessionFactoryBean.setHibernateProperties(hibProperties());
        return localSessionFactoryBean;
    }
    private Properties hibProperties() {
    	  Properties properties = new Properties();
    	  properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
    	  properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
    	  return properties; 
    	 }
    @Bean
    public DataSource dataSource() {
     DriverManagerDataSource dataSource = new DriverManagerDataSource();
     dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
     dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
     dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
     dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
     return dataSource;
    }

       
}
