package com.amazon.pages;

import com.amazon.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainLibraryPage {

    public MainLibraryPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='borrowed_books']")
    public WebElement borrowedBooksNumber;

    @FindBy(xpath = "//*[@id='menu_item']/li[3]/a")
    public WebElement booksTab;

}
