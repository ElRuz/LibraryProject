package com.amazon.pages;

import com.amazon.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoadBoardPage {

    public LoadBoardPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"load-board-header\"]/p")
    public WebElement loadBoardTab;

    @FindBy(xpath = "//div[.='Search']")
    public WebElement SearchButton;

    @FindBy(xpath = "//span[.='Saved searches']")
    public WebElement savedSearches;

    @FindBy(xpath = "//p[.='CA1']")
    public WebElement CA1;

    @FindBy(xpath = "//span[.='Apply']")
    public WebElement apply;

    @FindBy(xpath = "//*[@id='0977621d-35b2-4f4c-803d-d3ddefd20c9f']/div/div/div/div/div[7]/div[2]/span/span/div/span/span")
    public WebElement Price;

    @FindBy(xpath = "//*[@id='0977621d-35b2-4f4c-803d-d3ddefd20c9f']/div/div/div/div/span/button")
    public WebElement book;

    @FindBy(xpath = "//*[@id='filter-summary-panel']/div[1]/div[3]/button[3]/span")
    public WebElement gearIcon;

    @FindBy(xpath = "//*[text()='15 seconds']")
    public WebElement seconds;


}
