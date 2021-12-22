package com.example.harrypotter.controller;


import com.example.harrypotter.entity.wizards.*;
import com.example.harrypotter.repo.wizards.CommentsRepo;
import com.example.harrypotter.repo.wizards.WizardRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/wizard")
public class CommentsController {

    private CommentsRepo commentsRepo;
    private WizardRepo wizardRepo;


    @PostMapping("/comment/{id}")
    public ResponseEntity<Comments> createComment(@RequestBody @Validated Comments comments, @PathVariable int id) {
        Comments c = new Comments(comments.getContent(), wizardRepo.findById(id).orElse(null));
        commentsRepo.save(c);
        return new ResponseEntity<>((c), HttpStatus.OK);
    }


}
