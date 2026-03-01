package com.ui.pages;

import com.ui.pojo.CardDetails;
import com.utillity.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BrowserUtility {

    private static final By name_on_card_locator = By.xpath("//input[contains(@name,'name_on_card')]");
    private static final By card_number_locator = By.xpath("//input[contains(@name,'card_number')]");
    private static final By cvc_locator = By.xpath("//input[contains(@name,'cvc')]");
    private static final By expiry_month_locator = By.xpath("//input[contains(@name,'expiry_month')]");
    private static final By expiry_year_locator = By.xpath("//input[contains(@name,'expiry_year')]");
    private static final By pay_and_confirm_order_locator = By.xpath("//button[contains(@id,'submit')]");
    private static final By order_placed_locator = By.xpath("//p[contains(text(),'Congratulations!')]");
    private static final By download_invoice_locator = By.xpath("//a[contains(text(),'Download Invoice')]");
    private static final By continue_locator = By.xpath("//a[contains(text(),'Download Invoice')]");
    private static final By success_Message_locator = By.xpath("//p[contains(text(),'Congratulations')]");


    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public String enterpayementdetails(CardDetails cardDetails) {
        killAds();
        entertext(name_on_card_locator, cardDetails.getName());
        entertext(card_number_locator, String.valueOf(cardDetails.getCard_number()));
        entertext(cvc_locator, cardDetails.getCvc());
        entertext(expiry_month_locator, cardDetails.getExpiremonth());
        entertext(expiry_year_locator, cardDetails.getExpireyear());
        jsClick(pay_and_confirm_order_locator);
        killAds();
        return getVisibleText(order_placed_locator);
    }
    public HomePage downloadorderivoiceandContinue()
    {
        killAds();
       // jsClick(download_invoice_locator);
         jsClick(continue_locator);
        killAds();
         return new HomePage(getDriver());
    }


    public String getConfirmationMessage() {

        return getVisibleText(success_Message_locator);

    }
}
