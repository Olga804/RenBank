package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseStep {
    private static WebDriver driver;
    private static String baseUrl;
    private static Properties properties = TestProperties.getInstance().getProperties();



    @Before
    public static void setUp() throws Exception{
        System.setProperty("webdriver.chrome.driver", properties.getProperty("path.chrome"));
        driver = new ChromeDriver();
        baseUrl = properties.getProperty("url");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }
    @After
    public static void tearDown()throws Exception{
        driver.quit();
    }
    public static WebDriver getDriver() {
        return driver;
    }
}
