package com.example.harrypotter.repo.dummy;

import com.example.harrypotter.entity.dummy.Dummy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DummyRepo extends CrudRepository<Dummy, Integer> {
    List<Dummy> findAll();
    List<Dummy> findByName(String name);
}
