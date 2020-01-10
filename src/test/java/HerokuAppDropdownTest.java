import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HerokuAppDropdownTest {
    @Test
    public void checkCheckboxes() {
        By firstCheckbox = By.xpath("//*[@id='checkboxes']/input[1]");
        By secondCheckbox = By.xpath("//*[@id='checkboxes']/input[2]");

        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver browser = new ChromeDriver();
        browser.get("http://the-internet.herokuapp.com/checkboxes");
    }
}
