package com.ldrago.sample.cucumbersample.cucumber;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

@Configuration
public class SeleniumConfiguration {

  // what browsers to support
  private enum Browsers {Firefox, Chrome, InternetExplorer, Edge}

  @Bean
  public WebDriver webDriver() {
    WebDriver driver = null;
    Browsers browser = initBrowsers();
    switch (browser) { // check our browser
    case Firefox:
      WebDriverManager.firefoxdriver()
                      .setup();
      driver = new FirefoxDriver();
      break;
    case Chrome:
      WebDriverManager.chromedriver()
                      .setup();
      driver = new ChromeDriver();
      break;
    case InternetExplorer:
      WebDriverManager.iedriver()
                      .setup();
      driver = new InternetExplorerDriver();
      break;
    case Edge:
      WebDriverManager.edgedriver()
                      .setup();
      driver = new EdgeDriver();
      break;
    }
    driver.manage()
          .window()
          .maximize();
    return driver;
  }

  /**
   * Init generic driver and look for the user selected browser
   * Default is Chrome
   */
  private Browsers initBrowsers() {
    String browserName = System.getProperty("BROWSER") == null ? "Chrome" : System.getProperty("BROWSER");
    return Browsers.valueOf(browserName);
  }

}
