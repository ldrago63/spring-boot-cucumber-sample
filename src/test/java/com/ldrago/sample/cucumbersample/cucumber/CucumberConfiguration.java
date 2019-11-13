package com.ldrago.sample.cucumbersample.cucumber;

import com.ldrago.sample.cucumbersample.CucumberSampleApplication;
import io.cucumber.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = CucumberSampleApplication.class, loader = SpringBootContextLoader.class)
@EnableFeignClients
public class CucumberConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(CucumberConfiguration.class);

    /**
     * Need this method so the cucumber will recognize this class as glue and load spring context configuration
     */
    @Before
    public void setUp() {
        LOG.info("-------------- Spring Context Initialized For Executing Cucumber Tests --------------");
    }

}
