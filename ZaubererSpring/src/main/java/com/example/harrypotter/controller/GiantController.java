package com.example.harrypotter.controller;

import com.example.harrypotter.entity.magicalbeings.giants.Giant;
import com.example.harrypotter.entity.magicalbeings.giants.Gurg;
import com.example.harrypotter.entity.magicalbeings.giants.Hagrid;
import com.example.harrypotter.service.magicalbeings.giants.GurgService;
import com.example.harrypotter.service.magicalbeings.giants.HagridService;
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
    private GurgService gurgService;
    private HagridService halfGiantService;

    @PostMapping("/gurg")
    public ResponseEntity<Giant> createGurg(@RequestBody @Validated Gurg gurg){
        return gurgService.createGurg(gurg);
    }

    @PostMapping("/halfGiant")
    public ResponseEntity<Giant> createHalfGiant(@RequestBody @Validated Hagrid halfGiant){
        return halfGiantService.createHalfGiant(halfGiant);
    }
}
