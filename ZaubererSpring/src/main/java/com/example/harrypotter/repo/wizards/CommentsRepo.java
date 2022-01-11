package com.example.harrypotter.repo.wizards;

import com.example.harrypotter.entity.magicalbeings.Comments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepo extends CrudRepository<Comments, Integer> {
    List<Comments> findAll();
}
