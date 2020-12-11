import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SmartphonePage {

    private SelenideElement gpsLink= $x("//a[contains(text(),', GPS')]");

    public PhonesPage clickGpsLink(){
        executeJavaScript("window.scrollBy(0,1000)");
        gpsLink.shouldBe(visible).click();
        return new PhonesPage();
    }
}
