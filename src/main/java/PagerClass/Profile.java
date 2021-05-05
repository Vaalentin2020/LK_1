package PagerClass;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import com.codeborne.selenide.Selectors;

import static com.codeborne.selenide.Selenide.$;

public class Profile {
    public static SelenideElement getProfileNameField() {
        return $("#profileName");
    }
    public static SelenideElement getRefreshButton(){
        return $(By.cssSelector("body > div:nth-child(2) > div > div > form > div:nth-child(6) > div > button"));
    }

    public static void openProfile(String phoneNumber){
        $(Selectors.byClassName("person")).click();
        $(Selectors.byCssSelector("body > div.container.layout.smallpage > header > div > div.col-md-4.col-2.lk-wrapper.d-flex.align-items-center.justify-content-end > div.d-none.d-md-flex.dropdown.person-wrap.show > div.dropdown-menu.dropdown-menu-right.show > a:nth-child(2)")).click();
        $(Selectors.byId("profilePhone")).shouldHave(Condition.value(phoneNumber));
        $(Selectors.byCssSelector("body > div.container.layout.smallpage > header > div > div:nth-child(1) > div > a.col-md-2.logo > img")).shouldHave(Condition.exist);
        $(Selectors.byCssSelector("body > div.footer > div > div > div.col-md-5.copyright.text-md-right.text-center")).shouldHave(Condition.exactText("Copyright © 2009-2021, ПАО \"МегаФон\""));
    }

    public static void changeName(){
        String Testname = "Иван Иванович Иванов";               //Тестовое имя
        String ActualName = getProfileNameField().getValue();   //Переменная для существующего имени
        getProfileNameField().clear();                          //Очищаем поле "Имя"
        getProfileNameField().sendKeys(Testname);
        getRefreshButton().click();  //Кнопка "Обновить данные"
        Selenide.sleep(1000);
        $(By.cssSelector("body > div:nth-child(2) > div > div > div.profit-alert.alert.alert-success")).shouldBe(Condition.exist);  //Проверяем, что появилась строка с подтверждением смены имени
        getProfileNameField().shouldHave(Condition.value(Testname));     //Проверяем, что введенное имя совпадает с TestName
        getProfileNameField().clear();
        getProfileNameField().sendKeys(ActualName);                      //Возвращаем первое имя из переменное ActualName
        getRefreshButton().click();
        //Представить поиск в виде объекта для обращения
    }
    public static void changePassword(String testPassword, String url, String phoneNumber, String password) {
        $("#authPassword").sendKeys(testPassword);              //Вставляем новый пароль в первое поле
        $(By.id("registerPassword1")).sendKeys(testPassword);   //Вставляем новый пароль во второе поле
        $(By.cssSelector("body > div:nth-child(2) > div > div > form > div:nth-child(6) > div > button")).click();
        $(By.cssSelector("body > div.container.layout.smallpage > header > div > div.col-md-4.col-2.lk-wrapper.d-flex.align-items-center.justify-content-end > div.d-none.d-md-flex.dropdown.person-wrap > div.person")).click();
        $(By.cssSelector("body > div.container.layout.smallpage > header > div > div.col-md-4.col-2.lk-wrapper.d-flex.align-items-center.justify-content-end > div.d-none.d-md-flex.dropdown.person-wrap.show > div.dropdown-menu.dropdown-menu-right.show > a:nth-child(3)")).click();
        int i = 0;
        while (i <= 9 ){
            char letter = phoneNumber.charAt(i);
            $(By.id("authPhone")).sendKeys(String.valueOf(letter));
            Selenide.sleep(120);
            i++;
        }
        $(By.id("authPassword")).setValue(testPassword);
        $(By.cssSelector("body > div:nth-child(2) > div > div > article > form > div.row.d-flex.align-items-center > div.col-12.col-md-4.mt-2 > button")).click();
        //В этой части заходим в Профиль и возвращаем старый пароль
        $(Selectors.byClassName("person")).click();
        $(Selectors.byCssSelector("body > div.container.layout.smallpage > header > div > div.col-md-4.col-2.lk-wrapper.d-flex.align-items-center.justify-content-end > div.d-none.d-md-flex.dropdown.person-wrap.show > div.dropdown-menu.dropdown-menu-right.show > a:nth-child(2)")).click();
        $("#authPassword").sendKeys(password);              //Вставляем старый пароль в первое поле
        $(By.id("registerPassword1")).sendKeys(password);   //Вставляем старый пароль во второе поле
        $(By.cssSelector("body > div:nth-child(2) > div > div > form > div:nth-child(6) > div > button")).click();
    }
    public static void PageElements(){
        $(By.cssSelector("body > div.container.layout.smallpage > header > div > div:nth-child(1) > div > a.col-md-2.logo > img")).shouldBe(Condition.visible);
        $(By.cssSelector("body > div.footer > div > div > div.col-md-5.copyright.text-md-right.text-center")).shouldHave(Condition.exactText("Copyright © 2009-2021, ПАО \"МегаФон\""));
        $(By.cssSelector("body > div.container.layout.smallpage > header > div > div.col-md-4.col-8.contact-center.d-flex.justify-content-center.align-items-center.flex-column > a")).shouldBe(Condition.visible);
    }

}
