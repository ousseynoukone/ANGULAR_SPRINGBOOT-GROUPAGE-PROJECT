import { Component , OnInit , ViewChild, ElementRef  } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup, FormArray ,FormControl } from '@angular/forms';
import { Etudiant } from '../etudiant';

import * as Immutable from 'immutable';
import { timeout } from 'rxjs';

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styles: [
  ]
})
export class AccueilComponent {
  i = 0;
  tabEtudiant: any[];
  tabAll: any[];
  tabSujet: any[];
  tabSujetFiltred: any[];
  tabGroupeEtudiantSujet = [] as any[]
  groupeidTab: number[] = [];
loading: boolean = true;

  



  constructor(private http: HttpClient , private formBuilder: FormBuilder) { 

  }
  @ViewChild('tab', { static: true }) tableau: ElementRef;
  @ViewChild('alert', { static: true }) alert: ElementRef;

  ngOnInit() {
   
  }

loadAll()
{
  this.tabEtudiant=[]
  this.tabSujet = []
  this.http.get('http://localhost:8080/groupe').subscribe(data => {
  
    const map = new Map(Object.entries(data));

    this.tabEtudiant = map.get("groupesEtudiants")
  

    this.tabSujet = map.get("sujets")

    





    



  });

}
  

loadGroupes(){
  this.loadAll()
  this.alert.nativeElement.removeAttribute('hidden');
  this.tableau.nativeElement.removeAttribute('hidden');


  setTimeout(() => {
    this.alert.nativeElement.setAttribute('hidden', 'true')

  this.tabEtudiant.forEach(groupeEtudiant => {
    let sousSousTab: any[]=[];

    for (let index = 0; index < groupeEtudiant.length; index++) {
      this.tabSujet.forEach(sujet => {
        if (groupeEtudiant[index].idGroupe === sujet.id) {
          sousSousTab.push({ groupeEtudiant });
          sousSousTab.push({ sujet });
        
        }
        
      });
    break
      
    }
  

  
    this.tabGroupeEtudiantSujet.push(sousSousTab);
  });
  




  }, 2000);

  this.tabGroupeEtudiantSujet=[]






}








}
