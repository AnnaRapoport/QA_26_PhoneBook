package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        if(app.getHelperUser().isLoggedIn()){
            app.getHelperUser().logout();
        }
    }


    @Test
    public void registrationSuccessful(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        System.out.println(i);
        User user = new User()
                .setEmail("sprite"+i+"@mail.ru")
                .setPassword("Aa12345$");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isRegistered());
    }
 @AfterMethod
    public void postCondition(){
        app.getHelperUser().logout();
    }
}
