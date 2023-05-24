import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LocatorTest {


    public WebDriver webDriver;


    @Before
    public void init() {
        WebDriverManager.chromedriver()
                .setup();
        webDriver = new ChromeDriver();
    }

    @BeforeEach
    public void beforeEach() {

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    /* Positive test - switch language from Latvian to Russian
    Click on language button
    Choose Russian language
    Check that buttons have text in Russian
     */

    @Test
    public void localizationRussian() {

        AirBalticMainPage airBalticMainPage = new AirBalticMainPage(webDriver);
        airBalticMainPage.goToWebsite();
        airBalticMainPage.acceptCookies();
        airBalticMainPage.changeLanguageToRussian();
        WebElement buttonInRussian = webDriver.findElement(By.xpath(airBalticMainPage.russianVerificationXPath));
        Assert.assertEquals(airBalticMainPage.expectedMessage, buttonInRussian.getText());
        System.out.println("Ожидание: " + airBalticMainPage.expectedMessage);
        System.out.println("Результат: " + buttonInRussian.getText());


    }

    /*
     Negative test.
     Click login button
     Enter invalid email
     Enter random password
     Try to log in
     Should return error for Email without "@"
     */

    @Test
    public void wrongEmail() {
        AirBalticMainPage airBalticMainPage = new AirBalticMainPage(webDriver);
        airBalticMainPage.goToWebsite();
        airBalticMainPage.acceptCookies();
        airBalticMainPage.wrongEmail();
        WebElement errorMsg = webDriver.findElement(By.className(airBalticMainPage.classErrorMessage));
        System.out.println("Error message: " + errorMsg.getText());


    }


}
