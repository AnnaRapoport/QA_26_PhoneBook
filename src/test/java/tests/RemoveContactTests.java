package tests;

import models.ContactDTO;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (!app.getHelperUser().isLoggedIn()) {
            app.getHelperUser().login(new User().setEmail("fanta@mail.ru").setPassword("Aa12345$"));
        }
        // app.getHelperContact().provideContacts();//if list size<3 contacts-->add 3 contacts

    }

    @Test
    public void removeFirstContact() {
        app.getHelperContact().openContacts();
        app.getHelperContact().removeFirstContact();
        //Assert list size less by one
        Assert.assertTrue(app.getHelperContact().isLessByOne());
    }
    @Test
    public void removeAllContact() {
        app.getHelperContact().openContacts();
        app.getHelperContact().removeAllContact();
        //Assert with text 'No Сontacts here!'
       Assert.assertEquals(app.getHelperContact().NoContactsText(),"No Contacts here!");
    }
}