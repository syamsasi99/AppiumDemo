package com.carousell.demo.helper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author syam
 *
 */
public class AppiumController {

	public static OS executionOS = OS.ANDROID;

	public enum OS {
		ANDROID
	}

	public static AppiumController instance = new AppiumController();
	public AppiumDriver<?> driver;

	public void start() throws MalformedURLException {
		if (driver != null) {
			return;
		}
		switch (executionOS) {
		case ANDROID:
			File classpathRoot = new File(System.getProperty("user.dir"));
			File appDir = new File(classpathRoot, "/app/Android");
			File app = new File(appDir, "carousell.apk");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("deviceName", "Syam");
			capabilities.setCapability("app", app.getAbsolutePath());
			capabilities.setCapability("appPackage", "com.thecarousell.Carousell");
			capabilities.setCapability("appActivity", "com.thecarousell.Carousell.activities.EntryActivity");
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			break;
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void stop() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
