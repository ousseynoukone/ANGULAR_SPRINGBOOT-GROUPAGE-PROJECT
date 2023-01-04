package com.isi.devopsProject.Controller;

import com.isi.devopsProject.Models.Etudiant;
import com.isi.devopsProject.services.IEtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class EtudiantController {
    @Autowired
    private IEtudiantService IEtudiantService;

    @GetMapping("/")
    public String helloWolds(){
        return "HELOOOOOOOOOOOOO WORLD" ;
    }

    //create Etudiant
    @PostMapping("/add")
    public Etudiant createEtudiant(@RequestBody Etudiant e){
        Etudiant et= IEtudiantService.createEtudiant(e);
        return  et;

    }

    //lire Etudiant
    @GetMapping("/etudiants")
    public List<Etudiant> getEtudiants(){
        return IEtudiantService.gettudiants();

    }

    //update
    @PutMapping("/update/{id}")
    public Etudiant updateEtudiant(@RequestBody Etudiant e , @PathVariable("id") int id){
        return  IEtudiantService.updateEtudiant(e,id);

    }

    //Delete Etudiant by id

    @DeleteMapping("delete/{id}")
    public String deleteEtudiant(@PathVariable("id") int id){
        IEtudiantService.deleteEtudiant(id);
        return "Etudiant(e) suprimmée";
    }

    //Get Etudiant By id

    @GetMapping("/etudiant/{id}")
    public Etudiant getEtudiant(@PathVariable("id") int id){
        return  IEtudiantService.getEtudiant(id);

    }


}
