package com.ldrago.sample.cucumbersample.cucumber.steps.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DisplayPersonPage {

    @FindBy(id = "result")
    private WebElement result;

    @FindBy(id = "firstname")
    private WebElement displayedFirstName;

    @FindBy(id = "lastname")
    private WebElement displayedLastName;

    //public void goToHome(){
    //    homeLink.click();
    //}


    public WebElement getDisplayedFirstName() {
        return displayedFirstName;
    }

    public void setDisplayedFirstName(WebElement displayedFirstName) {
        this.displayedFirstName = displayedFirstName;
    }

    public WebElement getDisplayedLastName() {
        return displayedLastName;
    }

    public void setDisplayedLastName(WebElement displayedLastName) {
        this.displayedLastName = displayedLastName;
    }

    public WebElement getResult() {
        return result;
    }

    public void setResult(WebElement result) {
        this.result = result;
    }
}
