package com.example.harrypotter.service;

import com.example.harrypotter.entity.dummy.Dummy;
import com.example.harrypotter.repo.dummy.ConditionDummyRepo;
import com.example.harrypotter.repo.dummy.DummyRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class DummyServiceTest {
    @Autowired
    private DummyService dummyService;

    @Autowired
    private DummyRepo dummyRepo;

    @Autowired
    private ConditionDummyRepo conditionDummyRepo;

    @AfterEach
    public void deleteAll(TestInfo testInfo) {
        if (!testInfo.getTags().contains("deleteAll")) {
            dummyRepo.deleteAll();
        }
    }


    @Test
    public void testCreateDummy() {
        Dummy dummy = new Dummy();
        ResponseEntity<Dummy> response = dummyService.createDummy(dummy);

        Dummy dummyResponse = response.getBody();
        HttpStatus httpStatusResponse = response.getStatusCode();
        assertEquals(HttpStatus.OK, httpStatusResponse);

        assertNotNull(dummyResponse);
        assertNotNull(dummyResponse.getName());
        assertEquals(1, dummyRepo.findAll().size());
        assertNotNull(dummyRepo.findByName("Dummy").get(0).getId());

//        List<ConditionDummy> conditions = conditionDummyRepo.findAll();
//        assertEquals(dummyResponse.getConditions().size(), conditions.size());

    }

    @Test
    public void testGetDummyByName() {
        Dummy dummy = new Dummy();
        dummyService.createDummy(dummy);

        ResponseEntity<Dummy> response = dummyService.getDummyByName("Dummy");
        Dummy dummyResponse = response.getBody();


        assertNotNull(dummyResponse);
        assertNotNull(dummyResponse.getName());
        assertEquals(1, dummyRepo.findAll().size());
        assertNotNull(dummyRepo.findByName("Dummy").get(0).getId());
        assertEquals(dummy.getName(), dummyResponse.getName());
    }

    @Test
    @Tag("deleteAll")
    public void testDeleteAllDummy(){
        Dummy dummy = new Dummy();
        dummyService.createDummy(dummy);

        ResponseEntity<Void> response = dummyService.deleteAllDummy();
        HttpStatus httpStatusResponse = response.getStatusCode();

        assertEquals(HttpStatus.ACCEPTED, httpStatusResponse);

    }
}
