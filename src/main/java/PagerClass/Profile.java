package PagerClass;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import com.codeborne.selenide.Selectors;

public class Profile {
    public static void openProfile(String phoneNumber){
        Selenide.$(Selectors.byClassName("person")).click();
        Selenide.$(Selectors.byCssSelector("body > div.container.layout.smallpage > header > div > div.col-md-4.col-2.lk-wrapper.d-flex.align-items-center.justify-content-end > div.d-none.d-md-flex.dropdown.person-wrap.show > div.dropdown-menu.dropdown-menu-right.show > a:nth-child(2)")).click();
        Selenide.$(Selectors.byId("profilePhone")).shouldHave(Condition.value(phoneNumber));
        Selenide.$(Selectors.byCssSelector("body > div.container.layout.smallpage > header > div > div:nth-child(1) > div > a.col-md-2.logo > img")).shouldHave(Condition.exist);
        //Проверить присутствие ссылое на другие страницы, представив их url в виде массива
        Selenide.$(Selectors.byCssSelector("body > div.footer > div > div > div.col-md-5.copyright.text-md-right.text-center")).shouldHave(Condition.exactText("Copyright © 2009-2021, ПАО \"МегаФон\""));
    }

    public static void changeName(){
        String Testname = "Иван Иванович Иванов";                          //Тестовое имя
        String ActualName = Selenide.$(By.id("profileName")).getValue();   //Переменная для существующего имени
        Selenide.$(By.id("profileName")).clear();                          //Очищаем поле "Имя"
        Selenide.$(By.id("profileName")).sendKeys(Testname);
        Selenide.$(By.cssSelector("body > div:nth-child(2) > div > div > form > div:nth-child(6) > div > button")).click();
        Selenide.sleep(1000);
        Selenide.$(By.cssSelector("body > div:nth-child(2) > div > div > div.profit-alert.alert.alert-success")).shouldBe(Condition.exist);  //Проверяем, что появилась строка с подтверждением смены имени
        Selenide.$(By.id("profileName")).shouldHave(Condition.value(Testname));     //Проверяем, что введенное имя совпадает с TestName
        Selenide.$(By.id("profileName")).clear();
        Selenide.$(By.id("profileName")).sendKeys(ActualName);                      //Возвращаем первое имя из переменное ActualName
        Selenide.$(By.cssSelector("body > div:nth-child(2) > div > div > form > div:nth-child(6) > div > button")).click();



    }
}
