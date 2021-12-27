package com.example.harrypotter.entities.wizards;

import com.example.harrypotter.entity.wizards.Alumni;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class AlumniTest {


    @Test
    public void TestAlumni() {
        Alumni newt = new Alumni();
        assertNotNull(newt);

    }

    @Test
    public void TestConstructor() {
        Alumni newt = new Alumni("Newt", BigDecimal.valueOf(25), "Animal Friend");
        assertNotNull(newt);
        assertEquals("Newt", newt.getName());
        assertEquals(BigDecimal.valueOf(25), newt.getHealthPoints());
        assertEquals("Test Description", newt.getDescription());
        assertEquals("Alumni", newt.getKlasse());
        assertEquals(BigDecimal.valueOf(1.2), newt.getFaktor());
        assertEquals(newt.getHealthPoints(), newt.getInternHealthPoints());
    }

}
