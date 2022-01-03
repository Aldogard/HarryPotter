package com.example.harrypotter.entity.wizards;

import com.example.harrypotter.repo.wizards.CommentsRepo;
import com.example.harrypotter.repo.wizards.WizardRepo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CommentsTest {
//    List<Wizard> wizards = new ArrayList<>();
//
//
//    @Autowired
//    private WizardRepo wizardRepo;
//
//    @Autowired
//    private CommentsRepo commentsRepo;
//
//    @Before
//    public void safe() {
//        wizards = wizardRepo.findAll();
//        wizardRepo.deleteAll();
//        System.out.println("Test");
//
//
//    }
//
//    @After
//    public void delete(){
//        wizardRepo.deleteAll();
//        System.out.println("Test2");
//        wizardRepo.saveAll(wizards);
//    }

    @Test
    public void testComments(){
        Alumni test = new Alumni("test", BigDecimal.valueOf(25), "Test");
        Comments comment = new Comments("Test", test);

        assertNotNull(comment);
        assertEquals("Test", comment.getContent());
        assertEquals(test, comment.getWizard());






//        Response response = RestAssured.given().body(test).post("http://localhost:"+port+"/wizard");
//        assertEquals(200, response.getStatusCode());
//        Response allWizard = RestAssured.get("http://localhost:"+port+"/wizard" );
//        Response wizard = RestAssured.get("http://localhost:"+port+"/wizard{id}", allWizard.jsonPath().getString("id[0]"));
//        assertEquals(allWizard.jsonPath().getString("name[0]"), wizard.jsonPath().getString("name"));

    }
}
