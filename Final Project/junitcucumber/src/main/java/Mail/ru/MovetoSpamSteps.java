package Mail.ru;

import Database.DataBaseConnection;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class MovetoSpamSteps {
    private static final String loginField = "//*[@id='mailbox:login']";
    private static final String LOGIN = DataBaseConnection.getDataBaseValue("login");
    private static final String inputPasswordButton = "//*[@id='mailbox:submit']/input";
    private static final String passwordField = "//input [@id='mailbox:password']";
    private static final String PASSWORD = DataBaseConnection.getDataBaseValue("password");
    private static final String inputButton = "//*[@id='mailbox:submit']/input";
    private static final String NOTSPAMBUTTON = "//*[@id='app-canvas']/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/table"+
            "/tbody/tr/td/div[3]";
    private static final String INBOXMAIL = "//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/div[1]/div/div/div/div" +
            "[2]/div/div[1]/nav/a[1]/div/div[2]/div";
    private static final String INBOXMESSAGE = "//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div/" +
            "div/div/div[1]/div/div/div/a[1]/div[4]/div/div[1]";
    private static final String SetChBox = "//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div/div/" +
            "div/div[1]/div/div/div/a[1]/div[4]/div/div[1]";
    private static final String SpamButton = "//*[@id='app-canvas']/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/table/"  +
            "tbody/tr/td/div[3]";
    private static final String selectEmail = "//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div/"  +
            "div/div/div[1]/div/div/div/a[1]/div[4]/div/div[1]";
    private static final String MAIN_URL = "http://mail.ru";
    private static final String SPAM_FOLDER = "//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/div[1]/div/div/div/"  +
            "div[2]/div/div[1]/nav/a[4]/div/div[2]/div";
    private static final String SPAM_MESSAGE = "//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div/" +
            "div/div";
    private static ChromeDriver webDriver;


    public void LoginSteps() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jbUser\\Desktop\\New folder\\Task8\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Given("^I am on main page$")
    public void loadMainPage() {
        LoginSteps();
        webDriver.get(MAIN_URL);
        checkThatDisplayed(loginField);
        sendKey(loginField, LOGIN);
        findClickNoWait(inputPasswordButton);
        sendKey(passwordField, PASSWORD);
        findClickNoWait(inputButton);
    }

    @When("^Move email into spambox and otherwise$")
    public void moveEmailSpam() {

        findClick(SetChBox);
        findClick(selectEmail);
        checkThatDisplayed(SpamButton);
        findClick(SpamButton);
        webDriver.manage().window().maximize();
        checkThatDisplayed(SPAM_FOLDER);
        findClick(SPAM_FOLDER);
        findClick(selectEmail);
        checkThatDisplayed(NOTSPAMBUTTON);
        findClick(SPAM_MESSAGE);
        findClick(NOTSPAMBUTTON);
        findClick(INBOXMAIL);
    }

    @Then("^Message is moved to spambox$")
    public void notificationDisplayed() {
        webDriver.manage().window().maximize();
        findClick(INBOXMESSAGE);
    }

    @After("@MoveToSpam")
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
        WebElement checkThatDisplayed = (new WebDriverWait(webDriver, 20)).until((ExpectedConditions.
                elementToBeClickable(By.xpath(xpath))));
    }

    public void findClick(String xpath) {
        WebElement findClick = (new WebDriverWait(webDriver, 20)).until((ExpectedConditions.
                elementToBeClickable(By.xpath(xpath))));
        findClick.click();
    }
}