import com.codeborne.selenide.Configuration;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;

public class TestRozetka extends BaseTest {


    @Test
    public void firstTest() throws IOException {
        open("https://rozetka.com.ua/");
        new MainPage()
                .clickSmartphone()
                .clickGpsLink()
                .clickMobLink()
                .newFile()
                .clickDropDown()
                .selectFilter()
                .compareRange();


    }

}
