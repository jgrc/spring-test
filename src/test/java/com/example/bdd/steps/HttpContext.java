package com.example.bdd.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class HttpContext {
    private final TestRestTemplate template;
    private ResponseEntity<String> response;

    @Autowired
    public HttpContext(TestRestTemplate template) {
        this.template = template;
    }

    @Before
    public void clear() {
        response = null;
    }

    @When("I send POST to {string} with body:")
    public void iSendPostToWithBody(String url, String body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        this.response = template.postForEntity(url, new HttpEntity<>(body, headers), String.class);
    }

    @When("I send GET to {string}")
    public void iSendGetTo(String url) {
        this.response = template.getForEntity(url, String.class);
    }

    @Then("the response status should be {string} with body:")
    public void responseStatusShouldBeWithBody(
        String expectedStatus,
        String expectedBody
    ) throws JsonProcessingException {
        Assertions.assertEquals(expectedStatus, response.getStatusCode().toString());
        ObjectMapper mapper = new ObjectMapper();
        Assertions.assertEquals(mapper.readTree(expectedBody), mapper.readTree(response.getBody()));
    }
}
