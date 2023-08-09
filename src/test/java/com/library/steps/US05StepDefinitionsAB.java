package com.library.steps;

import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US05StepDefinitionsAB {

    @Given("Establish the database connection AB")
    public void establish_the_database_connection_ab() {
        System.out.println("Database connection handled in Hooks class");
    }
    @When("I execute query to find most popular book genre AB")
    public void i_execute_query_to_find_most_popular_book_genre_ab() {

        //Run query
        String query = "select bc.name, count(bb.id)\n" +
                "from book_borrow bb\n" +
                "         join books b on bb.book_id = b.id\n" +
                "         join book_categories bc on bc.id = b.book_category_id\n" +
                "group by bc.name order by count(bb.id) desc;";

        DB_Util.runQuery(query);
    }
    @Then("verify {string} is the most popular book genre. AB")
    public void verify_is_the_most_popular_book_genre_ab(String string) {

        //Get result, assert it is the correct one, and print
        String actualResult = DB_Util.getFirstRowFirstColumn();

        Assert.assertEquals(actualResult, string);
        System.out.println("Most popular book category: "+actualResult);
    }

}
