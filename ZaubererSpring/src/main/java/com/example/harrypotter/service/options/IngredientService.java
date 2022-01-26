package com.example.harrypotter.service.options;

import com.example.harrypotter.entity.options.Ingredient;
import com.example.harrypotter.entity.options.Potion;
import com.example.harrypotter.repo.options.IngredientRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class IngredientService {
    private IngredientRepo ingredientRepo;

    public void createIngredientsBBE(Potion potion){
        Ingredient leapingToadstool = new Ingredient("Leaping toadstool", potion);
        ingredientRepo.save(leapingToadstool);

        Ingredient frogBrains = new Ingredient("Frog brains", potion);
        ingredientRepo.save(frogBrains);

        Ingredient runespoorEggs = new Ingredient("Runespoor eggs", potion);
        ingredientRepo.save(runespoorEggs);

        Ingredient powderedDragonClaw = new Ingredient("Powdered dragon claw", potion);
        ingredientRepo.save(powderedDragonClaw);
    }

    public void createIngredientsEP(Potion potion){
        Ingredient icePop = new Ingredient("Ice pop", potion);
        ingredientRepo.save(icePop);

        Ingredient redSpider = new Ingredient("Red spider", potion);
        ingredientRepo.save(redSpider);

        Ingredient flowers = new Ingredient("Flowers", potion);
        ingredientRepo.save(flowers);
    }

    public void createIngredientsHP(Potion potion){
        Ingredient wormwood = new Ingredient("Wormwood", potion);
        ingredientRepo.save(wormwood);

        Ingredient butotuberPus = new Ingredient("Bobutuber pus", potion);
        ingredientRepo.save(butotuberPus);

        Ingredient dittany = new Ingredient("Dittany", potion);
        ingredientRepo.save(dittany);

        Ingredient dragonLiver = new Ingredient("Dragon liver", potion);
        ingredientRepo.save(dragonLiver);
    }

    public void createIngredientsID(Potion potion){
        Ingredient alihotsyLeaves = new Ingredient("Alihotsy leaves", potion);
        ingredientRepo.save(alihotsyLeaves);

        Ingredient driedBillywigStings = new Ingredient("Dried billywig stings", potion);
        ingredientRepo.save(driedBillywigStings);

        Ingredient peppermint = new Ingredient("Peppermint", potion);
        ingredientRepo.save(peppermint);

        Ingredient stewedMandrake = new Ingredient("Stewed mandrake", potion);
        ingredientRepo.save(stewedMandrake);

        Ingredient infusionOfWormwood = new Ingredient("Infusion of wormwood", potion);
        ingredientRepo.save(infusionOfWormwood);

        Ingredient honeywater = new Ingredient("Honeywater", potion);
        ingredientRepo.save(honeywater);

        Ingredient vervainInfusion = new Ingredient("Vervain infusion", potion);
        ingredientRepo.save(vervainInfusion);

        Ingredient scurvyGrass = new Ingredient("Scurvy grass", potion);
        ingredientRepo.save(scurvyGrass);

        Ingredient lovage = new Ingredient("Lovage", potion);
        ingredientRepo.save(lovage);

    }

    public void createIngredientsWSP(Potion potion){
        Ingredient groundScarabBeetles = new Ingredient("Ground scarab beetles", potion);
        ingredientRepo.save(groundScarabBeetles);

        Ingredient cutGingerRoots = new Ingredient("Cut ginger roots", potion);
        ingredientRepo.save(cutGingerRoots);

        Ingredient armandilloBile = new Ingredient("Armandillo bile", potion);
        ingredientRepo.save(armandilloBile);

        Ingredient newtSpleens = new Ingredient("Newt spleens", potion);
        ingredientRepo.save(newtSpleens);
    }
}
