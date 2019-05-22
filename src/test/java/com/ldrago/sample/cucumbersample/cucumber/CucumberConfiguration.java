package com.ldrago.sample.cucumbersample.cucumber;

import com.ldrago.sample.cucumbersample.CucumberSampleApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(classes = CucumberSampleApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration
@EnableFeignClients
public class CucumberConfiguration {
}
