import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    public static WebDriver driver;

    LoginPage(WebDriver driver) {
        LoginPage.driver = driver;

        // Verify that we have landed on the Login page
        new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("Login on Twitter / Twitter"));
    }

    public LoginPage logIn(String username, String password) {
        // Enter username
        driver.findElement(By.name("session[username_or_email]"))
                .sendKeys(username);

        // Enter password
        driver.findElement(By.name("session[password]"))
                .sendKeys(password);

        // Click 'Log in' button
        driver.findElement(By.xpath("//*[@id='react-root']/div/div/div[2]/main/div/div/div[1]/form/div/div[3]/div/div"))
                .click();

        return this;
    }

    public String getErrorMessage() {
        return  driver.findElement(By.xpath("//span[contains(text(),'The username and password you entered did not match')]"))
                .getText();
    }
}
