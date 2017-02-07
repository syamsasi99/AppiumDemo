package com.carousell.demo.helper;


import io.appium.java_client.AppiumDriver;

/**
 * @author syam
 *
 */
public abstract class AppiumBaseClass {

    protected AppiumDriver<?> driver() {
        return AppiumController.instance.driver;
    }
    
    protected String getPageSource() {
        return AppiumController.instance.driver.getPageSource();
    }
}
