import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;

public class uploadFile {
    WebDriver driver = null;
    Upload upload;

    /**
     *
     * @throws InterruptedException
     */
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
        upload = new Upload();
    }


    @Test
    public void fileUpload() throws AWTException {
        //Click on "File Upload"
        upload.linkClick(driver).click();
        //Upload any small image file
        String imgname = "avatar.jpg";
        String imgpath = System.getProperty("user.dir") + "\\Upload\\" + imgname;
        upload.fileUploader(driver).sendKeys(imgpath);
        upload.fileSubmit(driver).click();
        //Check that the file has been uploaded successfully
        Assert.assertTrue(upload.fileUploaded(driver).getText().contains(imgname));
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        driver.quit();
    }
}
