package mmmm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

public class OLDOPENSNAP implements Runnable {
	
	
//	TEST WITH GIT
	public static String valdCode = "";
	public static String taskLog = "Nothing happened yet";
	public static valdGUI logGUI;
//	private static snapGUI gui;
//	
//	public openSnap() {
//		this.gui = gui;
//	}
	
	

	
	
	public static void main(String[] args) throws Throwable {
	}
	
	public static void sesh(String _username, String _password, String dvN, int ct, boolean emulated) throws Throwable {
		for(int i = 0; i < ct; i++) {			
			AndroidDriver<AndroidElement> driver = loginSnap(_username, _password, dvN, emulated);
			quickAdd(driver, false, 7);
			driver.quit();
		}
	}
	
	public static void camSPost(String _username, String _password, String dvN, boolean emulated) throws Throwable {
		taskLog = "About to try to login";
		AndroidDriver<AndroidElement> driver = loginSnap(_username, _password, dvN, emulated);		//*[@resource-id='com.snapchat.android:id/ngs_memories_icon']
    	driver.findElementById("com.snapchat.android:id/ngs_memories_icon").click();
    	System.out.println("clicking memories");
    	
    	//*[@resource-id='com.snapchat.android:id/memories_empty_state_button']
    	try {    		
    		Thread.sleep(3000);
    		driver.findElementById("com.snapchat.android:id/memories_empty_state_button").click();
    		System.out.println("clicking got it");
    	} catch(Exception e) {}
    	
    	driver.findElementByXPath("//*[@text='Camera Roll']").click();
    	System.out.println("clicking camera roll");
    	
    	new TouchAction(driver).tap(PointOption.point(150, 800)).perform();
    	System.out.println("clicking most recent cam post");
    	
    	//*[@resource-id='com.snapchat.android:id/send_button']
    	driver.findElementById("com.snapchat.android:id/send_button").click();
    	System.out.println("clicking send");
    	
    	driver.findElementByXPath("//*[@text='My Story']").click();
    	System.out.println("clicking my story");
    	
    	try {    		
    		Thread.sleep(3000);
    		driver.findElementById("com.snapchat.android:id/button_text").click();
    		System.out.println("clicking okay");
    	} catch(Exception e) {}

    	
    	//*[@resource-id='com.snapchat.android:id/send_to_send_button']
    	driver.findElementById("com.snapchat.android:id/send_to_send_button").click();
    	System.out.println("clicking send");
    	
	}
	
	public static AndroidDriver<AndroidElement> pushPic(String dvN, File file) throws Throwable {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, dvN);
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		cap.setCapability("automationName", "uiautomator2");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url, cap);
		driver.pushFile("/storage/sdcard0/DCIM", file);
		return driver;
	}
	
	public static AndroidDriver<AndroidElement> makeAcct(String _username, String _password, String _number, String name, String dvN, boolean emulated) throws Throwable {
    	File f = new File("src\\test\\java\\appiumtests");
    	File fs = new File(f, "snapchat.apk");
    	
    	DesiredCapabilities cap = new DesiredCapabilities();
    	if(emulated) {    		
    		cap.setCapability(MobileCapabilityType.DEVICE_NAME, dvN);
    	}
    	if(!emulated) {
    		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
    	}
    	cap.setCapability("appPackage", "com.snapchat.android");
    	cap.setCapability("appActivity", "com.snap.mushroom.MainActivity");
    	cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
    	cap.setCapability("automationName", "uiautomator2");
    	URL url = new URL("http://0.0.0.0:4723/wd/hub");
    	AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url, cap);
    	System.out.println("Application Started...");
    	
//		NOW START LOGGING IN
    	Thread.sleep(1000);
    	
    	MobileElement su = driver.findElementById("com.snapchat.android:id/signup_button_horizontal");
    	su.click();
    	System.out.println("clicking sign up");

    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	driver.findElementById("com.snapchat.android:id/button_text").click();
    	
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	driver.findElementById("com.android.permissioncontroller:id/permission_deny_button").click();
    	
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	driver.findElementById("com.android.permissioncontroller:id/permission_allow_button").click();
    	
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	
    	driver.findElementById("com.snapchat.android:id/display_name_first_name_field").sendKeys(name);
    	
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	driver.findElementById("com.snapchat.android:id/button_text").click();
    	
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	System.out.println("finding year");
    	MobileElement yearPick = driver.findElementById("android:id/numberpicker_input");
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        System.out.println("touching");

    	driver.findElementByXPath("//*[@text='2002']").click();
    	driver.findElementByXPath("//*[@text='2001']").click();
    	driver.findElementByXPath("//*[@text='2000']").click();
    	driver.findElementByXPath("//*[@text='1999']").click();
        
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	driver.findElementById("com.snapchat.android:id/button_text").click();
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	
    	driver.findElementById("com.snapchat.android:id/username_form_field").clear();
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	
    	driver.findElementById("com.snapchat.android:id/username_form_field").sendKeys(_username);
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	
    	Thread.sleep(1000);
    	
    	driver.findElementById("com.snapchat.android:id/button_text").click();
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	
    	driver.findElementById("com.snapchat.android:id/password_form_field").sendKeys(_password);
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	
    	driver.findElementById("com.snapchat.android:id/button_text").click();
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	
    	driver.findElementById("com.snapchat.android:id/phone_form_field").clear();
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	
    	driver.findElementById("com.snapchat.android:id/phone_form_field").sendKeys(_number);
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	
    	driver.findElementById("com.snapchat.android:id/button_text").click();
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	
    	driver.findElementById("com.snapchat.android:id/alt_text").click();
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	
    	Thread.sleep(1000);
    	Thread.sleep(1000);
    	

    	driver.findElementByXPath("//*[@text='Okay']").click();
    	
    	System.out.println("Done - Waiting for code (45s for thread)");
    	
    	Thread.sleep(5000);
    	new TouchAction(driver).tap(PointOption.point((int) (0.9*width), (int) (0.5*height))).perform();
    	Thread.sleep(20000);
    	new TouchAction(driver).tap(PointOption.point((int) (0.9*width), (int) (0.5*height))).perform();
    	Thread.sleep(20000);
    	new TouchAction(driver).tap(PointOption.point((int) (0.9*width), (int) (0.5*height))).perform();
    	
////    	Scanner inputCode = new Scanner(System.in);
//    	t = new Thread(new valdGUI());
////    	Thread t = new Thread(new valdGUI());
//    	t.start();
//    	t.join(50000);
//    	if(valdCode.length() == 0) {
//    		return driver;
//    	}
//    	String inputCode = valdCode;
//    	driver.findElementById("com.snapchat.android:id/code_field").sendKeys(inputCode);
//    	System.out.println("input code ran");
    		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Code Here: ");
		String inputCode = input.nextLine();
		System.out.println(inputCode + " will be typed");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    	driver.findElementById("com.snapchat.android:id/code_field").sendKeys(inputCode);
    	
    	
//    	MIGHT NEED TO CODE SOMEHTING HERE
    	
    	driver.findElementById("com.snapchat.android:id/skip_button").click();
    	
    	driver.findElementById("com.snapchat.android:id/subscreen_top_right").click();
    	
    	driver.findElementById("com.snapchat.android:id/button_text").click();
    	
//    	USING CODE FROM LOGIN
    	
    	driver.findElementById("com.snapchat.android:id/turn_on_button").click();
    	
    	driver.findElementById("com.android.permissioncontroller:id/permission_allow_foreground_only_button").click();
    	
    	driver.findElementById("com.android.permissioncontroller:id/permission_allow_button").click();
    	
    	driver.findElementById("com.android.permissioncontroller:id/permission_allow_foreground_only_button").click();
		
    	return driver;
		
	}
	

    public static AndroidDriver<AndroidElement> loginSnap(String _username, String _password, String dvN, boolean emulated) throws MalformedURLException, Throwable {
		taskLog = "SETUP VARS:[NO] | LOG IN:[NO] | FINISH:[NO] .....";
    	File f = new File("src\\test\\java\\appiumtests");
    	File fs = new File(f, "snapchat.apk");
    	
    	DesiredCapabilities cap = new DesiredCapabilities();
    	if(emulated) {    		
    		cap.setCapability(MobileCapabilityType.DEVICE_NAME, dvN);
//    		MobileCapabilityType.
    	}
    	if(!emulated) {    		
    		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
    	}
    	cap.setCapability("appPackage", "com.snapchat.android");
    	cap.setCapability("appActivity", "com.snap.mushroom.MainActivity");
    	cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
    	cap.setCapability("automationName", "uiautomator2");
    	URL url = new URL("http://0.0.0.0:4723/wd/hub");
    	AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url, cap);
    	System.out.println("Application Started...");
		taskLog = "SETUP VARS:[YES] | LOG IN:[NO] | FINISH:[NO] .....";
//		NOW START LOGGING IN
    	Thread.sleep(3000);
    	MobileElement login1 = driver.findElementById("com.snapchat.android:id/login_button_horizontal");
    	login1.click();
    	System.out.println("logging in");
    	
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	MobileElement usernameTB = driver.findElementById("com.snapchat.android:id/username_or_email_field");
    	usernameTB.setValue(_username);
    	System.out.println("typing username");
    	
    	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    	MobileElement passTB = driver.findElementById("com.snapchat.android:id/password_field");
    	passTB.setValue(_password);
    	System.out.println("typing pass");
    	
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	MobileElement login2 = driver.findElementById("com.snapchat.android:id/button_text");
    	login2.click();
    	System.out.println("clicking login");
    	
    	driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		taskLog = "SETUP VARS:[YES] | LOG IN:[YES] | FINISH:[NO] .....";
    	try {
    		MobileElement turnOn = driver.findElementById("com.snapchat.android:id/turn_on_button");
        	turnOn.click();
        	System.out.println("turn ON");
    	} catch (Exception e) {
    		driver.quit();
    		openBrowser(_username, _password, dvN, emulated);
    		return loginSnap(_username, _password, dvN, emulated);
    	}
    	
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	MobileElement turnOn2 = driver.findElementById("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
    	turnOn2.click();
    	System.out.println("allowbox1");
    	
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
    	MobileElement turnOn3 = driver.findElementById("com.android.permissioncontroller:id/permission_allow_button");
    	turnOn3.click();
    	System.out.println("allowbox2");
    	
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	MobileElement turnOn4 = driver.findElementById("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
    	turnOn4.click();
    	System.out.println("allowbox3");
		taskLog = "SETUP VARS:[YES] | LOG IN:[YES] | FINISH:[YES] .....";
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
    	return driver;
    }
	
    public static AndroidDriver<AndroidElement> quickAdd(AndroidDriver driver, boolean emulated, int swipeCt) throws InterruptedException {
		
		System.out.println("click add friends");
		
		MobileElement addFriends = (MobileElement) driver.findElementById("com.snapchat.android:id/hova_header_add_friend_icon");
		addFriends.click();
		System.out.println("waiting 8-18 seconds");
		Thread.sleep(8000);
		if(emulated) {
			Thread.sleep(10000);
		}
		
		
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		for(int i = 0; i < swipeCt; i++) {			
			SwipeAndClick(driver);
		}
		System.out.println("DONE, SLEEPING 5s");
		Thread.sleep(5000);
		return driver;
	}

	public static void SwipeAndClick(AndroidDriver driver) throws InterruptedException {
		Dimension size = driver.manage().window().getSize();
		Thread.sleep(4000);
		System.out.println("swiping down");
		SwipeDown(driver);
		Thread.sleep(1000);
		new TouchAction(driver).tap(PointOption.point((int) (0.8*size.width), 450)).perform();
		System.out.println("tapping away");
		System.out.println("clicking along screen");
		ClickAlongScreen(driver);
	}
	
//    public static void SwipeUp(AndroidDriver driver) {
//        Dimension size = driver.manage().window().getSize();
//        int height = size.height;
//        int width = size.width;
//        new TouchAction(driver).longPress(PointOption.point(width / 2, 100))
//                .moveTo(PointOption.point(width / 2, height - 100)).release()
//                .perform();
//    }

    public static void SwipeDown(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = (int) (0.8*size.width);
        
        
    	MobileElement addfriendBigBox = (MobileElement) driver.findElementById("com.snapchat.android:id/add_friends_recycler_view");
    	List<MobileElement> addfriendList = addfriendBigBox.findElementsByClassName("android.widget.FrameLayout");
		int yVal = getYBound(addfriendList.get(8).getAttribute("bounds"));
        
    	
    	new TouchAction(driver)
				.longPress(PointOption.point(width, yVal))
                .moveTo(PointOption.point((int) (width*0.8), 100)).release().perform();
    }
    
    public static int getYBound(String boundString) {
    	char[] charArr = boundString.toCharArray();
    	String finString = "";
    	for(int i=0;i<charArr.length;i++) {
    		if(charArr[i] == "[".charAt(0) || charArr[i] == ",".charAt(0) || charArr[i] == "]".charAt(0)) {
    			charArr[i] = "x".charAt(0);
    		}
    		finString += charArr[i];
    	}
    	String[] stringArr = finString.split("x");
    	int y1 = Integer.parseInt(stringArr[2]);
    	int y2 = Integer.parseInt(stringArr[5]);
    	int YBound = (int) (y1+y2)/2;
    	return YBound;
    }
    
    public static void ClickAlongScreen(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = (int) (size.width*0.8);
        for(int i = 0; i<9; i++) {       
        	MobileElement addfriendBigBox = (MobileElement) driver.findElementById("com.snapchat.android:id/add_friends_recycler_view");
        	List<MobileElement> addfriendList = addfriendBigBox.findElementsByClassName("android.widget.FrameLayout");
    		int yVal = getYBound(addfriendList.get(2+i).getAttribute("bounds"));
        	new TouchAction(driver).tap(PointOption.point(width, yVal)).perform();
        }
    }
    
//    public static AndroidDriver<AndroidElement> openBrowser() throws MalformedURLException, InterruptedException {
//    	
//    	DesiredCapabilities cap = new DesiredCapabilities();
//    	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "NewPix3");
//    	cap.setCapability("appPackage", "com.android.chrome");
//    	cap.setCapability("appActivity", "org.chromium.chrome.browser.incognito.IncognitoTabLauncher");
//    	cap.setCapability("automationName", "uiautomator2");
//    	URL url = new URL("http://0.0.0.0:4723/wd/hub");
////    	AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url, cap);
//    	AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url, cap);
//    	System.out.println("Application Started...");
//    	

    public static void openBrowser(String _username, String _password, String dvN, boolean emulated) throws MalformedURLException, InterruptedException {
//    	AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>();
    	AndroidDriver<AndroidElement> driver;
    	DesiredCapabilities cap = new DesiredCapabilities();
//    	cap.setCapability("appPackage", "com.snapchat.android");
//    	cap.setCapability("appActivity", "com.snap.mushroom.MainActivity");
//    	cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
    	if(emulated) {
	    	cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");    		
	    	cap.setCapability(MobileCapabilityType.DEVICE_NAME, dvN);
    	}
    	if(!emulated) {    		
    		cap.setCapability("appPackage", "com.android.chrome");
    		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
    	}
    	cap.setCapability("appActivity", "org.chromium.chrome.browser.incognito.IncognitoTabLauncher");
    	cap.setCapability("automationName", "uiautomator2");
    	
    	
    	URL url = new URL("http://0.0.0.0:4723/wd/hub");
    	
    	driver = new AndroidDriver<AndroidElement>(url, cap);
    			
//    	wdriver = new AndroidDriver<AndroidElement>;
    	
//    	AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url, cap);
    	System.out.println("Application Started...");
    	
    	

    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	driver.findElementById("com.android.chrome:id/send_report_checkbox").click();
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	driver.findElementById("com.android.chrome:id/terms_accept").click();
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	driver.findElementById("com.android.chrome:id/negative_button").click();
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	
    	driver.findElementByXPath("//*[@resource-id='com.android.chrome:id/url_bar']").click();   	
    	driver.findElementByXPath("//*[@resource-id='com.android.chrome:id/url_bar']").sendKeys("snapchat.com/unlock");
    	Dimension size = driver.manage().window().getSize();
      	int height = size.height-100;
      	int width = (int) (size.width-100);
  		new TouchAction(driver).tap(PointOption.point(width, height)).perform();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	MobileElement userTB = driver.findElementByXPath("//*[@resource-id='username']");
    	userTB.sendKeys(_username);
    	MobileElement passTB = driver.findElementByXPath("//*[@resource-id='password']");
    	passTB.sendKeys(_password);
    	Thread.sleep(1000);
    	driver.findElementByXPath("//*[@text='Log In']").click();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	Thread.sleep(1000);
    	driver.findElementByXPath("//*[@text='Unlock']").click();
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	
    	
    }
    
//    public void changeMainLog(String text) {
//    	snapGUI.setMainLog(text);
//    }

public void run() {
	// TODO Auto-generated method stub
	
}


}