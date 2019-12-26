import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class HerokuAppDropdownTest {

    @Test
    public void checkDropdown() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver browser = new ChromeDriver();
        browser.get("http://the-internet.herokuapp.com/dropdown");

        WebElement selectElement = browser.findElement(By.id("dropdown"));
        Select select = new Select(selectElement);
        List<WebElement> dropdownOptions = select.getOptions();
        //Проверяем наличие элементов в выпадающем списке
        WebElement firstElement = dropdownOptions.get(1);
        assertEquals(firstElement.getAttribute("text"), "Option 1", "Значение первого элемента списка не соответствет ожидаемому");
        WebElement secondElement = dropdownOptions.get(2);
        assertEquals(secondElement.getAttribute("text"), "Option 2", "Значение второго элемента списка не соответсвтует ожидаемому");
        //Кликаем по первому элементу
        firstElement.click();
        assertEquals(firstElement.getAttribute("selected"), "true", "Данный элемент не выбран в выпадающем списке");
        secondElement.click();
        //Кликаем по второму элементу
        assertEquals(secondElement.getAttribute("selected"), "true", "Данный элемент не выбран в выпадающем списке");
        browser.quit();
    }
}
