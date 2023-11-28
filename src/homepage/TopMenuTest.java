package homepage;
/*
 * 1. create class "TopMenuTest"
 * 1.1 create method with name "selectMenu" it has one parameter name "menu" of type
 * string
 * 1.2 This method should click on the menu whatever name is passed as parameter.
 * 1.3. create the @Test method name verifyPageNavigation.use selectMenu method to
 * select the Menu and click on it and verify the page navigation.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //1.1 create method with name "selectMenu" it has one parameter name "menu" of type
    //string
    public void selectMenu(String menu) {
        //1.2 This method should click on the menu whatever name is passed as parameter.
//        WebElement menuElement = driver.findElement(By.linkText(menu));
//        menuElement.click();
        clickOnElement(By.linkText(menu));
    }
   //create the @Test method name verifyPageNavigation.use selectMenu method to select the Menu and
   // click on it and verify the page navigation.
   @Test
    public void verifyPageNavigation(){
        selectMenu("Books");
        String expectedText = "Books";
        String actualText = getTextFromElement(By.xpath("(//a[normalize-space()='Books'])[1]"));
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}

