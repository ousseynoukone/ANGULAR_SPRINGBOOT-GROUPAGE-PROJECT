package com.isi.devopsProject.config;

import com.isi.devopsProject.services.IEtudiantService;
import com.isi.devopsProject.services.EtudiantServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class beanConfigEtudiant {
    @Bean
    public IEtudiantService etudiantService() {
        IEtudiantService eService = new EtudiantServiceImpl();
        return eService;
    }
}
