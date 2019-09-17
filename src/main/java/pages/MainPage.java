package pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseStep;


import java.util.List;

public class MainPage extends BasePage{



   // @FindBy(xpath = "//div[contains(text(),'Что вас интересует')]/following-sibling::*//div[contains(text(),'')]")
   // List<WebElement> mainMenuItem;
   // @FindBy(xpath = "//div[contains(text(),'Что вас интересует')]/following-sibling::*//div[contains(text(),'')]")
   // List<WebElement> subMenuItem;


    public void selectMainMenuItem(String menuItem, String subMenu){

        /*for (WebElement item:
             mainMenuItem) {
            if(item.getAttribute("textContent").equalsIgnoreCase(menuItem)){
                Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
                wait.until(ExpectedConditions.visibilityOf(item));
                Actions actions = new Actions(driver);
                actions.moveToElement(item);
                return;
            }
        }
        Assert.fail("Не найден пункт меню - " + menuItem);

         */
        String path = String.format("//div[contains(text(),'Что вас интересует')]/" +
                "following-sibling::*//div[contains(text(),'%s')]", menuItem);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(path)));
        path = String.format("//div[contains(text(),'Что вас интересует')]/" +
                "following-sibling::*//span[contains(text(),'%s')]/parent::*",subMenu);
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(path))));
        driver.findElement(By.xpath(path)).click();

    }

   /* public void selectSubMenu(String menuItem){
        for (WebElement item:
             subMenuItem) {
                if(item.getAttribute("textContent").equalsIgnoreCase(menuItem)){
                    Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
                wait.until(ExpectedConditions.visibilityOf(item));
                item.click();
            }

        }
        Assert.fail("Не найден пункт меню - " + menuItem);
    }

    */



}
