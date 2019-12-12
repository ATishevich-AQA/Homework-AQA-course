import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Booking_Paris_Task9_2_3 {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "C://Users//jbUser//Desktop//New folder//chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String URL = "https://www.booking.com/";
        chromeDriver.get(URL);
        chromeDriver.navigate().to(URL);
        WebElement whereToGoField = chromeDriver.findElement(By.xpath(".//input [@data-component='search/destination/inp" +
                "ut-placeholder']"));
        whereToGoField.sendKeys("Paris");

        WebElement starDate = chromeDriver.findElement(By.xpath("(//*[@class='sb-date-field b-datepicker'])[1]"));
        starDate.click();

        chromeDriver.findElement(By.xpath("//*[@data-date='" + DateChange(4) + "']")).click();
        chromeDriver.findElement(By.xpath("//*[@data-date='" + DateChange(10) + "']")).click();

        WebElement openAddingAdultsMenu = chromeDriver.findElement(By.xpath("//*[@id='xp__guests__toggle']"));
        openAddingAdultsMenu.click();

        WebElement addingAdults = chromeDriver.findElement(By.xpath("//*[@id='xp__guests__inputs-container']/div/div/div" +
                "[1]/div/div[2]/button[2]"));
        addingAdults.click();

        addingAdults.click();
        WebElement addingRooms = chromeDriver.findElement(By.xpath("//*[@id='xp__guests__inputs-container']/div/div/div[" +
                "3]/div/div[2]/button[2]"));
        addingRooms.click();

        WebElement searchButtonPress = chromeDriver.findElement(By.xpath(".//button [@type='submit' and @data-sb-id='" +
                "main']"));
        searchButtonPress.click();

        if (chromeDriver.findElement((By.xpath("//*[@id='sort_by']/ul/li[3]"))).isDisplayed()) {
            WebElement sortingByRaitingPrice = chromeDriver.findElement((By.xpath("//*[@id='sort_by']/ul/li[3]")));
            sortingByRaitingPrice.click();
        } else if
        (chromeDriver.findElement((By.xpath("//*[@id='sortbar_dropdown_options']/li[2]"))).isDisplayed()) {
            WebElement sortingByRaitingPrice = chromeDriver.findElement((By.xpath("//*[@id='sortbar_dropdown_options']/l" +
                    "i[2]")));
            sortingByRaitingPrice.click();
        }
        Thread.sleep(3333);
        WebElement hotelSelection = chromeDriver.findElement(By.xpath(".//a [@class='hotel_name_link url']"));
        hotelSelection.click();
        chromeDriver.manage().window().maximize();
        int size = 2;

        String winHandleBefore = chromeDriver.getWindowHandle();
        for (String winHandle : chromeDriver.getWindowHandles()) {
            chromeDriver.switchTo().window(winHandle);
        }
        Select sel = new Select(chromeDriver.findElement(By.xpath("//select [@class='hprt-nos-select']")));
        String dropDownListValue = "1";
        sel.selectByValue(dropDownListValue);
        Thread.sleep(3333);
        WebElement iReserveNext = chromeDriver.findElement(By.xpath("//*[@id='hprt-form']/div[4]/div[2]/div[2]/div[5]"));
        iReserveNext.click();

        WebElement LastName = chromeDriver.findElement(By.xpath("//*[@id='lastname']"));
        LastName.sendKeys("Tishevich");
        WebElement email = chromeDriver.findElement(By.xpath("//*[@id='email']"));
        email.sendKeys("smth@mail.ru");
        WebElement confirmEmail = chromeDriver.findElement(By.xpath("//*[@id='email_confirm']"));
        confirmEmail.sendKeys("smth@mail.ru");
    }

    public static String DateChange(int datacahnger) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, +datacahnger);
        Date todate1 = cal.getTime();
        return dateFormat.format(todate1);
    }
}
