package tests;

import manager.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginSuccess() {
        app.getHelperUser().openLoginRegistrationForm();//openform
        app.getHelperUser().fillLoginRegistrationForm("cola@mail.ru", "Zz12345$");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLoggedIn());
    }
}