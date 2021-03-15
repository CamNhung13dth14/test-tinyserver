package pom;

import constants.WaitTime;
import models.UserModel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ThreadHelper;
import utils.WebDriverHelper;

public class UserPage {
    WebDriver _driver;

    public By addPeopleBy = By.xpath("//div/span[text()='Add People']");
    public By resultContent = By.xpath("//div[@class='flex-auto flex flex-column']//div[@class='tu mv3 fw6 f3 flex items-center green']");

    public UserPage(WebDriver driver)
    {
        _driver = driver;
    }

    public void navigateTo()
    {
        _driver.findElement(By.xpath("//div//a[@aria-label='Users and Settings']")).click();
        ThreadHelper.sleep(WaitTime.MEDIUM);
        _driver.findElement(By.xpath("//div/a[@href='/invite']")).click();
    }

    public void enterUserInfo(int rowIndex, UserModel user)
    {
        _driver.findElement(By.xpath("//div//tbody/tr["+rowIndex+"]/td[2]/div//input[@field='firstName']")).sendKeys(user.getFirstName());
        _driver.findElement(By.xpath("//div//tbody/tr["+rowIndex+"]/td[2]/div//input[@field='lastName']")).sendKeys(user.getLastName());
        _driver.findElement(By.xpath("//div//tbody/tr["+rowIndex+"]/td[3]/div//input[@field='email']")).sendKeys(user.getEmail());/**/


    }

    public void addUser()
    {
        ThreadHelper.sleep(WaitTime.SHORT);
        WebDriverHelper.executeClick(_driver, _driver.findElement(addPeopleBy));
    }

    public String getResultContent()
    {
        WebElement element= _driver.findElement(resultContent);
        String actualResult = element.getText();
        return  actualResult;
    }
}
