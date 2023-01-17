import { Component , OnInit , ViewChild, ElementRef  } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup, FormArray ,FormControl } from '@angular/forms';
import Swal from 'sweetalert2'

import * as Immutable from 'immutable';
import { timeout } from 'rxjs';
import { Etudiant } from '../etudiant';

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

  



  constructor(private http: HttpClient ) { 

  }
  @ViewChild('tab', { static: true }) tableau: ElementRef;
  @ViewChild('alert', { static: true }) alert: ElementRef;
  @ViewChild('enreg', { static: true }) enreg: ElementRef;

  ngOnInit() {

   
  }

  openSwalModal(){
    Swal.fire({
      title: 'Rapport',
      text:   'Groupe enregistré ! ',
      icon: 'success', //warning error info question
      confirmButtonText: 'Cool',
      timer : 2500 
    })
  }


  openSwalModalGroupeGenered(){
    Swal.fire({
      title: 'Groupe generé ! ',
      icon: 'success', //warning error info question
      showConfirmButton: false,
      timer : 1000,
      position: 'top-end',
      backdrop: false



    })}


loadAll()
{

  this.http.get('http://localhost:8080/groupe').subscribe(data => {

    //-------------------------------------------------------------
    const arrayofMap = new Map(Object.entries(data));

    console.log(arrayofMap)
    this.tabGroupeEtudiantSujet=[]


    arrayofMap.forEach(groupeDeGroupe => {
      let tab =[]
      tab.push(groupeDeGroupe['groupe'])
      tab.push(groupeDeGroupe['sujet'])

      this.tabGroupeEtudiantSujet.push(tab)
          
        });
        this.tabGroupeEtudiantSujet.sort((a, b) => a[1][0].id - b[1][0].id);
        this.tabGroupeEtudiantSujet.forEach(group => {
          group[0] = group[0].sort((a: Etudiant, b: Etudiant) => a.nom.localeCompare(b.nom));
          });


  });

}

enregGroupe()
{
  this.http.get('http://localhost:8080/enregGroupe', {responseType: 'text'}).subscribe(data => {
    console.log(data);
    if(data=="success!")
    this.openSwalModal()
  });
  this.enreg.nativeElement.setAttribute('disabled', 'true')


 

}
  

loadGroupes(){
  this.loadAll()
  this.enreg.nativeElement.removeAttribute('hidden');
  this.enreg.nativeElement.removeAttribute('disabled');
  this.tableau.nativeElement.removeAttribute('hidden');
 this.openSwalModalGroupeGenered()

  setTimeout(() => {
    console.log(this.tabGroupeEtudiantSujet)  

  }, 2000);







}








}
