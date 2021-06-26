package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CurrentBoardTests extends TestBase{

    String password1 = "CFDSGvcds!v43_4";

    @BeforeMethod
    public void initTests() throws InterruptedException {
        driver.findElement(By.cssSelector(".text-primary")).click();
        Thread.sleep(3000);

        WebElement emailField = driver.findElement(By.id("user"));

        editField(emailField, "andreev.s@gmail.com");

        driver.findElement(By.id("login")).click();
        Thread.sleep(2000);

        WebElement password = driver.findElement(By.cssSelector("#password"));

        editField(password, password1);

        password.submit();
        Thread.sleep(20000);
        //Thread.sleep(20000);

        WebElement buttonBoards = driver.findElement(By.xpath("//a[@data-test-id='home-team-boards-tab']//span[text() = \"Boards\"]"));
        buttonBoards.click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//a[@class=\"board-tile\"]//div [text()=\"QA Haifa9\"]")).click();
        Thread.sleep(5000);
    }

    @Test
    public void newListCreationTest() throws InterruptedException {



        WebElement addNewList = driver.findElement(By.cssSelector(".placeholder"));
        addNewList.click();

        WebElement newListNameInput = driver.findElement(By.cssSelector(".list-name-input"));

        editField(newListNameInput, "New list");
        newListNameInput.submit();
        Thread.sleep(5000);
    }

    @Test
    public void addNewCardTest() throws InterruptedException {
    //press 'Add a card' ('Add another card')
        WebElement addCardButton = driver.findElement(By.cssSelector(".card-composer-container"));
        addCardButton.click();
        // fill in card title
        WebElement cardTitleField = driver.findElement(By.cssSelector(".js-card-title"));
        editField(cardTitleField, "card title");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".js-add-card")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".js-cancel")).click();
        Thread.sleep(3000);

    }
    //HW-09
    @Test
    public void deleteFirstList() throws InterruptedException {

        if((driver.findElements(By.cssSelector(".js-list-content")).isEmpty()))
        {
            WebElement addNewList = driver.findElement(By.cssSelector(".placeholder"));
            addNewList.click();

            WebElement newListNameInput = driver.findElement(By.cssSelector(".list-name-input"));

            editField(newListNameInput, "New list");
            newListNameInput.submit();
            Thread.sleep(5000);

            firstListDeleting();
        }
        else{
            firstListDeleting();
        }
        Thread.sleep(3000);


    }

        private void firstListDeleting() throws InterruptedException {
        List<WebElement> settingButtons = driver.findElements(By.cssSelector(".list-header-extras"));
        settingButtons.get(0).click();
        Thread.sleep(1000);
        WebElement deleteList = driver.findElement(By.cssSelector(".js-close-list"));
        deleteList.click();
        Thread.sleep(3000);
    }

    //HW-10
    @Test
    public void copyList() throws InterruptedException {
        if((driver.findElements(By.cssSelector(".js-list-content")).isEmpty()))
        {
            WebElement addNewList = driver.findElement(By.cssSelector(".placeholder"));
            addNewList.click();

            WebElement newListNameInput = driver.findElement(By.cssSelector(".list-name-input"));

            editField(newListNameInput, "New list");
            newListNameInput.submit();
            Thread.sleep(5000);

            copyFirstList();
        }
        else{
            copyFirstList();
        }
        Thread.sleep(3000);

    }

    private void copyFirstList() throws InterruptedException {
        List<WebElement> settingButtons = driver.findElements(By.cssSelector(".list-header-extras"));
        settingButtons.get(0).click();
        Thread.sleep(1000);
        WebElement copyList = driver.findElement(By.cssSelector(".js-copy-list"));
        copyList.click();
        driver.findElement(By.cssSelector(".js-submit")).click();
        Thread.sleep(3000);
    }


    private void editField(WebElement field, String value) {
        field.click();
        field.sendKeys(value);
    }

}
