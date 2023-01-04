import { Component , OnInit , ViewChild, ElementRef  } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AppService } from 'src/app/app.service';
import { Sujet } from '../Sujet';


@Component({
  selector: 'app-ajouter-sujet',
  templateUrl: './ajouter-sujet.component.html',
  styles: [
  ]
})
export class AjouterSujetComponent {
  constructor(private service: AppService, private router: Router) { }




  
  data: any

  
  form = new FormGroup({
    text: new FormControl('', [Validators.required]),
    description: new FormControl('', [Validators.required]),
  })
  clearForm() {
    this.form.controls.text.setValue('');
    this.form.controls.description.setValue('');
  }
  
  ngOnInit(): void {
  }

//recuper l'element par l'id
@ViewChild('alert', { static: true }) alert: ElementRef;
@ViewChild('alert1', { static: true }) alert1: ElementRef;
  
  //Fontion pour enlever l'attribut
  showAlert() {
    this.alert.nativeElement.removeAttribute('hidden');
    this.alert1.nativeElement.setAttribute('hidden', 'true')

  }
  showAlert1() {
    this.alert1.nativeElement.removeAttribute('hidden');
    this.alert.nativeElement.setAttribute('hidden', 'true')


  }


  

  submit(){


    this.data = this.form.value
    
if(this.data.text!="" && this.data.description!="")
{
  this.service.addSujet(this.data).subscribe(data => {
    console.log(data)
    this.showAlert()
    this.clearForm()
  })

}else         this.showAlert1()




    
    
    this.router.navigate(['/ajoutSujet']);
  }


}
