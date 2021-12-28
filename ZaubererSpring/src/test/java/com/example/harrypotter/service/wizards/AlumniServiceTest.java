//package com.example.harrypotter.service.wizards;
//
//import com.example.harrypotter.entity.wizards.Alumni;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.math.BigDecimal;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(AlumniService.class)
//class AlumniServiceTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void testAlumni() throws Exception {
//        Alumni test = new Alumni("TestA", BigDecimal.valueOf(1), "old");
//        RequestBuilder request = MockMvcRequestBuilders.get("/wizard");
//        MvcResult result = mockMvc.perform(request).andReturn();
//        assertNotNull(result.getResponse().getContentAsString());
//
//
//    }
//
//
//}