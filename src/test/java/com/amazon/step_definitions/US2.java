package com.amazon.step_definitions;

import com.amazon.pages.LoginPages;
import com.amazon.pages.MainLibraryPage;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.DB_Util;
import com.amazon.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Connection;
import java.util.concurrent.TimeUnit;

public class US2 {

    LoginPages lp = new LoginPages();
    MainLibraryPage mlp = new MainLibraryPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    int borrowedBNum;

    @Given("User sends his info {string} and {string}")
    public void and(String username, String password) throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        lp.emailAd.sendKeys(username);
        lp.password.sendKeys(password);
        lp.signIn.click();
        DB_Util.createConnection(ConfigurationReader.getProperty("url"), ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
    }

    @Then("I am in the homepage of the library app")
    public void i_am_in_the_homepage_of_the_library_app() {
        String actualT = Driver.getDriver().getTitle();
        String expectedT = "Login - Library";
        System.out.println(expectedT + " = " + actualT);
        Assert.assertEquals(expectedT, actualT);
    }
    @When("I take borrowed books number")
    public void i_take_borrowed_books_number() throws InterruptedException {
        Thread.sleep(3000);
        borrowedBNum = Integer.parseInt(mlp.borrowedBooksNumber.getText());
    }
    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {
        DB_Util.runQuery("select count(*) from book_borrow where is_returned=0");
        int actualBNum = Integer.parseInt(DB_Util.getFirstRowFirstColumn());
        System.out.println(borrowedBNum + " = " + actualBNum);
        Assert.assertEquals(borrowedBNum, actualBNum);
    }

}
