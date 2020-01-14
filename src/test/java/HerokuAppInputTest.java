import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HerokuAppInputTest {
    @Test
    public void checkInputNumbers() {
        By input = By.xpath("//input");

        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver browser = new ChromeDriver();
        browser.get("http://the-internet.herokuapp.com/inputs");

        browser.findElement(input).sendKeys("1234567890");
        String elementValue = browser.findElement(input).getAttribute("value");
        assertEquals(elementValue, "1234567890", "Введенный текст не соответствует ожидаемому");
        browser.quit();
    }

    @Test
    public void checkInputLatin() {
        By input = By.xpath("//input");

        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver browser = new ChromeDriver();
        browser.get("http://the-internet.herokuapp.com/inputs");

        browser.findElement(input).sendKeys("1qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM");
        String elementValue = browser.findElement(input).getAttribute("value");
        assertEquals(elementValue,"1", "Введенный текст не соответствует ожидаемому");
        browser.quit();
    }

    @Test
    public void checkInputCyrillic() {
        By input = By.xpath("//input");

        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver browser = new ChromeDriver();
        browser.get("http://the-internet.herokuapp.com/inputs");

        browser.findElement(input).sendKeys("1йцукенгшщзхъфывапролджэячсмитьбюЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮЁё");
        String elementValue = browser.findElement(input).getAttribute("value");
        assertEquals(elementValue, "1", "Введенный текст не соответствует ожидаемому");
        browser.quit();
    }

    @Test
    public void checkInputSpecSymbols() {
        By input = By.xpath("//input");


        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver browser = new ChromeDriver();
        browser.get("http://the-internet.herokuapp.com/inputs");

        browser.findElement(input).sendKeys("1№?~`!@#$%^&*()_+-=;:|/.,<>");
        String elementValue = browser.findElement(input).getAttribute("value");
        assertEquals(elementValue, "1", "Введенный текст не соответствует ожидаемому");
        browser.quit();
    }

    @Test
    public void checkInputArrows() {
        By input = By.xpath("//input");


        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver browser = new ChromeDriver();
        browser.get("http://the-internet.herokuapp.com/inputs");

        for(int i = 0; i < 10; i ++){
            browser.findElement(input).sendKeys(Keys.ARROW_UP);
        }
        for(int i = 0; i < 3; i++){
            browser.findElement(input).sendKeys(Keys.ARROW_DOWN);
        }

        String elementValue = browser.findElement(input).getAttribute("value");
        assertEquals(elementValue, "7", "Введенный текст не соответствует ожидаемому");
        browser.quit();
    }
}
