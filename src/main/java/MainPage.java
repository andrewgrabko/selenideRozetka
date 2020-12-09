import com.codeborne.selenide.*;


import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private SelenideElement smartphone = $(byXpath("//sidebar-fat-menu//li[2]//a[1]"));


    public SmartphonePage clickSmartphone(){
        smartphone.waitUntil(Condition.visible, 5000).click();
        executeJavaScript("window.scrollBy(0,1000)");
        return new SmartphonePage();
    }


}
