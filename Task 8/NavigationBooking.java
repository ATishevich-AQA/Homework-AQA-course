import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationBooking {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C://Users//jbUser//Desktop//New folder//chromedriver.exe");
        ChromeDriver chromedriver = new ChromeDriver();
        String URL = "https://www.booking.com";
        chromedriver.navigate().to("https://www.booking.com");
        WebElement whereToGoField = chromedriver.findElement(By.xpath(".//input [@data-component='search/destination/inp" +
                "ut-placeholder']"));
        whereToGoField.sendKeys("Москва");
        WebElement searchButtonPress = chromedriver.findElement(By.xpath(".//button [@type='submit' and @data-sb-id='main']"));
        searchButtonPress.click();
        WebElement checkSearchResults = chromedriver.findElement(By.xpath(".//a [@class='hotel_name_link url'] "));
        checkSearchResults.click();
    }
}
