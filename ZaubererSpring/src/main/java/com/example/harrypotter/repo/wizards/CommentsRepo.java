package com.example.harrypotter.repo.wizards;

import com.example.harrypotter.entity.wizards.Comments;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentsRepo extends CrudRepository<Comments, Integer> {
    List<Comments> findAll();
}
