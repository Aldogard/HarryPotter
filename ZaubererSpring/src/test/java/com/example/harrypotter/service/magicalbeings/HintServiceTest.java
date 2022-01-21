package com.example.harrypotter.service.magicalbeings;

import com.example.harrypotter.entity.magicalbeings.Hint;
import com.example.harrypotter.entity.magicalbeings.wizards.Alumni;
import com.example.harrypotter.repo.magicalbeings.HintRepo;
import com.example.harrypotter.repo.magicalbeings.MagicalBeingRepo;
import com.example.harrypotter.service.options.UtilOptions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class HintServiceTest {
    @Autowired
    private HintRepo hintRepo;

    @Autowired
    private MagicalBeingRepo magicalBeingRepo;

    @Autowired
    private HintService hintService;


    @AfterEach
    public void deleteAll(){
        magicalBeingRepo.deleteAll();
        hintRepo.deleteAll();
    }

    private Alumni createAndSaveAlumni(){
        Alumni alumni = UtilOptions.createTesti();
        magicalBeingRepo.save(alumni);
        return alumni;
    }

    private Hint checkSavingOfHint(){
        assertNotNull(hintRepo.findAll());
        assertEquals(1, hintRepo.findAll().size());
        return hintRepo.findAll().get(0);
    }

    @Test
    public void testCreateDontMoveThisPiece(){
        Alumni test = createAndSaveAlumni();
        hintService.createDontMoveThisPiece(test);

        Hint hint = checkSavingOfHint();
        assertEquals("If I were you, I would move a different piece", hint.getContent());
        assertFalse(hint.getRavenclaw());
        assertFalse(hint.getRon());
        assertFalse(hint.getLuna());
        assertEquals(test, hint.getMagicalBeing());
    }

    @Test
    public void testCreateBetterAskRon(){
        Alumni test = createAndSaveAlumni();
        hintService.createBetterAskRon(test);

        Hint hint = checkSavingOfHint();
        assertEquals("You better ask Ron for help, your position is a catastrophe", hint.getContent());
        assertFalse(hint.getRavenclaw());
        assertTrue(hint.getRon());
        assertFalse(hint.getLuna());
        assertEquals(test, hint.getMagicalBeing());
    }

    @Test
    public void testCreateShouldHaveUsed(){
        Alumni test = createAndSaveAlumni();
        hintService.createShouldHaveUsed(test);

        Hint hint = checkSavingOfHint();
        assertEquals("You should have used this piece three moves ago", hint.getContent());
        assertFalse(hint.getRavenclaw());
        assertFalse(hint.getRon());
        assertFalse(hint.getLuna());
        assertEquals(test, hint.getMagicalBeing());
    }

    @Test
    public void testCreateTooPassive(){
        Alumni test = createAndSaveAlumni();
        hintService.createTooPassive(test);

        Hint hint = checkSavingOfHint();
        assertEquals("You are playing to passive right now", hint.getContent());
        assertFalse(hint.getRavenclaw());
        assertFalse(hint.getRon());
        assertFalse(hint.getLuna());
        assertEquals(test, hint.getMagicalBeing());
    }

    @Test
    public void testCreateTimeToAttack(){
        Alumni test = createAndSaveAlumni();
        hintService.createTimeToAttack(test);

        Hint hint = checkSavingOfHint();
        assertEquals("I think you should start an attack right now", hint.getContent());
        assertFalse(hint.getRavenclaw());
        assertFalse(hint.getRon());
        assertFalse(hint.getLuna());
        assertEquals(test, hint.getMagicalBeing());
    }

    @Test
    public void testCreateSacrifice(){
        Alumni test = createAndSaveAlumni();
        hintService.createSacrifice(test);

        Hint hint = checkSavingOfHint();
        assertEquals("Maybe you have to sacrifice a piece or two", hint.getContent());
        assertFalse(hint.getRavenclaw());
        assertFalse(hint.getRon());
        assertFalse(hint.getLuna());
        assertEquals(test, hint.getMagicalBeing());
    }

    @Test
    public void testCreatePushem(){
        Alumni test = createAndSaveAlumni();
        hintService.createPushem(test);

        Hint hint = checkSavingOfHint();
        assertEquals("What do we do with passed pawns? Push'em baby", hint.getContent());
        assertFalse(hint.getRavenclaw());
        assertFalse(hint.getRon());
        assertFalse(hint.getLuna());
        assertEquals(test, hint.getMagicalBeing());
    }

    @Test
    public void testCreateJustAsSane(){
        Alumni test = createAndSaveAlumni();
        hintService.createJustAsSane(test);

        Hint hint = checkSavingOfHint();
        assertEquals("You're just as sane as I am", hint.getContent());
        assertFalse(hint.getRavenclaw());
        assertFalse(hint.getRon());
        assertTrue(hint.getLuna());
        assertEquals(test, hint.getMagicalBeing());
    }

    @Test
    public void testCreateBasicHints(){
        Alumni test = createAndSaveAlumni();
        hintService.createBasicHints(test);

        assertEquals(8, hintRepo.findAll().size());
        assertEquals("If I were you, I would move a different piece", hintRepo.findAll().get(0).getContent());
        assertEquals("You better ask Ron for help, your position is a catastrophe", hintRepo.findAll().get(1).getContent());
        assertEquals("You should have used this piece three moves ago", hintRepo.findAll().get(2).getContent());
        assertEquals("You are playing to passive right now", hintRepo.findAll().get(3).getContent());
        assertEquals("I think you should start an attack right now", hintRepo.findAll().get(4).getContent());
        assertEquals("Maybe you have to sacrifice a piece or two", hintRepo.findAll().get(5).getContent());
        assertEquals("What do we do with passed pawns? Push'em baby", hintRepo.findAll().get(6).getContent());
        assertEquals("You're just as sane as I am", hintRepo.findAll().get(7).getContent());
    }

    @Test
    public void testCreateNotARavenclaw(){
        Alumni test = createAndSaveAlumni();
        hintService.createNotARavenclaw(test);

        Hint hint = checkSavingOfHint();
        assertEquals("That is not a very clever idea, " +
                "I am not surprised you aren't a Ravenclaw", hint.getContent());
        assertTrue(hint.getRavenclaw());
        assertFalse(hint.getRon());
        assertFalse(hint.getLuna());
        assertEquals(test, hint.getMagicalBeing());
    }

    @Test
    public void testCreateDecision(){
        Alumni test = createAndSaveAlumni();
        hintService.createDecision(test);

        Hint hint = checkSavingOfHint();
        assertEquals("You must choose between what is easy and what is right", hint.getContent());
        assertFalse(hint.getRavenclaw());
        assertFalse(hint.getRon());
        assertFalse(hint.getLuna());
        assertEquals(test, hint.getMagicalBeing());
    }

    @Test
    public void testCreateChoices(){
        Alumni test = createAndSaveAlumni();
        hintService.createChoices(test);

        Hint hint = checkSavingOfHint();
        assertEquals("It is our choices, that show what we truly are, " +
                "far more than our abilities", hint.getContent());
        assertFalse(hint.getRavenclaw());
        assertFalse(hint.getRon());
        assertFalse(hint.getLuna());
        assertEquals(test, hint.getMagicalBeing());
    }

    @Test
    public void testCreateUnknown(){
        Alumni test = createAndSaveAlumni();
        hintService.createUnknown(test);

        Hint hint = checkSavingOfHint();
        assertEquals("It is the unknown we fear when we look upon a Tal move, nothing more", hint.getContent());
        assertFalse(hint.getRavenclaw());
        assertFalse(hint.getRon());
        assertFalse(hint.getLuna());
        assertEquals(test, hint.getMagicalBeing());
    }

    @Test
    public void testCreateTwoTypes(){
        Alumni test = createAndSaveAlumni();
        hintService.createTwoTypes(test);

        Hint hint = checkSavingOfHint();
        assertEquals("There are two types of moves: correct ones, " +
                "and the one you are about to do", hint.getContent());
        assertFalse(hint.getRavenclaw());
        assertFalse(hint.getRon());
        assertFalse(hint.getLuna());
        assertEquals(test, hint.getMagicalBeing());
    }

    @Test
    public void testCreatePureblood(){
        Alumni test = createAndSaveAlumni();
        hintService.createPureblood(test);

        Hint hint = checkSavingOfHint();
        assertEquals("Are these pawns even purebloods?", hint.getContent());
        assertFalse(hint.getRavenclaw());
        assertFalse(hint.getRon());
        assertFalse(hint.getLuna());
        assertEquals(test, hint.getMagicalBeing());
    }

    @Test
    public void testCreateKnockOutKing(){
        Alumni test = createAndSaveAlumni();
        hintService.createKnockOutKing(test);

        Hint hint = checkSavingOfHint();
        assertEquals("There are some things you can't share without ending up liking each other, " +
                "and knocking out the opposite king is one of them.", hint.getContent());
        assertFalse(hint.getRavenclaw());
        assertFalse(hint.getRon());
        assertFalse(hint.getLuna());
        assertEquals(test, hint.getMagicalBeing());
    }

    @Test
    public void testCreateLikeWizardChess(){
        Alumni test = createAndSaveAlumni();
        hintService.createLikeWizardChess(test);

        Hint hint = checkSavingOfHint();
        assertEquals("You don't suppose this is going to be like real wizard chess, do you? " +
                "It is going to be exactly like wizard chess", hint.getContent());
        assertFalse(hint.getRavenclaw());
        assertFalse(hint.getRon());
        assertFalse(hint.getLuna());
        assertEquals(test, hint.getMagicalBeing());
    }

    @Test
    public void testCreateFriendshipAndBravery(){
        Alumni test = createAndSaveAlumni();
        hintService.createFriendshipAndBravery(test);

        Hint hint = checkSavingOfHint();
        assertEquals("Friendship! And Bravery! There are more important things - " +
                "material and positional advantage", hint.getContent());
        assertFalse(hint.getRavenclaw());
        assertFalse(hint.getRon());
        assertFalse(hint.getLuna());
        assertEquals(test, hint.getMagicalBeing());
    }

    @Test
    public void testCreateTimeIsGalleons(){
        Alumni test = createAndSaveAlumni();
        hintService.createTimeIsGalleons(test);

        Hint hint = checkSavingOfHint();
        assertEquals("Tempo is Galleons", hint.getContent());
        assertFalse(hint.getRavenclaw());
        assertFalse(hint.getRon());
        assertFalse(hint.getLuna());
        assertEquals(test, hint.getMagicalBeing());
    }

    @Test
    public void testCreateKeepingABishop(){
        Alumni test = createAndSaveAlumni();
        hintService.createKeepingABishop(test);

        Hint hint = checkSavingOfHint();
        assertEquals("There are things more important than keeping a bishop", hint.getContent());
        assertFalse(hint.getRavenclaw());
        assertFalse(hint.getRon());
        assertFalse(hint.getLuna());
        assertEquals(test, hint.getMagicalBeing());
    }

    @Test
    public void testCreateQueenSacrifice(){
        Alumni test = createAndSaveAlumni();
        hintService.createQueenSacrifice(test);

        Hint hint = checkSavingOfHint();
        assertEquals("The queen sacrifice. It is a beautiful and terrible thing, " +
                "and should therefore treated with great caution", hint.getContent());
        assertFalse(hint.getRavenclaw());
        assertFalse(hint.getRon());
        assertFalse(hint.getLuna());
        assertEquals(test, hint.getMagicalBeing());
    }

    @Test
    public void testCreatePawnPush(){
        Alumni test = createAndSaveAlumni();
        hintService.createPawnPush(test);

        Hint hint = checkSavingOfHint();
        assertEquals("Pawn pushes are not a sin. But we should exercise " +
                "caution with our pawn pushes", hint.getContent());
        assertFalse(hint.getRavenclaw());
        assertFalse(hint.getRon());
        assertFalse(hint.getLuna());
        assertEquals(test, hint.getMagicalBeing());
    }

    @Test
    public void testCreateBlunderingPieces(){
        Alumni test = createAndSaveAlumni();
        hintService.createBlunderingPieces(test);

        Hint hint = checkSavingOfHint();
        assertEquals("Blundering pieces like this proves you are still a man! " +
                "Blundering is part of being human", hint.getContent());
        assertFalse(hint.getRavenclaw());
        assertFalse(hint.getRon());
        assertFalse(hint.getLuna());
        assertEquals(test, hint.getMagicalBeing());
    }

    @Test
    public void testCreateQueensCanBeFound(){
        Alumni test = createAndSaveAlumni();
        hintService.createQueensCanBeFound(test);

        Hint hint = checkSavingOfHint();
        assertEquals("Queens can be found even in the darkest of times, " +
                "if one remembers to push past pawns", hint.getContent());
        assertFalse(hint.getRavenclaw());
        assertFalse(hint.getRon());
        assertFalse(hint.getLuna());
        assertEquals(test, hint.getMagicalBeing());
    }

    @Test
    public void testCreateDwellOnTactics(){
        Alumni test = createAndSaveAlumni();
        hintService.createDwellOnTactics(test);

        Hint hint = checkSavingOfHint();
        assertEquals("It does not do well to dwell on tactics and forget to move a piece", hint.getContent());
        assertFalse(hint.getRavenclaw());
        assertFalse(hint.getRon());
        assertFalse(hint.getLuna());
        assertEquals(test, hint.getMagicalBeing());
    }

    @Test
    public void testCreateSendToAzkaban(){
        Alumni test = createAndSaveAlumni();
        hintService.createSendToAzkaban(test);

        Hint hint = checkSavingOfHint();
        assertEquals("We don’t send wizards to Azkaban just for blundering a knight", hint.getContent());
        assertFalse(hint.getRavenclaw());
        assertFalse(hint.getRon());
        assertFalse(hint.getLuna());
        assertEquals(test, hint.getMagicalBeing());
    }

    @Test
    public void testCreateInaccuraciesAndMistakes(){
        Alumni test = createAndSaveAlumni();
        hintService.createInaccuraciesAndMistakes(test);

        Hint hint = checkSavingOfHint();
        assertEquals("Inaccuracies and mistakes often do much more damage " +
                "than outright blunders", hint.getContent());
        assertFalse(hint.getRavenclaw());
        assertFalse(hint.getRon());
        assertFalse(hint.getLuna());
        assertEquals(test, hint.getMagicalBeing());
    }

    @Test
    public void testCreateEveryPawn(){
        Alumni test = createAndSaveAlumni();
        hintService.createEveryPawn(test);

        Hint hint = checkSavingOfHint();
        assertEquals("Every pawn is worth the same, and worth saving.", hint.getContent());
        assertFalse(hint.getRavenclaw());
        assertFalse(hint.getRon());
        assertFalse(hint.getLuna());
        assertEquals(test, hint.getMagicalBeing());
    }

    @Test
    public void testCreateNotAGoodSign(){
        Alumni test = createAndSaveAlumni();
        hintService.createNotAGoodSign(test);

        Hint hint = checkSavingOfHint();
        assertEquals("Blundering pieces no one else would blunder isn’t a good sign, " +
                "even in the wizarding world.", hint.getContent());
        assertFalse(hint.getRavenclaw());
        assertFalse(hint.getRon());
        assertFalse(hint.getLuna());
        assertEquals(test, hint.getMagicalBeing());
    }











}
