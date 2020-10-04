package in.amazon.genericLib;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;

public class MyListener extends BaseTest implements ITestListener {
    public void onTestStart(ITestResult result) {
        Reporter.log(result.getName()+" method started", true);
    }

    public void onTestSuccess(ITestResult result) {
        Reporter.log(result.getName()+" method passed", true);
    }

    public void onTestFailure(ITestResult result) {
        Reporter.log(result.getName()+" method failed", true);
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File("screenShots" + result.getName()+".png");
        try {
            Files.copy(source, destination);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {
        Reporter.log(result.getName()+" method skipped", true);
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestResult result) {
        Reporter.log(result.getName()+" started", true);
    }

    public void onFinish(ITestResult result) {
        Reporter.log(result.getName()+" ended", true);
    }
}
