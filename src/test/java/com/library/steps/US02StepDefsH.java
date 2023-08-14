package com.library.steps;

import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.*;

import org.junit.Assert;

public class US02StepDefsH {

    //US02

    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage=new DashBoardPage();
  String actualBorrowedBook;
    @When("the librarian gets borrowed books number")
    public void the_librarian_gets_borrowed_books_number() {
       // BrowserUtil.waitForVisibility(dashBoardPage.borrowedBooksNumber,10);
       BrowserUtil.waitFor(3);
       actualBorrowedBook = dashBoardPage.borrowedBooksNumber.getText();

        System.out.println("actualBorrowedBook = " + actualBorrowedBook);

        System.out.println("dashBoardPage.getModuleCount(\"Borrowed Books\") = " + dashBoardPage.getModuleCount("Borrowed Books"));

    }

    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {

        String query = "select count(*) from book_borrow\n" +
                "where is_returned=0";

        DB_Util.runQuery(query);

        String expectedBorrowedBook = DB_Util.getFirstRowFirstColumn();
        System.out.println("expectedBorrowedBook = " + expectedBorrowedBook);

        Assert.assertEquals(expectedBorrowedBook,actualBorrowedBook);

    }
}
