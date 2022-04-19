package com.amazon.step_definitions;

import com.amazon.pages.BooksPage;
import com.amazon.utilities.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class US6 {

    List<String> actual;
    List<String> expected;
    BooksPage bp = new BooksPage();

    @When("I take all book categories in UI")
    public void i_take_all_book_categories_in_ui() {
        Select select = new Select(bp.dropDown);
        List<WebElement> list = select.getOptions();
        expected = new ArrayList<>();
        for (WebElement each : list) {
            expected.add(each.getText());
        }
        expected.removeIf(p->p.equalsIgnoreCase("all"));
    }
    @When("I execute a query to get book categories")
    public void i_execute_a_query_to_get_book_categories() {
        DB_Util.runQuery("select name from book_categories");
        actual = DB_Util.getColumnDataAsList(1);
    }
    @Then("verify book categories must match the book_categories table from DB.")
    public void verify_book_categories_must_match_the_book_categories_table_from_db() {
        System.out.println(expected + " = " + actual);
        Assert.assertEquals(expected, actual);
    }


}
