package manager;

import models.ContactDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperContact extends HelperBase {

    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openContactForm() {

        click(By.xpath("//a[normalize-space()='ADD']")); //(//a[.='ADD']"));
    }

    public void openContacts() {

        click(By.xpath("//a[normalize-space()='CONTACTS']")); //(//a[.='ADD']"));
    }

    public void fillContactForm(ContactDTO contact) {
        pause(5000);
        type(By.cssSelector("[placeholder='Name']"), contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"), contact.getLastName());
        type(By.cssSelector("[placeholder='Phone']"), contact.getPhone());
        type(By.cssSelector("[placeholder='email']"), contact.getEmail());
        type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector("[placeholder='description']"), contact.getDescription());
    }


    public void saveContact() {
        click(By.cssSelector(".add_form__2rsm2>button"));
    }

    public boolean isContactAddedByName(String name) {
        List<WebElement> list = wd.findElements(By.cssSelector("h2"));

        for (WebElement element : list) {
            if (element.getText().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void removeFirstContact() {
        List<WebElement> list = wd.findElements(By.cssSelector("h2"));
        WebElement firstContact = list.get(0);//first contact
        firstContact.click();
        wd.findElement(By.xpath("//button[text()='Remove']")).click();
    }

    public boolean isLessByOne() {
        List<WebElement> list = wd.findElements(By.cssSelector("h2"));
        for (WebElement element : list) {
            if (!list.isEmpty()) {
                list.remove(0);
            }
            return true;
        }
        return false;
    }

    public boolean isContactAddedByPhone(String phone) {
        List<WebElement> list
                = wd.findElements(By.cssSelector("h3"));

        for (WebElement element : list) {
            if (element.getText().equals(phone)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAddPageStillDisplayed() {
        return isElementPresent(By.cssSelector("a.active[href='/add']"));
    }

    public void removeAllContact() {
        List<WebElement> list = wd.findElements(By.cssSelector("h2"));
        if (!list.isEmpty()) {
            for (WebElement element : list) {
                element.click();
                wd.findElement(By.xpath("//button[normalize-space()='Remove']")).click();
            }
        }
    }

    public String NoContactsText() {
         String text= wd.findElement(By.cssSelector("div[class='contact-page_message__2qafk'] h1")).getText();
        return text;
    }
}