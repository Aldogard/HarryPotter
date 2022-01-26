package com.example.harrypotter.entity.options;

import com.example.harrypotter.entity.magicalbeings.wizards.Alumni;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class IngredientTest {

    @Test
    public void testIngredientConstructor(){
        Potion potion = new Potion();
        Ingredient test = new Ingredient("Wormwood", potion);

        assertNotNull(test);
        assertEquals("Wormwood", test.getIngredient());
        assertEquals(potion, test.getPotion());


    }
}
