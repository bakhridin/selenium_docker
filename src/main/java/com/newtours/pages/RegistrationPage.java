package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name="firstName")
    private WebElement firstNameTxt;

    @FindBy(name="lastName")
    private WebElement lastNameTxt;

    @FindBy(name="email")
    private WebElement usernameTxt;

    @FindBy(name="password")
    private WebElement passwordTxt;

    @FindBy(name="confirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(name="register")
    private WebElement submitBtn;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
        this.wait.until(ExpectedConditions.visibilityOf(this.firstNameTxt));

    }

    public void enterUserDetails(String firstName, String lastName) {
        this.firstNameTxt.sendKeys(firstName);
        this.lastNameTxt.sendKeys(lastName);

    }
    public void enterUserCreentials(String userName,String password) {
        this.usernameTxt.sendKeys(userName);
        this.passwordTxt.sendKeys(password);
        this.confirmPasswordTxt.sendKeys(password);

    }

    public void submit() {
        this.submitBtn.click();
    }







}
