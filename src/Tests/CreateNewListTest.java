package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CreateNewListTest extends TestBase{

    String password1 = "CFDSGvcds!v43_4";

    @Test
    public void newListCreation() throws InterruptedException {

        driver.findElement(By.cssSelector(".text-primary")).click();
        Thread.sleep(3000);

        WebElement emailField = driver.findElement(By.id("user"));
        emailField.click();
        emailField.sendKeys("andreev.s@gmail.com");

        driver.findElement(By.id("login")).click();
        Thread.sleep(2000);

        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.click();
        password.sendKeys(password1);
        password.submit();
        Thread.sleep(20000);
       // Thread.sleep(20000);

        //a[@data-test-id='home-team-boards-tab']//span[text() = "Boards"] - почему не находит????
        WebElement buttonBoards = driver.findElement(By.xpath("//a[@data-test-id='home-team-boards-tab']//span[text() = \"Boards\"]"));
        buttonBoards.click();
        Thread.sleep(10000);

        WebElement findBoardButton = driver.findElement(By.xpath("//a[@class=\"board-tile\"]//div [text()=\"QA Haifa9\"]"));
        findBoardButton.click();
        Thread.sleep(10000);

        WebElement addNewList = driver.findElement(By.cssSelector(".placeholder"));
        addNewList.click();

        WebElement newListNameInput = driver.findElement(By.cssSelector(".list-name-input"));
        newListNameInput.click();
        newListNameInput.sendKeys("New list");
        newListNameInput.submit();



        Thread.sleep(5000);
    }

}
