import PagerClass.LoginPage;
import PagerClass.MainPage;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainTest {
    public MainTest() {
    }

    public String phoneNumber = "9001228916";
    public String password = "40E9Qb9Z";
    public String url = "https://portal.demo.its-profit.ru/lk/auth";


    @BeforeTest
    public void checkAuthorisation() {
        Configuration.startMaximized = true;
        LoginPage.authorisation(this.phoneNumber, this.password, this.url);
    }

    public static class MainPageTest{
        //@Test
        //void FindZoneCheck() { PagerClass.MainPage.findZone();}
        @Test
        void beginParkingCheck(){
            MainPage.beginParking();
        }

    }
}

