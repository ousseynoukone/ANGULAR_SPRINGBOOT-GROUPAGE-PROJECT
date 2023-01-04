package com.isi.devopsProject.Controller;
import com.isi.devopsProject.Models.Sujet;
import com.isi.devopsProject.services.ISujetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class SujetController {

    @Autowired
    private ISujetService sujetService;



    //create Sujet
    @PostMapping("/addSujet")
    public Sujet createSujet(@RequestBody Sujet s) {
        Sujet s1 = sujetService.createSujet(s);
        return s1;

    }

    //lire Sujet
    @GetMapping("/Sujets")
    public List<Sujet> getSujets() {
        return sujetService.getSujets();

    }

    //update
    @PutMapping("/updateSujet/{id}")
    public Sujet updateSujet(@RequestBody Sujet s, @PathVariable("id") int id) {
        return sujetService.updateSujet(s, id);

    }

    //Delete Sujet by id

    @DeleteMapping("deleteSujet/{id}")
    public String deleteSujet(@PathVariable("id") int id) {
        sujetService.deleteSujet(id);
        return "Sujet(e) suprimmée";
    }

    //Get Sujet By id

    @GetMapping("/Sujet/{id}")
    public Sujet getSujet(@PathVariable("id") int id) {
        return sujetService.getSujet(id);
    }


}
