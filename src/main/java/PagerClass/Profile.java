package PagerClass;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import com.codeborne.selenide.Selectors;
import org.testng.annotations.AfterTest;

public class Profile {
    public static void openProfile(String phoneNumber){
        Selenide.$(Selectors.byClassName("person")).click();
        Selenide.$(Selectors.byCssSelector("body > div.container.layout.smallpage > header > div > div.col-md-4.col-2.lk-wrapper.d-flex.align-items-center.justify-content-end > div.d-none.d-md-flex.dropdown.person-wrap.show > div.dropdown-menu.dropdown-menu-right.show > a:nth-child(2)")).click();
        Selenide.$(Selectors.byId("profilePhone")).shouldHave(Condition.value(phoneNumber));
        Selenide.$(Selectors.byCssSelector("body > div.container.layout.smallpage > header > div > div:nth-child(1) > div > a.col-md-2.logo > img")).shouldHave(Condition.exist);
        //Нужно проверить присутствие ссылок на другие страницы, представив их url-ы в виде массива
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
        //Представить поиск в виде объекта для обращения
    }
    public static void changePassword(String testPassword, String url, String phoneNumber, String password) {
        Selenide.$("#authPassword").sendKeys(testPassword);              //Вставляем новый пароль в первое поле
        Selenide.$(By.id("registerPassword1")).sendKeys(testPassword);   //Вставляем новый пароль во второе поле
        Selenide.$(By.cssSelector("body > div:nth-child(2) > div > div > form > div:nth-child(6) > div > button")).click();
        Selenide.$(By.cssSelector("body > div.container.layout.smallpage > header > div > div.col-md-4.col-2.lk-wrapper.d-flex.align-items-center.justify-content-end > div.d-none.d-md-flex.dropdown.person-wrap > div.person")).click();
        Selenide.$(By.cssSelector("body > div.container.layout.smallpage > header > div > div.col-md-4.col-2.lk-wrapper.d-flex.align-items-center.justify-content-end > div.d-none.d-md-flex.dropdown.person-wrap.show > div.dropdown-menu.dropdown-menu-right.show > a:nth-child(3)")).click();
        int i = 0;
        while (i <= 9 ){
            char letter = phoneNumber.charAt(i);
            Selenide.$(By.id("authPhone")).sendKeys(String.valueOf(letter));
            Selenide.sleep(120);
            i++;
        }
        Selenide.$(By.id("authPassword")).setValue(testPassword);
        Selenide.$(By.cssSelector("body > div:nth-child(2) > div > div > article > form > div.row.d-flex.align-items-center > div.col-12.col-md-4.mt-2 > button")).click();
        //В этой части заходим в Профиль и возвращаем старый пароль
        Selenide.$(Selectors.byClassName("person")).click();
        Selenide.$(Selectors.byCssSelector("body > div.container.layout.smallpage > header > div > div.col-md-4.col-2.lk-wrapper.d-flex.align-items-center.justify-content-end > div.d-none.d-md-flex.dropdown.person-wrap.show > div.dropdown-menu.dropdown-menu-right.show > a:nth-child(2)")).click();
        Selenide.$("#authPassword").sendKeys(password);              //Вставляем старый пароль в первое поле
        Selenide.$(By.id("registerPassword1")).sendKeys(password);   //Вставляем старый пароль во второе поле
        Selenide.$(By.cssSelector("body > div:nth-child(2) > div > div > form > div:nth-child(6) > div > button")).click();
    }
    public static void PageElements(){
        Selenide.$(By.cssSelector("body > div.container.layout.smallpage > header > div > div:nth-child(1) > div > a.col-md-2.logo > img")).shouldBe(Condition.visible);
        Selenide.$(By.cssSelector("body > div.footer > div > div > div.col-md-5.copyright.text-md-right.text-center")).shouldHave(Condition.exactText("Copyright © 2009-2021, ПАО \"МегаФон\""));
        Selenide.$(By.cssSelector("body > div.container.layout.smallpage > header > div > div.col-md-4.col-8.contact-center.d-flex.justify-content-center.align-items-center.flex-column > a")).shouldBe(Condition.visible);
    }
}
