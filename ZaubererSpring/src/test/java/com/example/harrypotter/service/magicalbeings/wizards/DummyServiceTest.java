package com.example.harrypotter.service.magicalbeings.wizards;

import com.example.harrypotter.entity.magicalbeings.Condition;
import com.example.harrypotter.entity.magicalbeings.wizards.Dumbledore;
import com.example.harrypotter.entity.magicalbeings.wizards.Dummy;
import com.example.harrypotter.entity.magicalbeings.wizards.Wizard;
import com.example.harrypotter.repo.magicalbeings.ConditionRepo;
import com.example.harrypotter.repo.magicalbeings.MagicalBeingRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class DummyServiceTest {
    @Autowired
    private DummyService dummyService;

    @Autowired
    private MagicalBeingRepo magicalBeingRepo;

    @Autowired
    private ConditionRepo conditionRepo;

    @AfterEach
    public void deleteAll() {
        magicalBeingRepo.deleteAll();
    }


    @Test
    public void testDummyService(){
        Dummy dummy = new Dummy("Test", BigDecimal.valueOf(10), "test and more than 10");
        ResponseEntity<Wizard> response = dummyService.createDummy(dummy);

        Wizard wizardResponse = response.getBody();
        HttpStatus httpStatusResponse = response.getStatusCode();
        assertEquals(HttpStatus.OK, httpStatusResponse);


        Dummy dummy1 = new Dummy("Different Name", BigDecimal.valueOf(20), "test and more than 10");
        HttpStatus httpStatus1 = dummyService.createDummy(dummy1).getStatusCode();
        assertEquals(HttpStatus.BAD_REQUEST, httpStatus1);

        assertNotNull(wizardResponse);
        assertNotNull(wizardResponse.getName());
        assertEquals(1, magicalBeingRepo.findAll().size());
        assertNotNull(magicalBeingRepo.findByName("Test").get(0).getId());

        List<Condition> conditions = conditionRepo.findAll();
        assertEquals(UtilWizards.numberOfConditions, conditions.size());

    }
}
