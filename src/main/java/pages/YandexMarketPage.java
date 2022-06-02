package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YandexMarketPage {

    protected WebDriver chromeDriver;

    protected WebElement catalogPopupButton;

    protected WebDriverWait wait;

    public YandexMarketPage(WebDriver chromeDriver) {

        this.chromeDriver = chromeDriver;
        this.catalogPopupButton=chromeDriver.findElement(By.id("catalogPopupButton"));
        this.wait=new WebDriverWait(chromeDriver, Duration.ofSeconds(30));

    }

    public WebElement findSubCategory(String categoryName, String subcategoryName){

        catalogPopupButton.click();
        chromeDriver.findElement(By.xpath("//*[@alt='"+categoryName+"']/../.."));

        return chromeDriver.findElement(By.xpath("//a[text()='"+subcategoryName+"']"));
    }
}
