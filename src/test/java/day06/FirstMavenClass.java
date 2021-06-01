package day06;
import com.google.gson.stream.JsonToken;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
public class FirstMavenClass {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Samsung headphones"+ Keys.ENTER);
        // 4- Bulunan sonuc sayisini yazdiralim
        WebElement sonucYazisiWebElementi= driver.findElement(By.xpath("(//span[@dir='auto'])[1]"));
        System.out.println(sonucYazisiWebElementi.getText());
        // sadece sonuc adedini istersek sonuc yazisini String'e atayip string manipulation yapabiliriz
        // 5- Ilk urunu tiklayalim
        // <span class="a-size-medium a-color-base a-text-normal">SAMSUNG (2 Pack) OEM Wired 3.5mm White Headset with Microphone, Volume Control, and Call Answer End Button [EO-EG920BW] for SAMSUNG Galaxy S6 Edge+ / S6 / S5, Galaxy Note 5/4 / Edge (Bulk Packaging)</span>
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
        // 6- geri giderek arama sayfasindaki tum basliklari yazdiralim
        driver.navigate().back();
        List<WebElement> basliklarListesi = driver.findElements(By.xpath("//span[@class='a-size-base a-color-base']"));
        for (WebElement each: basliklarListesi
        ) {
            System.out.println(each.getText());
        }
        driver.close();
    }
}