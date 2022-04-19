package com.amazon.step_definitions;

import com.amazon.utilities.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US3 {

    String actual = "";

    @When("I execute a query to find the most popular book genre")
    public void i_execute_a_query_to_find_the_most_popular_book_genre() {
        DB_Util.runQuery("select bc.name,count(*) from book_borrow bb inner join books b on bb.book_id = b.id inner join book_categories bc on b.book_category_id=bc.id group by name order by 2 desc;");
        actual = DB_Util.getFirstRowFirstColumn(); //Classic
    }
    @Then("verify that Classic is the most popular book genre")
    public void verify_that_classic_is_the_most_popular_book_genre() {
        String expected = "Classic";
        System.out.println(expected+" = " + actual);
        Assert.assertEquals(expected, actual);
    }


}
