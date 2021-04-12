import PagerClass.LoginPage;
import PagerClass.MainPage;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class MainTest {
    public MainTest() {
    }

    public String phoneNumber = "9001228916";
    public String password = "40E9Qb9Z";
    public String url = "https://portal.demo.its-profit.ru/lk/auth";
    public String testPassword = "123456";

    @BeforeTest
    public void checkAuthorisation() {
        Configuration.startMaximized = true;
        LoginPage.authorisation(this.phoneNumber, this.password, this.url);
    }
    public void pageElementsToArray(){
        String[] links = new String[6];
        links[0] = "https://portal.demo.its-profit.ru/lk/start_parking";
        links[1] = "https://portal.demo.its-profit.ru/lk/parkings";
        links[2] = "https://portal.demo.its-profit.ru/lk/replenishment";
        links[3] = "https://portal.demo.its-profit.ru/lk/abonement";
        links[4] = "https://portal.demo.its-profit.ru/lk/profile";
        links[5] = "https://portal.demo.its-profit.ru/lk/cars";
    }
    @AfterClass
    public void checkLinksArray(){

    }



    /*public static class MainPageTest{
        @Test
        void FindZoneCheck() { PagerClass.MainPage.findZone();}
        @Test
        void beginParkingCheck(){
            MainPage.beginParking();
        }*/

}

