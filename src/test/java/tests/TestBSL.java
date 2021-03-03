package tests;

import constants.WaitTime;
import models.UserModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pom.LoginPage;
import pom.UserPage;
import utils.ThreadHelper;

public class TestBSL {
    public WebDriver driver;

    @Test
    public void TestBSL() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("camnhung13dth14@gmail.com", "Nhung12345678");

        UserPage userPage = new UserPage(driver);
        userPage.navigateTo();
        userPage.enterUserInfo(1, new UserModel("Test 09", "1", "test09@gmail.com"));
        userPage.enterUserInfo(2, new UserModel("Test 10", "2", "test10@gmail.com"));
        userPage.enterUserInfo(3, new UserModel("Test 11", "3", "test11@gmail.com"));
        userPage.enterUserInfo(4, new UserModel("Test 12", "4", "test12@gmail.com"));
        userPage.addUser();
        ThreadHelper.sleep(WaitTime.MEDIUM);

        String actualResult = userPage.getResultContent();
        String expectedResult = "check_circle\n" +
                "Congratulations";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @BeforeTest
    public void initDriver() {
        // Optional. If not specified, WebDriver searches the PATH for chromedriver.
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://staging.tinyserver.info/auth");
        driver.manage().window().maximize();
    }

    @AfterTest
    public void closeDriver() {
        driver.quit();
    }
}
