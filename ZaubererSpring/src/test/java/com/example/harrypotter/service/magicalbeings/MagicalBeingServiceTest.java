package com.example.harrypotter.service.magicalbeings;

import com.example.harrypotter.entity.magicalbeings.MagicalBeing;
import com.example.harrypotter.entity.magicalbeings.giants.Giant;
import com.example.harrypotter.entity.magicalbeings.wizards.Headmaster;

import com.example.harrypotter.repo.magicalbeings.MagicalBeingRepo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

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
    public void testGetAllMagicalBeings() {
        Giant giant = new Giant("Testi1", BigDecimal.valueOf(10), "Test and more than 10");
        Headmaster headmaster = new Headmaster("Test2", BigDecimal.valueOf(20), "Test and more than 20");

        magicalBeingRepo.save(giant);
        magicalBeingRepo.save(headmaster);

        ResponseEntity<List<MagicalBeing>> response = magicalBeingService.getAllMagicalBeings();

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
    }

    @Test
    public void testGetMagicalBeingById() {
        Giant giant = new Giant("Testi1", BigDecimal.valueOf(10), "Test and more than 10");
        magicalBeingRepo.save(giant);

        ResponseEntity<MagicalBeing> response = magicalBeingService.getMagicalBeingById(magicalBeingRepo.findAll().get(0).getId());
        ResponseEntity<MagicalBeing> responseNull = magicalBeingService.getMagicalBeingById(1000);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Testi1", response.getBody().getName());
        assertNull(responseNull.getBody());

    }
}
