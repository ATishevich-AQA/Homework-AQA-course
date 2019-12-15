import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.FindBy;


class LoginPage {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "C://Users//jbUser//Desktop//New folder//chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        String URL = "https://mail.ru/";
        chromeDriver.get(URL);

        // Login into mailbox
        chromeDriver.findElement(By.xpath("//input [@id='mailbox:login']")).sendKeys("alexalex.191@mail.ru");
        chromeDriver.findElement(By.xpath("//*[@id='mailbox:submit']/input")).click();
        chromeDriver.findElement(By.xpath("//input [@id='mailbox:password']")).sendKeys("lavZa123!");
        chromeDriver.findElement(By.xpath("//*[@id='mailbox:submit']/input")).click();

        // Move email into spambox and otherwise
        chromeDriver.findElement(By.xpath("//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div/div/div/a[1]/div[4]/div/div[1]")).click();
        chromeDriver.findElement(By.xpath("//*[@id='app-canvas']/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/table/tbody/tr/td/div[3]")).click();
        chromeDriver.manage().window().maximize();
        WebElement clickOnSpamFolder = (new WebDriverWait(chromeDriver, 10)).until((ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/div[1]/div/div/div/div[2]/div/div[1]/nav/a[4]/div/div[2]/div"))));
        clickOnSpamFolder.click();
        WebElement spamMailClick = (new WebDriverWait(chromeDriver, 10)).until((ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div/div/div/a[1]/div[4]/div"))));
        spamMailClick.click();
        WebElement notSpamMail = (new WebDriverWait(chromeDriver, 10)).until((ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app-canvas']/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/table/tbody/tr/td/div[3]"))));
        notSpamMail.click();

        // Send mail
        chromeDriver.manage().window().maximize();
        Actions action = new Actions(chromeDriver);
        action.sendKeys(Keys.chord("n")).perform();
        WebElement inputEmailTopic = (new WebDriverWait(chromeDriver, 10)).until((ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[16]/div[2]/div/div[1]/div[2]/div[3]/div[3]/div[1]/div[2]/div/input"))));
        inputEmailTopic.sendKeys("Task 12");
        WebElement inputAddress = (new WebDriverWait(chromeDriver, 10)).until((ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[2]/div/div/div[1]/div/div[2]/div/div/label/div/div/input"))));
        inputAddress.sendKeys("imxotepalex@gmail.com" +" "+"imxotepalex@gmail.com"+" ");
        WebElement sendMessageButtonPress = (new WebDriverWait(chromeDriver, 15)).until((ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[15]/div[2]/div/div[2]/div[1]/span[1]/span"))));
        sendMessageButtonPress.click();

        // setFlag On
        chromeDriver.manage().window().maximize();
        WebElement setFlag = (new WebDriverWait(chromeDriver, 10)).until((ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div/div/div/a[1]/div[4]/div/div[2]/button"))));
        setFlag.click();
        WebElement setFlag2 = (new WebDriverWait(chromeDriver, 10)).until((ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div/div/div/a[2]/div[4]/div/div[2]/button"))));
        setFlag2.click();
        WebElement setFlag3 = (new WebDriverWait(chromeDriver, 10)).until((ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div/div/div/a[3]/div[4]/div/div[2]/button"))));
        setFlag3.click();

        // setFlag On
        chromeDriver.manage().window().maximize();
        WebElement setFlag4 = (new WebDriverWait(chromeDriver, 10)).until((ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div/div/div/a[1]/div[4]/div/div[2]/button"))));
        setFlag4.click();
        WebElement setFlag5 = (new WebDriverWait(chromeDriver, 10)).until((ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div/div/div/a[2]/div[4]/div/div[2]/button"))));
        setFlag5.click();
        WebElement setFlag6 = (new WebDriverWait(chromeDriver, 10)).until((ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div/div/div/a[3]/div[4]/div/div[2]/button"))));
        setFlag6.click();
    }
}