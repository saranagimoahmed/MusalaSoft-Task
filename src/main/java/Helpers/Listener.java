package Helpers;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.*;

import static Helpers.Reporting.*;

public class Listener implements ISuiteListener, ITestListener, IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        ITestNGMethod testMethod = method.getTestMethod();
        if (testMethod.getDescription() != null && !testMethod.getDescription().equals("")) {
            Reporting.testCreation(testMethod.getDescription());
        } else {
            Reporting.testCreation(testResult.getName());
        }
        System.out.println("\n" + "============================================================================================");
        if (method.isConfigurationMethod()) {
            System.out.println("Starting Configuration Method (Setup or Teardown): [" + testResult.getName() + "]");
            if (testMethod.getDescription() != null && !testMethod.getDescription().equals("")) {
                Reporting.removeTest(testMethod.getDescription());
            } else {
                Reporting.removeTest(testResult.getName());
            }

        } else {
            System.out.println("Starting Test Case: [" + testResult.getName() + "]");
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("************************************");
        if (method.isConfigurationMethod()) {
            System.out.println("Finished Configuration Method (Setup or Teardown): [" + testResult.getName() + "]");
        } else {
            System.out.println("Finished Test Case: [" + testResult.getName() + "]");
        }
        System.out.println("************************************");
    }

    @Override
    public void onStart(ISuite suite) {
        System.out.println("***********************************");

        Report();
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("***********************************");
        reportFlush();
    }

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        messagePass(result.getMethod().getMethodName() + " Passed");

        markupPass(MarkupHelper.createLabel(result.getMethod().getMethodName() + " Passed", ExtentColor.BLUE));
    }

    @Override
    public void onTestFailure(ITestResult result) {

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test: [" + context.getName() + "] Started" + " ****************************************************");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test: [" + context.getName() + "] Finished");

    }
}
