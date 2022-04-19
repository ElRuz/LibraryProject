package com.amazon.step_definitions;

import com.amazon.utilities.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US4 {

    String actual;

    @When("I execute a query to find the most popular user")
    public void i_execute_a_query_to_find_the_most_popular_user() {
        DB_Util.runQuery("select full_name,count(*) from users u inner join book_borrow bb on u.id = bb.user_id group by full_name order by 2 desc");
        actual = DB_Util.getFirstRowFirstColumn(); // Test Student 1
    }
    @Then("verify Test Student [number] is the user who reads the most")
    public void verify_test_student_number_is_the_user_who_reads_the_most() {
        String expected = "Test Student 1";
        System.out.println(expected + " = " + actual);
        Assert.assertEquals(expected, actual);
    }



}
