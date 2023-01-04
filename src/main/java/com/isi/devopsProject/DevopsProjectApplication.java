package com.isi.devopsProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
/*
@EntityScan("com.isi.devopsProject.Models")
@EnableJpaRepositories("com.isi.devopsProject.repository")
*/

public class DevopsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevopsProjectApplication.class, args);
	}

}
