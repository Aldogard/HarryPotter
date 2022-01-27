package com.example.harrypotter.service.magicalbeings;

import com.example.harrypotter.entity.magicalbeings.Comments;
import com.example.harrypotter.repo.magicalbeings.CommentsRepo;
import com.example.harrypotter.repo.magicalbeings.MagicalBeingRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentsService {
    private MagicalBeingRepo magicalBeingRepo;
    private CommentsRepo commentsRepo;

    public ResponseEntity<Comments> createComment(Comments comments, int id){
        Comments c = new Comments(comments.getContent(), magicalBeingRepo.findById(id).orElse(null));
        commentsRepo.save(c);
        return new ResponseEntity<>((c), HttpStatus.OK);
    }
}
