import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Upload {
    //Find "File Upload" link
    public WebElement linkClick(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[18]/a"));
    }

    //"Choose File" button
    public WebElement fileUploader(WebDriver driver) {
        return driver.findElement(By.id("file-upload"));
    }

    //"upload" button
    public WebElement fileSubmit(WebDriver driver) {
        return driver.findElement(By.id("file-submit"));
    }

    // "File uploaded" message
    public WebElement fileUploaded(WebDriver driver) {
        return driver.findElement(By.id("uploaded-files"));
    }
}
