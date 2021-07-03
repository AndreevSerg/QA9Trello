package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    WebDriver driver;
    public static String PASSWORD = "CFDSGvcds!v43_4";
    public static String LOGIN = "andreev.s@gmail.com";

    @BeforeMethod
    public void startUp() {
        //Изменение языка интерфейса тестируемой страницы
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("lang=" + "rus" );
        //options.addArguments("lang=" + "eng" );
        //driver = new ChromeDriver(options);
        driver = new ChromeDriver();
        driver.get("https://trello.com/");
    }

    @AfterMethod()
    public void tearDown(){
        driver.close();
    }

    public void editField(WebElement field, String value) {
        field.click();
        field.sendKeys(value);
    }

    public void waitUntilElementIsClickable(By locator, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementTextIs(By locator, String text, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.textToBePresentInElementLocated(locator,text));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsVisible(By locator, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilAllElementsArePresent(By locator, int time){
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsInvisible(By locator, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

