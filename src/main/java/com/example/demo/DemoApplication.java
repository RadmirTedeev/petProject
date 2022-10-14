package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Bean
//	DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setUrl("jdbc:postgresql://localhost:5432/test_db?currentSchema=test_project");
//		dataSource.setUsername("postgres");
//		dataSource.setPassword("root");
//		dataSource.setDriverClassName("org.postgresql.Driver");
//		return dataSource;
//	}

}
