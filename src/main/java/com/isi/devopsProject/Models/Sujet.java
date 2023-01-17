package com.isi.devopsProject.Models;
import jakarta.persistence.*;


@Entity
@Table
public class Sujet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column
    private String text;

    @Column
    private String description;

    @Column
    public int idGroupeA ;

    //Constructor


    public Sujet() {
    }

    public Sujet( String text, String description , int idGroupeA) {
        super();
        this.text = text;
        this.description = description;
        this.idGroupeA = idGroupeA;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdGroupeA() {
        return this.idGroupeA;
    }

    public void setIdGroupeA(int idGroupeA) {
        this.idGroupeA = idGroupeA;
    }

}

