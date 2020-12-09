import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MobilePage {

    private ElementsCollection valuesTitle = $$(byXpath("//span[text()=' Топ продаж ']/following-sibling::a[@class='goods-tile__heading']/span"));
    private ElementsCollection valuesPrice = $$(byXpath("//span[text()=' Топ продаж ']/following-sibling::div[@class='goods-tile__prices']//span[@class='goods-tile__price-value']"));
    private SelenideElement heading = $(byXpath("//h1[@class='catalog-heading']"));
    private ElementsCollection priceForRange = $$(byXpath("//span[@class='goods-tile__price-value']"));
    private SelenideElement dropDown = $(byXpath("//select[@class='select-css ng-untouched ng-pristine ng-valid']"));
    private SelenideElement select = $(byXpath("//option[text()=' От дешевых к дорогим ']"));
    private SelenideElement moreButton = $(byXpath("//span[@class='show-more__text']"));


    public List<String> getLValuesTitles(){
        moreButton.waitUntil(Condition.visible, 6000);
        ElementsCollection titles = $$(valuesTitle);
        List<String> valuesTitle = new ArrayList<>();
        for(SelenideElement value: titles){
            valuesTitle.add(value.getText());
        }
        return valuesTitle;
    }

    public List<String> getLValuesPrices(){
        moreButton.waitUntil(Condition.visible, 6000);
        ElementsCollection titles = $$(valuesPrice);
        List<String> valuesTitle = new ArrayList<>();
        for(SelenideElement value: titles){
            valuesTitle.add(value.getText());
        }
        return valuesTitle;
    }

    public List<String> getValuesTitlesPages(int page){
        List<String> titlePages = getLValuesTitles();
        List<String> pricePages = getLValuesPrices();
        for (int i = 2; i<=page; i++){
            String xpath = "//a[@class='pagination__link'][contains(text(),'%s')]";
            SelenideElement pagPage = $(byXpath(String.format(xpath,i)));
            pagPage.click();
            moreButton.waitUntil(Condition.visible, 5000);
            titlePages.addAll(getLValuesTitles());
            pricePages.addAll(getLValuesPrices());
        }
        int length = titlePages.size();
        ArrayList<String> titlePrice = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            titlePrice.add(titlePages.get(i) + " - " + pricePages.get(i));
        }
        return titlePrice;
    }

    public void newFile (List<String> titlePrice) throws IOException {
        FileWriter nFile = new FileWriter("C:/autodoc/result.txt");
        for (String i: titlePrice){
            nFile.write(i+"\n");
        }
        nFile.close();
    }

    public List<Integer> priceInt(){
        ElementsCollection prices = $$(priceForRange);
        List<String> priceInt = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (WebElement myInt: prices){
            list.add(Integer.parseInt(myInt.getText().replaceAll(" ","")));
            priceInt.add(myInt.getText());
        }
        return list;
    }

    public MobilePage clickDropDown(){
        dropDown.click();
        select.waitUntil(Condition.visible, 5000);
        return this;
    }

    public MobilePage selectFilter(){
        select.click();
        heading.waitUntil(Condition.visible, 5000);
        return this;
    }

    public void compareRange(){
        List<Integer> pricesRoz = new ArrayList<>(priceInt());
        Collections.sort(pricesRoz);
        Assert.assertEquals(priceInt(),pricesRoz);
    }



}
