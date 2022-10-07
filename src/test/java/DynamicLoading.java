import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicLoading {
    WebDriver driver = null;
    Load load;

    @BeforeTest
    public void openBrowser() throws InterruptedException
    {
        //1- bridge between test script and browser
        String chromePath = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);
        //2- new object of webdriver
        driver = new ChromeDriver();
        //4-Navigate to the link I want to test and maximize
        driver.navigate().to("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        //5- create new object from pom design pattern
        load = new Load();
    }

    @Test
    public void dynamicLoad() throws InterruptedException {
        //Click on "Dynamic Loading"
        load.clickLink(driver).click();
        //Click on "Example 2"
        load.example(driver).click();
        //Click "Start"
        load.start(driver).click();
        //Wait for loading to finish
        Thread.sleep(6000);
        //Check that the text displayed is "Hello World!"
        Assert.assertTrue(load.text(driver).getText().contains("Hello World!"));
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        driver.quit();
    }
}
