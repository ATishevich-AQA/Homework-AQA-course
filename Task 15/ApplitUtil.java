import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplitUtil {


    public static void main(String[] args) {
        EyesRunner runner = new ClassicRunner();
        Eyes eyes = new Eyes(runner);
        eyes.setApiKey("HkfxjprPw4lbYMZghOs0ppc4kVowOzcb416mJHcG5PE110");
        System.setProperty("webdriver.chrome.driver", "C://Users//jbUser//Desktop//New folder//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
        eyes.open(driver, "HomeTask", "SendEmail_BaseLine",
                new RectangleSize(1240, 680));
        eyes.setMatchLevel(MatchLevel.LAYOUT);
        driver.get("https://www.mail.ru");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"mailbox:submit\"]/input"));
        eyes.checkWindow();
        // Login into mailbox
        driver.findElement(By.xpath("//input [@id='mailbox:login']")).sendKeys("alexalex.191@mail.ru");
        driver.findElement(By.xpath("//*[@id='mailbox:submit']/input")).click();
        driver.findElement(By.xpath("//input [@id='mailbox:password']")).sendKeys("lavZa123!");
        driver.findElement(By.xpath("//*[@id='mailbox:submit']/input")).click();
        // Check that button "Написать письмо" is displayed
        WebElement newMail = (new WebDriverWait(driver, 10)).until((ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div/span"))));
        eyes.checkElement(newMail);
        eyes.checkWindow();
        // Press new mail button and fill form:
        Actions action = new Actions(driver);
        action.sendKeys(Keys.chord("n")).perform();
        WebElement inputEmailTopic = (new WebDriverWait(driver, 10)).until((ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[3]/div[1]/div[2]/div/input"))));
        inputEmailTopic.sendKeys("Task 12");
        WebElement inputAddress = (new WebDriverWait(driver, 10)).until((ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[2]/div/div/div[1]/div/div[2]/div/div/label/div/div/input"))));
        inputAddress.sendKeys("imxotepalex@gmail.com" + " " + "imxotepalex@gmail.com" + " ");
        WebElement sendMessageButtonPress = (new WebDriverWait(driver, 15)).until((ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[15]/div[2]/div/div[2]/div[1]/span[1]/span"))));
        sendMessageButtonPress.click();
        WebElement sentMailForm = driver.findElement(By.xpath("/html/body/div[16]/div/div/div[2]/button[1]"));
        eyes.checkWindow();
        eyes.closeAsync();
        driver.quit();
        eyes.abortIfNotClosed();

        TestResultsSummary allTestResults = runner.getAllTestResults();
        System.out.println(allTestResults);
        allTestResults.getAllResults()[0].getTestResults().isPassed();
    }
}

