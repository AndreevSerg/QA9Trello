package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePageHelper;

public class HomePageTests extends TestBase{
    HomePageHelper homePage;


        @BeforeMethod
        public void initTest(){
        homePage = new HomePageHelper(driver);
        homePage.waitUntilPageIsLoaded();
    }

    @Test
    public void verifyApplTest(){
        Assert.assertTrue(homePage.isCorrectPage());
    }

}
