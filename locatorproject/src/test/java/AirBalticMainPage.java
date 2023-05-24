import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AirBalticMainPage {

    // Web driver and Constructor
    public WebDriver webDriver;

    public AirBalticMainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public AirBalticMainPage() {

    }


    // Locators

    public String cookieButton = "//button[contains(text(),'Atļaut visu un aizvērt')]";
    public String languageButton = "//button[@class='button lang']";
    public String changeToRussianLanguageButton = "//a[contains(text(),'Русский')]";
    public String russianVerificationXPath = "//div[@class='switch-wrap']/div[1]";
    public String loginButton = "//button[@class='button login']";
    public String emailInput = "//form[@class='login-form']/div[3]/input";
    public String passwordInput = "//input[@type='password']";
    public String registrationButton = "//form[@class='login-form']/div[6]/button";
    public String classErrorMessage = "error-msg";


    // Other variables

    public String expectedMessage = "Купить авиабилеты";


    // Methods

    public void goToWebsite() {

        webDriver.get("https://www.airbaltic.com/");

    }

    // Wait for element by xpath
    public void wait(String WaitFor) {
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(WaitFor)));
    }

    // Accept coockies and click button
    public void acceptCookies() {
        wait(cookieButton);
        webDriver.findElement(By.xpath(cookieButton)).click();

    }

    // Change language to Russian
    public void changeLanguageToRussian() {
        webDriver.findElement(By.xpath(languageButton)).click();
        wait(changeToRussianLanguageButton);
        webDriver.findElement(By.xpath(changeToRussianLanguageButton)).click();

        // Check that language switched to Russian

        wait(russianVerificationXPath);


// In test class create Assert webElement object and verify that language switched to Russian


    }
    /* Check that incorrect email returns error message
    Click login button
    Enter invalid email
    Enter random password
    Try to log in

     */
  public void wrongEmail(){
      webDriver.findElement(By.xpath(loginButton)).click();
      wait(emailInput);
      webDriver.findElement(By.xpath(emailInput)).sendKeys("Testmail.com");
      webDriver.findElement(By.xpath(passwordInput)).sendKeys("Password");
      webDriver.findElement(By.xpath(registrationButton)).click();

      // Create Object and assert to check error message
  }


}
