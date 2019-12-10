import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class NavigationBookingPart2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C://Users//jbUser//Desktop//New folder//chromedriver.exe");
        ChromeDriver chromedriver = new ChromeDriver();
        String URL = "https://www.booking.com/searchresults.html?aid=304142&label=gen173nr-1DCAEoggI46AdIM1gEaCWIAQGYATG4ARfIAQzYAQPoAQH4AQKIAgGoAgO4Ar6yte8FwAIB&sid=5123506973adcd971d4c26d139af9a9a&tmpl=searchresults&checkin_month=12&checkin_monthday=29&checkin_year=2019&checkout_month=1&checkout_monthday=22&checkout_year=2020&city=-2960561&class_interval=1&dest_id=-2960561&dest_type=city&dtdisc=0&from_sf=1&group_adults=2&group_children=0&inac=0&index_postcard=0&label_click=undef&no_rooms=1&postcard=0&raw_dest_type=city&room1=A%2CA&sb_price_type=total&shw_aparth=1&slp_r_match=0&src=searchresults&srpvid=c98d981447b40021&ss=Moscow&ss_all=0&ssb=empty&sshis=0&ssne=Moscow&ssne_untouched=Moscow&top_ufis=1&nflt=review_score%3D90%3B&rsf=";
        chromedriver.navigate().to(URL);
        Thread.sleep(4000);
        WebElement scoreSelection = chromedriver.findElement(By.xpath("//*[@id='hotellist_inner']/div[2]/div[2]/div[1]/div[2]/div/div/a[1]/div/div[1]"));
        Thread.sleep(4000);
        WebElement firstRowResultSelection = chromedriver.findElement(By.xpath("(.//div [@class='bui-review-score__badge'])[1]"));
        firstRowResultSelection.click();
        Thread.sleep(10000);
        double score = Double.parseDouble(scoreSelection.getText().replace(",", "."));

        System.out.println((score >= 9.0)?"Hotel raiting is Good":"Hotel raiting is lower than 9");
    }
}



