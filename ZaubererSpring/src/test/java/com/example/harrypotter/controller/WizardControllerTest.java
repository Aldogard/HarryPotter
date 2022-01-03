//package com.example.harrypotter.controller;
//
//import com.example.harrypotter.entity.wizards.Alumni;
//import com.example.harrypotter.entity.wizards.Wizard;
//import com.example.harrypotter.repo.wizards.WizardRepo;
//import com.example.harrypotter.service.wizards.WizardService;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.math.BigDecimal;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@WebMvcTest
//class WizardControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private WizardService wizardService;
//
//    @Autowired
//    private WizardRepo wizardRepo;
//
//    @Test
//    public void testWizardController() throws Exception {
//        Alumni test = new Alumni("Test", BigDecimal.valueOf(10), "Test D");
//        wizardRepo.save(test);
//        when(wizardService.
//                getWizardById(1).getStatusCode()).
//                thenReturn(HttpStatus.OK);
//        mockMvc.perform(get("/wizard/1")).
//                andDo(print()).
//                andExpect(status().isOk());
//        verify(wizardService).getWizardById(1);
//
//
//
//    }
//
//
//}
