package com.isi.devopsProject.controller;
import com.isi.devopsProject.Models.Etudiant;
import com.isi.devopsProject.services.IEtudiantService;
import java.util.List;
import java.util.NoSuchElementException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class EtudiantCrudTest {

    
    @Autowired
    private IEtudiantService iService ;


    

    private Etudiant createEtudiant(){
        Etudiant e = new Etudiant("TestNom","TestPrenom",0);

       return iService.createEtudiant(e);

    }


    


    @Test
    public void AjoutEtudiantTestEtSuprimmerEtudiant(){
        Etudiant s = createEtudiant();
       
        Assertions.assertThat(s.getId()).isGreaterThan(1);
        iService.deleteEtudiant(s.getId());
    }


    @Test void ListerEtudiantTest(){
    List <Etudiant> le =  iService.gettudiants();

    Assertions.assertThat(le).isNotNull();

    }

    @Test void ListerEtudiantParId(){
        Etudiant s = createEtudiant();
        Etudiant s1=null;

        try{
         s1 =  iService.getEtudiant(s.getId());


        }catch(NoSuchElementException  ex){
            Assertions.assertThat(s1).isNotNull();
        }

        iService.deleteEtudiant(s.getId());
    

    
        }

        
    @Test void UpdateEtudiant(){
        Etudiant e = createEtudiant();
        Etudiant e1 = new Etudiant("TestNom","TestPrenom",0);

        iService.updateEtudiant(e1, e.getId());

        Etudiant e2=iService.getEtudiant(e.getId());


    
        Assertions.assertThat(e2.getNom()).isEqualTo(e1.getNom());
        Assertions.assertThat(e2.getPrenom()).isEqualTo(e1.getPrenom());
        iService.deleteEtudiant(e.getId());


    
        }

    @Test void deleteEtudiant(){
        Etudiant e = createEtudiant();
        iService.deleteEtudiant(e.getId());



        Etudiant e1 = null;

        

        try {
             e1  = iService.getEtudiant(e.getId());

            Assertions.assertThat(e1).isNull();
        } catch (NoSuchElementException  ex) {
            
        }
    }

    
}
