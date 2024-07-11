package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm() {
//        WebElement loginTab= wd.findElement(By.cssSelector("//*[text()='LOGIN']"));
//        loginTab.click();
        click(By.xpath("//*[text()='LOGIN']"));
    }

    public void fillLoginRegistrationForm(String email, String password) {
        //WebElement emailInput =  wd.findElement(By.name("email"));
        //emailInput.click();
        //emailInput.clear();
        //emailInput.sendKeys(email);
        // WebElement passwordInput = wd.findElement(By.xpath("//input[2]"));
        type(By.name("email"), email);
        type(By.xpath("//input[2]"), password);
    }

    public void fillLoginRegistrationForm(User user) {
        type(By.name("email"), user.getEmail());
        type(By.xpath("//input[2]"), user.getPassword());
    }

    public void submitLogin() {
        click(By.xpath("//button[@name='login']"));

    }

    public void submitRegistration() {
        click(By.name("registration"));
    }

    public boolean isLoggedIn() {
        return isElementPresent(By.xpath("//button[text()='Sign Out']"));
    }

    public boolean isRegistered() {
        return isElementPresent(By.cssSelector("[href='/add']"));
    }
public void logout(){
        click(By.xpath("//button[text()='Sign Out']"));

}

}
