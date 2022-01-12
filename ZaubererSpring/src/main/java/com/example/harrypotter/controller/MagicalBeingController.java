package com.example.harrypotter.controller;

import com.example.harrypotter.entity.magicalbeings.MagicalBeing;
import com.example.harrypotter.service.magicalbeings.MagicalBeingService;
import lombok.AllArgsConstructor;
import lombok.Data;
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

    @GetMapping("")
    public ResponseEntity<List<MagicalBeing>> getAllMagicalBeings(){
        return magicalBeingService.getAllMagicalBeings();

    }

    @GetMapping("/{id}")
    public ResponseEntity<MagicalBeing> getAllMagicalBeings(@PathVariable int id){
        return magicalBeingService.getMagicalBeingById(id);
    }

}
