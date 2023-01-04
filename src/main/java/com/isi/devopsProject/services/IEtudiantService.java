package com.isi.devopsProject.services;

import com.isi.devopsProject.Models.Etudiant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEtudiantService {
    //create
    public Etudiant createEtudiant(Etudiant e);




    //read
    public List<Etudiant> gettudiants();

    //read Etudiant by id
    public Etudiant getEtudiant( int id);




    //delete etudiant by id
    public void deleteEtudiant(int id);

    //update Etudaint by id
    public Etudiant updateEtudiant(Etudiant e , int id);

}
