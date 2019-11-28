package com.ldrago.sample.cucumbersample.cucumber;

import com.ldrago.sample.cucumbersample.CucumberSampleApplication;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = CucumberSampleApplication.class, loader = SpringBootContextLoader.class)
@EnableFeignClients
public class CucumberConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(CucumberConfiguration.class);

    @Autowired
    private WebDriver webDriver;

    /**
     * Need this method so the cucumber will recognize this class as glue and load spring context configuration
     */
    @Before
    public void setUp() {
        LOG.info("-------------- Spring Context Initialized For Executing Cucumber Tests --------------");
    }

    @After("@webui")
    public void afterTest(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            }
        } catch (NoSuchSessionException e) {
            LOG.warn("NoSuchSessionException, maybe you are just not in a selenium test.");
        }
    }


}
