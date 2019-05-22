package com.ldrago.sample.cucumbersample.cucumber;

import com.ldrago.sample.cucumbersample.CucumberSampleApplication;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"})
@SpringBootTest(classes = CucumberSampleApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration
public class CucumberITests {
}
