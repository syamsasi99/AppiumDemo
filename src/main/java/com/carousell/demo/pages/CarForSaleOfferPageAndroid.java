package com.carousell.demo.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.carousell.demo.helper.AppiumHelper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * @author syam
 *
 */
public class CarForSaleOfferPageAndroid extends AppiumHelper implements CarForSaleOfferPage {

	@FindBy(xpath = "//*[@text='OK, Got it!']")
	public MobileElement okGotItButton;

	@FindBy(xpath = "//*[@text='Buy Now']")
	public MobileElement buyNowButton;

	@FindBy(xpath = "//*[@text='Make Offer']")
	public MobileElement makeOfferButton;

	@FindBy(xpath = "//*[@text='Yes']")
	public MobileElement yesButton;

	@FindBy(xpath = "//*[@text='Cancel Offer']")
	public MobileElement cancelOfferButton;

	@FindBy(xpath = "//*[@text='View Offer']")
	public MobileElement viewOfferButton;

	@FindBy(id = "com.thecarousell.Carousell:id/text_offer")
	public MobileElement offeredMoney;

	@FindBy(id = "com.thecarousell.Carousell:id/text_chat_action")
	public MobileElement displayedAmountInChat;

	public CarForSaleOfferPageAndroid(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@Override
	public void makeAnOffer(String amount) {

		clickElement(okGotItButton);
		clickElement(okGotItButton);
		clickElement(buyNowButton);
		inputString(offeredMoney, amount);
		clickElement(makeOfferButton);
		clickElement(yesButton);
		goBack();
		clickElement(viewOfferButton);

	}

	@Override
	public boolean isChatPageLoaded() {

		return isVisible(cancelOfferButton);
	}

	@Override
	public String getDisplayedAmountOnChat() {
		return getAttribute(displayedAmountInChat, "text");
	}

}
