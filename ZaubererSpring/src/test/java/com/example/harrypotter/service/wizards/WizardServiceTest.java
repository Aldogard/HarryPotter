package com.example.harrypotter.service.wizards;


import com.example.harrypotter.entity.wizards.Dumbledore;
import com.example.harrypotter.repo.wizards.WizardRepo;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class WizardServiceTest {

    @Autowired
    private WizardService wizardService;

    @Autowired
    private WizardRepo wizardRepo;


}
