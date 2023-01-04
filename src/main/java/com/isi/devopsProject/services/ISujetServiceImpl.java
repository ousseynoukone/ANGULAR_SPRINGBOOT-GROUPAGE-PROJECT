package com.isi.devopsProject.services;

import com.isi.devopsProject.Models.Etudiant;
import com.isi.devopsProject.Models.Sujet;
import com.isi.devopsProject.repository.ISujetRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ISujetServiceImpl implements ISujetService {
    @Autowired
    public ISujetRepository sujetRepository;

    @Override
    public Sujet createSujet(Sujet s) {
        return sujetRepository.save(s);
    }

    @Override
    public List<Sujet> getSujets() {
        return (List<Sujet>) sujetRepository.findAll();    }

    @Override
    public Sujet getSujet(int id) {
        return   sujetRepository.findById(id).get();
    }

    @Override
    public void deleteSujet(int id) {
        sujetRepository.deleteById(id);

    }

    @Override
    public Sujet updateSujet(Sujet s, int id) {
        Sujet e = sujetRepository.findById(id).get();
        e.setText(s.getText());
        e.setDescription(s.getDescription());
        return sujetRepository.save(e);    }
}
