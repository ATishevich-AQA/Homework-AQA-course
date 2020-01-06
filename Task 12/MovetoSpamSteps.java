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

public class MovetoSpamSteps {
    private static final String NOTSPAMBUTTON = "//*[@id='app-canvas']/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/table/" +
            "tbody/tr/td/div[3]";
    private static final String INBOXMAIL = "//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[1]/div/div/div/div" +
            "[2]/div/div[1]/nav/a[1]/div/div[2]/div";
    private static final String INBOXMESSAGE = "//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div/" +
            "div/div/div[1]/div/div/div/a[1]/div[4]/div/div[1]";
    private WebDriver webDriver;

    public void LoginSteps() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jbUser\\Desktop\\New folder\\Task8\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("^I am on main page$")
    public void loadMainPage() throws Throwable {
        LoginSteps();
        webDriver.get("https://mail.ru/");
        webDriver.findElement(By.xpath("//*[@id='mailbox:login']")).sendKeys("abuatop_y208@mail.ru");
        webDriver.findElement(By.xpath("//*[@id='mailbox:submit']/input")).click();
        webDriver.findElement(By.xpath("//input [@id='mailbox:password']")).sendKeys("NoKiA6300");
        webDriver.findElement(By.xpath("//*[@id='mailbox:submit']/input")).click();
    }

    @When("^Move email into spambox and otherwise$")
    public void moveEmailSpam() {
        webDriver.findElement(By.xpath("//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div/div/div/" +
                "div[1]/div/div/div/a[1]/div[4]/div/div[1]")).click();
        webDriver.findElement(By.xpath("//*[@id='app-canvas']/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/table/tbody/tr" +
                "/td/div[3]")).click();
        webDriver.manage().window().maximize();
        WebElement clickOnSpamFolder = (new WebDriverWait(webDriver, 10)).until((ExpectedConditions.
                elementToBeClickable(By.xpath("//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/div[1]/div/div/div/" +
                        "div[2]/div/div[1]/nav/a[4]/div/div[2]/div"))));
        clickOnSpamFolder.click();
        WebElement spamMailClick = (new WebDriverWait(webDriver, 10)).until((ExpectedConditions.
                elementToBeClickable(By.xpath("//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div/" +
                        "div/div/div[1]/div/div/div/a[1]/div[4]/div"))));
        spamMailClick.click();
        WebElement notSpamMail = (new WebDriverWait(webDriver, 10)).until((ExpectedConditions.
                elementToBeClickable(By.xpath("//*[@id='app-canvas']/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/table/" +
                        "tbody/tr/td/div[3]"))));
        notSpamMail.click();
        spamFolderSelect();
        firstMessageSelect();
        findClick(NOTSPAMBUTTON);
        findClick(INBOXMAIL);
    }

    @Then("^Message is moved to spambox$")
    public void notificationDisplayed() {
        webDriver.manage().window().maximize();
        findClick(INBOXMESSAGE);
    }

    public void spamFolderSelect() {
        WebElement clickOnSpamFolder = (new WebDriverWait(webDriver, 10)).until((ExpectedConditions.
                elementToBeClickable(By.xpath("//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/div[1]/div/div/div/" +
                        "div[2]/div/div[1]/nav/a[4]/div/div[2]/div"))));
        clickOnSpamFolder.click();
    }

    public void firstMessageSelect() {
        WebElement selectFirstMessage = (new WebDriverWait(webDriver, 10)).until((ExpectedConditions.
                elementToBeClickable(By.xpath("//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div/" +
                        "div/div/div[1]/div/div/div/a[1]/div[4]/div/div[1]"))));
        selectFirstMessage.click();
    }

    public void findClick(String s) {
        WebElement notSpamMail = (new WebDriverWait(webDriver, 10)).until((ExpectedConditions.
                elementToBeClickable(By.xpath(s))));
        notSpamMail.click();
    }

    @After
    public void afterClass() {
        webDriver.quit();
    }
}
