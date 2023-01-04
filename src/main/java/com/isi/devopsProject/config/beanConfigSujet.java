package com.isi.devopsProject.config;

import com.isi.devopsProject.services.EtudiantServiceImpl;
import com.isi.devopsProject.services.IEtudiantService;
import com.isi.devopsProject.services.ISujetService;
import com.isi.devopsProject.services.ISujetServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class beanConfigSujet {
    @Bean
    public ISujetService sujetService() {
        ISujetService sService = new ISujetServiceImpl();
        return sService;
    }
}
