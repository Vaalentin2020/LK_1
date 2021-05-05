package PagerClass;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

public class PageElements {
    public void pageElementsToArray(){
        String[] links = new String[6];
        links[0] = "https://portal.demo.its-profit.ru/lk/start_parking";
        links[1] = "https://portal.demo.its-profit.ru/lk/parkings";
        links[2] = "https://portal.demo.its-profit.ru/lk/replenishment";
        links[3] = "https://portal.demo.its-profit.ru/lk/abonement";
        links[4] = "https://portal.demo.its-profit.ru/lk/profile";
        links[5] = "https://portal.demo.its-profit.ru/lk/cars";
    }
    public static void getLinks(){
        Selenide.$(By.cssSelector("body > div:nth-child(2) > div > div > div > nav > ul > li:nth-child(1) > a")).shouldHave(Condition.exactText("Начало парковки")).shouldBe(Condition.visible);
        Selenide.$(By.cssSelector("body > div:nth-child(2) > div > div > div.table-responsive.mb-4 > nav > ul > li:nth-child(2) > a")).shouldHave(Condition.exactText("История парковок / оплаты")).shouldBe(Condition.visible);
        Selenide.$(By.cssSelector("body > div:nth-child(2) > div > div > div.table-responsive.mb-4 > nav > ul > li:nth-child(3) > a")).shouldHave(Condition.exactText("Пополнение баланса")).shouldBe(Condition.visible);
        Selenide.$(By.cssSelector("body > div:nth-child(2) > div > div > div.table-responsive.mb-4 > nav > ul > li:nth-child(4) > a")).shouldHave(Condition.exactText("Абонементы")).shouldBe(Condition.visible);
        Selenide.$(By.cssSelector("body > div:nth-child(2) > div > div > div.table-responsive.mb-4 > nav > ul > li.nav-item.active > a")).shouldHave(Condition.exactText("Профиль")).shouldBe(Condition.visible);
        Selenide.$(By.cssSelector("body > div:nth-child(2) > div > div > div.table-responsive.mb-4 > nav > ul > li:nth-child(6) > a")).shouldHave(Condition.exactText("Автомобили")).shouldBe(Condition.visible);
    }
}

