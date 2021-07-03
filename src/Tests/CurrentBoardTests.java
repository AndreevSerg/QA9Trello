package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CurrentBoardTests extends TestBase{

    @BeforeMethod
    public void initTests() throws InterruptedException {
        waitUntilElementIsClickable(By.cssSelector(".text-primary"), 40);
        // click on 'Log in' button
        driver.findElement(By.cssSelector(".text-primary")).click();
        waitUntilElementIsClickable(By.id("login"),10);
        // fill in email field
        WebElement emailField = driver.findElement(By.id("user"));
        editField(emailField, LOGIN);
        waitUntilElementIsClickable(By.xpath("//input[@value = 'Войти с помощью Atlassian']"), 5);
        WebElement loginAsAttl = driver.findElement(By.xpath("//input[@value = 'Войти с помощью Atlassian']"));

        // press 'Log in with Atlassian' button
        loginAsAttl.click();

        waitUntilElementIsClickable(By.id("password"), 5);
        WebElement password = driver.findElement(By.cssSelector("#password"));

        editField(password, PASSWORD);

        password.submit();
        waitUntilElementIsClickable(By.xpath("//button[@data-test-id='header-boards-menu-button']/."),30);


        WebElement buttonBoards = driver.findElement(By.xpath("//a[@data-test-id='home-team-boards-tab']//span[text() = \"Boards\"]"));
        buttonBoards.click();
        Thread.sleep(2000);
        waitUntilElementIsClickable(By.xpath("//a[@class=\"board-tile\"]//div [text()=\"QA Haifa9\"]"), 10);

        driver.findElement(By.xpath("//a[@class=\"board-tile\"]//div [text()=\"QA Haifa9\"]")).click();
        //Thread.sleep(2000);

       waitUntilElementIsClickable(By.cssSelector(".placeholder"), 20);
        waitUntilAllElementsArePresent(By.cssSelector(".js-list-content"),10);
    }

    @Test
    public void newListCreationTest() throws InterruptedException {


        List<WebElement> lists = driver.findElements(By.cssSelector(".js-list-content"));
        int size = lists.size();

        WebElement addNewList = driver.findElement(By.cssSelector(".placeholder"));
        addNewList.click();

        WebElement newListNameInput = driver.findElement(By.cssSelector(".list-name-input"));

        editField(newListNameInput, "New list");

        newListNameInput.submit();

        List<WebElement> lists1 = driver.findElements(By.cssSelector(".js-list-content"));
        int size1 = lists1.size();

        Assert.assertEquals(size1, size+1, "List haven't created");
    }

    @Test
    public void addNewCardTest(){
    //press 'Add a card' ('Add another card')
        List<WebElement> titles = driver.findElements(By.cssSelector(".list-card-title.js-card-name"));
        int size = titles.size();

        WebElement addCardButton = driver.findElement(By.cssSelector(".card-composer-container"));
        addCardButton.click();
        // fill in card title
        WebElement cardTitleField = driver.findElement(By.cssSelector(".js-card-title"));
        editField(cardTitleField, "New card title");

        driver.findElement(By.cssSelector(".js-add-card")).click();

        driver.findElement(By.cssSelector(".js-cancel")).click();

        List<WebElement> titles1 = driver.findElements(By.cssSelector(".list-card-title.js-card-name"));
        int size1 = titles1.size();

        Assert.assertEquals(size1, size+1, "Title haven't created");

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
        }
            firstListDeleting();

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

        }
            copyFirstList();

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

    /*//HW-12
    @Test
    public void deleteListByName() throws InterruptedException {

        if((driver.findElement(By.xpath("//h2[text()=\"Monitor test\"]")).isEmpty()))
        {
            WebElement addNewList = driver.findElement(By.cssSelector(".placeholder"));
            addNewList.click();

            WebElement newListNameInput = driver.findElement(By.cssSelector(".list-name-input"));

            editField(newListNameInput, "Monitor test");
            newListNameInput.submit();
        }
        nameListDeleting();

    }

    private void nameListDeleting() {
        WebElement settingButtons =  driver.findElement(By.xpath("//h2[text()=\"Monitor test\"]"));
        settingButtons.click();
        WebElement deleteList = driver.findElement(By.cssSelector(".js-close-list"));
        deleteList.click();
    }
*/
}
