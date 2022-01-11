package com.example.harrypotter.service.options;

import com.example.harrypotter.entity.options.Potion;
import com.example.harrypotter.entity.options.Spell;
import com.example.harrypotter.entity.magicalbeings.wizards.Alumni;

import java.math.BigDecimal;

public class UtilOptions {
    public static Alumni createTesti(){
        return new Alumni("Testi", BigDecimal.valueOf(10), "Test and more than 10");

    }

    public static boolean allFalse(Spell spell){
        return !spell.getStunned() &&
                !spell.getConfunded() &&
                !spell.getImperio() &&
                !spell.getCrucio() &&
                !spell.getProtego() &&
                !spell.getFiendfyre() &&
                !spell.getAntiFiendfyre();
    }

    public static boolean allFalseExceptStunned(Spell spell){
        return spell.getStunned() &&
                !spell.getConfunded() &&
                !spell.getImperio() &&
                !spell.getCrucio() &&
                !spell.getProtego() &&
                !spell.getFiendfyre() &&
                !spell.getAntiFiendfyre();
    }

    public static boolean allFalseExceptConfunded(Spell spell){
        return !spell.getStunned() &&
                spell.getConfunded() &&
                !spell.getImperio() &&
                !spell.getCrucio() &&
                !spell.getProtego() &&
                !spell.getFiendfyre() &&
                !spell.getAntiFiendfyre();
    }

    public static boolean allFalseZeroRecoveryAndHealing(Potion potion){
        return potion.getHealing().equals(BigDecimal.valueOf(0.0)) &&
                potion.getEnergyRecovery().equals(BigDecimal.valueOf(0.0)) &&
                !potion.getAntiParalysis() &&
                !potion.getAntiConfunded() &&
                !potion.getRegeneration() &&
                !potion.getUnicornBlood();

    }

    public static boolean allFalse(Potion potion){
        return !potion.getAntiParalysis() &&
                !potion.getAntiConfunded() &&
                !potion.getRegeneration() &&
                !potion.getUnicornBlood();

    }
}
