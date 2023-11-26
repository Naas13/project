package core;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract public class BaseTest {
    protected static WebDriver driver;

    @BeforeAll
    public void setUp(){
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("safebrowsing.enabled", "true");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("D:\\chromium-gost\\chrome.exe");
        options.addArguments("--start-maximized");
        options.setExperimentalOption("prefs", chromePrefs);
        options.addExtensions(new File("src/main/resources/1.2.7.crx"));
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        BasePage.setDriver(driver);
    }

    @AfterAll
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}
