import { Component , OnInit } from '@angular/core';
import { AppService } from '../app.service';
import { Etudiant } from '../etudiant';
import { ActivatedRoute, Router } from '@angular/router';
import { FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
@Component({
  selector: 'app-update-etudiant',
  templateUrl: './update-etudiant.component.html',
  styles: [
  ]
})
export class UpdateEtudiantComponent {
  et?: Etudiant
  data: any

  constructor(private service: AppService, private route: ActivatedRoute, private router : Router) { }

  ngOnInit(): void {
    let id = this.route.snapshot.params['id'];
    this.service.getEtudiant(id).subscribe(data => {
      this.et = data
      console.log(this.et)
      this.form = new FormGroup({
        nom: new FormControl(data.nom, [Validators.required]),
        prenom: new FormControl(data.prenom, [Validators.required]),
      })
    })
  }

 

  form = new FormGroup({
    nom: new FormControl('', [Validators.required]),
    prenom: new FormControl('', [Validators.required]),
  })

  submit(){
    this.data = this.form.value
    console.log(this.data)
    
    this.service.updateEtudiant(this.et?.id, this.data).subscribe(data => {
      console.log(data)
    })

    window.location.href='/etudiants'

  }

}
