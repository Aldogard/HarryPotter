package com.example.harrypotter.service.magicalbeings;

import com.example.harrypotter.entity.magicalbeings.MagicalBeing;
import com.example.harrypotter.repo.magicalbeings.MagicalBeingRepo;
import com.example.harrypotter.service.comments.ConditionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MagicalBeingService {
    private MagicalBeingRepo magicalBeingRepo;

    public ResponseEntity<List<MagicalBeing>> getAllMagicalBeings(){
        return new ResponseEntity<>(magicalBeingRepo.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<MagicalBeing> getMagicalBeingById(int id){
        return new ResponseEntity<>(magicalBeingRepo.findById(id).orElse(null), HttpStatus.OK);
    }

    public boolean checkName(MagicalBeing magicalBeing) {
        for (MagicalBeing mb : magicalBeingRepo.findAll()) {
            if (mb.getName().equals(magicalBeing.getName())) {
                return true;
            }
        }
        return false;
    }

}
