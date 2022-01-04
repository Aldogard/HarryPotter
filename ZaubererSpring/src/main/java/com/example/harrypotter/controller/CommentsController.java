package com.example.harrypotter.controller;


import com.example.harrypotter.entity.wizards.*;
import com.example.harrypotter.repo.wizards.CommentsRepo;
import com.example.harrypotter.repo.wizards.WizardRepo;
import com.example.harrypotter.service.comments.CommentsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/wizard")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;


    @PostMapping("/comment/{id}")
    public ResponseEntity<Comments> createComment(@RequestBody @Validated Comments comments, @PathVariable int id) {
        return commentsService.createComment(comments, id);
    }
}
