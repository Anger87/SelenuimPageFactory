import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium_helper.utils.ConfigProperties;
import selenium_helper.utils.KeyboardEmulation;

import java.io.IOException;

public class DriverFixture {

    public static final String URL = "http://todomvc.com/examples/backbone/";

    public static WebDriver driver;
    public static WebDriverWait wait;
    private static ChromeDriverService service;
    public static KeyboardEmulation keyboardEmulation = new KeyboardEmulation();

    @Before
    public  void setUp() throws IOException {
        System.setProperty(ConfigProperties.getProperty("chrome"), ConfigProperties.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 15);
        driver.get(URL);
    }



    @After
    public  void tearDown() {
        driver.quit();
    }

}
