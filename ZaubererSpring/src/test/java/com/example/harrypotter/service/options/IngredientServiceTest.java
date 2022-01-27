package com.example.harrypotter.service.options;

import com.example.harrypotter.entity.magicalbeings.wizards.Alumni;
import com.example.harrypotter.entity.options.Ingredient;
import com.example.harrypotter.entity.options.Potion;
import com.example.harrypotter.repo.magicalbeings.MagicalBeingRepo;
import com.example.harrypotter.repo.options.IngredientRepo;
import com.example.harrypotter.repo.options.PotionsRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class IngredientServiceTest {

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private IngredientRepo ingredientRepo;

    @Autowired
    private MagicalBeingRepo magicalBeingRepo;

    @Autowired
    private PotionsRepo potionsRepo;

    @Autowired
    private PotionService potionService;

    @AfterEach
    public void deleteAll(){
        ingredientRepo.deleteAll();
        magicalBeingRepo.deleteAll();
        potionsRepo.deleteAll();
    }

    private List<Ingredient> checkSavingOfIngredient(){
        assertNotNull(ingredientRepo.findAll());
        return ingredientRepo.findAll();
    }

    @Test
    public void testCreateIngredientBBE(){
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        potionService.createBrainElixir(alumni, 1);
        Potion bbe = potionsRepo.findAll().get(0);
        ingredientService.createIngredientsBBE(bbe);

        List<Ingredient> test = checkSavingOfIngredient();
        assertNotNull(test);
        assertEquals(4, ingredientRepo.findAll().size());
        assertEquals(bbe, test.get(0).getPotion());
        assertEquals("Runespoor eggs", test.get(2).getIngredient());
    }

    @Test
    public void testCreateIngredientEP(){
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        potionService.createExplodingPotion(alumni, 1);
        Potion ep = potionsRepo.findAll().get(0);
        ingredientService.createIngredientsEP(ep);

        List<Ingredient> test = checkSavingOfIngredient();
        assertNotNull(test);
        assertEquals(3, ingredientRepo.findAll().size());
        assertEquals(ep, test.get(0).getPotion());
        assertEquals("Ice pop", test.get(0).getIngredient());
    }

    @Test
    public void testCreateIngredientHP(){
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        potionService.createHealingPotion(alumni, 1);
        Potion hp = potionsRepo.findAll().get(0);
        ingredientService.createIngredientsHP(hp);

        List<Ingredient> test = checkSavingOfIngredient();
        assertNotNull(test);
        assertEquals(4, ingredientRepo.findAll().size());
        assertEquals(hp, test.get(0).getPotion());
        assertEquals("Bobutuber pus", test.get(1).getIngredient());
    }

    @Test
    public void testCreateIngredientID(){
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        potionService.createInvogiration(alumni, 1);
        Potion id = potionsRepo.findAll().get(0);
        ingredientService.createIngredientsID(id);

        List<Ingredient> test = checkSavingOfIngredient();
        assertNotNull(test);
        assertEquals(9, ingredientRepo.findAll().size());
        assertEquals(id, test.get(0).getPotion());
        assertEquals("Scurvy grass", test.get(7).getIngredient());
    }

    @Test
    public void testCreateIngredientWSP(){
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        potionService.createWitSharpeningPotion(alumni, 1);
        Potion wsp = potionsRepo.findAll().get(0);
        ingredientService.createIngredientsWSP(wsp);

        List<Ingredient> test = checkSavingOfIngredient();
        assertNotNull(test);
        assertEquals(4, ingredientRepo.findAll().size());
        assertEquals(wsp, test.get(0).getPotion());
        assertEquals("Ground scarab beetles", test.get(0).getIngredient());
    }
}
