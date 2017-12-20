package com.musicinstruments.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.musicinstruments.config")
@PropertySource({"classpath:ds-hibernate-cfg.properties"})
@EnableTransactionManagement
public class ApplicationContextConfig {

	@Autowired Environment env;
	
	// Bean configurations
	@Bean(name = "DataSource")
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("ds.databasedriver"));
		dataSource.setUrl(env.getProperty("ds.url"));
		dataSource.setUsername(env.getProperty("ds.username"));
		dataSource.setPassword(env.getProperty("ds.password"));
		
		return dataSource;
	}
	
	@Autowired
	@Bean(name = "sessionFactory")
    public SessionFactory hibernateSessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan(new String[] { 
                  "com.musicinstruments.entity" 
        });
        factoryBean.setHibernateProperties(hibernateProperties());

        SessionFactory sessionFactory = factoryBean.getObject();
        return sessionFactory;
    }
	
	private Properties hibernateProperties() {
		return new Properties() {
			{
				setProperty("hibernate.hbm2ddl.auto",
						env.getProperty("hibernate.hbm2ddl.auto"));
				setProperty("hibernate.dialect",
						env.getProperty("hibernate.dialect"));
				setProperty("current_session_context_class",
						env.getProperty("true"));
				setProperty("hibernate.globally_quoted_identifiers",
						"true");
			}
		};
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
	  
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		return txManager;
	}
}
