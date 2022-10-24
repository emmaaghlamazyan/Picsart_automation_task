package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test started");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test finished");
    }
}