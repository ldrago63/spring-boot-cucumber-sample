package com.ldrago.sample.cucumbersample.cucumber;

import com.ldrago.sample.cucumbersample.CucumberSampleApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(classes = CucumberSampleApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class CucumberConfiguration {
}
