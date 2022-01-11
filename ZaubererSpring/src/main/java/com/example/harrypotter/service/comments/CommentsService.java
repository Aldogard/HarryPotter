package com.example.harrypotter.service.comments;

import com.example.harrypotter.entity.magicalbeings.Comments;
import com.example.harrypotter.repo.wizards.CommentsRepo;
import com.example.harrypotter.repo.wizards.WizardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CommentsService {

    @Autowired
    private WizardRepo wizardRepo;

    @Autowired
    private CommentsRepo commentsRepo;

    public ResponseEntity<Comments> createComment(Comments comments, int id){
        Comments c = new Comments(comments.getContent(), wizardRepo.findById(id).orElse(null));
        commentsRepo.save(c);
        return new ResponseEntity<>((c), HttpStatus.OK);
    }
}
