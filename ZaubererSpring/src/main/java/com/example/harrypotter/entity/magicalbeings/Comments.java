package com.example.harrypotter.entity.magicalbeings;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity(name = "comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Size(min = 10, max = 100)
    @Column(name = "content")
    private String content;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "magicalBeing_id")
    private MagicalBeing magicalBeing;


    public Comments(){

    }

    /**
     * Constructor to create a new comment. Each comment must contain:
     * @param content contains the submitted comment
     * @param magicalBeing indicates to which wizard the comment belongs
     */

    public Comments(String content, MagicalBeing magicalBeing){
        this.content = content;
        this.magicalBeing = magicalBeing;
    }

}
