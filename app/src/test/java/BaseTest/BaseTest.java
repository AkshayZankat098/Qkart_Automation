package BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import PageObjectFile.PageObject_Flipkart;
import PageObjectFile.PageObject_QkartLogin;
import PageObjectFile.PageObject_Registration;
import PageObjectFile.PageObject_Searchbox;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    public static WebDriver driver;
    protected PageObject_QkartLogin loginPage;          // ✅ Accessible to child test classes
    protected PageObject_Registration registration;     // ✅ Accessible to child test classes
    protected PageObject_Searchbox searchbox;           // ✅ Accessible to child test classes    
    protected PageObject_Flipkart flipkart;             // ✅ Accessible to child test classes

    public void initializeBrowserAndPage() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //✅ Initialize Page Object
        loginPage = new PageObject_QkartLogin(driver);
        registration = new PageObject_Registration(driver);
        searchbox = new PageObject_Searchbox(driver);
        flipkart = new PageObject_Flipkart(driver);

        driver.get("https://www.flipkart.com/");
        String CurrentURL = driver.getCurrentUrl();
        
        if (CurrentURL.contains("flipkart")) {
            System.out.println("Navigated to the flipkart");
        }

    }

    @AfterTest
    public void CloseBrowser() {
        driver.quit();
    }

}
