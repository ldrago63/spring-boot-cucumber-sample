package com.ldrago.sample.cucumbersample.cucumber;

import io.cucumber.junit.Cucumber;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CucumberReporter extends Cucumber {

    public CucumberReporter(Class clazz) throws InitializationError {
        super(clazz);
    }

    @Override
    public void run(RunNotifier notifier) {
        super.run(notifier);
        generateReport();
        closeBrowser();
    }

    public static void generateReport() {
        File reportOutputDirectory = new File("target/cucumber/masterthought-report");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/cucumber/cucumber-report.json");

        // set values from respective build tool
        Configuration configuration = new Configuration(reportOutputDirectory, "spring-boot-cucumber-sample");

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }

    private void closeBrowser() {
        SpringContext.getBean(WebDriver.class).quit();
    }
}