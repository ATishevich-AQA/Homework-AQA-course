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

public class SetFlagSteps {
    private static final String MAIN_URL = "http://mail.ru";
    private static final String loginField = "//*[@id='mailbox:login']";
    private static final String LOGIN = DataBaseConnection.getDataBaseValue("login");
    private static final String inputPasswordButton = "//*[@id='mailbox:submit']/input";
    private static final String passwordField = "//input [@id='mailbox:password']";
    private static final String PASSWORD = DataBaseConnection.getDataBaseValue("password");
    private static final String inputButton = "//*[@id='mailbox:submit']/input";
    private static final String firstEmailInListFlag = "//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/div[2]/div/" +
            "div/div/div/div/div[1]/div/div/div/a[1]/div[4]/div/div[2]/button";
    private static final String secondEmailInListFlag = "//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/div[2]/div/" +
            "div/div/div/div/div[1]/div/div/div/a[2]/div[4]/div/div[2]/button";
    private static final String thirdEmailInListFlag = "//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/div[2]/div/" +
            "div/div/div/div/div[1]/div/div/div/a[3]/div[4]/div/div[2]/button";
    private static final String flagOffToolTip = "//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div/" +
            "div/div/div[1]/div/div/div/a[5]/div[4]/div/div[2]/button";
    private WebDriver webDriver;

    public void LoginSteps() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jbUser\\Desktop\\New folder\\Task8\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Given("^I passed authorization successfully$")
    public void loadMainPage() throws Throwable {
        LoginSteps();
        webDriver.get(MAIN_URL);
        checkThatDisplayed(loginField);
        sendKey(loginField, LOGIN);
        findClickNoWait(inputPasswordButton);
        sendKey(passwordField, PASSWORD);
        findClickNoWait(inputButton);
        webDriver.manage().window().maximize();
    }

    @When("^I set flag ON for first three emails from the list$")
    public void setFlagON() throws InterruptedException {
        webDriver.manage().window().maximize();
        findClick(firstEmailInListFlag);
        findClick(secondEmailInListFlag);
        findClick(thirdEmailInListFlag);
    }

    @When("^I set flag OFF for first three emails from the list$")
    public void setFlagOff() {
        findClick(firstEmailInListFlag);
        findClick(secondEmailInListFlag);
        findClick(thirdEmailInListFlag);
    }

    @Then("^No emails with flag ON$")
    public void NoEmailsWithFlagOn() {
        checkThatDisplayed(flagOffToolTip);
    }

    @After("@SetFlag")
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