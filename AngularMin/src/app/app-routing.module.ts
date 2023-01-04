import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccueilComponent } from './accueil/accueil.component';
import { AjoutEtudiantComponent } from './ajout-etudiant/ajout-etudiant.component';
import { AjouterSujetComponent } from './ajouter-sujet/ajouter-sujet.component';
import { ListerEtudiantComponent } from './lister-etudiant/lister-etudiant.component';
import { ListerSujetComponent } from './lister-sujet/lister-sujet.component';
import { UpdateEtudiantComponent } from './update-etudiant/update-etudiant.component';
import { UpdateSujetComponent } from './update-sujet/update-sujet.component';

const routes: Routes = [
  { path : 'ajout' , component : AjoutEtudiantComponent},
  { path : 'ajoutSujet' , component : AjouterSujetComponent},
  { path : 'Accueil' , component : AccueilComponent},
  { path : 'etudiants' ,   component : ListerEtudiantComponent},
  { path : 'sujets' ,   component : ListerSujetComponent},
  { path : 'update/:id' ,   component : UpdateEtudiantComponent},
  { path : 'updateSujet/:id' ,   component : UpdateSujetComponent},
  { path : '' , redirectTo : 'Accueil' ,  pathMatch: "full"}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
