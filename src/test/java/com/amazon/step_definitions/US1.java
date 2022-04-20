package com.amazon.step_definitions;

import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class US1 {

    int expectedIDsCount, distinctIDsCount;
    List<String> expectedList;

    @Given("Establish the database connection")
    public void establish_the_database_connection() {
        DB_Util.createConnection(ConfigurationReader.getProperty("url"), ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
    }
    @When("Execute query to get all IDs from users")
    public void execute_query_to_get_all_i_ds_from_users() {
        DB_Util.runQuery("SELECT count('id') FROM users");
        expectedIDsCount = Integer.parseInt(DB_Util.getFirstRowFirstColumn());
        System.out.println("expectedIDsCount = " + expectedIDsCount);
    }
    @Then("verify all users has unique ID")
    public void verify_all_users_has_unique_id() {
        DB_Util.runQuery("SELECT DISTINCT count('id') FROM users");
        distinctIDsCount = Integer.parseInt(DB_Util.getFirstRowFirstColumn());
        Assertions.assertEquals(expectedIDsCount, distinctIDsCount);
    }

    @When("Execute query to get all columns")
    public void execute_query_to_get_all_columns() {
        DB_Util.runQuery("SELECT * FROM users");
        expectedList = DB_Util.getAllColumnNamesAsList();
    }
    @Then("verify the below columns are listed in result")
    public void verify_the_below_columns_are_listed_in_result(List<String> actualList) {
        System.out.println("actualList = " + actualList);
        System.out.println("expectedList = " + expectedList);
        Assertions.assertEquals(expectedList, actualList);
    }
}
