package mmmm;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import mmmm.vars.OrderType;

//THIS CLASS MAKES EMULATOR OBJECTS WHICH CAN BE USED TO EXECUTE SNAP METHODS
public class Emulator {
	
	private AndroidDriver<AndroidElement> driver;
	private String name;
	private boolean isActive;
	
	public Emulator(String name) throws MalformedURLException {
		this.name = name;
		this.isActive = false;
		DesiredCapabilities cap = new DesiredCapabilities();
////    	cap.setCapability("appPackage", "com.snapchat.android");
////    	cap.setCapability("appActivity", "com.snap.mushroom.MainActivity");
////    	cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
//    	cap.setCapability("automationName", "uiautomator2");
    	URL url = new URL("http://0.0.0.0:4723/wd/hub");
    	cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");    		
    	cap.setCapability(MobileCapabilityType.DEVICE_NAME, name);
    	cap.setCapability("appActivity", "org.chromium.chrome.browser.incognito.IncognitoTabLauncher");
    	cap.setCapability("automationName", "uiautomator2");
    	driver = new AndroidDriver<AndroidElement>(url, cap);
	}
	
	public void run(OrderType orderType) throws Exception {
		if(this.isActive) {
			throw new Exception("THREAD IS ALREADY ACTIVE");
		}
		this.isActive = true;
		
		
		
		this.isActive = false;
	}
	
	public AndroidDriver<AndroidElement> getDriver() {
		return driver;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
