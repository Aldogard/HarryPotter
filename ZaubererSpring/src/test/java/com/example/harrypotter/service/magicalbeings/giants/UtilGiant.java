package com.example.harrypotter.service.magicalbeings.giants;

import com.example.harrypotter.entity.magicalbeings.giants.Gurg;
import com.example.harrypotter.entity.magicalbeings.giants.Hagrid;
import com.example.harrypotter.entity.magicalbeings.wizards.Alumni;

import java.math.BigDecimal;

public class UtilGiant {
    public static Hagrid createHagrid(){
        return new Hagrid("Hagrid", BigDecimal.valueOf(10), "Test and more than 10");
    }

    public static Gurg createGurg(){
        return new Gurg("Gurg", BigDecimal.valueOf(10), "Test and more than 10");
    }
}
