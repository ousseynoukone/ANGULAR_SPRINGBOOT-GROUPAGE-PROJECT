package com.isi.devopsProject.repository;

import com.isi.devopsProject.Models.Etudiant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEtudiantrepository extends CrudRepository<Etudiant,Integer> {



}
