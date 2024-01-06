import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test01 {

    @Test
    public  void test01 (){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1- Hepsi burada linkine gidilir
        driver.get("https://www.testotomasyonu.com/");
        // 2- Arama çubuğuna Nike Sneaker Orange & Gray yazılır.
        WebElement searchTextBox = driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div/div[2]/form/label"));

        searchTextBox.sendKeys("Nike Sneaker Orange & Gray" + Keys.ENTER);
        // 3- arama sonuçlarının nutella içerdiğini doğrulayın
        WebElement searchResult = driver.findElement(By.xpath("/html/body/div[2]/section[2]/div/div/div[2]/ul/li/div/div[3]/div/a"));
        String actualResult = searchResult.getText();
        if (actualResult.contains("Nike Sneaker Orange & Gray")){
            System.out.println("NİKE İÇERİYOR. TEST GEÇTİ ");
        }else {
            System.out.println("NİKE İÇERMİYOR. TEST KALDI ");
        }
        driver.quit();
    }
}
