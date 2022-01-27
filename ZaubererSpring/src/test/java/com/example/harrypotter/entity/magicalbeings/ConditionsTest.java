package com.example.harrypotter.entity.magicalbeings;

import com.example.harrypotter.entity.magicalbeings.wizards.Alumni;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class ConditionsTest {
    @Test
    public void testConditions(){
        Alumni test = new Alumni("Test", BigDecimal.valueOf(25), "Test");
        Condition condition = new Condition(test, "testConditions");
        assertNotNull(condition);
        assertEquals(test, condition.getMagicalBeing());
        assertEquals("testConditions", condition.getName());
        assertFalse(condition.getCondition());
    }
}
