package com.example.harrypotter.controller;

import com.example.harrypotter.entity.dummy.Dummy;
import com.example.harrypotter.service.DummyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/dummy")
public class DummyController {
    private DummyService dummyService;


    @PostMapping("")
    public ResponseEntity<Dummy> createDummy(){
        return dummyService.createDummy();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Dummy> getDummyByName(@PathVariable String name) {
        return  dummyService.getDummyByName(name);
    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<Void> deleteAllDummy() {
        return dummyService.deleteAllDummy();
    }

}
