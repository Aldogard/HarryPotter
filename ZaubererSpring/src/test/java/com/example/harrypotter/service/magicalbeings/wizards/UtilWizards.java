package com.example.harrypotter.service.magicalbeings.wizards;

import com.example.harrypotter.entity.options.Spell;
import com.example.harrypotter.entity.magicalbeings.wizards.Alumni;
import com.example.harrypotter.entity.magicalbeings.wizards.StrengthAndWeakness;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UtilWizards {
    public static final int numberOfConditions = 2;

    public static Alumni createTesti(){
        return new Alumni("Testi", BigDecimal.valueOf(10), "Test and more than 10");

    }

    public static List<StrengthAndWeakness> findStrength (List<StrengthAndWeakness> sawList){
        List<StrengthAndWeakness> strength = new ArrayList<>();
        for (StrengthAndWeakness saw: sawList) {
            if(saw.getStrength()){
                strength.add(saw);
            }
        }
        return strength;
    }

    public static List<StrengthAndWeakness> findWeaknesses (List<StrengthAndWeakness> sawList){
        List<StrengthAndWeakness> weaknesses = new ArrayList<>();
        for (StrengthAndWeakness saw: sawList) {
            if(!saw.getStrength()){
                weaknesses.add(saw);
            }
        }
        return weaknesses;
    }

    public static boolean checkFiendfyre (List<Spell> spellList){
        boolean fiendfyre = false;
        boolean antiFiendfyre = false;

        for (Spell spell:spellList) {
            if(spell.getFiendfyre()){
                fiendfyre=true;
            }
            if (spell.getAntiFiendfyre()){
                antiFiendfyre = true;
            }
        }
        return fiendfyre == antiFiendfyre;
    }
}
