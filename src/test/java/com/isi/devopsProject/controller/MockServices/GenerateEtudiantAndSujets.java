package com.isi.devopsProject.controller.MockServices;
import java.util.ArrayList;
import java.util.List;

import com.isi.devopsProject.Models.Etudiant;
import com.isi.devopsProject.Models.Sujet;

public class GenerateEtudiantAndSujets {
    public static List<Etudiant> getEtudiants() {
        // Create a mock EtudiantService
    //    IEtudiantService mockEtudiantService = Mockito.mock(IEtudiantService.class);

        // Define the behavior of the getEtudiants method
        List<Etudiant> etudiants = new ArrayList<>();
        etudiants.add(new Etudiant("Kone", "Ousseynou",0));
        etudiants.add(new Etudiant("Random", "Personne",0));
        etudiants.add(new Etudiant("Anyway", "Prenom",0));
  //      Mockito.when(mockEtudiantService.gettudiants()).thenReturn(etudiants);

        return etudiants;
    }

    public static List<Sujet> getSujets() {
        // Create a mock EtudiantService
  //      ISujetService mockEtudiantService = Mockito.mock(ISujetService.class);

        // Define the behavior of the getSubjects method
        List<Sujet> sujets = new ArrayList<>();
        sujets.add(new Sujet("Math","Description  de math"));
        sujets.add(new Sujet("Physique","Description de la physique"));
        sujets.add(new Sujet("Chimie","Description de la chimie"));
 //       Mockito.when(mockEtudiantService.getSujets()).thenReturn(sujets);

        return sujets;
    }
}
