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
public class HomePageAndroid extends AppiumHelper implements HomePage {

	@FindBy(xpath = "//*[@text='Cars']")
	public MobileElement carsSection;

	@FindBy(xpath = "//*[@text='BROWSE']")
	public MobileElement homePageBrowseLink;

	@FindBy(xpath = "//*[@text='Cars for Sale']")
	public MobileElement carForSaleMenu;

	public HomePageAndroid(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@Override
	public void selectCarMenu() {

		clickElement(carsSection);

	}

	@Override
	public boolean isHomePageLoaded() {

		return isVisible(homePageBrowseLink);

	}

}
