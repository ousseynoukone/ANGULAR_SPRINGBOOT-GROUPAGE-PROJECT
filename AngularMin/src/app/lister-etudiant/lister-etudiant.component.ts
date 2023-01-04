import { Component } from '@angular/core';
import { Etudiant } from '../etudiant';
import { AppService } from '../app.service';
import { Router } from '@angular/router';
import { ChangeDetectorRef } from '@angular/core';

@Component({
  selector: 'app-lister-etudiant',
  templateUrl: './lister-etudiant.component.html',
  styles: [
  ]
})
export class ListerEtudiantComponent {
  
etudiants: any[] | undefined
url: string = "http://localhost:8080/";

constructor(private service: AppService, private router: Router , private cdr: ChangeDetectorRef) { 
 
}
reloadComponent() {
  this.cdr.detectChanges();
}

ngOnInit(): void {
  
  
  this.service.getEtudiants().subscribe(data => {
    this.etudiants = data;
  })
}

deleteEtudiant(id: number){
  this.service.deleteEtudiant(id).subscribe(data => {
    this.etudiants = this.etudiants?.filter(etudiant => etudiant.id !== id);
  })
  
    setTimeout(()=>{
      window.location.reload();
    }, 100);

}


updateEtudiant(id: number){
  this.router.navigate(['update', id]);
}

}
