package com.example.harrypotter.controller;

import com.example.harrypotter.entity.magicalbeings.giants.Giant;
import com.example.harrypotter.service.magicalbeings.giants.GiantService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/giant")
public class GiantController {
    private GiantService giantService;

    @PostMapping("")
    public ResponseEntity<Giant> createMagicalBeing(@RequestBody @Validated Giant giant){
        return giantService.createGiant(giant);
    }
}
