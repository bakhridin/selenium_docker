package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationConfirmationPage {
     private WebDriver driver;
     private WebDriverWait wait;



     @FindBy(id="flight-link")
     private WebElement flightsLink;

    public RegistrationConfirmationPage(WebDriver driver) {
            this.driver=driver;
            this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void goToFlightDetailsPage() {
       this.wait.until(ExpectedConditions.visibilityOf(this.flightsLink));
        this.flightsLink.click();
    }

}
