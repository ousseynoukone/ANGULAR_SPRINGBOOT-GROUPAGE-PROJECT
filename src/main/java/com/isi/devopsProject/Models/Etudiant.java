package com.isi.devopsProject.Models;


import jakarta.persistence.*;




@Entity
@Table
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column
    private String nom ;

    @Column
    public String prenom ;

    @Column
    public int idGroupe ;

    public Etudiant() {
    }

    public Etudiant (String nom , String prenom , int idGroupe){
        super();
        this.idGroupe = idGroupe;
        this.prenom = prenom;
        this.nom = nom;
        
    }

    //getters
    public String  getNom(){return nom;}
    public String  getPrenom(){return prenom;}
    public int  geIdGroupe(){return idGroupe;}
    public int  getId(){return id;}

    //setters
    public void  setNom(String nom){this.nom=nom;}
    public void  setPrenom(String prenom){this.prenom=prenom;}
    public void  setIdGroupe(int idGroupe){this.idGroupe=idGroupe;}
    

    
    
}
