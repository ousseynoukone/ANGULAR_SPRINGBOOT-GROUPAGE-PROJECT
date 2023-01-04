import { Component , OnInit} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl:'app.component.html'
})

export class AppComponent implements OnInit  {
  title = 'angular';
  public val : any ;

  constructor(private http: HttpClient) {}



  ngOnInit() {
    // Initialization logic goes here
  }



  getData() {
    this.http.get('http://localhost:8080/hello').subscribe(data => {
      // Traitement des données ici
      this.val=data;
      console.log(this.val);
    });
  }

 




  }