package com.example.harrypotter.entity.magicalbeings;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "hint")
public class Hint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "content")
    private String content;

    @Column(name = "Ravenclaw")
    private Boolean ravenclaw;

    @Column(name = "ron")
    private Boolean ron;

    @Column(name = "luna")
    private Boolean luna;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "magicalBeing_id")
    private MagicalBeing magicalBeing;

    public Hint(String content, Boolean ravenclaw, Boolean ron, Boolean luna, MagicalBeing magicalBeing) {
        this.content = content;
        this.ravenclaw = ravenclaw;
        this.ron = ron;
        this.luna = luna;
        this.magicalBeing = magicalBeing;
    }


    public Hint() {

    }
}
