package com.qa.Base;

import io.github.bonigarcia.wdm.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.concurrent.TimeUnit;
public class BaseClass {
    private final ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    public static BaseClass get() {
        return BaseClass.BaseClassParent.INSTANCE;
    }

    private static class BaseClassParent {
        static final BaseClass INSTANCE = new BaseClass();
    }

    public WebDriver getDriver() {

        if (driverThread.get() == null) {
            WebDriver driver;
            if (FrameworkProperties.BROWSER.equals("chrome")) {
                WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
                ChromeOptions chrome = new ChromeOptions();
                chrome.addArguments("user-agent=YOUR_USER_AGENT");
                driver = new ChromeDriver(chrome);
            } else  {
                WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
                driver = new FirefoxDriver();
            }
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            driverThread.set(driver);
        }
        return driverThread.get();

    }

    public void quitDriver(WebDriver driver) {
        driver.quit();
        driverThread.remove();
    }

//    public String getSession(WebDriver driver) {
//        return String.valueOf(((RemoteWebDriver) driver).getSessionId());
//    }


}

