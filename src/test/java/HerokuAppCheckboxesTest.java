import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HerokuAppCheckboxesTest {

    @Test
    public void checkCheckboxes() {
        By firstCheckbox = By.xpath("//*[@id='checkboxes']/input[1]");
        By secondCheckbox = By.xpath("//*[@id='checkboxes']/input[2]");

        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver browser = new ChromeDriver();
        browser.get("http://the-internet.herokuapp.com/checkboxes");

        //Проверяем, что первый чекбокс не отмечен
        boolean checkUnSelected = browser.findElement(firstCheckbox).isSelected();
        assertEquals(checkUnSelected, false, "Первый чекбокс отмечен");
        //Кликаем на первый чекбокс
        browser.findElement(firstCheckbox).click();
        //Проверяем, что первый чекбокс отмечен
        boolean checkSelected = browser.findElement(firstCheckbox).isSelected();
        assertEquals(checkSelected, true, "Первый чекбокс не отмечен");
        //Проверяем, что второй чекбокс отмечен
        checkSelected = browser.findElement(secondCheckbox).isSelected();
        assertEquals(checkSelected, true, "Второй чекбокс не отмечен");
        //Кликаем на второй чекбокс
        browser.findElement(secondCheckbox).click();
        //Проверяем, что второй чекбокс не отмечен
        checkUnSelected = browser.findElement(secondCheckbox).isSelected();
        assertEquals(checkUnSelected, false, "Второй чекбокс отмечен");
        browser.quit();
    }
}
