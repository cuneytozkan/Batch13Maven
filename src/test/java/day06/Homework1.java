package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Homework1 {
    public static void main(String[] args) {
        /*
        1. http://zero.webappsecurity.com sayfasina gidin
        2. Signin buttonuna tiklayin
        3. Login alanine “username” yazdirin
        4. Password alanine “password” yazdirin
        5. Sign in buttonuna tiklayin
        6. Pay Bills sayfasina gidin
        7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        8. tarih kismina “2020-09-10”
        9. Pay buttonuna tiklayin
        10. “The payment was successfully submitted.” mesajinin ciktigini control edin
         */


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

       // 1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com/");

        //2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button' and @type='button']")).click();

        //3. Login alanine “username” yazdirin
        WebElement loginBox = driver.findElement(By.xpath("//input[@id='user_login' and @name='user_login']"));
        loginBox.sendKeys("username");

        //4. Password alanine “password” yazdirin
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='user_password' and @name='user_password']"));
        passwordBox.sendKeys("password");

        // 5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type='submit' and @name='submit']")).click();
        driver.findElement(By.xpath("//button[@id='details-button' and @class='secondary-button small-link']")).click();
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click();

        //6. Pay Bills sayfasina gidin
        driver.findElement(By.linkText("Pay Bills")).click();

        // 7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amountBox = driver.findElement(By.xpath("//input[@type='text' and @id='sp_amount']"));
        amountBox.sendKeys("1234");

        // 8. tarih kismina “2020-09-10”
        WebElement dateBox = driver.findElement(By.xpath("//input[@type='text' and @id='sp_date']"));
        dateBox.sendKeys("2020-09-10");

        //9. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type='submit' and @class='btn btn-primary']")).click();

        //10. “The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement message = driver.findElement(By.xpath("//div/span"));
        String paymentMessage = message.getText();

        if(paymentMessage.equals("The payment was successfully submitted.")){
            System.out.println("Payment Message appears, test passed");
        }else{
            System.out.println("Payment message does not appears, test failed!");
        }

        driver.close();






    }
}
