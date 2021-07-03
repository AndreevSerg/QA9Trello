package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests extends TestBase {
    @BeforeMethod
    public void initTests() {
        //Thread.sleep(5000);
        waitUntilElementIsClickable(By.cssSelector(".text-primary"), 40);
        //click 'Log in' button
        System.out.println("Log in button name: " + driver.findElement(By.cssSelector(".text-primary")));
        driver.findElement(By.cssSelector(".text-primary")).click();
        //Thread.sleep(3000);
        waitUntilElementIsClickable(By.id("login"), 10);

    }

    @Test
    public void negativeLogin() {
        //fill in email field
        WebElement emailField = driver.findElement(By.id("user"));
        editField(emailField,"email");
        //fill in password field
        WebElement passwordField = driver.findElement(By.id("password"));
       editField(passwordField, PASSWORD);
        //press log in button
        driver.findElement(By.id("login")).click();
        //Thread.sleep(3000);
        waitUntilElementIsVisible(By.cssSelector("p.error-message"), 10);
        //Output error message
        /*System.out.println("Error message: " + driver
                .findElements(By.cssSelector("p.error-message")).get(0).getText());
            Устарело
            */
        Assert.assertEquals(driver
                .findElements(By.cssSelector("p.error-message")).get(0).getText(),
                "Аккаунта с таким именем пользователя не существует", "The error message is not correct");

    }

    @Test(enabled = false)
    public void loginTest() throws InterruptedException {

        driver.findElement(By.cssSelector("[class = 'btn btn-sm btn-link text-primary']")).click();
        Thread.sleep(2000);

        WebElement emailLogin = driver.findElement(By.xpath("//input[@id='user']"));
        emailLogin.click();
        emailLogin.sendKeys(LOGIN);
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("#login")).click();
        Thread.sleep(3000);

        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.click();
        password.sendKeys(PASSWORD);
        password.submit();
        //   driver.findElement(By.cssSelector("#login-submit")).click();
        Thread.sleep(5000);

      /*  System.out.println("Name of the element is: " + driver
                .findElements(By.xpath("(//button[@data-test-id='header-boards-menu-button']/span)[2]")).get(0).getText());
        Устарело
        */

        Assert.assertEquals(driver
                .findElements(By.xpath("(//button[@data-test-id='header-boards-menu-button']/span)[2]")).get(0).getText(), "Boards"
        , "Name of button is not 'Boards'");
        Thread.sleep(3000);
    }

    @Test
    public void positiveLogin() throws InterruptedException {
        // fill in email field
        WebElement emailField = driver.findElement(By.id("user"));
        editField(emailField, LOGIN);
        waitUntilElementIsClickable(By.xpath("//input[@value = 'Войти с помощью Atlassian']"), 5);
        WebElement loginAsAttl = driver.findElement(By.xpath("//input[@value = 'Войти с помощью Atlassian']"));

        // press 'Log in with Atlassian' button
        loginAsAttl.click();

        waitUntilElementIsClickable(By.cssSelector("#password"), 5);
        WebElement passwordField = driver.findElement(By.cssSelector("#password"));
        editField(passwordField, PASSWORD);
        //  driver.findElement(By.id("login-submit")).click();
        waitUntilElementIsClickable(By.id("login-submit"), 5);
        driver.findElement(By.id("login-submit")).click();
        waitUntilElementIsClickable(By.xpath("//button[@data-test-id='header-boards-menu-button']/."),30);

        //   System.out.println("Name of the element is: "
        //          + driver.findElement(By.xpath("//button[@data-test-id='header-boards-menu-button']/.")).getText());
        Assert.assertEquals(driver.findElement(By.xpath("//button[@data-test-id='header-boards-menu-button']/.")).getText(), "Boards",
                "Name of the button is not 'Boards'");

    }

    @Test(enabled = false)
    public void newListCreatingTest() throws InterruptedException {
        driver.findElement(By.cssSelector(".text-primary")).click();
        Thread.sleep(3000);

        WebElement emailField = driver.findElement(By.id("user"));
        emailField.click();
        emailField.sendKeys(LOGIN);
        Thread.sleep(2000);

        driver.findElement(By.id("login")).click();
        Thread.sleep(3000);

        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.click();
        password.sendKeys(PASSWORD);
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
        nameListField.sendKeys("New test List");
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

