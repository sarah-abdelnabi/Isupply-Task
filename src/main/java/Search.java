import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Search {
    //Find the search bar
    public WebElement search(WebDriver driver)
    {
        return driver.findElement(By.name("q"));
    }

    //Find the third result
    public WebElement header(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@id=\"rso\"]/div[3]/div/div/div[1]/div/a/h3"));
    }
}
