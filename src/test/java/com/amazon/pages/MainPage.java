package com.amazon.pages;

import com.amazon.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public MainPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    
    @FindBy(xpath = "//*[@id=\"home-nav--lg-up\"]/li[3]/a")
    public WebElement signIn;

    @FindBy(xpath = "//*[@id=\"ap_email\"]")
    public WebElement username;

    @FindBy(xpath = "//*[@id=\"ap_password\"]")
    public WebElement password;

    @FindBy(xpath = "//*[@id=\"signInSubmit\"]")
    public WebElement logIn;



}
