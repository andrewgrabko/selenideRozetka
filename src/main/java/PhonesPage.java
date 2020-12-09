import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PhonesPage {

    private SelenideElement mobLink= $(byXpath("//li[@class='portal-navigation__item']/a[@href='https://rozetka.com.ua/mobile-phones/c80003/']"));


    public MobilePage clickGpsLink(){

        mobLink.waitUntil(Condition.visible, 5000).click();
        return new MobilePage();
    }
}
