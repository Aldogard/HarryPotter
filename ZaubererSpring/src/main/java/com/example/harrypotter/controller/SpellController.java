package com.example.harrypotter.controller;

import com.example.harrypotter.entity.options.Spell;
import com.example.harrypotter.repo.options.SpellRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/wizard")
@AllArgsConstructor
public class SpellController {
    private SpellRepo spellRepo;

    @GetMapping("/attack/{id}")
    public ResponseEntity<Spell> getAttackById(@PathVariable int id){
        return new ResponseEntity<>(spellRepo.findById(id).orElse(null), HttpStatus.OK);
    }
}
