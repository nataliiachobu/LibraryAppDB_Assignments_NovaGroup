package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US06StepDefinitionsAB {

    LoginPage loginPage = new LoginPage();
    BookPage bookPage = new BookPage();

    @Given("the {string} on the home page")
    public void the_on_the_home_page(String string) {
        //login as the specified user
        loginPage.login(string);
        BrowserUtil.waitFor(3);
    }

    @Given("the user navigates to {string} page")
    public void the_user_navigates_to_page(String string) {

        //Navigate to the specified page using the built in method
        bookPage.navigateModule(string);
        BrowserUtil.waitFor(3);

    }

    @When("the librarian click to add book")
    public void the_librarian_click_to_add_book() {
        //Click the Add Book button on the books page
        bookPage.addBook.click();
        BrowserUtil.waitFor(3);
    }

    @When("the librarian enter book name {string}")
    public void the_librarian_enter_book_name(String string) {
        bookPage.bookName.sendKeys(string);
    }

    @When("the librarian enter ISBN {string}")
    public void the_librarian_enter_isbn(String string) {
        bookPage.isbn.sendKeys(string);
    }
    @When("the librarian enter year {string}")
    public void the_librarian_enter_year(String string) {
        bookPage.year.sendKeys(string);
    }
    @When("the librarian enter author {string}")
    public void the_librarian_enter_author(String string) {
        bookPage.author.sendKeys(string);
    }
    @When("the librarian choose the book category {string}")
    public void the_librarian_choose_the_book_category(String string) {
        BrowserUtil.selectOptionDropdown(bookPage.categoryDropdown, string);
        BrowserUtil.waitFor(3);
    }
    @When("the librarian click to save changes")
    public void the_librarian_click_to_save_changes() {

        bookPage.saveChanges.click();
    }
    @Then("verify {string} message is displayed")
    public void verify_message_is_displayed(String string) {

        Assert.assertEquals(bookPage.toastMessage.getText(), string);
    }
    @Then("verify {string} information must match with DB")
    public void verify_information_must_match_with_db(String string) {

        //Store query
        String query = "select name from books where name = '"+string+"';";


        //Run query using utility class
        DB_Util.runQuery(query);

        //get first row first column results and print
        String actualResult = DB_Util.getFirstRowFirstColumn();
        System.out.println("actualResult = " + actualResult);

        //Complete assertion
        Assert.assertEquals(actualResult, string);

    }

}
