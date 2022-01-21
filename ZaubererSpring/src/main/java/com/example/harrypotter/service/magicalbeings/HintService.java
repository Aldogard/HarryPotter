package com.example.harrypotter.service.magicalbeings;

import com.example.harrypotter.entity.magicalbeings.Hint;
import com.example.harrypotter.entity.magicalbeings.MagicalBeing;
import com.example.harrypotter.repo.magicalbeings.HintRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HintService {
    private HintRepo hintRepo;

    public void createDontMoveThisPiece(MagicalBeing magicalBeing){
        hintRepo.save(new Hint(
           "If I were you, I would move a different piece",
           false,
           false,
           false,
           magicalBeing
        ));
    }

    public void createBetterAskRon(MagicalBeing magicalBeing){
        hintRepo.save(new Hint(
                "You better ask Ron for help, your position is a catastrophe",
                false,
                true,
                false,
                magicalBeing
        ));
    }

    public void createShouldHaveUsed(MagicalBeing magicalBeing){
        hintRepo.save(new Hint(
                "You should have used this piece three moves ago",
                false,
                false,
                false,
                magicalBeing
        ));
    }

    public void createTooPassive(MagicalBeing magicalBeing){
        hintRepo.save(new Hint(
                "You are playing to passive right now",
                false,
                false,
                false,
                magicalBeing
        ));
    }

    public void createTimeToAttack(MagicalBeing magicalBeing){
        hintRepo.save(new Hint(
                "I think you should start an attack right now",
                false,
                false,
                false,
                magicalBeing
        ));
    }

    public void createSacrifice(MagicalBeing magicalBeing){
        hintRepo.save(new Hint(
                "Maybe you have to sacrifice a piece or two",
                false,
                false,
                false,
                magicalBeing
        ));
    }

    public void createPushem(MagicalBeing magicalBeing){
        hintRepo.save(new Hint(
                "What do we do with passed pawns? Push'em baby",
                false,
                false,
                false,
                magicalBeing
        ));
    }

    public void createJustAsSane(MagicalBeing magicalBeing){
        hintRepo.save(new Hint(
                "You're just as sane as I am",
                false,
                false,
                true,
                magicalBeing
        ));
    }

    public void createBasicHints(MagicalBeing magicalBeing){
        createDontMoveThisPiece(magicalBeing);
        createBetterAskRon(magicalBeing);
        createShouldHaveUsed(magicalBeing);
        createTooPassive(magicalBeing);
        createTimeToAttack(magicalBeing);
        createSacrifice(magicalBeing);
        createPushem(magicalBeing);
        createJustAsSane(magicalBeing);
    }

    public void createNotARavenclaw(MagicalBeing magicalBeing){
        hintRepo.save(new Hint(
                "That is not a very clever idea, I am not surprised you aren't a Ravenclaw",
                true,
                false,
                false,
                magicalBeing
        ));
    }

    public void createDecision(MagicalBeing magicalBeing) {
        hintRepo.save(new Hint(
                "You must choose between what is easy and what is right",
                false,
                false,
                false,
                magicalBeing
        ));
    }

    public void createChoices(MagicalBeing magicalBeing) {
        hintRepo.save(new Hint(
                "It is our choices, that show what we truly are, far more than our abilities",
                false,
                false,
                false,
                magicalBeing
        ));
    }

    public void createUnknown(MagicalBeing magicalBeing) {
        hintRepo.save(new Hint(
                "It is the unknown we fear when we look upon a Tal move, nothing more",
                false,
                false,
                false,
                magicalBeing
        ));
    }

    public void createTwoTypes(MagicalBeing magicalBeing) {
        hintRepo.save(new Hint(
                "There are two types of moves: correct ones, and the one you are about to do",
                false,
                false,
                false,
                magicalBeing
        ));
    }

    public void createPureblood(MagicalBeing magicalBeing){
        hintRepo.save(new Hint(
                "Are these pawns even purebloods?",
                false,
                false,
                false,
                magicalBeing
        ));
    }

    public void createKnockOutKing(MagicalBeing magicalBeing){
        hintRepo.save(new Hint(
                "There are some things you can't share without ending up liking each other, " +
                        "and knocking out the opposite king is one of them.",
                false,
                false,
                false,
                magicalBeing
        ));
    }

    public void createLikeWizardChess(MagicalBeing magicalBeing){
        hintRepo.save(new Hint(
                "You don't suppose this is going to be like real wizard chess, do you? " +
                        "It is going to be exactly like wizard chess",
                false,
                false,
                false,
                magicalBeing

        ));
    }

    public void createFriendshipAndBravery(MagicalBeing magicalBeing){
        hintRepo.save(new Hint(
                "Friendship! And Bravery! There are more important things - material and positional advantage",
                false,
                false,
                false,
                magicalBeing
                ));
    }

    public void createTimeIsGalleons(MagicalBeing magicalBeing){
        hintRepo.save(new Hint(
                "Tempo is Galleons",
                false,
                false,
                false,
                magicalBeing
        ));
    }

    public void createKeepingABishop(MagicalBeing magicalBeing){
        hintRepo.save(new Hint(
                "There are things more important than keeping a bishop",
                false,
                false,
                false,
                magicalBeing
        ));
    }

    public void createQueenSacrifice(MagicalBeing magicalBeing){
        hintRepo.save(new Hint(
                "The queen sacrifice. It is a beautiful and terrible thing, " +
                        "and should therefore treated with great caution",
                false,
                false,
                false,
                magicalBeing
        ));
    }

    public void createPawnPush(MagicalBeing magicalBeing){
        hintRepo.save(new Hint(
                "Pawn pushes are not a sin. But we should exercise caution with our pawn pushes",
                false,
                false,
                false,
                magicalBeing
        ));
    }

    public void createBlunderingPieces(MagicalBeing magicalBeing){
        hintRepo.save(new Hint(
                "Blundering pieces like this proves you are still a man! Blundering is part of being human",
                false,
                false,
                false,
                magicalBeing
        ));
    }

    public void createQueensCanBeFound(MagicalBeing magicalBeing){
        hintRepo.save(new Hint(
                "Queens can be found even in the darkest of times, if one remembers to push past pawns",
                false,
                false,
                false,
                magicalBeing
        ));
    }

    public void createDwellOnTactics(MagicalBeing magicalBeing){
        hintRepo.save(new Hint(
                "It does not do well to dwell on tactics and forget to move a piece",
                false,
                false,
                false,
                magicalBeing
        ));
    }

    public void createSendToAzkaban(MagicalBeing magicalBeing){
        hintRepo.save(new Hint(
                "We don’t send wizards to Azkaban just for blundering a knight",
                false,
                false,
                false,
                magicalBeing
        ));
    }

    public void createInaccuraciesAndMistakes(MagicalBeing magicalBeing){
        hintRepo.save(new Hint(
                "Inaccuracies and mistakes often do much more damage than outright blunders",
                false,
                false,
                false,
                magicalBeing
        ));
    }

    public void createEveryPawn(MagicalBeing magicalBeing){
        hintRepo.save(new Hint(
                "Every pawn is worth the same, and worth saving.",
                false,
                false,
                false,
                magicalBeing
        ));
    }

    public void createNotAGoodSign(MagicalBeing magicalBeing){
        hintRepo.save(new Hint(
                "Blundering pieces no one else would blunder isn’t a good sign, even in the wizarding world.",
                false,
                false,
                false,
                magicalBeing
        ));
    }


































}
