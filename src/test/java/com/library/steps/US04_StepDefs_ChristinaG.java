package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class US04_StepDefs_ChristinaG {

    LoginPage loginPage = new LoginPage();
    BookPage bookPage = new BookPage();

    @Given("the {string} on the home page")
    public void the_on_the_home_page(String user) {
        loginPage.login(user);
    }
    @Given("the user navigates to {string} page")
    public void the_user_navigates_to_page(String page) {
        bookPage.navigateModule(page);

    }
    @When("the user searches for {string} book")
    public void the_user_searches_for_book(String string) {

    }
    @When("the user clicks edit book button")
    public void the_user_clicks_edit_book_button() {

    }
    @Then("book information must match the Database")
    public void book_information_must_match_the_database() {

    }

}
