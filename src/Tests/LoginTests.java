package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    String password1 = "CFDSGvcds!v43_4";


    @Test
    public void negativeLogin() throws InterruptedException {

        driver.findElement(By.cssSelector(".text-primary")).click();
        Thread.sleep(3000);
        //fill in email field
        WebElement emailField = driver.findElement(By.id("user"));
        emailField.click();
        emailField.sendKeys("email");
        //fill in password field
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.sendKeys("password");
        //press log in button
        driver.findElement(By.id("login")).click();
        Thread.sleep(3000);
        System.out.println("Error message: " + driver.findElements(By.cssSelector("p.error-message")).get(0).getText());

    }

    @Test
    public void loginTest() throws InterruptedException {

        driver.findElement(By.cssSelector("[class = 'btn btn-sm btn-link text-primary']")).click();
        Thread.sleep(2000);

        WebElement emailLogin = driver.findElement(By.xpath("//input[@id='user']"));
        emailLogin.click();
        emailLogin.sendKeys("andreev.s@gmail.com");
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("#login")).click();
        Thread.sleep(3000);

        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.click();
        password.sendKeys(password1);
        password.submit();
        //   driver.findElement(By.cssSelector("#login-submit")).click();
        Thread.sleep(5000);

        System.out.println("Name of the element is: " + driver.findElements(By.cssSelector("[class=\"_3Ow-m_R7rIILjd\"]")).get(0).getText());
        Thread.sleep(3000);
    }

    @Test
    public void positiveLogin() throws InterruptedException {
        driver.findElement(By.cssSelector(".text-primary")).click();
        Thread.sleep(3000);

        WebElement emailField = driver.findElement(By.id("user"));
        emailField.click();
        emailField.sendKeys("andreev.s@gmail.com");
        Thread.sleep(2000);

        driver.findElement(By.id("login")).click();
        Thread.sleep(3000);

        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.click();
        password.sendKeys(password1);
        password.submit();
        //  driver.findElement(By.id("login-submit")).click();
        Thread.sleep(5000);

        //   System.out.println("Name of the element is: "
        //          + driver.findElement(By.xpath("//button[@data-test-id='header-boards-menu-button']/.")).getText());
        Thread.sleep(3000);

    }

    @Test
    public void newListCreatingTest() throws InterruptedException {
        driver.findElement(By.cssSelector(".text-primary")).click();
        Thread.sleep(3000);

        WebElement emailField = driver.findElement(By.id("user"));
        emailField.click();
        emailField.sendKeys("andreev.s@gmail.com");
        Thread.sleep(2000);

        driver.findElement(By.id("login")).click();
        Thread.sleep(3000);

        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.click();
        password.sendKeys(password1);
        password.submit();
        Thread.sleep(20000);
        //  go to the 'Boards' tab
        driver.findElement(By.xpath("//a[@data-test-id = 'home-team-boards-tab']")).click();
        Thread.sleep(3000);
        // open 'QA Haifa9' board
        driver.findElement(By.xpath("//a[@class = 'board-tile'][.//div[@title='QA Haifa9']]")).click();
        Thread.sleep(3000);
        // press 'Add list button'
        WebElement createListButton = driver.findElement(By.cssSelector(".placeholder"));
        createListButton.click();
        // enter name of the list
        WebElement nameListField = driver.findElement(By.cssSelector("input[name='name']"));
        nameListField.click();
        nameListField.sendKeys("Test List");
        // click 'Add list' button
        WebElement saveListButton = driver.findElement(By.cssSelector(".js-save-edit"));
        saveListButton.click();
        // click 'x' button to cancel new list creating
        Thread.sleep(2000);
        WebElement cancelListCreatingButton = driver.findElement(By.cssSelector(".js-cancel-edit"));
        cancelListCreatingButton.click();
        Thread.sleep(2000);
    }
}

