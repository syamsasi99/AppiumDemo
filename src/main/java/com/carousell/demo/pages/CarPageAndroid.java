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
public class CarPageAndroid extends AppiumHelper implements CarPage {

	@FindBy(xpath = "//*[@text='OK, Got it!']")
	public MobileElement okGotItButton;

	@FindBy(xpath = "//*[@text='Cars for Sale']")
	public MobileElement carForSaleMenu;

	public CarPageAndroid(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@Override
	public void selectCarForSale() {

		clickElement(carForSaleMenu);

	}

	@Override
	public void clickOnOKGotIT() {

		clickElement(okGotItButton);

	}

	@Override
	public boolean isCarPageLoaded() {

		return isVisible(carForSaleMenu);
	}

}
