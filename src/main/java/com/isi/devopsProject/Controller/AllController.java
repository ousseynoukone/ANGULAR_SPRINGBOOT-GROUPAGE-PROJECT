package com.isi.devopsProject.Controller;

import com.isi.devopsProject.Models.Etudiant;
import com.isi.devopsProject.Models.Sujet;
import com.isi.devopsProject.repository.IEtudiantrepository;
import com.isi.devopsProject.services.IEtudiantService;
import com.isi.devopsProject.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class AllController {
    @Autowired
    private IEtudiantService IEtudiantService;
    @Autowired
    private ISujetService sujetService;

    @GetMapping("/Accueil")
    public ResponseEntity<Object> getDataFromTables() {
        // Récupérez les données de vos deux tables ici
        List<Etudiant> tabEtudiant = IEtudiantService.gettudiants();
        List<Sujet> tabSujet = sujetService.getSujets();
        Map<String, Object> data = new HashMap<>();
        data.put("tabEtudiant", tabEtudiant);
        data.put("tabSujet", tabSujet);
        return ResponseEntity.ok(data);
    }

}
