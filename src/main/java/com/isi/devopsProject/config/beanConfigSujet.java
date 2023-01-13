package com.isi.devopsProject.config;

import com.isi.devopsProject.services.ISujetService;
import com.isi.devopsProject.services.SujetServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class beanConfigSujet {
    @Bean
    public ISujetService sujetService() {
        ISujetService sService = new SujetServiceImpl();
        return sService;
    }
}
