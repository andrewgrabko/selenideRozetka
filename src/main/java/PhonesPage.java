import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class PhonesPage {

    private SelenideElement mobLink= $x("//li[@class='portal-navigation__item']/a[@href='https://rozetka.com.ua/mobile-phones/c80003/']");

    public MobilePage clickMobLink(){
        mobLink.shouldBe(visible).click();
        return new MobilePage();
    }
}
