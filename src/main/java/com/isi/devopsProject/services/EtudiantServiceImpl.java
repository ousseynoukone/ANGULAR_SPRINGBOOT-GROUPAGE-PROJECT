package com.isi.devopsProject.services;

import com.isi.devopsProject.Models.Etudiant;
import com.isi.devopsProject.repository.IEtudiantrepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public class EtudiantServiceImpl implements IEtudiantService {


    @Autowired
    private IEtudiantrepository etuRepository;

    @Override
    public Etudiant createEtudiant(Etudiant e){
        return etuRepository.save(e);
    }

    @Override
    public List<Etudiant> gettudiants() {
        return (List<Etudiant>) etuRepository.findAll();
    }

    @Override
    public Etudiant getEtudiant( int id){
        return etuRepository.findById(id).get();
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e , int id) {
        Etudiant et = etuRepository.findById(id).get();
        et.setPrenom(e.getPrenom());
        et.setNom(e.getNom());
        et.setIdGroupe(e.geIdGroupe());
        et.setIdGroupeA(e.geIdGroupeA());
        return etuRepository.save(et);
    }

    @Override
    public void deleteEtudiant(int id) {
        etuRepository.deleteById(id);
    }
}
