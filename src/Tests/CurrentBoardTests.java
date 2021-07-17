package Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPageHelper;
import pages.CurrentBoardPageHelper;
import pages.HomePageHelper;
import pages.LoginPageHelper;

public class CurrentBoardTests extends TestBase{
    HomePageHelper homePage;
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;
    CurrentBoardPageHelper qaHaifa9Board;

    @BeforeMethod
    public void initTests(){

        homePage = PageFactory.initElements(driver, HomePageHelper.class);
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        boardsPage = PageFactory.initElements(driver,  BoardsPageHelper.class);
        qaHaifa9Board = new CurrentBoardPageHelper(driver, "QA Haifa9") ;

        homePage.waitUntilPageIsLoaded();
        loginPage.openPage();
        loginPage.waitUntilPageIsLoaded();
        loginPage.loginAsAttl(LOGIN,PASSWORD);
        boardsPage.waitUntilPageIsLoaded();
        boardsPage.openBoardsMenu();
        qaHaifa9Board.openPage();
        qaHaifa9Board.waitUntilPageIsLoaded();
    }

    @Test
    public void newListCreatingTest()  {
        int beginListsQuantity = qaHaifa9Board.getListsQuantity();
        qaHaifa9Board.addNewList("New");
        int endListsQuantity = qaHaifa9Board.getListsQuantity();
        Assert.assertEquals(endListsQuantity,beginListsQuantity+1,"endListsQuantity is not beginListsQuantity+1");
    }

    @Test
    public void addNewCardTest()  {
        int beginLists = qaHaifa9Board.getListsQuantity();
        if (beginLists == 0){
            qaHaifa9Board.addNewList("ForNewCard");
        }
        int beginCards = qaHaifa9Board.getCardsQuantity();
        qaHaifa9Board.addNewCardToFirstList("card title");
        int endCardsQuantity = qaHaifa9Board.getCardsQuantity();
        Assert.assertEquals(endCardsQuantity,beginCards+1,"endCardsQuantity is not beginCards+1");
    }
    //HW-09
    @Test
    public void deleteFirstList(){
        int beginLists = qaHaifa9Board.getListsQuantity();
        if (beginLists==0){
            qaHaifa9Board.addNewList("ForNewCard");
            beginLists++;
        }
        qaHaifa9Board.archiveFirstList();
        int endLists = qaHaifa9Board.getListsQuantity();
        Assert.assertEquals(beginLists-1,endLists,"beginLists-1 is not endLists");
    }

    //HW-10
    @Test
    public void copyFirstList() {
        int beginLists = qaHaifa9Board.getListsQuantity();
        if (beginLists == 0){
            qaHaifa9Board.addNewList("TestList");
            beginLists++;
        }
        qaHaifa9Board.copyFirstList("Copy");
        int endLists = qaHaifa9Board.getListsQuantity();
        Assert.assertEquals(endLists,beginLists+1, "endLists is not beginLists+1");
    }

    //HW-12
    @Test
    public void deleteListByName() {
        String nameList = "Copy";
        int beginLists = qaHaifa9Board.getListsQuantity();
        int number = qaHaifa9Board.getNumberOfElementWithName(nameList);
        if (number==-1){
            qaHaifa9Board.addNewList("Copy");
            number = beginLists;
            beginLists++;
        }
        qaHaifa9Board.archiveList(number);
        int endLists = qaHaifa9Board.getListsQuantity();
        Assert.assertEquals(beginLists-1,endLists, "beginLists-1 is not endLists");
    }
}
