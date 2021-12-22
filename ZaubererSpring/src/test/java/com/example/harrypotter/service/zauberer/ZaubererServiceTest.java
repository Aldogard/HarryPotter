package com.example.harrypotter.service.zauberer;


import com.example.harrypotter.entity.wizards.Wizard;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
public class ZaubererServiceTest {

    @Autowired
    private WizardService zaubererService;

    @Test
    @Transactional
    public void testHeadMasterService(){
        List<Wizard> alleHeadmaster = (List<Wizard>) zaubererService.getAllWizards();
        assertNotEquals(0, alleHeadmaster.size());
        assertNotNull(alleHeadmaster);

    }
}
