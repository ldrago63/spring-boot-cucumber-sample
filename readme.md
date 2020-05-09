# Why this sample

This application is just a simple spring boot app with a minimalist thymeleaf UI and a sample test package using **Cucumber**, **OpenFeign** to test REST APIs and **Selnium** to test UI.

To have a better cucumber report **Masterthought** cucumber reporting is used.

# Easy to use

#### Gherkins file are in resources folder :

    src/test/resources/features

#### Java steps for feature files are in test package :

    src/test/java/com/ldrago/sample/cucumbersample/cucumber/steps

#### To test APIs, steps use feing client. They just extend controller interfaces and define base url : 

    @FeignClient(name="personsClient", url = "http://localhost:8080/api/persons")
    public interface PersonsClient extends PersonsController {
    }

Next, with spring IoC, you must just inject your feign client to call controller methods.

Selenium java web pages used by steps are in test package :

    src/test/java/com/ldrago/sample/cucumbersample/cucumber/steps/webpages

#### Annoted scenario with *@webui* take automatically a browser screenshot for report when scenario fails.

#### To launch this sample, just use :

    mvn clean install

#### Web driver are automatically installed by the magical webdrivermanager project of Boni García [https://github.com/bonigarcia](https://github.com/bonigarcia)

The used browser is defined in *SeleniumConfiguration* with maven -DBROWSER option. Default used browser is Chrome. To chose another during test phase use :

    mvn clean install -DBROWSER=Firefox
    mvn clean install -DBROWSER=InternetExplorer
    mvn clean install -DBROWSER=Edge


#### To launch only api tests, run :

    mvn clean install -Dcucumber.options="--tags @api" 


#### To launch only ui tests, run :

    mvn clean install -DBROWSER=Chrome -Dcucumber.options="--tags @webui"



#### Bonus build this spring app in docker image :

    mvn clean install && docker build -t ldrago/demo-spring .
    
and run 

    docker run -d --name=demo-spring -p 8080:8080 ldrago/demo-spring

