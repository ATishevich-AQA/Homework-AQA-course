package Mail.ru;

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

public class SendMessageSteps {
    private static final String MAIN_URL = "http://mail.ru";
    private static final String loginField = "//*[@id='mailbox:login']";
    private static final String LOGIN = "alexalex.191@mail.ru";
    private static final String inputPasswordButton = "//*[@id='mailbox:submit']/input";
    private static final String passwordField = "//input [@id='mailbox:password']";
    private static final String PASSWORD = "lavZa123!";
    private static final String inputButton = "//*[@id='mailbox:submit']/input";
    private static final String SUMMARYFIELD = "/html/body/div[16]/div[2]/div/div[1]/div[2]/div[3]/div[3]/div[1]/div[2]" +
            "/div/input";
    private static final String SendEmailTo = "/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[2]/div/div/div[1]" +
            "/div/div[2]/div/div/label/div/div/input";
    private static final String address = "alexalex.191@mail.ru";
    private static final String SENDMESSAGE = "/html/body/div[15]/div[2]/div/div[2]/div[1]/span[1]/span";
    private static final String EMPTY_MESSAGE_POPUP = "/html/body/div[16]/div/div/div[2]/button[1]";
    private WebDriver webDriver;

    public void LoginSteps() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jbUser\\Desktop\\New folder\\Task8\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Given("^I logged successfully$")
    public void loadMainPage() throws Throwable {
        LoginSteps();
        webDriver.get(MAIN_URL);
        sendKey(loginField, LOGIN);
        findClickNoWait(inputPasswordButton);
        sendKey(passwordField, PASSWORD);
        findClickNoWait(inputButton);
    }

    @When("^I Click new message$")
    public void newMessage() {
        webDriver.manage().window().maximize();
        findClick("//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div");
    }

    @When("^I Input valid summary and email addresses$")
    public void inputEmailData() {
        sendKey(SUMMARYFIELD, "Task 12");
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

    public void checkThatDisplayed(String xpath) {
        WebElement checkThatDisplayed = (new WebDriverWait(webDriver, 15)).until((ExpectedConditions.
                elementToBeClickable(By.xpath(xpath))));
    }

    public void findClick(String s) {
        WebElement findClick = (new WebDriverWait(webDriver, 15)).until((ExpectedConditions.
                elementToBeClickable(By.xpath(s))));
        findClick.click();
    }

    public void sendKey(String xpath, String value) {
        webDriver.findElement(By.xpath(xpath)).sendKeys(value);
    }

    public void findClickNoWait(String element) {
        webDriver.findElement(By.xpath(element)).click();
    }

    @After
    public void afterClass() {
        webDriver.quit();
    }
}