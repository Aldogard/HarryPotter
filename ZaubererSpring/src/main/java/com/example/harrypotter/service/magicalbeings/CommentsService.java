package com.example.harrypotter.service.magicalbeings;

import com.example.harrypotter.entity.magicalbeings.Comments;
import com.example.harrypotter.repo.magicalbeings.CommentsRepo;
import com.example.harrypotter.repo.magicalbeings.MagicalBeingRepo;
import com.example.harrypotter.repo.magicalbeings.wizards.WizardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CommentsService {

    @Autowired
    private MagicalBeingRepo magicalBeingRepo;

    @Autowired
    private CommentsRepo commentsRepo;

    public ResponseEntity<Comments> createComment(Comments comments, int id){
        Comments c = new Comments(comments.getContent(), magicalBeingRepo.findById(id).orElse(null));
        commentsRepo.save(c);
        return new ResponseEntity<>((c), HttpStatus.OK);
    }
}
