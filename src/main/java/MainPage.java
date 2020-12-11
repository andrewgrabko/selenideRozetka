import com.codeborne.selenide.*;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private SelenideElement smartphone = $(byXpath("//sidebar-fat-menu//li[2]//a[1]"));


    public SmartphonePage clickSmartphone(){
        smartphone.shouldBe(visible).click();
        executeJavaScript("window.scrollBy(0,1000)");
        return new SmartphonePage();
    }


}
