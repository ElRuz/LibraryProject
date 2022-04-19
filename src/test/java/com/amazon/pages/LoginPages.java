package com.amazon.pages;

import com.amazon.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPages {

    public LoginPages(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='inputEmail']")
    public WebElement emailAd;

    @FindBy(xpath = "//*[@id='inputPassword']")
    public WebElement password;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signIn;


}
