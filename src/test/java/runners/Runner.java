package runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Runner {

    public static WebDriver driver;

    @BeforeClass
    public static void setupTest() {
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void endupTest() {
        driver.quit();
    }
}
