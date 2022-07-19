package com.searchmodule.tests;

import com.searchmodule.pages.SearchPage;
import com.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
   @Parameters({"searchKeyword"})
    public void search(String searchKeyword) {
         var searchPage= new SearchPage(driver);
         searchPage.goTo();
         searchPage.doSearch(searchKeyword);
         searchPage.goToVideos();
         int size=searchPage.getResult();
        Assert.assertTrue(size>0,"No search result");
    }

}
