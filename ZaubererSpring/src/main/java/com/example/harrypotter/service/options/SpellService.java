package com.example.harrypotter.service.options;

import com.example.harrypotter.entity.options.Spell;
import com.example.harrypotter.entity.magicalbeings.MagicalBeing;
import com.example.harrypotter.repo.options.OptionsRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SpellService {

    private OptionsRepo optionsRepo;

    //Attacks
    public void createExpelliarmus(MagicalBeing magicalBeing) {
        optionsRepo.save(new Spell(
                "Expelliarmus",
                5.0,
                10.0,
                0.0,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                0,
                magicalBeing,
                "Forces whatever an opponent is holding to fly out of their hand. " +
                        "It was considered to be Harry Potter's signature spell."));
    }

    public void createStupefy(MagicalBeing magicalBeing) {
        optionsRepo.save(new Spell(
                "Stupefy",
                7.0,
                2.0,
                0.0,
                true,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                5,
                magicalBeing,
                "Stuns the target, rendering them unconscious."
        ));
    }

    public void createLevicorpus(MagicalBeing magicalBeing) {
        optionsRepo.save(new Spell(
                "Levicorpus",
                3.5,
                5.0,
                0.0,
                false,
                true,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                0,
                magicalBeing,
                "Hoists people up into the air by their ankle. Created by Severus Snape."));
    }

    public void createCalvorio(MagicalBeing magicalBeing) {
        optionsRepo.save(new Spell(
                "Calvorio",
                1.0,
                3.0,
                0.0,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                0,
                magicalBeing,
                "Removes the victim's hair."));
    }

    public void createImmobilus(MagicalBeing magicalBeing) {
        optionsRepo.save(new Spell(
                "Immobilus",
                3.0,
                0.0,
                0.0,
                true,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                0,
                magicalBeing,
                "Immobilises and stops the actions of the target. " +
                        "It works both on living and inanimate things."));
    }

    public void createSectumssempra(MagicalBeing magicalBeing) {
        optionsRepo.save(new Spell(
                "Sectumssempra",
                10.0,
                17.5,
                0.0,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                10,
                magicalBeing,
                "Lacerates the target, as if they have been \"slashed by a sword.\" " +
                        "Subsequently, the target can easily bleed to death from the wounds. " +
                        "This curse was invented by Severus Snape, to be used against his personal enemies."));
    }

    public void createConfundo(MagicalBeing magicalBeing) {
        optionsRepo.save(new Spell(
                "Confundo",
                2.5,
                1.0,
                0.0,
                false,
                true,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                3,
                magicalBeing,
                "Causes the victim to become confused and befuddled."));
    }

    public void createAvadaKedavra(MagicalBeing magicalBeing) {
        optionsRepo.save(new Spell(
                "Avada Kedavra",
                25.0,
                40.0,
                0.0,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                25,
                magicalBeing,
                "Causes instantaneous death. It is accompanied by a flash of green light and a rushing noise. " +
                        "There is no known Counter-curse that can protect the victim from dying, " +
                        "except for a loving sacrifice. It is one of the three Unforgivable Curses."));
    }

    public void createImperio(MagicalBeing magicalBeing) {
        optionsRepo.save(new Spell(
                "Imperio",
                15.0,
                5.0,
                0.0,
                false,
                true,
                true,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                15,
                magicalBeing,
                "Places the victim completely under the caster's control and it " +
                        "becomes very suggestible to the commands of the caster. " +
                        "However, those who are strong willed may learn to resist it. " +
                        "One of the three Unforgivable Curses."));
    }

    public void createCrucio(MagicalBeing magicalBeing) {
        optionsRepo.save(new Spell(
                "Crucio",
                15.0,
                25.0,
                0.0,
                false,
                true,
                false,
                true,
                false,
                false,
                false,
                false,
                false,
                false,
                20,
                magicalBeing,
                "Inflicts intense pain on the recipient of the curse. " +
                        "It cannot be cast successfully by a person who is doing so out of pure spite or anger; " +
                        "one must feel a true desire to cause the victim pain."));
    }

    public void createProtego(MagicalBeing magicalBeing) {
        optionsRepo.save(new Spell(
                "Protego",
                10.0,
                0.0,
                0.0,
                false,
                false,
                false,
                false,
                true,
                false,
                false,
                false,
                false,
                false,
                5,
                magicalBeing,
                "Invisible shield that reflects spells and blocks physical entities."));
    }

    public void createFiendfyre(MagicalBeing magicalBeing) {
        optionsRepo.save(new Spell(
                "Fiendfyre",
                20.0,
                50.0,
                0.0,
                false,
                false,
                false,
                false,
                false,
                true,
                false,
                false,
                false,
                false,
                20,
                magicalBeing,
                "Unleashes cursed fire that actively seek out " +
                        "living targets and burn anything in its path. " +
                        "In addition, this fire is made even more dangerous due to the fact " +
                        "that it is extremely difficult to control."));
    }

    public void createAntiFiendfyre(MagicalBeing magicalBeing) {
        optionsRepo.save(new Spell(
                "Anti Fiendfyre",
                10.0,
                0.0,
                0.0,
                false,
                false,
                false,
                false,
                false,
                false,
                true,
                false,
                false,
                false,
                25,
                magicalBeing,
                "Only possibility to end the Fiendfyre. " +
                        "If not used immediately after casting the Fiendfyre, the casting magicalBeing will be killed by it."));
    }

    public void createFirestorm(MagicalBeing magicalBeing) {
        optionsRepo.save(new Spell(
                "Firestorm",
                15.0,
                27.5,
                0.0,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                15,
                magicalBeing,
                "Produces a ring of fire from the wand."
        ));
    }

    public void createPiertotumLocomotor(MagicalBeing magicalBeing) {
        optionsRepo.save(new Spell(
                "Piertotum Locomotor",
                10.0,
                20.0,
                0.0,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                true,
                15,
                magicalBeing,
                "Brings animates inanimate targets"
        ));
    }

    public void createVulneraSanentur(MagicalBeing magicalBeing) {
        optionsRepo.save(new Spell(
                "Vulnera Sanentur",
                15.0,
                0.0,
                0.8,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                15,
                magicalBeing,
                "Healing spell that slows blood flow, clears residue, and knits wounds. It is the counter-curse to Sectumsempra."

        ));
    }

    public void createPertrificusTotalus(MagicalBeing magicalBeing) {
        optionsRepo.save(new Spell(
                "Pertrificus Totalus",
                5.0,
                1.0,
                0.0,
                true,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                1,
                magicalBeing,
                "Used to temporarily bind the victim's body in a position much like that of a soldier at attention; the victim will usually fall to the ground."
        ));
    }

    public void createEpiskey(MagicalBeing magicalBeing) {
        optionsRepo.save(new Spell(
                "Episkey",
                5.0,
                0.0,
                0.1,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                1,
                magicalBeing,
                "In 1996, Nymphadora Tonks used this spell to fix Harry's broken nose after Draco Malfoy broke it on the Hogwarts Express."

        ));
    }
}
