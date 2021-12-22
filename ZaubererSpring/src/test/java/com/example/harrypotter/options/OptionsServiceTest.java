package com.example.harrypotter.options;

import com.example.harrypotter.entity.options.Options;
import com.example.harrypotter.repo.options.OptionsRepo;
import com.example.harrypotter.service.options.OptionsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@SpringBootTest
@AllArgsConstructor
public class OptionsServiceTest {


    private OptionsService optionsService;
    private OptionsRepo optionsRepo;

    @Test
    @Transactional
    public void testOptionsService(){
        List<Options> alleOptions = optionsRepo.findAll();
        assertNotEquals(0, alleOptions.size());
        assertNotNull(alleOptions);

    }
}
