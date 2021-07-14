package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageHelper extends PageBase{

    public LoginPageHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage(){
        //click 'Log in' button
        //Thread.sleep(5000);
        waitUntilElementIsClickable(By.cssSelector(".text-primary"), 40);
        //click 'Log in' button
        //System.out.println("Log in button name: " + driver.findElement(By.cssSelector(".text-primary")));
        driver.findElement(By.cssSelector(".text-primary")).click();
    }
    public void waitUntilPageIsLoaded(){
        waitUntilElementIsClickable(By.id("login"),10);
    }

    public void loginNotAttl(String login, String password){
        fillInEmailField(login);
        fillInPasswordField(password);
        submitLoginNoAttl();
    }

    public String getErrorMessage(){
        waitUntilElementIsVisible(By.cssSelector("p.error-message"), 10);
        //Output error message
        /*System.out.println("Error message: " + driver
                .findElements(By.cssSelector("p.error-message")).get(0).getText());
            Устарело
            */
       return  driver.findElements(By.cssSelector("p.error-message")).get(0).getText();
    }

    public void fillInEmailField(String value) {
        //fill in email field
        WebElement emailField = driver.findElement(By.id("user"));
        editField(emailField,value);
    }

    public void fillInPasswordField(String value) {
        //fill in password field
        WebElement passwordField = driver.findElement(By.id("password"));
        editField(passwordField, value);
    }

    public void submitLoginNoAttl() {
        //press log in button
        driver.findElement(By.id("login")).click();
    }

    public void loginAsAttl(String login, String password){
       fillInEmailField(login);
       pressLoginAttlButton();
       fillInPasswordAttl(password);
       submitLoginAttl();
    }

    public void pressLoginAttlButton() {
        waitUntilElementIsClickable(By.xpath("//input[@value = 'Log in with Atlassian']"), 5);
        WebElement loginAsAttl = driver.findElement(By.xpath("//input[@value = 'Log in with Atlassian']"));

        // press 'Log in with Atlassian' button
        loginAsAttl.click();
    }

    public void fillInPasswordAttl(String volume) {
        waitUntilElementIsClickable(By.cssSelector("#password"), 5);
        WebElement passwordField = driver.findElement(By.cssSelector("#password"));
        editField(passwordField, volume);
    }

    public void submitLoginAttl() {
        //  driver.findElement(By.id("login-submit")).click();
        waitUntilElementIsClickable(By.id("login-submit"), 5);
        driver.findElement(By.id("login-submit")).click();
    }
}
