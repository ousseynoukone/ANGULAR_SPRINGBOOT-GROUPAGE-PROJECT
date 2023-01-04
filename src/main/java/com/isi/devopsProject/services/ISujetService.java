package com.isi.devopsProject.services;

import com.isi.devopsProject.Models.Sujet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

//On peut faire ca dirrectement aussi au lieu de creer le serviceRepository et creer une instance de celui ci
//Dans ce cas , on va juste instancier cette interface
public interface ISujetService  {

    public Sujet createSujet(Sujet s);




    //read
    public List<Sujet> getSujets();

    //read Sujet by id
    public Sujet getSujet( int id);




    //delete Sujet by id
    public void deleteSujet(int id);

    //update Etudaint by id
    public Sujet updateSujet(Sujet s , int id);



}
