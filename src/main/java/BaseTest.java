import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class BaseTest {

    @BeforeTest
    public void setBrowser(){
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
    }

    @AfterTest
    private void close() {
        closeWebDriver();
    }



}
