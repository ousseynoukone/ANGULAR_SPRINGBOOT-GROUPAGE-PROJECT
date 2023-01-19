package com.isi.devopsProject.controller;
import com.isi.devopsProject.Models.Sujet;
import com.isi.devopsProject.services.ISujetService;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SujetCrudTest {
    

    @Autowired
    private ISujetService iService ;


    

    private Sujet createSujet(){
        Sujet s = new Sujet("TestTile","TestDescription",0);

       return iService.createSujet(s);

    }


    


    @Test
    public void AjoutSujetTestEtSuprimmerSujet(){
        Sujet s = createSujet();
       
        Assertions.assertThat(s.getId()).isGreaterThanOrEqualTo(1);

        iService.deleteSujet(s.getId());
    }


    @Test void ListerSujetTest(){
    List <Sujet> ls =  iService.getSujets();

    Assertions.assertThat(ls).isNotNull();

    }

    @Test void ListerSujetParId(){
        Sujet s = createSujet();


        Sujet s1 =  iService.getSujet(s.getId());
    
        Assertions.assertThat(s1).isNotNull();
        iService.deleteSujet(s.getId());

    
        }

        
    @Test void UpdateSujet(){
        Sujet s = createSujet();
        Sujet s1= new Sujet("test2Title","test2Description",0);

        iService.updateSujet(s1, s.getId());

        Sujet s2=iService.getSujet(s.getId());


    
        Assertions.assertThat(s2.getText()).isEqualTo(s1.getText());
        Assertions.assertThat(s2.getDescription()).isEqualTo(s1.getDescription());
        iService.deleteSujet(s.getId());



    
        }





}
