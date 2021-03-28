package PagerClass;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

public class MainPage {
   /* public static void findZone(){
        Selenide.$(By.className("select2-selection__placeholder")).click();
        Selenide.$("body > span > span > span.select2-search.select2-search--dropdown > input").sendKeys("254");
        Selenide.$(By.cssSelector("#select2-map-search-results > li")).click();
        Selenide.$(Selectors.byId("select2-map-search-container")).shouldHave(Condition.attribute("title", "254 - Заречный б-р."));*/

    public static void beginParking(){
        Selenide.$(By.className("select2-selection__placeholder")).click();
        Selenide.$("body > span > span > span.select2-search.select2-search--dropdown > input").sendKeys("254 - Заречный б-р.");
        Selenide.$(By.cssSelector("#select2-map-search-results > li")).click();
        Selenide.$(By.cssSelector("#map > div.leaflet-pane.leaflet-map-pane > div.leaflet-pane.leaflet-marker-pane > div:nth-child(2) > div")).click();
        Selenide.$(By.cssSelector("#map > div.leaflet-pane.leaflet-map-pane > div.leaflet-pane.leaflet-popup-pane > div > div.leaflet-popup-content-wrapper > div > div > div:nth-child(3) > a")).click();

    }
}
