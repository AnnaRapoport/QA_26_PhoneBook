package tests;

import manager.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {


    @BeforeMethod
    public void precondition(){
     if(app.getHelperUser().isLoggedIn()){
         app.getHelperUser().logout();
     }
    }


    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginRegistrationForm();//openform
        app.getHelperUser().fillLoginRegistrationForm("cola@mail.ru", "Zz12345$");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLoggedIn());

    }


    @Test
    public void loginSuccessModel() {
        app.getHelperUser().openLoginRegistrationForm();//openform
        app.getHelperUser().fillLoginRegistrationForm("cola@mail.ru", "Zz12345$");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLoggedIn());
    }
    @Test
    public void loginWrongEmail(){
        app.getHelperUser().openLoginRegistrationForm();//openform
        app.getHelperUser().fillLoginRegistrationForm("colamail.ru", "Zz12345$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }
    @Test
    public void loginWrongPassword(){
        app.getHelperUser().openLoginRegistrationForm();//openform
        app.getHelperUser().fillLoginRegistrationForm("cola@mail.ru", "Zz12345");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }
    @Test
    public void loginUnregUser(){
        app.getHelperUser().openLoginRegistrationForm();//openform
        app.getHelperUser().fillLoginRegistrationForm("fanta@mail.ru", "Zz12345$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }
}