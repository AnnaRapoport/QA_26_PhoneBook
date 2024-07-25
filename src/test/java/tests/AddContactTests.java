package tests;

import models.ContactDTO;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{

    @BeforeClass
    public void precondition(){
        if(!app.getHelperUser().isLoggedIn()){
            app.getHelperUser().login(new User().setEmail("fanta@mail.ru").setPassword("Aa12345$"));
        }
    }
    @Test(invocationCount = 5)
    public void  addContactSuccessful(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        ContactDTO contact = ContactDTO.builder()
                .name("Vasya"+i)
                .lastName("Stark")
                .phone("12345678"+ i)
                .email("vasya.stark@mail.ru")
                .address("123 Main")
                .description("The")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));



    }

    @Test
    public void addContactSuccessReqFields() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        ContactDTO contact = ContactDTO.builder()
                .name("Tony")
                .lastName("Stark")
                .phone("3434343"+i)
                .email("stark"+i+"@gmail.com")
                .address("NY")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));
    }


    @Test
    public void addNewContactWrongName(){
        ContactDTO contact = ContactDTO.builder()
                .name("")
                .lastName("Stark")
                .phone("34343436665")
                .email("stark@gmail.com")
                .address("NY")
                .description("Friend")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
    }

    @Test
    public void addNewContactWrongAddress(){
        ContactDTO contact = ContactDTO.builder()
                .name("Tony")
                .lastName("Stark")
                .phone("34343434444")
                .email("stark@gmail.com")
                .address("")
                .description("Friend")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());

    }

    @Test
    public void addNewContactWrongLastName(){
        ContactDTO contact = ContactDTO.builder()
                .name("Tony")
                .lastName("")
                .phone("34343435555")
                .email("stark@gmail.com")
                .address("NY")
                .description("Friend")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());

    }



    @Test
    public void addNewContactWrongPhone(){
        ContactDTO contact = ContactDTO.builder()
                .name("Tony")
                .lastName("Stark")
                .phone("")
                .email("stark@gmail.com")
                .address("NY")
                .description("Friend")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperContact().isAlertPresent(" Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));

    }

    @Test
    public void addNewContactWrongEmail(){
        ContactDTO contact = ContactDTO.builder()
                .name("Tony")
                .lastName("Stark")
                .phone("34343444443")
                .email("starkgmail.com")
                .address("NY")
                .description("Friend")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperContact().isAlertPresent("Email not valid"));


    }


}
