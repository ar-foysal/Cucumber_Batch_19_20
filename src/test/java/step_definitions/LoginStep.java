package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.DemoLoginPage;

import static utilities.DriverSetup.getDriver;

public class LoginStep {
    DemoLoginPage demoLoginPage = new DemoLoginPage();

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        getDriver().get(demoLoginPage.loginPageURL);
    }
    @When("User input valid username")
    public void user_input_valid_username() {
        demoLoginPage.writeOnElement(demoLoginPage.username, "standard_user");
    }
    @When("User input valid password")
    public void user_input_valid_password() {
        demoLoginPage.writeOnElement(demoLoginPage.password, "secret_sauce");
    }
    @When("User click on the login button")
    public void user_click_on_the_login_button() {
        demoLoginPage.clickOnElement(demoLoginPage.loginButton);
    }
    @Then("User successfully logged in")
    public void user_successfully_logged_in() {
        Assert.assertTrue((demoLoginPage.isElementVisible(demoLoginPage.productsTitle)));
    }
    @Then("User should see the inventory page")
    public void user_should_see_the_inventory_page() {
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }
    @When("User input invalid password")
    public void user_input_invalid_password() {
        demoLoginPage.writeOnElement(demoLoginPage.password, "secretsaucee");
    }

    @When("User input username {string}")
    public void user_input_username(String username) {
        demoLoginPage.writeOnElement(demoLoginPage.username, username);
    }
    @When("User input password {string}")
    public void user_input_password(String password) {
        demoLoginPage.writeOnElement(demoLoginPage.password, password);
    }

    @Then("User should be on the log in page")
    public void user_should_be_on_the_log_in_page() {
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/");

    }
    @Then("User should see an error message {string}")
    public void user_should_see_an_error_message(String errorMsg) {
        Assert.assertEquals(demoLoginPage.getElementText(demoLoginPage.error), errorMsg);
    }
}
