package com.duke.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.duke.base.BaseClass;

public class TestUtils extends BaseClass {
	private static TestUtils instance = null;

	private TestUtils() {

	}

	public static TestUtils getInstance() {
		if (instance == null) {
			instance = new TestUtils();
		}
		return instance;
	}

	public String projPath = System.getProperty("user.dir");


	// To capture screenshot
	public void captureScreenshotAsJPG(String fileName) throws IOException {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(projPath + "\\target\\screenShots\\" + TestUtils.getInstance().getTimeStamp() + "_"
				+ fileName + ".jpg");
		FileUtils.copyFile(SrcFile, destFile);
	}

	public void captureScreenshotAsJPEG(String fileName) throws IOException {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(projPath + "\\target\\screenShots\\" + TestUtils.getInstance().getTimeStamp() + "_"
				+ fileName + ".jpeg");
		FileUtils.copyFile(SrcFile, destFile);
	}

	public void captureScreenshotAsPNG(String fileName) throws IOException {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(projPath + "\\target\\screenShots\\" + TestUtils.getInstance().getTimeStamp() + "_"
				+ fileName + ".png");
		FileUtils.copyFile(SrcFile, destFile);
	}

	// generate time stamp
	public String getTimeStamp() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat f = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss_SSSSSS");
		String timeStamp = f.format(cal.getTime());
		return timeStamp;
	}
}
