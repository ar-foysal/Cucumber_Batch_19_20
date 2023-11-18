package pages;

import org.openqa.selenium.By;

public class DemoLoginPage extends BasePage{

    public String loginPageURL = "https://www.saucedemo.com";
    public By username = By.xpath("//input[@id='user-name']");
    public By password = By.xpath("//input[@id='password']");
    public By loginButton = By.xpath("//input[@id='login-button']");
    public By error = By.xpath("//h3[@data-test='error']");
    public By productsTitle = By.xpath("//span[@class='title']");

    public void doLogin(String username_text, String password_text){
        writeOnElement(username, username_text);
        writeOnElement(password, password_text);
        clickOnElement(loginButton);
    }
}
