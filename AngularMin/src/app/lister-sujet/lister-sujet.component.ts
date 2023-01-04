import { Component } from '@angular/core';
import { Sujet } from '../Sujet';
import { AppService } from '../app.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-lister-sujet',
  templateUrl: './lister-sujet.component.html',
  styles: [
  ]
})
export class ListerSujetComponent {
    
sujet: any[] | undefined
url: string = "http://localhost:8080/";

constructor(private service: AppService, private router: Router ) { 
 
}
reloadComponent() {
}

ngOnInit(): void {
  
  
  this.service.getSujets().subscribe(data => {
    this.sujet = data;
  })
}

deleteSujet(id: number){
  this.service.deleteSujet(id).subscribe(data => {
    this.sujet = this.sujet?.filter(sujet => sujet.id !== id);
  })
  
    setTimeout(()=>{
      window.location.reload();
    }, 100);

}


updateSujet(id: number){
  this.router.navigate(['updateSujet', id]);
}

}
