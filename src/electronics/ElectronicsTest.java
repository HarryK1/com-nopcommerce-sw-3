package electronics;
/*
 * Create the class ElectronicsTest
 * Write the following test
 * 1. Test name verifyUserShouldNavigateToCellPhonesPageSuccessfully()
 * 1.1 Mouse Hover on “Electronics” Tab
 * 1.2 Mouse Hover on “Cell phones” and click
 * 1.3 Verify the text “Cell phones”
 * 2. Test name verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()
 * 2.1 Mouse Hover on “Electronics” Tab
 * 2.2 Mouse Hover on “Cell phones” and click
 * 2.3 Verify the text “Cell phones”
 * 2.4 Click on List View Tab
 * 2.5 Click on product name “Nokia Lumia 1020” link
 *
 * 2.6 Verify the text “Nokia Lumia 1020”
 * 2.7 Verify the price “$349.00”
 * 2.8 Change quantity to 2
 * 2.9 Click on “ADD TO CART” tab
 * 2.10 Verify the Message "The product has been added to your shopping cart" on Top
 * green Bar
 * After that close the bar clicking on the cross button.
 * 2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
 * 2.12 Verify the message "Shopping cart"
 * 2.13 Verify the quantity is 2
 * 2.14 Verify the Total $698.00
 * 2.15 click on checkbox “I agree with the terms of service”
 * 2.16 Click on “CHECKOUT”
 * 2.17 Verify the Text “Welcome, Please Sign In!”
 * 2.18 Click on “REGISTER” tab
 * 2.19 Verify the text “Register”
 * 2.20 Fill the mandatory fields
 * 2.21 Click on “REGISTER” Button
 * 2.22 Verify the message “Your registration completed”
 * 2.23 Click on “CONTINUE” tab
 * 2.24 Verify the text “Shopping card”
 * 2.25 click on checkbox “I agree with the terms of service”
 * 2.26 Click on “CHECKOUT”
 * 2.27 Fill the Mandatory fields
 * 2.28 Click on “CONTINUE”
 * 2.29 Click on Radio Button “2nd Day Air ($0.00)”
 * 2.30 Click on “CONTINUE”
 * 2.31 Select Radio Button “Credit Card”
 * 2.32 Select “Visa” From Select credit card dropdown
 * 2.33 Fill all the details
 * 2.34 Click on “CONTINUE”
 * 2.35 Verify “Payment Method” is “Credit Card”
 * 2.36 Verify “Shipping Method” is “2nd Day Air”
 * 2.37 Verify Total is “$698.00”
 * 2.38 Click on “CONFIRM”
 * 2.39 Verify the Text “Thank You”
 * 2.40 Verify the message “Your order has been successfully processed!”
 * 2.41 Click on “CONTINUE”
 * 2.42 Verify the text “Welcome to our store”
 * 2.43 Click on “Logout” link
 * 2.44 Verify the URL is “https://demo.nopcommerce.com/”
 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.util.UUID;

public class ElectronicsTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully(){
        //1.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//a[text()='Electronics ']"));
        //1.2 Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        //1.3 Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = getTextFromElement(By.xpath("//div[@class='page-title']"));
        Assert.assertEquals(expectedText, actualText);
    }
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//a[text()='Electronics ']"));
        //2.2 Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        //2.3 Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = getTextFromElement(By.xpath("//div[@class='page-title']"));
        Assert.assertEquals(expectedText, actualText);
        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        Thread.sleep(1000);
        //2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]"));
        //2.6 Verify the text “Nokia Lumia 1020”
        String expectedTxt = "Nokia Lumia 1020";
        String actualTxt = getTextFromElement(By.tagName("h1"));
        Assert.assertEquals(expectedTxt, actualTxt);
        //2.7 Verify the price “$349.00”
        String expectedPrice = "$349.00";
        String actualPrice = getTextFromElement(By.id("price-value-20"));
        Assert.assertEquals(expectedPrice, actualPrice);
        //2.8 Change quantity to 2
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"),"2");
        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("(//button[@id='add-to-cart-button-20'])[1]"));
        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedMessage = "The product has been added to your shopping cart";
        String actualMessage = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals(expectedMessage, actualMessage);
        Thread.sleep(1000);
        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@class='close']"));
        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//a[@class='ico-cart']"));////a[@class='ico-cart']....//a[contains(text(),'shopping cart')]
        clickOnElement(By.xpath("//span[@class='cart-label']"));
        // or ... use ... clickOnElement(By.xpath("(//button[normalize-space()='Go to cart'])[1]"));
        //2.12 Verify the message "Shopping cart"
        String expectedMsg = "Shopping cart";
        String actualMsg = getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']"));
        Assert.assertEquals(expectedMsg, actualMsg);
        //2.13 Verify the quantity is 2
        String expectedQuantity = "(2)";
        String actualQuantity = getTextFromElement(By.xpath("//span[contains(text(),'(2)')]"));
        Assert.assertEquals(expectedQuantity,actualQuantity);
        //2.14 Verify the Total $698.00
        String expectedTotal = "$698.00";
        String actualTotal = getTextFromElement(By.className("product-subtotal")); // or //span[@class='product-subtotal']
        Assert.assertEquals(expectedTotal, actualTotal);
        //2.15 click on checkbox “I agree with the terms of service”
        selectCheckBox(By.id("termsofservice"));// please check this while running the test or change it to
        // clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //2.16 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        //2.17 Verify the Text “Welcome, Please Sign In!”
        String expTxt = "Welcome, Please Sign In!";
        String actTxt = getTextFromElement(By.tagName("h1"));
        Assert.assertEquals(expTxt, actTxt);
        //2.18 Click on “REGISTER” tab
        clickOnElement(By.className("ico-register"));
        //2.19 Verify the text “Register”
        String expectText1 = "Register";
        String actualText1 = getTextFromElement(By.cssSelector(".ico-register"));
        Assert.assertEquals(expectText1, actualText1);
        //2.20 Fill the mandatory fields
        sendTextToElement(By.id("FirstName"), "Ashok");
        sendTextToElement(By.id("LastName"), "Patil");
        final String randomEmail = randomEmail();
        sendTextToElement(By.id("Email"), randomEmail);
        //sendTextToElement(By.id("Email"), "baba01@gmail.com");
        sendTextToElement(By.id("Password"), "Learnmore2");
        sendTextToElement(By.id("ConfirmPassword"), "Learnmore2");
        //2.21 Click on “REGISTER” Button
        clickOnElement(By.id("register-button"));
        //2.22 Verify the message “Your registration completed”
        String expectedRegistrationMessage = "Your registration completed";
        String actualRegistrationMessage = getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        //or (By.cssSelector(".result"));
        Assert.assertEquals(expectedRegistrationMessage, actualRegistrationMessage);
        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[@class='button-1 register-continue-button']"));
        //2.24 Verify the text “Shopping cart”
        String expectedDisplay = "Shopping cart";
        String actualDisplay = getTextFromElement(By.cssSelector(".cart-label"));
        Assert.assertEquals(expectedDisplay, actualDisplay);
        //2.25 click on checkbox “I agree with the terms of service”
        //clickOnElement(By.xpath("//input[@id='termsofservice']"));// please check this while running the test or change it to
        //clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //2.26 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //2.27 Fill the Mandatory fields
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"), "United Kingdom");
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "64 Best Road");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode") , "HA4 6SD");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "07848533612");
        Thread.sleep(1000);
        //2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[onclick='Billing.save()']"));
        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//label[contains(text(),'2nd Day Air ($0.00)')]"));
        //2.30 Click on “CONTINUE”
        clickOnElement(By.className("button-1 shipping-method-next-step-button"));
        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        //2.32 Select “Visa” From Select credit card dropdown
        WebElement card = driver.findElement(By.xpath("//select[@id='CreditCardType']"));
        Select credit = new Select(card);
        credit.selectByVisibleText("Visa");
        //2.33 Fill all the details
        sendTextToElement(By.id("CardholderName"), "Ashok");
        sendTextToElement(By.id("CardNumber"), "4420193144551237");
        selectByVisibleTextFromDropDown(By.id("ExpireMonth"), "04");
        selectByVisibleTextFromDropDown(By.id("ExpireYear"), "2030");
        sendTextToElement(By.id("CardCode"), "750");
        //2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //2.35 Verify “Payment Method” is “Credit Card”
        String expectedPayMethod = "Credit Card";
        String actualPayMethod = getTextFromElement(By.xpath("//li[@class='payment-method']"));
        Assert.assertEquals(expectedPayMethod, actualPayMethod);
        //2.36 Verify “Shipping Method” is “2nd Day Air”
        String expectedMethod = "2nd Day Air";
        String actualMethod = getTextFromElement(By.xpath("//li[@class='shipping-method']"));
        Assert.assertEquals(expectedMethod, actualMethod);
        //2.37 Verify Total is “$698.00”
        String expectedVal = "$698.00";
        String actualVal = getTextFromElement(By.xpath("//span[text() ='$698.00']"));
        Assert.assertEquals(expectedVal, actualVal);
        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));
        //2.39 Verify the Text “Thank You”
        String expectedVerify = "Thank You";
        String actualVerify = getTextFromElement(By.xpath("//h1[text() = 'Thank you']"));
        Assert.assertEquals(expectedVerify, actualVerify);
        //2.40 Verify the message “Your order has been successfully processed!”
        String expectedMsg2 = "Your order has been successfully processed!";
        String actualMsg2 = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals(expectedMsg2, actualMsg2);
        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class = 'button-1 order-completed-continue-button']"));
        //2.42 Verify the text “Welcome to our store”
        String expectedTxt2 = "Welcome to our store";
        String actualTxt2 = getTextFromElement(By.xpath("//h2[text() = 'Welcome to our store']"));
        Assert.assertEquals(expectedTxt2, actualTxt2);
        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String expectedUrl = "https://demo.nopcommerce.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);

    }
    private static String randomEmail() {

        return "random-" + UUID.randomUUID().toString() + "@gmail.com";
    }


    @After
    public void tearDown(){
        closeBrowser();
    }


}
