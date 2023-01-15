package com.isi.devopsProject.Controller;

import com.isi.devopsProject.Models.Etudiant;
import com.isi.devopsProject.Models.Sujet;
import com.isi.devopsProject.services.IEtudiantService;
import com.isi.devopsProject.services.ISujetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class EtudiantController {
    @Autowired
    private IEtudiantService IEtudiantService;
    @Autowired
    private ISujetService ISujetService;



//Shuffle fonction
    public static  Map<String , Object> ShuffledAndGroupedEtudiants(List <Etudiant> lEtudiants ,List <Sujet> lSujet){


    if(lSujet.isEmpty()==false && lEtudiants.isEmpty()==false){

    Collections.shuffle(lEtudiants);
    Collections.shuffle(lSujet);
    
        // Calculer le nombre maximum d'étudiants par groupe
        int maxPerGroup = (int) Math.ceil((double) lEtudiants.size() / lSujet.size());
    
    //    int maxPerGroup = 10; // Taille maximale des groupes d'étudiants
        int nb_groupes = (int) Math.ceil((double) lEtudiants.size() / maxPerGroup ); // nombre de groupes nécessaires
        
        // Diviser les étudiants en groupes
        List<List<Etudiant>> groups = new ArrayList<>();
        for (int i = 0; i < nb_groupes; i++) {
            int j = i*maxPerGroup;
            int k = Math.min((i + 1) * maxPerGroup,lEtudiants.size()) ;
            groups.add(lEtudiants.subList(j, k));
        }

        Map<String, Object> map = new HashMap<>();
        map.put("groupesEtudiants", groups);
        map.put("sujets", lSujet);

        return map;        }

        else 
            return   new HashMap<>();

    
}


    

/* 
    @GetMapping("/Accueil")
    public ResponseEntity<Object> getDataFromTables() {
        // Récupérez les données de vos deux tables ici
        List<Etudiant> tabEtudiant = IEtudiantService.gettudiants();
        List<Sujet> tabSujet = ISujetService.getSujets();
        Map<String, Object> data = new HashMap<>();
        data.put("tabEtudiant", tabEtudiant);
        data.put("tabSujet", tabSujet);
        return ResponseEntity.ok(data);
    }
*/
    @GetMapping("/groupe")
    public Map<String, Object> getGroupe() {
        List <Etudiant> el = IEtudiantService.gettudiants();
        List <Sujet> sl  = ISujetService.getSujets();

        Map<String, Object> map = new HashMap<>();

        map=EtudiantController.ShuffledAndGroupedEtudiants(el,sl);

        List<List<Etudiant>> groups = (List<List<Etudiant>>) map.get("groupesEtudiants");
        List<Sujet> lSujet = (List<Sujet>) map.get("sujets");

        int index = 0;
        for (List<Etudiant> group : groups) {
            for (Etudiant e : group) {
                e.setIdGroupe(lSujet.get(index).getId());
                IEtudiantService.updateEtudiant(e, e.getId());
            }
            index++;
            if(index == lSujet.size()){
              break ;
            }
        }

        map = new HashMap<>();
        map.put("groupesEtudiants", groups);
        map.put("sujets", lSujet);

        return map;
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
