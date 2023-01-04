import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { AjoutEtudiantComponent } from './ajout-etudiant/ajout-etudiant.component';
import { AccueilComponent } from './accueil/accueil.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ListerEtudiantComponent } from './lister-etudiant/lister-etudiant.component';
import { UpdateEtudiantComponent } from './update-etudiant/update-etudiant.component';
import { ListerSujetComponent } from './lister-sujet/lister-sujet.component';
import { AjouterSujetComponent } from './ajouter-sujet/ajouter-sujet.component';
import { UpdateSujetComponent } from './update-sujet/update-sujet.component';


@NgModule({
  declarations: [
    AppComponent,
    AjoutEtudiantComponent,
    AccueilComponent,
    ListerEtudiantComponent,
    UpdateEtudiantComponent,
    ListerSujetComponent,
    AjouterSujetComponent,
    UpdateSujetComponent
  ],
  imports: [
    FormsModule,
    ReactiveFormsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule

    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
