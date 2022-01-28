package com.example.harrypotter.controller;

import com.example.harrypotter.entity.options.Animal;
import com.example.harrypotter.entity.options.Melee;
import com.example.harrypotter.entity.options.Potion;
import com.example.harrypotter.entity.options.Spell;
import com.example.harrypotter.repo.options.AnimalRepo;
import com.example.harrypotter.repo.options.MeleeRepo;
import com.example.harrypotter.repo.options.PotionsRepo;
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
@RequestMapping("/mb")
@AllArgsConstructor
public class OptionsController {
    private PotionsRepo potionsRepo;
    private SpellRepo spellRepo;
    private AnimalRepo animalRepo;
    private MeleeRepo meleeRepo;


    @GetMapping("/potion/{id}")
    public ResponseEntity<Potion> getPotionById(@PathVariable int id){
        return new ResponseEntity<>(potionsRepo.findById(id).orElse(null), HttpStatus.OK);
    }

    @GetMapping("/attack/{id}")
    public ResponseEntity<Spell> getAttackById(@PathVariable int id){
        return new ResponseEntity<>(spellRepo.findById(id).orElse(null), HttpStatus.OK);
    }

    @GetMapping("/animal/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable int id){
        return new ResponseEntity<>(animalRepo.findById(id).orElse(null), HttpStatus.OK);
    }

    @GetMapping("/melee/{id}")
    public ResponseEntity<Melee> getMeleeById(@PathVariable int id){
        return new ResponseEntity<>(meleeRepo.findById(id).orElse(null), HttpStatus.OK);
    }


}
