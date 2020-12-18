import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MobilePage {

    private ElementsCollection valuesTitles = $$x("//span[text()=' Топ продаж ']/following-sibling::a[@class='goods-tile__heading']/span");
    private ElementsCollection valuesPrices = $$x("//span[text()=' Топ продаж ']/following-sibling::div[@class='goods-tile__prices']//span[@class='goods-tile__price-value']");
    private SelenideElement heading = $x("//h1[@class='catalog-heading']");
    private ElementsCollection priceForRange = $$x("//span[@class='goods-tile__price-value']");
    private SelenideElement dropDown = $x("//select[@class='select-css ng-untouched ng-pristine ng-valid']");
    private SelenideElement select = $x("//option[text()=' От дешевых к дорогим ']");
    private SelenideElement moreButton = $x("//span[@class='show-more__text']");
    private SelenideElement pagPage(int position) {
        return $x((String.format( "//a[@class='pagination__link'][contains(text(),'%s')]", position)));
    }


    public List<String> getLValuesTitles(){
        moreButton.shouldBe(visible);
        List<String> valuesTitle = new ArrayList<>();
        for(SelenideElement value: valuesTitles){
            valuesTitle.add(value.getText());
        }
        return valuesTitle;
    }

    public List<String> getLValuesPrices(){
        moreButton.shouldBe(visible);
        List<String> valuesPrice = new ArrayList<>();
        for(SelenideElement value: valuesPrices){
            valuesPrice.add(value.getText());
        }
        return valuesPrice;
    }

    public List<String> getValuesTitlesPages(int page){
        List<String> titlePages = getLValuesTitles();
        List<String> pricePages = getLValuesPrices();
        for (int i = 2; i<=page; i++){
            pagPage(i).click();
            moreButton.shouldBe(visible);
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

    public MobilePage newFile () throws IOException {
        List<String> listPricesTitles = this.getValuesTitlesPages(3);
        FileWriter nFile = new FileWriter("C:/autodoc/result.txt");
        for (String i:listPricesTitles){
            nFile.write(i+"\n");
        }
        nFile.close();
        return this;
    }

    public List<Integer> priceInt(){
        List<String> priceInt = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (SelenideElement myInt: priceForRange){
            list.add(Integer.parseInt(myInt.getText().replaceAll(" ","")));
            priceInt.add(myInt.getText());
        }
        return list;
    }

    public MobilePage clickDropDown(){
        dropDown.click();
        select.shouldBe(visible);
        return this;
    }

    public MobilePage selectFilter(){
        select.click();
        heading.shouldBe(visible);
        return this;
    }

    public void compareRange(){
        List<Integer> pricesRoz = new ArrayList<>(priceInt());
        Collections.sort(pricesRoz);
        Assert.assertEquals(priceInt(),pricesRoz);
    }



}
