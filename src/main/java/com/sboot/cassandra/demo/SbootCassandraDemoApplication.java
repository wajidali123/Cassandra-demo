package com.sboot.cassandra.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication
@EnableCassandraRepositories(basePackages = "com.sboot.cassandra.demo.repo")
public class SbootCassandraDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbootCassandraDemoApplication.class, args);
	}

}
