package native_App;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import NativeApp.SimplenoteCapties;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Simplenote extends SimplenoteCapties {
	
AndroidDriver<AndroidElement>driver;
	
	@BeforeTest
	public void bt() throws MalformedURLException {
		
		// I'm calling the cap method from the previous class by extending that class using extend method
		driver = cap(); // method name
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void Test() throws InterruptedException {
		
		try {
			
			System.out.println("Simplenote is opened");
			
			// Tap On the lOgin Button
			AndroidElement Login = driver.findElement(MobileBy.id("com.automattic.simplenote:id/button_login")); 		
			Login.click();
			
			// Tap the Login Manually
			driver.findElement(MobileBy.id("com.automattic.simplenote:id/sign_in_login_manually")).click();
			
			// Input the email
			AndroidElement email = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Email\")"));
			email.sendKeys("sharmilabnkwb@gmail.com");
			
			// Input the Password
			AndroidElement pass = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Password\")"));
			pass.sendKeys("Simran2506");
			
			// Click the logButton
			AndroidElement button = driver.findElement(MobileBy.id("com.automattic.simplenote:id/button"));
			button.click();	
			Thread.sleep(1000);
			
			// Create a new Note 
			 AndroidElement note = driver.findElement(MobileBy.AccessibilityId("New Note"));
			 note.click();
			 
			// Add a tag
			 AndroidElement tag = driver.findElement(MobileBy.id("com.automattic.simplenote:id/tag_input"));
			 tag.sendKeys("ConstructWeek");
			 
			// Now for back 
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			Thread.sleep(1000);
			
			// Write Some Content
			AndroidElement content = driver.findElement(MobileBy.id("com.automattic.simplenote:id/note_content"));
			content.sendKeys("Project work");
			
			// Now going back again
			driver.findElement(MobileBy.AccessibilityId("Navigate up")).click();
			Thread.sleep(3000);
			
			// Long Press
			AndroidElement lp = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Let us Work Hard\")"));
			TouchAction tA = new TouchAction(driver);
			tA.longPress(longPressOptions().withElement(element(lp)).withDuration(ofSeconds(3))).release().perform();
			
			// delete the particular selected one
			driver.findElement(MobileBy.AccessibilityId("Search Notes or Tags")).click();
			
			// Search for notes
		    AndroidElement search = driver.findElement(MobileBy.id("com.automattic.simplenote:id/menu_search"));
		    search.click();
		    AndroidElement s1 = driver.findElement(MobileBy.id("com.automattic.simplenote:id/search_src_text"));
		    s1.sendKeys("Con");
		    
		    // Click on the search suggestion
			AndroidElement suggest = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"tag:ConstructWeek\")"));
			suggest.click();
			
			// Assert the result
			String result = driver.findElement(MobileBy.id("com.automattic.simplenote:id/note_title")).getText();
			System.out.println(result);

			
			// open the Notification 
					driver.openNotifications();
					
					// Toggle Battery Saver Mode On
					driver.findElements(MobileBy.className("android.widget.TextView")).get(4).click();
					
					// Toggle Battery Saver Mode Off
					driver.findElements(MobileBy.className("android.widget.TextView")).get(4).click();
					
					// Navigate to the Home Screen
					driver.pressKey(new KeyEvent(AndroidKey.HOME));
					Thread.sleep(3000);
					System.out.println("Successfully Opened the notification and perform the action");
					
			// Switch App to APIDemos
					driver.activateApp("io.appium.android.apis");
					
					// Clicking on OS
					driver.findElement(MobileBy.AccessibilityId("OS")).click();
					
					// Click on SMS
					driver.findElement(MobileBy.AccessibilityId("SMS Messaging")).click();
					
					// Enabling the broadcast
					driver.findElement(MobileBy.AccessibilityId("Enable SMS broadcast receiver")).click();
					
					// Sending mssg to the recipient
					driver.findElement(By.id("io.appium.android.apis:id/sms_recipient")).sendKeys("(650)555-1212");
					
					// The mssg which will be send 
					driver.findElement(By.id("io.appium.android.apis:id/sms_content")).sendKeys("Anneyong");
					
					// Code for Hiding the keyboard
					driver.hideKeyboard();
					
					// click on send button
					driver.findElement(MobileBy.AccessibilityId("Send")).click();
					
					System.out.println("Successfully Send message");
					
			// Switch App to Message 
					driver.activateApp("com.google.android.apps.messaging");
					Thread.sleep(5000);
					
					// Assert the result
					String Msg = driver.findElement(MobileBy.id("com.google.android.apps.messaging:id/conversation_snippet")).getText();
					System.out.println(Msg);
					
					// Navigate to switch back 
					driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
					
					// Navigate back to Home
					driver.pressKey(new KeyEvent(AndroidKey.HOME));
					
					System.out.println("Message is visible");
			// OVERALL TESTING DONE
					System.out.println("Native App Testing Done.");
					
//		    // Close the driver
		            driver.quit();
			
		} catch (Exception e) {
			
		}		
	}
	
	
//	@Test
//	public void notification() {
//		// open the Notification 
//		driver.openNotifications();
//		// Toggle Battery Saver Mode On
//		driver.findElements(MobileBy.className("android.widget.TextView")).get(4).click();
//		// Toggle Battery Saver Mode Off
//		driver.findElements(MobileBy.className("android.widget.TextView")).get(4).click();
//		// Navigate to the Home Screen
//		driver.pressKey(new KeyEvent(AndroidKey.HOME));
//	}
}
