
import org.example.SwagLoginTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class SetUp {
    protected WebDriver driver;
    protected SwagLoginTest swagLoginTest;

    @BeforeClass
    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--ignore-certificate-errors");
//        chromeOptions.addArguments("--ignore-ssl-errors=yes");
        driver = new ChromeDriver(chromeOptions);
        goLoginPage();
    }

    public void goLoginPage() {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        swagLoginTest = new SwagLoginTest(driver);
    }

    @AfterClass
    public void Quit() {
        driver.quit();
    }
}