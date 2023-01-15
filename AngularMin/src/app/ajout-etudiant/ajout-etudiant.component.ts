import { Component , OnInit , ViewChild, ElementRef  } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AppService } from 'src/app/app.service';



@Component({
  selector: 'app-ajout-etudiant',
  templateUrl: 'ajout-etudiant.component.html',
  styles: [
  ]
})
export class AjoutEtudiantComponent implements OnInit {

  constructor(private service: AppService, private router: Router) { }

  data: any

  
  form = new FormGroup({
    nom: new FormControl('', [Validators.required]),
    prenom: new FormControl('', [Validators.required]),
  })
  clearForm() {
    this.form.controls.nom.setValue('');
    this.form.controls.prenom.setValue('');
  }
  
  ngOnInit(): void {
  }

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
    
if(this.data.prenom!="" && this.data.nom!="")
{
  this.service.addEtudiant(this.data).subscribe(data => {
    console.log(data)
    this.showAlert()
    this.clearForm()
  })

}else         this.showAlert1()




    
    
    this.router.navigate(['/ajout']);
  }

}
