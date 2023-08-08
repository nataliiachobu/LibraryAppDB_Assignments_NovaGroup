package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.Map;

public class US04_StepDefs_ChristinaG {

    LoginPage loginPage = new LoginPage();
    BookPage bookPage = new BookPage();
    String bookTitle;
    String actualName;
    String actualIsbn;
    String actualYear;
    String actualAuthor;
    String expectedName;
    String expectedIsbn;
    String expectedYear;
    String expectedAuthor;

    @Given("the {string} on the home page")
    public void the_on_the_home_page(String user) {
        loginPage.login(user);
    }
    @Given("the user navigates to {string} page")
    public void the_user_navigates_to_page(String page) {
        bookPage.navigateModule(page);

    }
    @When("the user searches for {string} book")
    public void the_user_searches_for_book(String bookTitle) {
        bookPage.search.sendKeys(bookTitle + Keys.ENTER);
        this.bookTitle = bookTitle;

    }
    @When("the user clicks edit book button")
    public void the_user_clicks_edit_book_button() {
        bookPage.editBook(bookTitle).click();
    }

    @Then("book information must match the Database")
    public void book_information_must_match_the_database() {
        BrowserUtil.waitFor(2);

        actualName = bookPage.bookName.getAttribute("value");
        actualIsbn = bookPage.isbn.getAttribute("value");
        actualYear = bookPage.year.getAttribute("value");
        actualAuthor = bookPage.author.getAttribute("value");

        DB_Util.runQuery("select name, isbn, year, author from books where books.name = '"+bookTitle+"'");

        Map<String, String> bookInfo = DB_Util.getRowMap(1);

        expectedName = bookInfo.get("name");
        expectedIsbn = bookInfo.get("isbn");
        expectedYear = bookInfo.get("year");
        expectedAuthor = bookInfo.get("author");

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedIsbn, actualIsbn);
        Assert.assertEquals(expectedYear, actualYear);
        Assert.assertEquals(expectedAuthor, actualAuthor);
    }

}
