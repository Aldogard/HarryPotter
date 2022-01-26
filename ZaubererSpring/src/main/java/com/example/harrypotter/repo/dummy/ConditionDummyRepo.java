package com.example.harrypotter.repo.dummy;

import com.example.harrypotter.entity.dummy.ConditionDummy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConditionDummyRepo extends CrudRepository<ConditionDummy, Integer> {
    List<ConditionDummy> findAll();

}
