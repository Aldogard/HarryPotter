package com.example.harrypotter.service.magicalbeings;

import com.example.harrypotter.entity.magicalbeings.MagicalBeing;
import com.example.harrypotter.entity.magicalbeings.giants.Gurg;
import com.example.harrypotter.entity.magicalbeings.wizards.*;

import com.example.harrypotter.repo.magicalbeings.MagicalBeingRepo;

import com.example.harrypotter.service.magicalbeings.wizards.UtilWizard;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class MagicalBeingServiceTest {

    @Autowired
    private MagicalBeingRepo magicalBeingRepo;

    @Autowired
    private MagicalBeingService magicalBeingService;

    @AfterEach
    public void deleteAll() {
        magicalBeingRepo.deleteAll();
    }


    @Test
    public void testGetMagicalBeingById() {
        Gurg gurg = new Gurg("Testi1", BigDecimal.valueOf(10), "Test and more than 10");
        magicalBeingRepo.save(gurg);

        ResponseEntity<MagicalBeing> response = magicalBeingService.getMagicalBeingById(magicalBeingRepo.findAll().get(0).getId());
        ResponseEntity<MagicalBeing> responseNull = magicalBeingService.getMagicalBeingById(1000);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Testi1", Objects.requireNonNull(response.getBody()).getName());
        assertNull(responseNull.getBody());

    }



    @Test
    public void testQuote() {
        assertNotNull(magicalBeingService.quote());
    }

    @Test
    public void testMagicalBeingRepo() {
        Alumni alumni = UtilWizard.createTesti();
        magicalBeingRepo.save(alumni);
        assertNotNull(alumni);
        assertEquals(1, magicalBeingRepo.findAll().size());
    }


    @Test
    public void testUpdateMagicalBeing(){
        Alumni alumni = UtilWizard.createTesti();
        magicalBeingRepo.save(alumni);

        ResponseEntity<MagicalBeing> responseTest = magicalBeingService.updateMagicalBeing(
                new Headmaster(
                        "Testi",
                        BigDecimal.valueOf(5),
                        "NEW and more than 10"), 10000);
        assertNull(responseTest.getBody());
        assertEquals(HttpStatus.FORBIDDEN, responseTest.getStatusCode());

        ResponseEntity<MagicalBeing> response = magicalBeingService.updateMagicalBeing(
                new Headmaster(
                        "Testi",
                        BigDecimal.valueOf(5),
                        "NEW and more than 10"), alumni.getId());
        assertEquals(alumni, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    public void testDeleteMagicalBeing(){
        Alumni alumni = UtilWizard.createTesti();
        magicalBeingRepo.save(alumni);
        assertEquals(1, magicalBeingRepo.findAll().size());
        ResponseEntity<Void> responseTestLessThanFive = magicalBeingService.deleteMagicalBeing(alumni.getId());
        assertNull(responseTestLessThanFive.getBody());
        assertEquals(HttpStatus.FORBIDDEN, responseTestLessThanFive.getStatusCode());

        for (int i=0; i<5; i++){
            String number = "Testi " + i;
            magicalBeingRepo.save(new Alumni(number, BigDecimal.valueOf(10), "Test and more than 10"));
        }

        assertEquals(6, magicalBeingRepo.findAll().size());

        ResponseEntity<Void> responseTestWrongId = magicalBeingService.deleteMagicalBeing(1000);
        assertNull(responseTestWrongId.getBody());
        assertEquals(HttpStatus.NO_CONTENT, responseTestWrongId.getStatusCode());


        ResponseEntity<Void> response = magicalBeingService.deleteMagicalBeing(magicalBeingRepo.findAll().get(magicalBeingRepo.findAll().size()-1).getId());
        assertNull(response.getBody());

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testGetAllMagicalBeings(){
        Alumni alumni = UtilWizard.createTesti();
        Headmaster headmaster = new Headmaster("Headi", BigDecimal.valueOf(5), "Master and more than 10");
        magicalBeingRepo.save(alumni);
        magicalBeingRepo.save(headmaster);
        ResponseEntity<List<MagicalBeing>> response = magicalBeingService.getAllMagicalBeings(null, null, null);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, Objects.requireNonNull(response.getBody()).size());

        ResponseEntity<List<MagicalBeing>> responseName = magicalBeingService.getAllMagicalBeings("Headi", null, null);
        assertEquals(1, Objects.requireNonNull(responseName.getBody()).size());
        assertEquals("Headi", responseName.getBody().get(0).getName());

        ResponseEntity<List<MagicalBeing>> responseClass = magicalBeingService.getAllMagicalBeings(null, "Alumni", null);
        assertEquals(1, Objects.requireNonNull(responseClass.getBody()).size());
        assertEquals("Testi", responseClass.getBody().get(0).getName());

        ResponseEntity<List<MagicalBeing>> responseSpecies = magicalBeingService.getAllMagicalBeings(null, null, "Wizard");
        assertEquals(1, responseClass.getBody().size());
        assertEquals("Testi", responseClass.getBody().get(0).getName());
    }

    @Test
    public void testGetVoldemort(){
        Alumni alumni = UtilWizard.createTesti();
        magicalBeingRepo.save(alumni);

        ResponseEntity<MagicalBeing> responseNoVoldemort = magicalBeingService.getVoldemort("Voldemort");
        assertNull(responseNoVoldemort.getBody());
        assertEquals(HttpStatus.NO_CONTENT, responseNoVoldemort.getStatusCode());

        Voldemort voldemort = new Voldemort("Voldi", BigDecimal.valueOf(10), "Dark and more than 10");
        magicalBeingRepo.save(voldemort);

        ResponseEntity<MagicalBeing> response = magicalBeingService.getVoldemort("Voldemort");
        assertEquals(voldemort, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testGetAllMagicalBeingsHp(){
        for (int i = 0; i<5; i++){
            String number = "Test" + i;
            magicalBeingRepo.save(new Alumni(number, BigDecimal.valueOf(i+1), "Test  and more than 10"));
        }
        ResponseEntity<List<MagicalBeing>> responseMax= magicalBeingService.getAllMagicalBeingHp(3.5, null);
        assertEquals(2, Objects.requireNonNull(responseMax.getBody()).size());
        assertEquals(HttpStatus.OK, responseMax.getStatusCode());

        ResponseEntity<List<MagicalBeing>> responseMin= magicalBeingService.getAllMagicalBeingHp(null, 3.5);
        assertEquals(3, Objects.requireNonNull(responseMin.getBody()).size());
        assertEquals(HttpStatus.OK, responseMin.getStatusCode());
    }

    @Test
    public void testGetAllMagicalBeingsVictories(){
        Alumni alumni = UtilWizard.createTesti();
        alumni.setVictories(10);
        Alumni alumni100Victories = new Alumni("Test100", BigDecimal.valueOf(100), "Test100  and more than 10");
        alumni.setVictories(10);
        alumni100Victories.setVictories(100);
        magicalBeingRepo.save(alumni);
        magicalBeingRepo.save(alumni100Victories);

        ResponseEntity<List<MagicalBeing>> response10= magicalBeingService.getAllMagicalBeingsVictories(10);
        assertEquals(2, Objects.requireNonNull(response10.getBody()).size());

        ResponseEntity<List<MagicalBeing>> response15= magicalBeingService.getAllMagicalBeingsVictories(15);
        assertEquals(1, Objects.requireNonNull(response15.getBody()).size());

        ResponseEntity<List<MagicalBeing>> response101= magicalBeingService.getAllMagicalBeingsVictories(101);
        assertEquals(0, Objects.requireNonNull(response101.getBody()).size());

    }

    @Test
    public void testUpdateRating(){
        Alumni alumni = UtilWizard.createTesti();
        magicalBeingRepo.save(alumni);

        Headmaster alumniUpdate = new Headmaster("Testi", BigDecimal.valueOf(10), "Test  and more than 10");
        alumniUpdate.setAmount(5);
        alumniUpdate.setRating(BigDecimal.valueOf(3.5));

        ResponseEntity<MagicalBeing> response = magicalBeingService.updateRating(alumniUpdate, alumni.getId());
        assertEquals(alumni, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertEquals(alumni.getAmount(), alumniUpdate.getAmount());
        assertEquals(alumni.getRating(), alumniUpdate.getRating());

        Headmaster alumniUpdateWrongId = new Headmaster("Testi", BigDecimal.valueOf(10), "Test");
        alumniUpdate.setAmount(50);
        alumniUpdate.setRating(BigDecimal.valueOf(2.5));

        ResponseEntity<MagicalBeing> responseWrongId = magicalBeingService.updateRating(alumniUpdateWrongId, 1000);
        assertEquals(HttpStatus.NO_CONTENT, responseWrongId.getStatusCode());
        assertNull(responseWrongId.getBody());
        assertNotEquals(alumni.getRating(), alumniUpdateWrongId.getRating());
        assertNotEquals(alumni.getAmount(), alumniUpdateWrongId.getAmount());

    }

    @Test
    public void testUpdateVictories(){
        Alumni alumni = UtilWizard.createTesti();
        magicalBeingRepo.save(alumni);

        Headmaster alumniUpdate = new Headmaster("Testi", BigDecimal.valueOf(10), "Test  and more than 10");
        alumniUpdate.setId(alumni.getId());
        alumniUpdate.setVictories(10);

        ResponseEntity<MagicalBeing> response = magicalBeingService.updateVictories(alumniUpdate);

        assertEquals(alumni, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(alumni.getVictories(), alumniUpdate.getVictories());

        Headmaster alumniUpdateWrongId = new Headmaster("Testi", BigDecimal.valueOf(10), "Test  and more than 10");
        alumniUpdate.setId(1000);
        alumniUpdate.setVictories(50);

        ResponseEntity<MagicalBeing> responseWrongId = magicalBeingService.updateVictories(alumniUpdateWrongId);
        assertEquals(HttpStatus.NO_CONTENT, responseWrongId.getStatusCode());
        assertNull(responseWrongId.getBody());
        assertNotEquals(alumni.getVictories(), alumniUpdateWrongId.getVictories());


    }

    @Test
    public void testUpdateVictoriesChess(){
        Alumni alumni = UtilWizard.createTesti();
        magicalBeingRepo.save(alumni);

        Headmaster alumniUpdate = new Headmaster("Testi", BigDecimal.valueOf(10), "Test  and more than 10");
        alumniUpdate.setId(alumni.getId());
        alumniUpdate.setVictoriesChess(BigDecimal.valueOf(10));

        ResponseEntity<MagicalBeing> response = magicalBeingService.updateVictoriesChess(alumniUpdate);

        assertEquals(alumni, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(alumni.getVictoriesChess(), alumniUpdate.getVictoriesChess());

        Headmaster alumniUpdateWrongId = new Headmaster("Testi", BigDecimal.valueOf(10), "Test  and more than 10");
        alumniUpdate.setId(1000);
        alumniUpdate.setVictoriesChess(BigDecimal.valueOf(50));

        ResponseEntity<MagicalBeing> responseWrongId = magicalBeingService.updateVictoriesChess(alumniUpdateWrongId);
        assertEquals(HttpStatus.NO_CONTENT, responseWrongId.getStatusCode());
        assertNull(responseWrongId.getBody());
        assertNotEquals(alumni.getVictoriesChess(), alumniUpdateWrongId.getVictoriesChess());


    }

    @Test
    public void testGetMagicalBeingByName(){
        Alumni alumni = UtilWizard.createTesti();
        magicalBeingRepo.save(alumni);

        ResponseEntity<MagicalBeing> response = magicalBeingService.getMagicalBeingByName("Testi");
        ResponseEntity<MagicalBeing> responseNull = magicalBeingService.getMagicalBeingByName("Güllmann");

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Testi", Objects.requireNonNull(response.getBody()).getName());
        assertNull(responseNull.getBody());

    }

    @Test
    public void testDeleteAllMagicalBeings(){
        Alumni alumni = UtilWizard.createTesti();
        magicalBeingRepo.save(alumni);

        ResponseEntity<Void> response = magicalBeingService.deleteAllMagicalBeings();
        assertEquals(0, magicalBeingRepo.findAll().size());
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());

    }

    @Test
    public void testCheckName(){
        Alumni alumni = UtilWizard.createTesti();
        Alumni alumni2 = new Alumni("Test2", BigDecimal.valueOf(10), "Test  and more than 10");
        magicalBeingRepo.save(alumni);

        boolean response = magicalBeingService.checkName(alumni);
        boolean responseAnotherWizard = magicalBeingService.checkName(alumni2);

        assertTrue(response);
        assertFalse(responseAnotherWizard);

    }

    @Test
    public void testCheckHouse(){
        Alumni alumni = UtilWizard.createTesti();
        Professor professor = new Professor("Test2", BigDecimal.valueOf(10), "Test  and more than 10");
        magicalBeingRepo.save(alumni);

        boolean response = magicalBeingService.checkHouse(alumni);
        boolean responseAnotherWizard = magicalBeingService.checkHouse(professor);

        assertTrue(response);
        assertFalse(responseAnotherWizard);
    }
}
