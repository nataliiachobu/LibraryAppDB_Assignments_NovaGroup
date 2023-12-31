package com.library.steps;

import com.library.pages.BookPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class US03_StepDefinitionsMS {

    BookPage bookPage = new BookPage();
    List<String> categoryNamesUI;
    List<String> categoryNamesDB;


    @When("the user clicks book categories")
    public void the_user_clicks_book_categories() {
        BrowserUtil.waitFor(3);
        categoryNamesUI = BrowserUtil.getAllSelectOptions(bookPage.mainCategoryElement);
        System.out.println(categoryNamesUI);

        categoryNamesUI.remove(0);
        System.out.println(categoryNamesUI);
    }

    @Then("verify book categories must match book_categories table from db")
    public void verify_book_categories_must_match_book_categories_table_from_db() {

        String query = "select name from book_categories";
        DB_Util.runQuery(query);

        categoryNamesDB = DB_Util.getColumnDataAsList(1);
        System.out.println(categoryNamesDB);

        Assert.assertEquals(categoryNamesDB, categoryNamesUI);
    }
}
