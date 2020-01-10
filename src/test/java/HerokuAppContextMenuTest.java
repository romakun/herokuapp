import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HerokuAppContextMenuTest {

    @Test
    public void checkContextMenu() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver browser = new ChromeDriver();
        browser.get("http://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(browser);
        WebElement elementLocator = browser.findElement(By.id("hot-spot"));
        actions.contextClick(elementLocator).perform();
        Alert alert = browser.switchTo().alert();
        String alertText = alert.getText();
        assertEquals(alertText, "You selected a context menu", "Алерт не появился");
        alert.dismiss();
        browser.quit();

    }

}
