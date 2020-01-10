import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HerokuAppDynamicControlsTest {

    @Test
    public void checkDynamicControls() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver browser = new ChromeDriver();
        browser.get("http://the-internet.herokuapp.com/dynamic_controls");
        boolean findCheckbox = browser.findElement(By.xpath("//input[@type='checkbox']")).isDisplayed();
        assertEquals(findCheckbox, true, "Чекбокс не найден");
        browser.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        WebDriverWait wait = new WebDriverWait(browser, 10);
        boolean waitText = wait.until(ExpectedConditions.textToBe(By.id("message"), "It's gone!"));
        assertEquals(waitText, true, "Сообщение об удалении чекбокса не появилось");
        int countCheckboxes = browser.findElements(By.xpath("//input[@type='checkbox']")).size();
        assertEquals(countCheckboxes, 0, "Чекбокс присутсвтует на странице");

        boolean inputEnabled = browser.findElement(By.xpath("//input[@type='text']")).isEnabled();
        assertEquals(inputEnabled, false, "Input не задизейблен");
        browser.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
        boolean waitInputEnable = wait.until(ExpectedConditions.textToBe(By.id("message"), "It's enabled!"));
        assertEquals(waitInputEnable, true, "Сообщение об активации поля не появилось");
        assertEquals(browser.findElement(By.xpath("//input[@type='text']")).isEnabled(), true, "Input не активарован");

        browser.quit();

    }
}
