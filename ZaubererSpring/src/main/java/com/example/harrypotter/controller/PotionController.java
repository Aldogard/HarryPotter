package com.example.harrypotter.controller;


import com.example.harrypotter.entity.options.Potion;
import com.example.harrypotter.repo.options.PotionsRepo;
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
public class PotionController {
    private PotionsRepo potionsRepo;

    @GetMapping("/potion/{id}")
    public ResponseEntity<Potion> getPotionById(@PathVariable int id){
        return new ResponseEntity<>(potionsRepo.findById(id).orElse(null), HttpStatus.OK);
    }
}
