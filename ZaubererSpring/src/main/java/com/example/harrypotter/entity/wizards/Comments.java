package com.example.harrypotter.entity.wizards;



import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "content")
    private String content;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "wizard_id")
    private Wizard wizard;


    public Comments(){

    }

    /**
     * Constructor to create a new comment. Each comment must contain:
     * @param content contains the submitted comment
     * @param wizard indicates to which wizard the comment belongs
     */

    public Comments(String content, Wizard wizard){
        this.content = content;
        this.wizard = wizard;
    }

}
