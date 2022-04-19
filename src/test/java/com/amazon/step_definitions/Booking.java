package com.amazon.step_definitions;

import com.amazon.pages.LoadBoardPage;
import com.amazon.pages.MainPage;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;

public class Booking {

    MainPage page = new MainPage();
    LoadBoardPage lbp = new LoadBoardPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();


    @Given("User is on the relay page")
    public void userIsOnTheRelayPage() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        page.signIn.click();
        page.username.sendKeys(ConfigurationReader.getProperty("username"));
        page.password.sendKeys(ConfigurationReader.getProperty("password"));
        page.logIn.click();

        lbp.loadBoardTab.click();
        lbp.SearchButton.click();

    }

    @When("User inputs the requirements")
    public void userInputsTheRequirements() throws InterruptedException {

        lbp.savedSearches.click();
        js.executeScript("arguments[0].scrollIntoView();", lbp.CA1);
        lbp.CA1.click();

        lbp.apply.click();

        lbp.gearIcon.click();
        Thread.sleep(2000);
        lbp.seconds.click();


    }

    @Then("makes sure that the price_perMile is above {double} dollars")
    public void makesSureThatThePricePerMileIsAboveDollars(double desiredPrice) {

        double price = 0;

        do {
            price = Double.parseDouble(lbp.Price.getText().substring(1,5));
            if (price>=desiredPrice) {
                System.out.println("true" + price);
            }
        } while (price<=desiredPrice);

    }

}
