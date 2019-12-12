
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Booking_Paris9_1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C://Users//jbUser//Desktop//New folder//chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String URL = "https://www.booking.com/";
        chromeDriver.get(URL);
        chromeDriver.navigate().to(URL);
        WebElement whereToGoField = chromeDriver.findElement(By.xpath(".//input [@data-component='search/destination/inp" +
                "ut-placeholder']"));
        whereToGoField.sendKeys("Paris");
        WebElement starDate = chromeDriver.findElement(By.xpath("(//*[@class='sb-date-field b-datepicker'])[1]"));
        starDate.click();
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//*[@data-date='" + DateChange(4) + "']")).click();
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//*[@data-date='" + DateChange(10) + "']")).click();
        WebElement searchButtonPress = chromeDriver.findElement(By.xpath(".//button [@type='submit' and @data-sb-id='main']"));
        searchButtonPress.click();

        if (chromeDriver.findElement((By.xpath(".//*[@id='sort_by']/ul/li[6]/a"))).isDisplayed()) {
            WebElement sortingByRaitingPrice = chromeDriver.findElement((By.xpath(".//*[@id='sort_by']/ul/li[6]/a")));
            sortingByRaitingPrice.click();
        } else if
        (chromeDriver.findElement((By.xpath("//*[@id='b2searchresultsPage']"))).isDisplayed()) {
            WebElement sortingByRaitingPrice = chromeDriver.findElement((By.xpath("//*[@id='b2searchresultsPage']")));
            sortingByRaitingPrice.click();
        }
    }

    public static String DateChange(int datacahnger) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, +datacahnger);
        Date todate1 = cal.getTime();
        return dateFormat.format(todate1);
    }
}
