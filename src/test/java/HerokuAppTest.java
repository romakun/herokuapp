import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HerokuAppTest {

    @Test
    public void addRemoveElements() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver browser = new ChromeDriver();
        browser.get("http://the-internet.herokuapp.com/add_remove_elements/");
        browser.findElement(By.xpath("//button[text()='Add Element]")).click();
        browser.findElement(By.xpath("//button[text()='Add Element]")).click();
        browser.findElement(By.className("added-manually")).click();
        int numberOfDeleteButtons = browser.findElements(By.className("added-manually")).size();
        assertEquals(numberOfDeleteButtons, 1, "Количество удаляемых элементов не совпадает с ожидаемым результатом");

        browser.quit();

    }
}
