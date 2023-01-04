import { Injectable } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { Etudiant } from './etudiant';
import { Observable } from 'rxjs'
import { Sujet } from './Sujet';

@Injectable({
  providedIn: 'root'
})
export class AppService {



  
  private url = "http://localhost:8080/";

  constructor(private http: HttpClient) { }

  // Add Etudiant - Create
  addEtudiant(Etudiant: Etudiant){
    return this.http.post<Etudiant>(`${this.url}add`, Etudiant)
  }

  // Get Etudiants - Read
  getEtudiants(): Observable<any[]>{
    return this.http.get<any[]>(this.url+'etudiants')
  }

  // Get Etudiant by Id - Read
  getEtudiant(id: number): Observable<Etudiant>{
    return this.http.get<Etudiant>(`${this.url}etudiant/${id}`)
  }

  // Update Etudiant - Update
  updateEtudiant(id?: number ,Etudiant?: any): Observable<any>{
    return this.http.put<any>(`${this.url}update/${id}`, Etudiant)
  }

  // Delete Etudiant - Delete
  deleteEtudiant(id: number): Observable<any>{
    return this.http.delete<any>(`${this.url}delete/${id}`)
  }







  //SUUUUUUUUUJJJJJJJJEEEEETTTTTTTTTTTTT
      // Add Etudiant - Create
      addSujet(sujet: Sujet){
        return this.http.post<Sujet>(`${this.url}addSujet`, sujet)
      }
    // Get Etudiants - Read
    getSujets(): Observable<any[]>{
      return this.http.get<any[]>(this.url+'Sujets')
    }
  
    // Get Etudiant by Id - Read
    getSujet(id: number): Observable<Sujet>{
      return this.http.get<Sujet>(`${this.url}Sujet/${id}`)
    }
  
    // Update Etudiant - Update
    updateSujet(id?: number ,sujet?: any): Observable<any>{
      return this.http.put<any>(`${this.url}updateSujet/${id}`, sujet)
    }
  
    // Delete Etudiant - Delete
    deleteSujet(id: number): Observable<any>{
      return this.http.delete<any>(`${this.url}deleteSujet/${id}`)
    }
  


}
