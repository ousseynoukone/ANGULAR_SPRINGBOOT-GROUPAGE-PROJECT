package com.isi.devopsProject.Controller;

import com.isi.devopsProject.Models.Etudiant;
import com.isi.devopsProject.Models.Sujet;
import com.isi.devopsProject.services.IEtudiantService;
import com.isi.devopsProject.services.ISujetService;

import io.micrometer.common.lang.Nullable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.http.HttpStatus;

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

    private Map<String, Object> map = new HashMap<>();



//Shuffle fonction
public static  Map<String , Object> ShuffledAndGroupedEtudiants(List <Etudiant> lEtudiants ,List <Sujet> lSujet , @Nullable Integer divise){
    if(lSujet.isEmpty()==false && lEtudiants.isEmpty()==false){
        Collections.shuffle(lEtudiants);
        Collections.shuffle(lSujet);
        // Calculer le nombre maximum d'étudiants par groupe
        int maxPerGroup;
        if(divise!=null && divise!=0)
            maxPerGroup = (int) Math.ceil((double) lEtudiants.size() / divise);
        else
            maxPerGroup = (int) Math.ceil((double) lEtudiants.size() / lSujet.size());
        int nb_groupes = (int) Math.ceil((double) lEtudiants.size() / maxPerGroup ); // nombre de groupes nécessaires
        
        // Diviser les étudiants en groupes
        List<List<Etudiant>> groups = new ArrayList<>();
        for (int i = 0; i < nb_groupes; i++) {
            int j = i*maxPerGroup;
            int k = Math.min((i + 1) * maxPerGroup,lEtudiants.size()) ;
            groups.add(lEtudiants.subList(j, k));
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("groupesEtudiants", groups);
        map1.put("sujets", lSujet);

        return map1;        
    }
    else 
        return new HashMap<>();
}


    


@GetMapping("/groupe")
public List<Map<String,Object>> getGroupe(@RequestParam(required = false, defaultValue = "0") Integer divise){    
        List <Etudiant> el = IEtudiantService.gettudiants();
        List <Sujet> sl  = ISujetService.getSujets();

        this.map = ShuffledAndGroupedEtudiants(el, sl,divise);

        List<List<Etudiant>> groups = (List<List<Etudiant>>) this.map.get("groupesEtudiants");
        List<Sujet> lSujet = (List<Sujet>) this.map.get("sujets");

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
        



        sl = (List<Sujet>) this.map.get("sujets");
        

// cAR SHUFFLEANDGROUPEETUDIANT RENVOIT UNE LISTE DE LISTE D'ETUDIANT 
        List<List<Etudiant>> etuDeconcatenner = (List<List<Etudiant>>) this.map.get("groupesEtudiants");
        List<Etudiant> concatenatedListE = new ArrayList<>();
        for (List<Etudiant> subList : etuDeconcatenner) {
        concatenatedListE.addAll(subList);
        }

        


        List<Map<String,Object>> m1 = groupage(concatenatedListE, sl);
     

        return m1 ;
    }







    @GetMapping("/listeGroupe")
    public  List<Map<String,Object>> loadGroupe() {
        List<Etudiant> el = IEtudiantService.gettudiants();
        List<Sujet> sujets = ISujetService.getSujets();

        return groupage(el, sujets);


    }


    //groupage
    private List<Map<String,Object>> groupage(List<Etudiant> el ,List<Sujet> sujets ){
        List<Map<String,Object>> listOfMapOfList = new ArrayList<>();
        for (Sujet s : sujets) {

            var  check = false ;

            ArrayList<Etudiant> dataE = new ArrayList<>();
            ArrayList<Sujet> dataL = new ArrayList<>();
            Map<String, Object> dataMap = new HashMap<>();


            for (Etudiant e : el) {
                    if (e.geIdGroupe() == s.getId()) {
                        dataE.add( e);
                        if(check == false){
                          dataL.add(s);
                          check = true;
                        }
                    }
                }
        if(ObjectUtils.isEmpty(dataE)==false && ObjectUtils.isEmpty(dataL)==false ){
            dataMap.put("groupe", dataE);
            dataMap.put("sujet", dataL); 
    
            listOfMapOfList.add(dataMap);
        }
      

    
    }
        
        // groupData contient maintenant les données de la vue
        
    
        return listOfMapOfList;
    }
    







    //Enregistrer groupe
    @GetMapping("/enregGroupe")
    public ResponseEntity<String> enregGroupe() {
        
        List<List<Etudiant>> groups = (List<List<Etudiant>>) this.map.get("groupesEtudiants");
        List<Sujet> lSujet = (List<Sujet>) this.map.get("sujets");

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

        return new ResponseEntity<>("success!", HttpStatus.OK);


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
