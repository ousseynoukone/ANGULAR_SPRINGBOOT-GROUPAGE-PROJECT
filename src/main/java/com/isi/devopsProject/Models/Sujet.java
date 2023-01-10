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

    //Constructor


    public Sujet() {
    }

    public Sujet( String text, String description) {
        super();
        this.text = text;
        this.description = description;
    }

//getters

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getDescription() {
        return description;
    }
    //setters

    public void setText(String text) {
        this.text = text;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

