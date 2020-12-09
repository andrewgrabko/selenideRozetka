import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected MainPage mainPage;
    protected SmartphonePage smartphonePage;
    protected PhonesPage phonesPage;
    protected MobilePage mobilePage;

    @BeforeTest
    public void setBrowser(){
        Configuration.startMaximized = true;
        //Configuration.holdBrowserOpen = true;
        mainPage = new MainPage();
        smartphonePage = new SmartphonePage();
        phonesPage = new PhonesPage();
        mobilePage = new MobilePage();

    }







}
