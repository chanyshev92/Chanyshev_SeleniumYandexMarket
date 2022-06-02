package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Objects;

public class YandexMarketProductListPage extends YandexMarketPage{

    public YandexMarketProductListPage(WebDriver chromeDriver) {
        super(chromeDriver);
    }

    public WebElement checkboxOfManufacturer(String legendName,String checkBoxName){

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//legend[text()='" + legendName + "']/..//li//input[@name='" + legendName + " " + checkBoxName + "']/../div")));
        WebElement element = chromeDriver.findElement(By.xpath("//legend[text()='" + legendName + "']/..//li//input[@name='" + legendName + " " + checkBoxName + "']/../div"));
        return element;

    }
    public void changeShowCountIfNotEquals(String showCountString){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-haspopup='true']")));
        String s=chromeDriver.findElement(By.xpath("//button[@aria-haspopup='true']/span/span")).getText();
        if (!Objects.equals(s, showCountString)){
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-haspopup='true']")));
            chromeDriver.findElement(By.xpath("//button[@aria-haspopup='true']")).click();
            chromeDriver.findElement(By.xpath("//button[text()='"+showCountString+"']")).click();
        }
    }
    public List<WebElement> getResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article[@data-zone-name='snippet-card']")));
        return chromeDriver.findElements(By.xpath("//article[@data-zone-name='snippet-card']//h3/a"));
    }
}
