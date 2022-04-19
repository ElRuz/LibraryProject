package com.amazon.step_definitions;

import com.amazon.pages.BooksPage;
import com.amazon.pages.MainLibraryPage;
import com.amazon.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US5 {

    List<String> expected;
    List<String> actual;
    MainLibraryPage mlp = new MainLibraryPage();
    BooksPage bp = new BooksPage();

    @Given("I navigate to {string} page")
    public void i_navigate_to_page(String string) {
       mlp.booksTab.click();
    }
    @When("I open book {string}")
    public void i_open_book(String string) {
        bp.searchBar.sendKeys(string + Keys.ENTER);
        expected = new ArrayList<>(Arrays.asList(bp.bookN.getText(), bp.authorN.getText(), bp.yearN.getText()));
    }
    @Then("book information must match the Database")
    public void book_information_must_match_the_database() {
        DB_Util.runQuery("select name, author,year from books where name='Chordeiles minor'");
        actual = new ArrayList<>(DB_Util.getRowDataAsList(1));
        System.out.println(expected + " = " + actual);
        Assert.assertEquals(expected, actual);
    }


}
