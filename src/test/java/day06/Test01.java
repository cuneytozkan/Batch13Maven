package day06;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class Test01 {
    /*
        1-Test01 isimli bir class olusturun
        2- https://www.walmart.com/ adresine gidin
        3- Browseri tam sayfa yapin
        4- Sayfayi “refresh” yapin
        5- Sayfa title'inin “Save” ifadesi icerdigini control edin
        6- Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz
        7- URL in walmart.com icerdigini control edin
        8-”Nutella” icin arama yapiniz
        9- Kac sonuc bulundugunu yaziniz
        10-Sayfayi kapatin
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.walmart.com/");
        driver.navigate().refresh();
        String sayfaBasligi= driver.getTitle();
        // 5- Sayfa title'inin “Save” ifadesi icerdigini control edin
        if (sayfaBasligi.contains("Save")){
            System.out.println("Sayfa basligi Save iceriyor, test PASS");
        } else {
            System.out.println("Sayfa basligi Save icermiyor, test FAILED");
        }
        // 6- Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz
        if (sayfaBasligi.equals("Walmart.com | Save Money.Live Better")){
            System.out.println("Sayfa basligi testi PASS");
        } else {
            System.out.println("Sayfa basligi testi FAILED");
            System.out.println("current title " + sayfaBasligi);
            System.out.println("Expected Title " + "Walmart.com | Save Money.Live Better");
        }
        String currentUrl=driver.getCurrentUrl();
        if (currentUrl.contains("walmart.com")){
            System.out.println("URL testi PASS");
        } else System.out.println("URL testi FAILED");
        // 8-”Nutella” icin arama yapiniz
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement aramaCubugu=driver.findElement(By.cssSelector("input[id='global-search-input']"));
        String aramaKelimesi = "Nutella";
        aramaCubugu.sendKeys(aramaKelimesi+ Keys.ENTER);
        //9- Kac sonuc bulundugunu yaziniz
        WebElement sonucYazisi=driver.findElement(By.className("result-summary-container"));
        System.out.println(sonucYazisi.getText());
        //10-Sayfayi kapatin
        driver.close();
    }
}