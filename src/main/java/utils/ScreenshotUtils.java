package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

	public static String captureScreenshot(WebDriver driver, String testName) {

	    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

	    String folderPath = System.getProperty("user.dir") + "/screenshots/";

	    File folder = new File(folderPath);
	    if (!folder.exists()) {
	        folder.mkdirs();
	    }

	    String path = folderPath + testName + "_" + timeStamp + ".png";

	    File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    File dest = new File(path);
	    
	    System.out.println("Screenshot saved at: " + path);

	    try {
	        FileUtils.copyFile(src, dest);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return path;
	    
	    
	}
	
    
}