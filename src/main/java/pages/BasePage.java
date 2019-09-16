package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import steps.BaseStep;



public class BasePage {
    WebDriver driver = BaseStep.getDriver();

    public BasePage(){
        PageFactory.initElements(driver, this);
    }

}
