package com.example.harrypotter.entity.magicalbeings.giants;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class HagridTest {

    @Test
    public void testHagridConstructor(){
        Hagrid hg = new Hagrid("Rubeus", BigDecimal.valueOf(15), "Test and more than 10");

        assertNotNull(hg);
        assertEquals("Rubeus", hg.getName());
        assertEquals(BigDecimal.valueOf(15), hg.getHealthPoints());
        assertEquals("Test and more than 10", hg.getDescription());

        assertEquals("Hagrid", hg.getKlasse());
        assertEquals(BigDecimal.valueOf(0.75), hg.getFaktor());
        assertEquals(10, hg.getStunnedProtection());
        assertEquals(30, hg.getIntelligence());
    }
}
