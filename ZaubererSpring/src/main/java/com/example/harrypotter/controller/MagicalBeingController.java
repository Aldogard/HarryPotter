package com.example.harrypotter.controller;

import com.example.harrypotter.entity.magicalbeings.MagicalBeing;
import com.example.harrypotter.entity.magicalbeings.wizards.*;
import com.example.harrypotter.service.magicalbeings.MagicalBeingService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/mb")
@AllArgsConstructor
public class MagicalBeingController {
    private MagicalBeingService magicalBeingService;

    @GetMapping("/{id}")
    public ResponseEntity<MagicalBeing> getAllMagicalBeings(@PathVariable int id){
        return magicalBeingService.getMagicalBeingById(id);
    }

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<MagicalBeing>> getAll(@RequestParam(required = false) String name, @RequestParam(required = false) String klasse, @RequestParam(required = false) String species) {
        return magicalBeingService.getAllMagicalBeings(name, klasse, species);
    }


    @GetMapping("/hp")
    @ResponseBody
    public ResponseEntity<List<MagicalBeing>> getAllByHealthPoints(@RequestParam(required = false) Double min, @RequestParam(required = false) Double max) {
        return magicalBeingService.getAllMagicalBeingHp(min, max);
    }

    @GetMapping("/victory")
    @ResponseBody
    public ResponseEntity<List<MagicalBeing>> getAllByVictory(@RequestParam(required = false) Integer victories) {
        return magicalBeingService.getAllMagicalBeingsVictories(victories);
    }


    @GetMapping("/name/{name}")
    public ResponseEntity<MagicalBeing> getMagicalBeingByName(@PathVariable String name) {
        return  magicalBeingService.getMagicalBeingByName(name);
    }

    @GetMapping("/voldemort")
    public ResponseEntity<MagicalBeing> getVoldemort(){
        return magicalBeingService.getVoldemort("Voldemort");
    }

    @PutMapping("/{id}")
    public ResponseEntity<MagicalBeing> updateMagicalBeing(@RequestBody @Validated Headmaster mb, @PathVariable int id) {
        return magicalBeingService.updateMagicalBeing(mb, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMagicalBeing(@PathVariable Integer id) {
        return magicalBeingService.deleteMagicalBeing(id);
    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<Void> deleteAllWizards() {
        return magicalBeingService.deleteAllMagicalBeings();
    }

    @GetMapping("/pin")
    public ResponseEntity<Integer> getNumber() {
        return new ResponseEntity<>(394, HttpStatus.OK);
    }

    @GetMapping("/quote")
    public ResponseEntity<String> getQuote() {
        String quote = magicalBeingService.quote();
        return new ResponseEntity<>(quote, HttpStatus.OK);
    }

    @PutMapping("/rating/{id}")
    public ResponseEntity<MagicalBeing> updateRating(@RequestBody @Validated Headmaster magicalBeing, @PathVariable int id) {
        return magicalBeingService.updateRating(magicalBeing, id);
    }

    @PutMapping("/victory")
    public ResponseEntity<MagicalBeing> updateVictories(@RequestBody @Validated Headmaster magicalBeing){
        return magicalBeingService.updateVictories(magicalBeing);
    }

    @PutMapping("/victorychess")
    public ResponseEntity<MagicalBeing> updateChesVictories(@RequestBody @Validated Headmaster magicalBeing){
        return magicalBeingService.updateVictoriesChess(magicalBeing);
    }



}
