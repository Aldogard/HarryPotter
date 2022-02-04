package com.example.harrypotter.entity.quiz;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "answer")
    private String answer;

    @Column(name = "correct")
    public Boolean correct;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public Answer(String answer, Boolean correct, Question question){
        this.answer = answer;
        this.correct = correct;
        this.question = question;
    }

    public Answer() {

    }
}
