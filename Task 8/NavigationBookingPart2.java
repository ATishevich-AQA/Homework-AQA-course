import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.json.JsonOutput;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.concurrent.TimeUnit;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class NavigationBookingPart2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C://Users//jbUser//Desktop//New folder//chromedriver.exe");
        ChromeDriver chromedriver = new ChromeDriver();
        String URL = "https://www.booking.com/searchresults.html?aid=304142&label=gen173nr-1DCAEoggI46AdIM1gEaCWIAQGYATG4ARfIAQzYAQPoAQH4AQKIAgGoAgO4Ar6yte8FwAIB&sid=5123506973adcd971d4c26d139af9a9a&tmpl=searchresults&checkin_month=12&checkin_monthday=12&checkin_year=2019&checkout_month=12&checkout_monthday=28&checkout_year=2019&city=-2960561&class_interval=1&dest_id=-2960561&dest_type=city&dtdisc=0&from_sf=1&group_adults=2&group_children=0&inac=0&index_postcard=0&label_click=undef&nflt=class%3D5%3Breview_score%3D90%3B&no_rooms=1&postcard=0&raw_dest_type=city&room1=A%2CA&sb_price_type=total&shw_aparth=1&slp_r_match=0&srpvid=0c82774045f4003b&ss=Moscow&ss_all=0&ssb=empty&sshis=0&ssne=Moscow&ssne_untouched=Moscow&top_ufis=1&order=class_and_price";
        chromedriver.navigate().to(URL);
        WebElement clickHidePopUps = chromedriver.findElement(By.xpath(".//a [@class='hotel_name_link url'][1]"));
        Thread.sleep(1000);
        clickHidePopUps.click();
        Thread.sleep(1000);
        WebElement firstRowResultSelection = chromedriver.findElement(By.xpath("(.//div [@class='bui-review-score__badge'])[1]"));
        Thread.sleep(1000);
        firstRowResultSelection.click();

//        WebElement scoreAreaSelection = chromedriver.findElement(By.xpath("//*[@id='js--hp-gallery-scorecard']/a"));
//        Actions action = new Actions(chromedriver);
//        action.moveToElement(scoreAreaSelection).build().perform();
//        scoreAreaSelection.click();

//        WebDriverWait wait = new WebDriverWait(chromedriver, 1);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p [contains(text(),'rated it')]/strong")));

//        WebElement raitingValue = chromedriver.findElement(By.xpath("//p [@class='geo_information']"));
//        JavascriptExecutor executor = (JavascriptExecutor)chromedriver;
//        executor.executeScript("arguments[0].scrollIntoView(true)", raitingValue);

//        Thread.sleep(4000);
//        Select select = new Select();
//        Select WebElem = new Select(chromedriver.findElement(By.tagName("//p [contains(text(),'rated it')]/strong")));

        WebElement scoreSelection = chromedriver.findElement(By.xpath("//p [contains(text(),'rated it')]/strong"));

        int scoreInt = Integer.parseInt(scoreSelection.getAttribute("9.4"));
        if (scoreInt >= 9) {
            System.out.println("Test Passed");
        }
    }
}

