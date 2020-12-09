import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class SmartphonePage {
    private SelenideElement gpsLink= $(byXpath("//a[contains(text(),', GPS')]"));


    public PhonesPage clickGpsLink(){
        executeJavaScript("window.scrollBy(0,1000)");
        gpsLink.waitUntil(Condition.visible, 5000).click();
        return new PhonesPage();
    }
}
