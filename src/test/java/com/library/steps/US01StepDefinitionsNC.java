package com.library.steps;

import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class US01StepDefinitionsNC {
    String expectedDataCount;
    String actualDataCount;
    List<String> actualDataColumn;

    @When("Execute query to get all columns")
    public void execute_query_to_get_all_columns() {
        DB_Util.runQuery("select * from users");
        actualDataColumn=DB_Util.getAllColumnNamesAsList();


    }
    @Then("verify the below columns are listed in result")
    public void verify_the_below_columns_are_listed_in_result(List<String> expectedDataColumn) {
        Assert.assertEquals(expectedDataColumn,actualDataColumn);
        System.out.println("actualDataColumn="+actualDataColumn+", "+"expectedDataColumn="+expectedDataColumn);
    }

}
