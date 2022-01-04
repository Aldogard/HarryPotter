package com.example.harrypotter.service.strengthAndWeaknessService;

import com.example.harrypotter.entity.wizards.StrengthAndWeakness;
import com.example.harrypotter.entity.wizards.Wizard;
import com.example.harrypotter.repo.wizards.SaWRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class StrengthAndWeaknessService {
    private SaWRepo saWRepo;

    public void strengthHeadmaster(Wizard wizard) {
        saWRepo.save(new StrengthAndWeakness("Headmaster", true, wizard));
    }

    public void weaknessHeadmaster(Wizard wizard) {
        saWRepo.save(new StrengthAndWeakness("Headmaster", false, wizard));
    }

    public void strengthVoldemort(Wizard wizard) {
        saWRepo.save(new StrengthAndWeakness("Voldemort", true, wizard));
    }

    public void weaknessVoldmort(Wizard wizard) {
        saWRepo.save(new StrengthAndWeakness("Voldemort", false, wizard));
    }

    public void strengthHufflepuff(Wizard wizard) {
        saWRepo.save(new StrengthAndWeakness("Hufflepuff", true, wizard));
    }

    public void weaknessHufflepuff(Wizard wizard) {
        saWRepo.save(new StrengthAndWeakness("Hufflepuff", false, wizard));
    }

    public void strengthDeathEater(Wizard wizard) {
        saWRepo.save(new StrengthAndWeakness("DeathEater", true, wizard));
    }

    public void weaknessDeathEater(Wizard wizard) {
        saWRepo.save(new StrengthAndWeakness("DeathEater", false, wizard));
    }

    public void strengthGryffindor(Wizard wizard) {
        saWRepo.save(new StrengthAndWeakness("Gryffindor", true, wizard));
    }

    public void weaknessGryffindor(Wizard wizard) {
        saWRepo.save(new StrengthAndWeakness("Gryffindor", false, wizard));
    }

    public void strengthSlytherin(Wizard wizard) {
        saWRepo.save(new StrengthAndWeakness("Slytherin", true, wizard));
    }

    public void weaknessSlytherin(Wizard wizard) {
        saWRepo.save(new StrengthAndWeakness("Slytherin", false, wizard));
    }

    public void strengthRavenclaw(Wizard wizard) {
        saWRepo.save(new StrengthAndWeakness("Ravenclaw", true, wizard));
    }

    public void weaknessRavenclaw(Wizard wizard) {
        saWRepo.save(new StrengthAndWeakness("Ravenclaw", false, wizard));
    }

    public void strengthAlumni(Wizard wizard) {
        saWRepo.save(new StrengthAndWeakness("Alumni", true, wizard));
    }

    public void weaknessAlumni(Wizard wizard) {
        saWRepo.save(new StrengthAndWeakness("Alumni", false, wizard));
    }

    public void strengthProfessor(Wizard wizard) {
        saWRepo.save(new StrengthAndWeakness("Professor", true, wizard));
    }

    public void weaknessProfessor(Wizard wizard) {
        saWRepo.save(new StrengthAndWeakness("Professor", false, wizard));
    }

    public void strengthDumbledore(Wizard wizard) {
        saWRepo.save(new StrengthAndWeakness("Dumbledore", true, wizard));
    }

    public void weaknessDumbledore(Wizard wizard) {
        saWRepo.save(new StrengthAndWeakness("Dumbledore", false, wizard));
    }

    public void strengthPotionsMaster(Wizard wizard) {
        saWRepo.save(new StrengthAndWeakness("Potions Master", true, wizard));
    }

    public void weaknessPotionsMaster(Wizard wizard) {
        saWRepo.save(new StrengthAndWeakness("Potions Master", false, wizard));
    }

    public void strengthHogwartsHouse(Wizard wizard) {
        saWRepo.save(new StrengthAndWeakness("Gryffindor", true, wizard));
        saWRepo.save(new StrengthAndWeakness("Slytherin", true, wizard));
        saWRepo.save(new StrengthAndWeakness("Hufflepuff", true, wizard));
        saWRepo.save(new StrengthAndWeakness("Ravenclaw", true, wizard));
    }


}
