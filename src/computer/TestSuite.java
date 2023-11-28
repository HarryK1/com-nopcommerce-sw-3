package computer;
/*
 *1. Create class “TestSuite”
 * Write the following Test:
 * 1.Test name verifyProductArrangeInAlphaBaticalOrder()
 * 1.1 Click on Computer Menu.
 * 1.2 Click on Desktop
 * 1.3 Select Sort By position "Name: Z to A"
 * 1.4 Verify the Product will arrange in Descending order.
 * 2. Test name verifyProductAddedToShoppingCartSuccessFully()
 * 2.1 Click on Computer Menu.
 * 2.2 Click on Desktop
 * 2.3 Select Sort By position "Name: A to Z"
 * 2.4 Click on "Add To Cart"
 * 2.5 Verify the Text "Build your own computer"
 * 2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
 * 2.7.Select "8GB [+$60.00]" using Select class.
 * 2.8 Select HDD radio "400 GB [+$100.00]"
 * 2.9 Select OS radio "Vista Premium [+$60.00]"
 * 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
 *
 * [+$5.00]"
 * 2.11 Verify the price "$1,475.00"
 * 2.12 Click on "ADD TO CARD" Button.
 * 2.13 Verify the Message "The product has been added to your shopping cart" on Top
 * green Bar
 * After that close the bar clicking on the cross button.
 * 2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
 * 2.15 Verify the message "Shopping cart"
 * 2.16 Change the Qty to "2" and Click on "Update shopping cart"
 * 2.17 Verify the Total"$2,950.00"
 * 2.18 click on checkbox “I agree with the terms of service”
 * 2.19 Click on “CHECKOUT”
 * 2.20 Verify the Text “Welcome, Please Sign In!”
 * 2.21Click on “CHECKOUT AS GUEST” Tab
 * 2.22 Fill the all mandatory field
 * 2.23 Click on “CONTINUE”
 * 2.24 Click on Radio Button “Next Day Air($0.00)”
 * 2.25 Click on “CONTINUE”
 * 2.26 Select Radio Button “Credit Card”
 * 2.27 Select “Master card” From Select credit card dropdown
 * 2.28 Fill all the details
 * 2.29 Click on “CONTINUE”
 * 2.30 Verify “Payment Method” is “Credit Card”
 * 2.32 Verify “Shipping Method” is “Next Day Air”
 * 2.33 Verify Total is “$2,950.00”
 * 2.34 Click on “CONFIRM”
 * 2.35 Verify the Text “Thank You”
 * 2.36 Verify the message “Your order has been successfully processed!”
 * 2.37 Click on “CONTINUE”
 * 2.37 Verify the text “Welcome to our store”
 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder(){
        //1.1 Click on Computer Menu.
        clickOnElement(By.xpath("(//a[normalize-space()='Computers'])[1]"));
        //1.2 Click on Desktop
        clickOnElement(By.xpath("//img[@alt='Picture for category Desktops']"));
        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.id("products-orderby"), "Name: Z to A");
        //1.4 Verify the Product will arrange in Descending order.
        String expectedOrder = "Name: Z to A";
        String actualOrder = getTextFromElement(By.xpath("//select[@id='products-orderby']/option[text()='Name: Z to A']"));
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Click on Computer Menu.
        clickOnElement(By.xpath("(//a[normalize-space()='Computers'])[1]"));
        //2.2 Click on Desktop
        clickOnElement(By.xpath("//img[@alt='Picture for category Desktops']"));
        //2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.id("products-orderby"), "Name: A to Z");
        Thread.sleep(1000);
        //2.4 Click on "Add To Cart"
        clickOnElement(By.xpath("(//button[@type='button'][normalize-space()='Add to cart'])[1]"));
        Thread.sleep(1000);
        //2.5 Verify the Text "Build your own computer"
        String expectedText = "Build your own computer";
        String actualText = getTextFromElement(By.xpath("//h1[normalize-space()='Build your own computer']"));
        Assert.assertEquals(expectedText, actualText);
        Thread.sleep(1000);
        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.id("product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");
        Thread.sleep(1000);
        //2.7.Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropDown(By.id("product_attribute_2"), "8GB [+$60.00]");
        Thread.sleep(1000);
        //2.8 Select HDD radio "400 GB [+$100.00]"
        selectRadioButton(By.id("product_attribute_3_7"));
        Thread.sleep(1000);
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        selectRadioButton(By.id("product_attribute_4_9"));
        Thread.sleep(1000);
        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander[+$5.00]"
        selectCheckBox(By.id("product_attribute_5_10")); // or... clickOnTheElement(By.xpath("//input[@id='product_attribute_5_10']"));
        Thread.sleep(1000);
        selectCheckBox(By.id("product_attribute_5_12")); // Or ..  clickOnTheElement(By.xpath("//input[@id='product_attribute_5_12']"));
        Thread.sleep(1000);
        //2.11 Verify the price "$1,475.00"
        String expectedPrice = "$1,475.00";
        String actualPrice = getTextFromElement(By.id("price-value-1"));
        Assert.assertEquals(expectedPrice, actualPrice);
        //2.12 Click on "ADD TO CART" Button.
        clickOnElement(By.id("add-to-cart-button-1"));
        //2.13 Verify the Message "The product has been added to your shopping cart" on Top Green Bar
        String expectedMsg = "The product has been added to your shopping cart";
        String actualMsg = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals(expectedMsg, actualMsg);
        //After that close the bar clicking on the cross button.
        clickOnElement(By.cssSelector("span[title='Close']"));
        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[@class='cart-label']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//span[@class='cart-label']"));
        //2.15 Verify the message "Shopping cart"
        String expectedMsg1 = "Shopping cart";
        String actualMsg1 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals(expectedMsg1, actualMsg1);
        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        driver.findElement(By.xpath("//input[@class='qty-input']")).clear();
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@class='qty-input']"), "2");
        Thread.sleep(1000);
        //click on update shopping cart
        clickOnElement(By.id("updatecart"));
        Thread.sleep(1000);
        //2.17 Verify the Total"$2,950.00"
        String expectedPrice1 = "$2,950.00";
        String actualPrice1 = getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"));
        Assert.assertEquals(expectedPrice1, actualPrice1);
        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice")); // or selectCheckBox
        //2.19 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        //2.20 Verify the Text “Welcome, Please Sign In!”
        String expectedDisplay = "Welcome, Please Sign In!";
        String actualDisplay = getTextFromElement(By.xpath("(//h1[normalize-space()='Welcome, Please Sign In!'])[1]"));
        Assert.assertEquals(expectedDisplay, actualDisplay);
        //2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[normalize-space()='Checkout as Guest']"));
        //2.22 Fill the all mandatory field
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Ashok");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Patil");
        sendTextToElement(By.id("BillingNewAddress_Email"), "baba02@gmail.com");
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"), "United Kingdom");
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "64 Best Road");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "HA4 6SD");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "07848533612");
        //2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[text() = 'Continue']"));
        //2.24 Click on Radio Button “Next Day Air($0.00)”
        selectRadioButton(By.id("shippingoption_1"));
        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        //2.26 Select Radio Button “Credit Card”
        selectRadioButton(By.id("paymentmethod_1"));
        Thread.sleep(1000);
        //2.27 Select “Master card” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.id("CreditCardType"), "Master card");
        Thread.sleep(1000);
        //2.28 Fill all the details
        sendTextToElement(By.id("CardholderName"), "Ashok");
        sendTextToElement(By.id("CardNumber"), "5585478547852145");
        selectByVisibleTextFromDropDown(By.id("ExpireMonth"), "11");
        selectByVisibleTextFromDropDown(By.id("ExpireYear"), "2025");
        sendTextToElement(By.id("CardCode"), "456");
        //2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //2.30 Verify “Payment Method” is “Credit Card”
        String expectedPayMethod = "Credit Card";
        String actualPayMethod = getTextFromElement(By.xpath("//li[@class='payment-method']"));
        Assert.assertEquals(expectedPayMethod, actualPayMethod);
        //Verify “Shipping Method” is “Next Day Air”
        String expectedDisplay1 = "Next Day Air";
        String actualDisplay1 = getTextFromElement(By.xpath("//li[@class = 'shipping-method']"));
        Assert.assertEquals(expectedDisplay1, actualDisplay1);
        //Verify Total is “$2,950.00”
        String expectedValue = "$2,950.00";
        String actualValue = getTextFromElement(By.xpath("//span[text() ='$2,950.00']"));
        Assert.assertEquals(expectedValue, actualValue);
        //Click on “CONFIRM”
        clickOnElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));
        //Verify the Text “Thank You”
        String expectedMsg2 = "Thank You";
        String actualMsg2 = getTextFromElement(By.xpath("//h1[text() = 'Thank you']"));
        Assert.assertEquals(expectedMsg2, actualMsg2);
        //Verify the message “Your order has been successfully processed!”
        String expectedMsg3 = "Your order has been successfully processed!";
        String actualMsg3 = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals(expectedMsg3, actualMsg3);
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class = 'button-1 order-completed-continue-button']"));
        //Verify the text “Welcome to our store”
        String expectedMsg4 = "Welcome to our store";
        String actualMsg4 = getTextFromElement(By.xpath("//h2[text() = 'Welcome to our store']"));
        Assert.assertEquals(expectedMsg4, actualMsg4);



    }
    @After
    public void tearDown(){
        closeBrowser();
    }


}
