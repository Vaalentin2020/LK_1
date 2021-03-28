import PagerClass.Profile;
import org.testng.annotations.Test;

public class TestProfile extends MainTest{
    MainTest mainTest = new MainTest();

    @Test
    public void OpenProfileTest() {
        Profile.openProfile(mainTest.phoneNumber);
        Profile.changeName();
    }
   // @Test
    //public void changingNameTest(){
      //  Profile.changeName();
    //}
}
