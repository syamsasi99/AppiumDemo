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
public class LoginPageAndroid extends AppiumHelper implements LoginPage {

	@FindBy(id = "com.thecarousell.Carousell:id/email_signin_button")
	public MobileElement emailOption;

	@FindBy(xpath = "//*[@text='LOGIN']")
	public MobileElement loginLink;

	@FindBy(xpath = "//*[@text='Login']")
	public MobileElement loginButton;

	@FindBy(id = "com.thecarousell.Carousell:id/text_username")
	public MobileElement userNameTextField;

	@FindBy(id = "com.thecarousell.Carousell:id/text_password")
	public MobileElement passwordTextField;

	@FindBy(xpath = "//*[@text='ALLOW']")
	public MobileElement permissionAllowButton;

	@FindBy(xpath = "//*[@text='Allow']")
	public MobileElement picturesAndVideoPermissionAllowButton;

	public LoginPageAndroid(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void login(String userName, String passWord, String mode) {

		switch (mode) {
		case "email":
			clickElement(emailOption);
			clickElement(permissionAllowButton);
			clickElement(picturesAndVideoPermissionAllowButton);
			clickElement(loginLink);
			inputString(userNameTextField, userName);
			inputString(passwordTextField, passWord);
			clickElement(loginButton);
			break;
		}
	}

}
