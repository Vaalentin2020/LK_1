import PagerClass.Profile;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TestProfile extends MainTest{
    MainTest mainTest = new MainTest();

    @Test
    public void ProfileTest() {
        Profile.openProfile(mainTest.phoneNumber);
        Profile.changeName();
        Profile.changePassword(mainTest.testPassword, mainTest.url, mainTest.phoneNumber, mainTest.password);
    }
    @AfterTest
    public void checkPageElements(){
        Profile.PageElements();
    }

   // @Test
    //public void changingNameTest(){
      //  Profile.changeName();
    //}
}
