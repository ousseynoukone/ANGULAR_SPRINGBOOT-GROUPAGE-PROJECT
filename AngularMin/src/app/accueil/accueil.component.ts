import { Component , OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup, FormArray ,FormControl } from '@angular/forms';
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
  tabSujet: any[];
  groups : any[];
  sujets : any[];
  sujetParGroupe : any[];
  groupsForm = new FormGroup({
    groups: new FormControl()
  });

  sujetForm = new FormGroup({
    sujet: new FormControl()
  });


  constructor(private http: HttpClient , private formBuilder: FormBuilder) { 

  }

  ngOnInit() {
    this.http.get('http://localhost:8080/Accueil').subscribe(data => {
      /*
      this.tabEtudiant = data['tabEtudiant'];
      this.tabSujet = data['tabSujet'];
      */
      const map = new Map(Object.entries(data));

      this.tabEtudiant = map.get("tabEtudiant")
      this.tabSujet = map.get("tabSujet")

 
      let groups : any;
      const sujets = [];
      this.shuffle(this.tabEtudiant);
      groups=this.createGroups(this.tabEtudiant,this.tabSujet.length)
      console.log(groups)
      this.groups=this.shuffle(groups)
      this.shuffleArrayOfArrays(this.groups)
      /*
      let maxPerTable = this.tabEtudiant.length/this.tabSujet.length;

      for (let i = 0; i < this.tabEtudiant.length / 10; i++) {
        groups.push(this.tabEtudiant.slice(i * 10, (i + 1) * 10));

      }
      this.groups=this.shuffle(groups)
      this.shuffleArrayOfArrays(this.groups)

*/



      for (let i = 0; i < this.tabSujet.length / 10; i++) {
        sujets.push(this.tabSujet.slice(i * 10, (i + 1) * 10));
      }
      this.sujets=this.shuffle(sujets)

      this.shuffleArrayOfArrays(this.sujets)


      console.log(sujets)






    });

  }

loadGroupes(){
  console.log(this.groupsForm);
  this.groupsForm.controls.groups.setValue(this.groups);
  this.sujetForm.controls.sujet.setValue(this.sujets);
  console.log(this.sujetForm)




}
//Melanger une table
 shuffle(array : any[]) {
  let currentIndex = array.length;
  let temporaryValue, randomIndex;

  // While there remain elements to shuffle...
  while (currentIndex !== 0) {
    // Pick a remaining element...
    randomIndex = Math.floor(Math.random() * currentIndex);
    currentIndex -= 1;

    // And swap it with the current element.
    temporaryValue = array[currentIndex];
    array[currentIndex] = array[randomIndex];
    array[randomIndex] = temporaryValue;
  }

  return array;
}

 shuffleArrayOfArrays(arrayOfArrays: any[][]) {
  for (let i = 0; i < arrayOfArrays.length; i++) {
    this.shuffle(arrayOfArrays[i]);
  }
}

 createGroups(students: Etudiant[], subjectCount: number) {
  // Calculer le nombre maximum d'étudiants par groupe
  const maxPerGroup = Math.ceil(students.length / subjectCount);
  console.log(students.length)

  // Diviser les étudiants en groupes
  const groups: Etudiant[][] = [];
  for (let i = 0; i < students.length / maxPerGroup; i++) {
    groups.push(students.slice(i * maxPerGroup, (i + 1) * maxPerGroup));
  }

  return groups;
}



}
