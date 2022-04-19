package com.amazon.pages;

import com.amazon.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BooksPage {

    public BooksPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchBar;

    @FindBy(xpath = "//td[.='Chordeiles minor']")
    public WebElement bookN;

    @FindBy(xpath = "//td[.='Waylon Connold']")
    public WebElement authorN;

    @FindBy(xpath = "//td[.='2005']")
    public WebElement yearN;


}
