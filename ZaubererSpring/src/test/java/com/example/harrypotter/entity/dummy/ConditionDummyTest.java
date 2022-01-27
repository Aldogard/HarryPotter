package com.example.harrypotter.entity.dummy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConditionDummyTest {
    @Test
    public void testConditions(){
        Dummy test = new Dummy();
        ConditionDummy condition = new ConditionDummy(test, "testConditions");
        assertNotNull(condition);
        assertEquals(test, condition.getDummy());
        assertEquals("testConditions", condition.getName());
        assertFalse(condition.getCondition());
    }
}
