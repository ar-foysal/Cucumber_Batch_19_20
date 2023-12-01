package pages;

import org.openqa.selenium.By;

public class DemoProductPage extends BasePage{
    public By addToCartButton = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    public By cartItemCount = By.xpath("//span[@class='shopping_cart_badge']");
    public By removeCartItemButton = By.xpath("//button[@id='remove-sauce-labs-backpack']");

    public String getCurrentCartItemCount(){
        return getElementText(cartItemCount);
    }

}
