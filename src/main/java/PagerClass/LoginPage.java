package PagerClass;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import com.codeborne.selenide.Selectors;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public LoginPage(){
        
    }

    public static void authorisation(String phoneNumber, String password, String url){
        Selenide.open(url);
        int i = 0;
       while(i <= 9){
            char letter = phoneNumber.charAt(i);
            Selenide.$(By.id("authPhone")).sendKeys(String.valueOf(letter));
            Selenide.sleep(120);
            i++;
        }
        Selenide.$(By.id("authPassword")).setValue(password);
        Selenide.$(Selectors.byXpath("/html/body/div[2]/div/div/article/form/div[3]/div[1]/button")).click();
        Selenide.$(Selectors.byId("map")).shouldBe(Condition.visible);
    }
}
