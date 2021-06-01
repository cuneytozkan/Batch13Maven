package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Tekrar01 {
    public static void main(String[] args) {
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

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://www.walmart.com/");
        driver.navigate().refresh();

        String title = driver.getTitle();
        if(title.contains("Save")){
            System.out.println("Title contains Save, test passed");
        }else{
            System.out.println("Title does not contain Save, test failed!");
        }

        if(driver.getTitle().equals("Walmart.com | Save Money.Live Better")){
            System.out.println("Title is true, test passed");
        }else{
            System.out.println("test failed");
            System.out.println(driver.getTitle());
        }

        String url = driver.getCurrentUrl();
        if(url.contains("walmart.com")){
            System.out.println("Url contanins walmart.com, test passed");
        }else{
            System.out.println("Url deos not contanin walmart.com, test failed!");
            System.out.println("Current url: " + driver.getCurrentUrl());
        }

        WebElement searchBox = driver.findElement(By.xpath("//input[@class = 'k_a bo_b header-GlobalSearch-input mweb-Typeahead-input k_b']"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);

        WebElement searchResult = driver.findElement(By.xpath("//div[@class='result-summary-container']"));
        System.out.println("buluna sonuc sayiis : " + searchResult.getText());
        driver.close();
    }
}
