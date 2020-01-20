package Mail.ru;

import Database.DataBaseConnection;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    private static final String loginField = "//*[@id='mailbox:login']";
    private static final String LOGIN = DataBaseConnection.getDataBaseValue("login");
    private static final String inputPasswordButton = "//*[@id='mailbox:submit']/input";
    private static final String passwordField = "//input [@id='mailbox:password']";
    private static final String PASSWORD = DataBaseConnection.getDataBaseValue("password");
    private static final String inputButton = "//*[@id='mailbox:submit']/input";
    private static final String MAIN_URL = "http://mail.ru";
    private static final String LOGOUT = "//*[@id='PH_logoutLink']";
    private WebDriver webDriver;

    public void LoginSteps() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jbUser\\Desktop\\New folder\\Task8\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Given("^I on mail.ru page$")
    public void loginIntoMailBox() {
        LoginSteps();
        webDriver.manage().window().maximize();
        webDriver.get(MAIN_URL);
    }

    @When("^I input valid credentials$")
    public void inputCredentials() {
        checkThatDisplayed(loginField);
        sendKey(loginField, LOGIN);
        findClickNoWait(inputPasswordButton);
        sendKey(passwordField, PASSWORD);
        findClickNoWait(inputButton);
    }

    @Then("^I see logout link$")
    public void Logout() {
        checkThatDisplayed(LOGOUT);
    }

    @After("@Login")
    public void afterClass() {
        webDriver.quit();
    }

    public void sendKey(String xpath, String value) {
        webDriver.findElement(By.xpath(xpath)).sendKeys(value);
    }

    public void findClickNoWait(String element) {
        webDriver.findElement(By.xpath(element)).click();
    }

    public void checkThatDisplayed(String xpath) {
        WebElement checkThatDisplayed = (new WebDriverWait(webDriver, 15)).until((ExpectedConditions.
                elementToBeClickable(By.xpath(xpath))));
    }

    public void findClick(String xpath) {
        WebElement findClick = (new WebDriverWait(webDriver, 15)).until((ExpectedConditions.
                elementToBeClickable(By.xpath(xpath))));
        findClick.click();
    }
}