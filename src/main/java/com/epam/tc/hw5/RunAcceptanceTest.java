package com.epam.tc.hw5;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"classpath:/scr/test/java/resources/cucumber_features"},
        glue = {"com.epam.tc.hw5.steps", "com.epam.tc.hw5.hook"},
        publish = true)

public class RunAcceptanceTest extends AbstractTestNGCucumberTests {
}
