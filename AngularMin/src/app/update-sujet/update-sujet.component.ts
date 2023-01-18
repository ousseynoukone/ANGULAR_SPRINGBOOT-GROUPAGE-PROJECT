import { Component , OnInit } from '@angular/core';
import { AppService } from '../app.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { Sujet } from '../Sujet';
@Component({
  selector: 'app-update-sujet',
  templateUrl: './update-sujet.component.html',
  styles: [
  ]
})
export class UpdateSujetComponent {

  s?: Sujet
  data: any


  constructor(private service: AppService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    let id = this.route.snapshot.params['id'];
    this.service.getSujet(id).subscribe(data => {
      this.s = data
      console.log(this.s)
      this.form = new FormGroup({
        text: new FormControl(data.text, [Validators.required]),
        description: new FormControl(data.description, [Validators.required]),
        idGroupeA : new FormControl(data.idGroupeA.toString()) 
        
      })
    })
  }

 

  form = new FormGroup({
    text: new FormControl('', [Validators.required]),
    description: new FormControl('', [Validators.required]),
    idGroupeA: new FormControl(''),
  })

  submit(){
    this.data = this.form.value
    console.log(this.data)
    
    this.service.updateSujet(this.s?.id, this.data).subscribe(data => {
      console.log(data)
    })

    window.location.href='/sujets'

  }


}
