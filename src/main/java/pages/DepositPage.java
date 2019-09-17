package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.function.Function;

public class DepositPage extends BasePage {
    Wait<WebDriver> wait = new WebDriverWait(driver, 15);
    @FindBy (xpath = "//div[contains(text(),'Валюта')]/following-sibling::*//input[contains(@value,'')]")
    List<WebElement> money;
    @FindBy (xpath = "//label[contains(text(),'')]")
    List<WebElement> field;
    @FindBy (xpath = "//li[contains(text(),'')]")
    List<WebElement> data;




    public void selectMoney(String string){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", driver.findElement(By.xpath("//h2[contains(text(),'Рассчитайте доходность')]")));
        for (WebElement item:
             money) {
            if(item.getAttribute("value").equalsIgnoreCase(string)){
                if(!item.isSelected()){
                    item.click();
                    return;
                }
            }

        }
       // Assert.fail("Не найден пункт меню - " + string);
    }

    public void selectField(String string, String value){
        for (WebElement item:
             field) {
            if (item.getAttribute("textContent").equalsIgnoreCase(string)){
                item.click();
                String path = String.format("//label[contains(text(),'%s')]/" +
                        "following-sibling::*//input", string);
                driver.findElement(By.xpath(path)).sendKeys(value);
                return;
            }
            
        }
        Assert.fail("Не найден пункт меню - " + string);

    }
    public void selectData(String string){
        String oldValue = driver.findElement(By.xpath("//div[contains(text(),'Ставка')]/span/span")).getAttribute("textContent");
        driver.findElement(By.xpath("//label[contains(text(),'На срок')]/following-sibling::*")).click();
        for (WebElement item:
             data) {
            if(item.getAttribute("textContent").equalsIgnoreCase(string)){
                wait.until(ExpectedConditions.visibilityOf(item));
                Function<? super WebDriver, Object> valueChanged = new ExpectedCondition<Object>() {
                    @Override
                    public Boolean apply(WebDriver webDriver) {
                        return !webDriver.findElement(By.xpath("//div[contains(text(),'Ставка')]/span/span")).getAttribute("textContent").equals(oldValue);
                    }
                };
                item.click();
                wait.until(valueChanged);
                return;
            }

        }
        Assert.fail("Не найден пункт меню - " + string);
    }

    public void checkBox(String string){
        String path = String.format("//span[contains(text(),'%s')]/parent::*/preceding-sibling::*//input", string);
        if(!driver.findElement(By.xpath(path)).isSelected()){
            path = String.format("//span[contains(text(),'%s')]/parent::*/preceding-sibling::*/div",string);
        }
        driver.findElement(By.xpath(path)).click();
    }

    public void assertDep(String string){
        Assert.assertEquals("Ставка", string, driver.findElement
                (By.xpath("//div[contains(text(),'Ставка')]/span/span")).getAttribute("textContent"));
    }
    public void assertDepResult(String string){
        Assert.assertEquals("к снятию через 6 месяцев", string, driver.findElement
                (By.xpath("//div[contains(text(),'К снятию через')]/following-sibling::*/" +
                        "span[contains(@class,'calc-result')]")).getAttribute("textContent"));
    }

    public void assertResult(String string){
        Assert.assertEquals("начислено", string, driver.findElement
                (By.xpath("//td[contains(text(),'Начислено')]/following-sibling::*//" +
                        "span[contains(@class,'calc-earned')]")).getAttribute("textContent"));
    }




}
