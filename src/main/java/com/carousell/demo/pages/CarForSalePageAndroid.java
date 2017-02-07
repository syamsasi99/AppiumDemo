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
public class CarForSalePageAndroid extends AppiumHelper implements CarForSalePage {

	@FindBy(xpath = "//*[@text='OK, Got it!']")
	public MobileElement okGotItButton;

	@FindBy(xpath = "//*[@text='Cars For Sale']")
	public MobileElement carsForSaleHeader;

	@FindBy(id = "com.thecarousell.Carousell:id/text_product")
	public MobileElement firstProductItem;

	public CarForSalePageAndroid(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@Override
	public void selectTheFirstItem() {

		clickElement(firstProductItem);

	}

	@Override
	public boolean isCarForSalePageLoaded() {
		return isVisible(carsForSaleHeader);
	}

}
