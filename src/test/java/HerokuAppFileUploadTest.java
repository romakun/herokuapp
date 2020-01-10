import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HerokuAppFileUploadTest {

    @Test
    public void checkFileUpload() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver browser = new ChromeDriver();
        browser.get("http://the-internet.herokuapp.com/upload");
        browser.findElement(By.xpath("//input[@type='file']")).sendKeys("C:/1.jpg");
        browser.findElement(By.id("file-submit")).click();
        browser.findElement(By.id("uploaded-files")).getText();
        assertEquals(browser.findElement(By.id("uploaded-files")).getText(), "1.jpg", "Не верное название загруженного файла");
        browser.quit();
    }
}
