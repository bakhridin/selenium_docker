package com.newtours.tests;

import com.newtours.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTest {
    private WebDriver driver;
    private String noOfPassengers;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"noOfPassengers", "expectedPrice"})
    public void setupDriver(String noOfPassengers, String expectedPrice) {
        this.noOfPassengers=noOfPassengers;
        this.expectedPrice=expectedPrice;
       // this.driver=new ChromeDriver();
        WebDriver driver = WebDriverManager.chromedriver().create();
        this.driver = driver;
    }

    @Test
    public void registrationPage() {
        RegistrationPage registrationPage=new RegistrationPage(driver);
        registrationPage.goTo();
        registrationPage.enterUserDetails("selenium","docker");
        registrationPage.enterUserCreentials("selenium", "docker");
        registrationPage.submit();

    }

    @Test (dependsOnMethods = "registrationPage")
    public void registrationConfirmationPage() {
        RegistrationConfirmationPage registrationConfirmationPage= new RegistrationConfirmationPage(driver);
        registrationConfirmationPage.goToFlightDetailsPage();

    }

    @Test(dependsOnMethods = "registrationConfirmationPage")
    public void flightDetailsPage() {
        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
        flightDetailsPage.selectPassengers(noOfPassengers);
        flightDetailsPage.goToFindFlightsPage();
    }

    @Test(dependsOnMethods = "flightDetailsPage")
    public void findFlightPage() {
        FindFlightsPage findFlightsPage=new FindFlightsPage(driver);
        findFlightsPage.submitFindFlightPage();
        findFlightsPage.goToFlightConfirmationPage();

    }

    @Test(dependsOnMethods = "findFlightPage")
    public void flightConfirmationPage() {
        FlightConfirmationPage flightConfirmationPage=new FlightConfirmationPage(driver);
        String actualPrice=flightConfirmationPage.getPrice();
        Assert.assertEquals(actualPrice,expectedPrice);


    }

    @AfterTest
    public void driverQuit() {
        this.driver.quit();
    }

}
