import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTests {
    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe"); // TODO - You need to place the geckodriver in the 'drivers' folder!
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://twitter.com/login");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void testLogInWithInvalidCredentials() {
        // Instantiate page object
        LoginPage loginPage = new LoginPage(driver);

        // Attempt login
        loginPage.logIn("userA", "invalidPassword");

        // Get error message
        String errorMessage = loginPage.getErrorMessage();

        // Verify error message
        Assert.assertEquals(errorMessage, "The username and password you entered did not match our records. Please double-check and try again.", "Error message not found!");
    }
}
