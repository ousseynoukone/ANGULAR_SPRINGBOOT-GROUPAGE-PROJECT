package com.isi.devopsProject.Fonction;
import com.isi.devopsProject.Controller.EtudiantController;
import com.isi.devopsProject.Models.Etudiant;
import com.isi.devopsProject.Models.Sujet;
import com.isi.devopsProject.controller.MockServices.GenerateEtudiantAndSujets;
import com.isi.devopsProject.services.IEtudiantService;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class SuffleTest {

    @Test
    public void testShuffledAndGroupedEtudiants() {
        //  mocked etudiant and subject
        List<Etudiant>   el=GenerateEtudiantAndSujets.getEtudiants();
        List<Sujet>   sl=GenerateEtudiantAndSujets.getSujets();

     



        int maxPerGroup = (int) Math.ceil((double) el.size() / sl.size());
        int nb_groupes = (int) Math.ceil((double) el.size() / maxPerGroup);
        


        Map<String , Object> result = EtudiantController.ShuffledAndGroupedEtudiants(el,sl);

        // Assert
        Assertions.assertThat(result).isNotNull();
        
        List<List<Etudiant>> groups = (List<List<Etudiant>>) result.get("groupesEtudiants");
        List<Sujet> returnedSujets = (List<Sujet>) result.get("sujets");
        Assertions.assertThat(groups).hasSize(nb_groupes);
        Assertions.assertThat(returnedSujets).hasSize(sl.size());
        
    }

    
}
