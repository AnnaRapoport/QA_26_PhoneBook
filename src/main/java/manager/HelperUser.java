package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void openLoginRegistrationForm(){
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
        type(By.name("email"),email);
        type(By.xpath("//input[2]"),password);
    }
public void submitLogin(){
    click(By.xpath("//button[@name='login']"));

}
public boolean isLoggedIn(){
return isElementPresent(By.xpath("//button[text()='Sign Out']"));


}
}
