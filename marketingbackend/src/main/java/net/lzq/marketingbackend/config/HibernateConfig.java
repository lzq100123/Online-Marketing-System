package net.lzq.marketingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"net.lzq.marketingbacked.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	
	//Database connection information
	private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/onlinemarketingsystem";
	private final static String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.MySQLDialect";
	private final static String DATABASE_USERNME = "root";
	private final static String DATABASE_PASSWORD = "123456";
	
	@Bean
	public DataSource getDataSource() {
		BasicDataSource datasource = new BasicDataSource();
		
		// Database connection information
		datasource.setDriverClassName(DATABASE_DRIVER);
		datasource.setUrl(DATABASE_URL);
		datasource.setUsername(DATABASE_USERNME);
		datasource.setPassword(DATABASE_PASSWORD);
		
		return datasource;
	}
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
	
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("net.lzq.marketingbackend.dto");
		
		
		return builder.buildSessionFactory();
	}
	
	//Providing all the hibernate properties
	private Properties getHibernateProperties() {

		Properties properties = new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		
		return properties;
	}
	
	// transactionManager Bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
}
