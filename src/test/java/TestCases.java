import org.example.SwagBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.AssertJUnit.assertEquals;

public class TestCases extends SetUp {
    SoftAssert softAssert = new SoftAssert();

    @Test(priority = 0)
    public void checkUserNAmeAndPasswordInMainScreen() {
        softAssert.assertTrue(swagLoginTest.usernameVisibility());
        softAssert.assertTrue(swagLoginTest.passwordVisibility());
        softAssert.assertTrue(swagLoginTest.loginBtnVisibility());
    }

    @Test(priority = 1)
    public void checkValidCredentials() {
        swagLoginTest.enterUsername("standard_user");
        swagLoginTest.enterPassword("secret_sauce");
        SwagBaseTest swagBaseTest = swagLoginTest.clickLoginBtn();
        Assert.assertTrue(swagBaseTest.checkSwagLabsTextIsDisplayed());
        swagBaseTest.returnToLoginPage();
    }

    @Test(priority = 2)
    public void checkInvalidCredentials() {
        swagLoginTest.enterUsername("test");
        swagLoginTest.enterPassword("secret_sauce");
        swagLoginTest.clickLoginBtn();
        Assert.assertEquals(swagLoginTest.getErrorMessageText(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test(priority = 3)
    public void testEmptyCredentials( ) {
        String expectedUserNameErrorMessage = "Epic sadface: Username is required";
        String expectedPasswordErrorMessage = "Epic sadface: Password is required";
        String username = "";
        String password = "";
        swagLoginTest.clearAllFields();
        swagLoginTest.enterUsername(username);
        swagLoginTest.enterPassword(password);
        swagLoginTest.clickLoginBtn();
        Assert.assertTrue(swagLoginTest.getEmptyFieldErrorMessage().contains(expectedUserNameErrorMessage)
                || swagLoginTest.getEmptyFieldErrorMessage().contains(expectedPasswordErrorMessage));
    }


}
