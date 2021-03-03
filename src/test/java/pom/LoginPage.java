package pom;

import constants.WaitTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ThreadHelper;

public class LoginPage {
    WebDriver _driver;

    public By userNameBy = By.xpath("//div/input[@type='text']");
    public By continueBy = By.xpath("//div/span[text()='Continue']");
    public By passwordBy = By.xpath("//div/input[@type='password']");
    public By signinBy = By.xpath("//div/span[text()='Sign in']");


    public LoginPage(WebDriver driver)
    {
        _driver = driver;
    }

    public void login(String username, String password)
    {
        _driver.findElement(userNameBy).sendKeys(username);
        _driver.findElement(continueBy).click();
        ThreadHelper.sleep(WaitTime.SHORT);
        _driver.findElement(passwordBy).sendKeys(password);
        _driver.findElement(signinBy).click();
        ThreadHelper.sleep(WaitTime.MEDIUM);
    }
}
