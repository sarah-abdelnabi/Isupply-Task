import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Load {
   //Find "Dynamic Loading" link
    public WebElement clickLink(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[14]/a"));
    }

    //Find "Example 2" link
    public WebElement example(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"content\"]/div/a[2]"));
    }

    //Find button "start"
    public WebElement start(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"start\"]/button"));
    }

    //Find text after loading
    public WebElement text(WebDriver driver) {
        return driver.findElement(By.id("finish"));
    }
}
