package utilities;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public abstract class TestBase {
   protected WebDriver driver ;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
       // driver.close();
    }

    //Select Visible Text Dropdown
    public void selectVisile(WebElement ddm, String option){
        Select slect = new Select(ddm);
        slect.selectByVisibleText(option);
    }

    // Select Index Dropdown
    public void selectIndex(WebElement ddm, int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    // Hard Wait
    public void waitForSecond(int second) {

        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}




