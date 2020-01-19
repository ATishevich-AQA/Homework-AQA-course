package Mail.ru;

import Database.DataBaseConnection;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;

public class SendMessageSteps {

    private static final String MAIN_URL = "http://mail.ru";
    private static final String loginField = "//*[@id='mailbox:login']";
    private static final String LOGIN = DataBaseConnection.getDataBaseValue("login");
    private static final String inputPasswordButton = "//*[@id='mailbox:submit']/input";
    private static final String passwordField = "//input [@id='mailbox:password']";
    private static final String PASSWORD = DataBaseConnection.getDataBaseValue("password");
    private static final String inputButton = "//*[@id='mailbox:submit']/input";
    private static final String SUMMARYFIELD = "/html/body/div[16]/div[2]/div/div[1]/div[2]/div[3]/div[3]/div[1]/div[2]" +
            "/div/input";
    private static final String SendEmailTo = "/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[2]/div/div/div[1]" +
            "/div/div[2]/div/div/label/div/div/input";
    private static final String address = "alexalex.191@mail.ru";
    private static final String SENDMESSAGE = "/html/body/div[15]/div[2]/div/div[2]/div[1]/span[1]/span";
    private static final String EMPTY_MESSAGE_POPUP = "/html/body/div[16]/div/div/div[2]/button[1]";
    private static final String NEWMESSAGE = "//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/div[1]/div/div/div/" +
            "div[1]/div";
    private WebDriver webDriver;

    public void LoginSteps() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jbUser\\Desktop\\New folder\\Task8\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Given("^I logged successfully$")
    public void loadMainPage() {
        LoginSteps();
        webDriver.get(MAIN_URL);
        checkThatDisplayed(loginField);
        sendKey(loginField, LOGIN);
        findClickNoWait(inputPasswordButton);
        sendKey(passwordField, PASSWORD);
        findClickNoWait(inputButton);
        webDriver.manage().window().maximize();
    }

    @When("^I Click new message$")
    public void newMessage() {
        findClick(NEWMESSAGE);
    }

    @When("^I Input valid summary and email addresses$")
    public void inputEmailData() {
        sendKey(SUMMARYFIELD, "New login -" + LOGIN);
        sendKey(SendEmailTo, address);
    }

    @When("^I click sent message$")
    public void clickSendMessage() {
        findClick(SENDMESSAGE);
    }

    @Then("^Message is sent$")
    public void notificationDisplayed() {
        checkThatDisplayed(EMPTY_MESSAGE_POPUP);
    }

    @After("@SendMessage")
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
        ;
    }
}