package com.example.harrypotter;

import com.example.harrypotter.entity.options.Potion;
import com.example.harrypotter.entity.options.Spell;
import com.example.harrypotter.entity.wizards.*;
import com.example.harrypotter.repo.wizards.WizardRepo;
import com.example.harrypotter.service.zauberer.WizardService;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HarryPotterApplicationTests {


    @Autowired
    private WizardRepo wizardRepo;
    @Autowired
    private WizardService wizardService;

//    @Test
//    public void testCheckName(){
//        Dumbledore testWizard = new Dumbledore("TestWizard", BigDecimal.valueOf(99), "Powerful wizard");
//        Dumbledore testWizard2 = new Dumbledore("TestWizard2", BigDecimal.valueOf(1), "Test");
//        wizardRepo.save(testWizard);
//        assertTrue(wizardService.checkName(testWizard));
//        assertFalse(wizardService.checkName(testWizard2));
//    }

    @Test
    public void testAlumniConstructor() {
        Alumni test = new Alumni("TestA", BigDecimal.valueOf(1), "old");
        assertNotNull(test);
        assertEquals("TestA", test.getName());
        assertEquals(BigDecimal.valueOf(1), test.getHealthPoints());
        assertEquals("old", test.getDescription());
        assertEquals("Alumni", test.getKlasse());
        assertEquals(BigDecimal.valueOf(1.2), test.getFaktor());
        assertEquals(test.getHealthPoints(), test.getInternHealthPoints());
    }

    @Test
    public void testComments(){
        Alumni test = new Alumni("test", BigDecimal.valueOf(25), "Test");
        Comments comment = new Comments("Test", test);
        assertNotNull(comment);
//        assertNotNull(comment.getId());
        assertEquals("Test", comment.getContent());
        assertEquals(test, comment.getWizard());

    }

    @Test
    public void testConditions(){
        Alumni test = new Alumni("Test", BigDecimal.valueOf(25), "Test");
        Condition condition = new Condition(test, "testConditions");
        assertNotNull(condition);
        assertEquals(test, condition.getWizard());
        assertEquals("testConditions", condition.getName());
        assertFalse(condition.getCondition());
    }

    @Test
    public void testDeathEaterConstructor(){
        DeathEater test = new DeathEater("TestDe", BigDecimal.valueOf(2), "Evil");
        assertNotNull(test);
        assertEquals("TestDe", test.getName());
        assertEquals(BigDecimal.valueOf(2), test.getHealthPoints());
        assertEquals("Evil", test.getDescription());
        assertEquals("DeathEater", test.getKlasse());
        assertEquals(BigDecimal.valueOf(1.25), test.getFaktor());
        assertEquals(test.getHealthPoints(), test.getInternHealthPoints());
    }

    @Test
    public void testDumbledoreConstructor(){
        Dumbledore test = new Dumbledore("TestD", BigDecimal.valueOf(3), "Good");
        assertNotNull(test);
        assertEquals("TestD", test.getName());
        assertEquals(BigDecimal.valueOf(3), test.getHealthPoints());
        assertEquals("Good", test.getDescription());
        assertEquals("Dumbledore", test.getKlasse());
        assertEquals(BigDecimal.valueOf(2.0), test.getFaktor());
        assertEquals(test.getHealthPoints(), test.getInternHealthPoints());
    }

    @Test
    public void testWizard(){
        Dumbledore test = new Dumbledore("TestW", BigDecimal.valueOf(4), "Neutral");
        Condition condition = new Condition(test, "Bad");
        Spell spell = new Spell("testSpell", 1.0, 1.0, false, false, false, false, false, false, false, 1, test, "Amazing");
        Potion potion = new Potion("testPotion", 1, 1.0 , 0.35, false, false, false, false, 1.0, 1.0, 1, test, "Average");
        Comments comments = new Comments("test", test);
        StrengthAndWeakness saw = new StrengthAndWeakness("ALumni", false, test);

        assertNotNull(test);
        assertEquals("TestW", test.getName());
        assertEquals(BigDecimal.valueOf(4), test.getHealthPoints());
        assertEquals("Neutral", test.getDescription());
        assertEquals("Dumbledore", test.getKlasse());
        assertEquals(BigDecimal.valueOf(2.0), test.getFaktor());
        assertEquals(test.getHealthPoints(), test.getInternHealthPoints());
        assertEquals(BigDecimal.valueOf(25.0), test.getEnergy());
        assertEquals(test.getEnergy(), test.getInternEnergy());
        assertEquals(BigDecimal.valueOf(1.0), test.getAdditionalFactor());
        assertFalse(test.getHalfLife());
        assertEquals(0, test.getStunnedProtection());
        assertEquals(0, test.getConfundedProtection());
        assertFalse(test.getProtego());
        assertFalse(test.getFiendfyre());
        assertEquals(0, test.getPtCounter());
        assertEquals(0, test.getVictories());
        assertEquals(0, test.getAmount());
        assertEquals("Dursley", test.getRank());
        assertEquals(BigDecimal.valueOf(0.0), test.getRating());
//        //Test bei Service
//        assertNotNull(test.getConditions());
//        assertNotNull(test.getSpells());
//        assertNotNull(test.getPotions());
//        assertNotNull(test.getComments());
//        assertNotNull(test.getStrengthAndWeaknesses());
    }

    @Test
    public void testGryffindorConstructor(){
        Gryffindor test = new Gryffindor("TestG", BigDecimal.valueOf(5), "Brave");
        assertNotNull(test);
        assertEquals("TestG", test.getName());
        assertEquals(BigDecimal.valueOf(5), test.getHealthPoints());
        assertEquals("Brave", test.getDescription());
        assertEquals("Gryffindor", test.getKlasse());
        assertEquals(BigDecimal.valueOf(1.0), test.getFaktor());
        assertEquals(test.getHealthPoints(), test.getInternHealthPoints());
    }

    @Test
    public void testHeadmasterConstructor(){
        Headmaster test = new Headmaster("TestHm", BigDecimal.valueOf(6), "Leader");
        assertNotNull(test);
        assertEquals("TestHm", test.getName());
        assertEquals(BigDecimal.valueOf(6), test.getHealthPoints());
        assertEquals("Leader", test.getDescription());
        assertEquals("Headmaster", test.getKlasse());
        assertEquals(BigDecimal.valueOf(1.25), test.getFaktor());
        assertEquals(test.getHealthPoints(), test.getInternHealthPoints());
    }

    @Test
    public void testHufflepuffConstructor(){
        Hufflepuff test = new Hufflepuff("TestH", BigDecimal.valueOf(7), "Loyal");
        assertNotNull(test);
        assertEquals("TestH", test.getName());
        assertEquals(BigDecimal.valueOf(7), test.getHealthPoints());
        assertEquals("Loyal", test.getDescription());
        assertEquals("Hufflepuff", test.getKlasse());
        assertEquals(BigDecimal.valueOf(1.1), test.getFaktor());
        assertEquals(test.getHealthPoints(), test.getInternHealthPoints());
    }

    @Test
    public void testPotionsMasterConstructor(){
        PotionsMaster test = new PotionsMaster("TestPm", BigDecimal.valueOf(8), "Skilled");
        assertNotNull(test);
        assertEquals("TestPm", test.getName());
        assertEquals(BigDecimal.valueOf(8), test.getHealthPoints());
        assertEquals("Skilled", test.getDescription());
        assertEquals("Potions Master", test.getKlasse());
        assertEquals(BigDecimal.valueOf(1.25), test.getFaktor());
        assertEquals(test.getHealthPoints(), test.getInternHealthPoints());
    }

    @Test
    public void testProfessorConstructor(){
        Professor test = new Professor("TestP", BigDecimal.valueOf(9), "Boss");
        assertNotNull(test);
        assertEquals("TestP", test.getName());
        assertEquals(BigDecimal.valueOf(9), test.getHealthPoints());
        assertEquals("Boss", test.getDescription());
        assertEquals("Professor", test.getKlasse());
        assertEquals(BigDecimal.valueOf(1.25), test.getFaktor());
        assertEquals(test.getHealthPoints(), test.getInternHealthPoints());
    }

    @Test
    public void testRavenclawConstructor(){
        Ravenclaw test = new Ravenclaw("TestR", BigDecimal.valueOf(10), "Clever");
        assertNotNull(test);
        assertEquals("TestR", test.getName());
        assertEquals(BigDecimal.valueOf(10), test.getHealthPoints());
        assertEquals("Clever", test.getDescription());
        assertEquals("Ravenclaw", test.getKlasse());
        assertEquals(BigDecimal.valueOf(1.0), test.getFaktor());
        assertEquals(test.getHealthPoints(), test.getInternHealthPoints());
    }

    @Test
    public void testSlytherinConstructor(){
        Slytherin test = new Slytherin("TestS", BigDecimal.valueOf(11), "Ambitious");
        assertNotNull(test);
        assertEquals("TestS", test.getName());
        assertEquals(BigDecimal.valueOf(11), test.getHealthPoints());
        assertEquals("Ambitious", test.getDescription());
        assertEquals("Slytherin", test.getKlasse());
        assertEquals(BigDecimal.valueOf(1.0), test.getFaktor());
        assertEquals(test.getHealthPoints(), test.getInternHealthPoints());
    }

    @Test
    public void testVoldemortConstructor(){
        Voldemort test = new Voldemort("TestV", BigDecimal.valueOf(12), "Dark");
        assertNotNull(test);
        assertEquals("TestV", test.getName());
        assertEquals(BigDecimal.valueOf(12), test.getHealthPoints());
        assertEquals("Dark", test.getDescription());
        assertEquals("Voldemort", test.getKlasse());
        assertEquals(BigDecimal.valueOf(1.5), test.getFaktor());
        assertEquals(test.getHealthPoints(), test.getInternHealthPoints());
    }

    @Test
    public void testStrengthAndWeakness(){
        Alumni test = new Alumni("Test", BigDecimal.valueOf(25), "Test");
        StrengthAndWeakness saw = new StrengthAndWeakness("Hufflepuff", true, test);
        assertNotNull(saw);
        assertEquals("Hufflepuff", saw.getHouse());
        assertTrue(saw.getStrength());
        assertEquals(test, saw.getWizard());
    }

    @Test
    public void testOptions(){
        Dumbledore test = new Dumbledore("TestW", BigDecimal.valueOf(4), "Neutral");
        Spell spell = new Spell("testO", 1.0, 1.0, false, false, false, false, false, false, false, 1, test, "Strong");
        assertNotNull(spell);
        assertEquals("testO", spell.getName());
        assertEquals(BigDecimal.valueOf(1.0), spell.getEnergyUsage());
        assertEquals(BigDecimal.valueOf(1.0), spell.getMaxDamage());
        assertEquals("Strong", spell.getDescriptionOption());
        assertEquals(1, spell.getRequiredExperience());

    }

    @Test
    public void testSpell(){
        Dumbledore test = new Dumbledore("TestW", BigDecimal.valueOf(4), "Neutral");
        Spell spell = new Spell("testSpell", 2.0, 2.0, false, false, false, false, false, false, false, 2, test, "Powerful");
        assertNotNull(spell);
        assertEquals("testSpell", spell.getName());
        assertEquals(BigDecimal.valueOf(2.0), spell.getMaxDamage());
        assertEquals("Powerful", spell.getDescriptionOption());
        assertEquals(2, spell.getRequiredExperience());

        assertEquals(BigDecimal.valueOf(2.0), spell.getEnergyUsage());
        assertFalse(spell.getStunned());
        assertFalse(spell.getConfunded());
        assertFalse(spell.getImperio());
        assertFalse(spell.getCrucio());
        assertFalse(spell.getProtego());
        assertFalse(spell.getFiendfyre());
        assertFalse(spell.getAntiFiendfyre());
        assertEquals(test, spell.getWizard());

    }

    @Test
    public void testPotion(){
        Dumbledore test = new Dumbledore("TestW", BigDecimal.valueOf(4), "Neutral");
        Potion potion = new Potion("testPotion", 2, 0.5 , 0.3, false, false, false, false, 2.0, 1.5, 3, test, "Rare");

        assertNotNull(potion);
        assertEquals("testPotion", potion.getName());
        assertEquals(BigDecimal.valueOf(2.0), potion.getMaxDamage());
        assertEquals("Rare", potion.getDescriptionOption());
        assertEquals(3, potion.getRequiredExperience());

        assertEquals(2, potion.getStorage());
        assertEquals(BigDecimal.valueOf(0.5), potion.getHealing());
        assertEquals(BigDecimal.valueOf(0.3), potion.getEnergyRestorage());
        assertFalse(potion.getAntiParalysis());
        assertFalse(potion.getAntiConfunded());
        assertFalse(potion.getRegeneration());
        assertFalse(potion.getUnicornBlood());
        assertEquals(BigDecimal.valueOf(1.5), potion.getAdditionalFactor());
        assertEquals(test, potion.getWizard());

    }


















}
