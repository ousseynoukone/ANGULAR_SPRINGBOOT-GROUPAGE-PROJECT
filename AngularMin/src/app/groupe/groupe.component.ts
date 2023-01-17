import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Etudiant } from '../etudiant';


@Component({
  selector: 'childGroupe',
  templateUrl: './groupe.component.html',
  styles: [
  ]
})
export class GroupeComponent {

 
  tabGroupeEtudiantSujet = [] as any[]

  constructor(private http: HttpClient ) { 

  }

  ngOnInit() {
    this.http.get('http://localhost:8080/listeGroupe').subscribe(data => {
  
    const arrayofMap = new Map(Object.entries(data));

    console.log(arrayofMap)


    arrayofMap.forEach(groupeDeGroupe => {
      let tab =[]
      tab.push(groupeDeGroupe['groupe'])
      tab.push(groupeDeGroupe['sujet'])

      this.tabGroupeEtudiantSujet.push(tab)
          
        });
        //Triage pour l'affichage
        this.tabGroupeEtudiantSujet.sort((a, b) => a[1][0].id - b[1][0].id);

        this.tabGroupeEtudiantSujet.forEach(group => {
        group[0] = group[0].sort((a: Etudiant, b: Etudiant) => a.nom.localeCompare(b.nom));
        });
        



        console.log(this.tabGroupeEtudiantSujet)


//3for
/*
console.log(arrayofMap)
console.log(this.tabGroupeEtudiantSujet)
arrayofMap.forEach(groupeDeGroupe => {

  console.log(groupeDeGroupe['groupe'][0])
      
    });

    //this.load()

    */


  });


   
  }




}
