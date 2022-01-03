package com.example.harrypotter.controller;

import com.example.harrypotter.entity.wizards.*;
import com.example.harrypotter.repo.options.OptionsRepo;
import com.example.harrypotter.repo.wizards.ConditionRepo;
import com.example.harrypotter.repo.wizards.WizardRepo;
import com.example.harrypotter.service.wizards.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Data
@RestController
@RequestMapping("/wizard")
@AllArgsConstructor
public class WizardController {


    private WizardRepo wizardRepo;
    private ConditionRepo conditionRepo;
    private OptionsRepo optionsRepo;
    private WizardService wizardService;
    private HeadmasterService headmasterService;
    private VoldemortService voldemortService;
    private HufflepuffService hufflepuffService;
    private SlytherinService slytherinService;
    private RavenclawService ravenclawService;
    private GryffindorService gryffindorService;
    private DeathEaterService deathEaterService;
    private AlumniService alumniService;
    private ProfessorService professorService;
    private DumbledoreService dumbledoreService;
    private PotionsMasterService potionsMasterService;


    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<Wizard>> getAll(@RequestParam(required = false) String name, @RequestParam(required = false) String klasse) {
        return wizardService.getAllWizards(name, klasse);
    }


    @GetMapping("/hp")
    @ResponseBody
    public ResponseEntity<List<Wizard>> getAllByHealthPoints(@RequestParam(required = false) Double min, @RequestParam(required = false) Double max) {
        return wizardService.getAllWizardsHp(min, max);
    }

    @GetMapping("/victory")
    @ResponseBody
    public ResponseEntity<List<Wizard>> getAllByVictory(@RequestParam(required = false) Integer victories) {
        return wizardService.getAllWizardsVictories(victories);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Wizard> getWizardById(@PathVariable Integer id) {
        return wizardService.getWizardById(id);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Wizard> getWizardByName(@PathVariable String name) {
        for (Wizard zauberer : wizardRepo.findAll()) {
            if (zauberer.getName().equals(name)) {
                return new ResponseEntity<>(wizardRepo.findById(zauberer.getId()).orElse(null), HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/voldemort")
    public ResponseEntity<Wizard> getVoldemort(){
        return wizardService.getVoldemort("Voldemort");
    }


    @PostMapping("/headmaster")
    public ResponseEntity<Wizard> createHeadmaster(@RequestBody @Validated Headmaster headmaster) {
        return headmasterService.createHeadmaster(headmaster);
    }

    @PostMapping("/voldemort")
    public ResponseEntity<Wizard> createVoldemort(@RequestBody @Validated Voldemort voldemort) {
       return voldemortService.createVoldemort(voldemort);
    }

    @PostMapping("/hufflepuff")
    public ResponseEntity<Wizard> createHufflepuff(@RequestBody @Validated Hufflepuff hufflepuff) {
        return hufflepuffService.createHufflepuff(hufflepuff);
    }

    @PostMapping("/slytherin")
    public ResponseEntity<Wizard> createSlytherin(@RequestBody @Validated Slytherin slytherin) {
        return slytherinService.createSlytherin(slytherin);
    }

    @PostMapping("/ravenclaw")
    public ResponseEntity<Wizard> createRavenclaw(@RequestBody @Validated Ravenclaw ravenclaw) {
        return ravenclawService.createRavenclaw(ravenclaw);
    }

    @PostMapping("/gryffindor")
    public ResponseEntity<Wizard> createGryffindor(@RequestBody @Validated Gryffindor gryffindor) {
        return gryffindorService.createGryffindor(gryffindor);
    }

    @PostMapping("/deatheater")
    public ResponseEntity<Wizard> createDeathEater(@RequestBody @Validated DeathEater deathEater){
        return deathEaterService.createDeathEater(deathEater);
    }

    @PostMapping("/alumni")
    public ResponseEntity<Wizard> createAlumni(@RequestBody @Validated Alumni alumni){
        return alumniService.createAlumni(alumni);
    }

    @PostMapping("/professor")
    public ResponseEntity<Wizard> createProfessor(@RequestBody @Validated Professor professor){
        return professorService.createProfessor(professor);
    }

    @PostMapping("/dumbledore")
    public ResponseEntity<Wizard> createDumbledore(@RequestBody @Validated Dumbledore dumbledore){
        return dumbledoreService.createDumbledore(dumbledore);
    }

    @PostMapping("/potionsmaster")
    public ResponseEntity<Wizard> createPotionsMaster(@RequestBody @Validated PotionsMaster potionsMaster){
        return potionsMasterService.createPotionsMaster(potionsMaster);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Wizard> updateWizard(@RequestBody @Validated Headmaster wizard, @PathVariable int id) {
       return wizardService.updateWizard(wizard, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWizard(@PathVariable Integer id) {
       return wizardService.deleteWizard(id);
    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<Void> deleteAllWizards() {
        wizardRepo.deleteAll(wizardRepo.findAll());
        if (wizardRepo.findAll().size() == 0) {
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }


    @GetMapping("/pin")
    public ResponseEntity<Integer> getNumber() {
        return new ResponseEntity<>(394, HttpStatus.OK);
    }

    @GetMapping("/quote")
    public ResponseEntity<String> getQuote() {
        String quote = wizardService.quote();
        return new ResponseEntity<>(quote, HttpStatus.OK);
    }

    @PutMapping("/rating/{id}")
    public ResponseEntity<Wizard> updateRating(@RequestBody @Validated Headmaster wizard, @PathVariable int id) {
        return wizardService.updateRating(wizard, id);
    }

    @PutMapping("/victory")
    public ResponseEntity<Wizard> updateVictories(@RequestBody @Validated Headmaster wizard){
        return wizardService.updateVictories(wizard);
    }


}
