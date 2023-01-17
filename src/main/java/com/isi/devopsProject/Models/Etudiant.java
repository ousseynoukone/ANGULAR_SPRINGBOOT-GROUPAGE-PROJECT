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

    @Column
    public int idGroupeA ;


    public Etudiant() {
    }

    public Etudiant (String nom , String prenom , int idGroupe ,int idGroupeA){
        super();
        this.idGroupe = idGroupe;
        this.prenom = prenom;
        this.nom = nom;
        this.idGroupeA = idGroupeA;
        
    }

    //getters
    public String  getNom(){return nom;}
    public String  getPrenom(){return prenom;}
    public int  geIdGroupe(){return idGroupe;}
    public int  geIdGroupeA(){return idGroupeA;}
    public int  getId(){return id;}

    //setters
    public void  setNom(String nom){this.nom=nom;}
    public void  setPrenom(String prenom){this.prenom=prenom;}
    public void  setIdGroupe(int idGroupe){this.idGroupe=idGroupe;}
    public void  setIdGroupeA(int idGroupeA){this.idGroupeA=idGroupeA;}
    

    
    
}
