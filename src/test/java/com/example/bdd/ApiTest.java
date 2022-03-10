package com.example.bdd;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(extraGlue = "com.example.bdd.steps", features = "src/test/resources/features")
public class ApiTest {
}
