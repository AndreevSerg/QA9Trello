package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePageHelper;

public class TestBase {

    WebDriver driver;

    public static String PASSWORD = "CFDSGvcds!v43_4";
    public static String LOGIN = "andreev.s@gmail.com";

    HomePageHelper homePage;

    @BeforeMethod
    public void startUp() {
        //Изменение языка интерфейса тестируемой страницы
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("lang=" + "rus" );
        options.addArguments("lang=" + "eng");
        driver = new ChromeDriver(options);
        //driver = new ChromeDriver();
        driver.get("https://trello.com/");
        homePage = PageFactory.initElements(driver,HomePageHelper.class);
        homePage.waitUntilPageIsLoaded();
    }

    @AfterMethod()
    public void tearDown(){

        driver.quit();
    }


}

