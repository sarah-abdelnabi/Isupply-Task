import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class SeleniumSearch {
    WebDriver driver = null;
    Search search;

    @BeforeTest
    public void openBrowser() throws InterruptedException
    {
        //1- bridge between test script and browser
        String chromePath = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);
        //2- new object of webdriver
        driver = new ChromeDriver();
        //4-Navigate to the link I want to test and maximize
        driver.navigate().to("https://www.google.com/ncr");
        driver.manage().window().maximize();
        //5- create new object from pom design pattern
        search = new Search();
    }

    @Test
    public void search() throws InterruptedException {
        //Search for "selenium webdriver"
        search.search(driver).sendKeys("selenium webdriver");
        search.search(driver).sendKeys(Keys.ENTER);
        //Check that the third result text contains "What is Selenium WebDriver?"
        Assert.assertTrue(search.header(driver).getText().contains("What is Selenium WebDriver?"));
    }

    //Taking screenshot of the site that had a failure
    @AfterMethod
    public void takeScreenShot(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus())
        {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source=ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source,new File("./ScreenShots/" +result.getName()+".png"));
        }
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        driver.quit();
    }
}
