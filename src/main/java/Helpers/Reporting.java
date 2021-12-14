package Helpers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting {
    public static ExtentReports Report;
    public static ExtentTest Test;
    public static String TestCaseName;
    public static String Message;
    public static Markup Markup;
    public static Throwable Throwable;
    public static Media Media;

    public static void Report() {
        Report = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("Report.html");
        Report.attachReporter(spark);
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Report");
        spark.config().setReportName("MusalaSoft Automation Task ");

    }

    public static void throwableSkip() {
        Test.skip(Throwable);
    }

    public static void messageSkip() {
        Test.skip(Message);
    }

    public static void mediaFail() {
        Test.fail(Media);
    }

    public static void throwableFail() {
        Test.fail(Throwable);
    }

    public static void markupFail() {
        Test.fail(Markup);
    }

    public static void messageFail() {
        Test.fail(Message);
    }

    public static void markupPass(com.aventstack.extentreports.markuputils.Markup mark) {
        Test.pass(mark);
    }

    public static void messagePass(String s) {
        Test.pass(Message);
    }

    public void markupInfo() {
        Test.info(Markup);
    }

    public static void testCreation(String TestCaseName) {
        Test = Report.createTest(TestCaseName);
    }

    public static void messageInfo() {
        Test.info(Message);
    }

    public static void removeTest(String description) {
        Report.removeTest(TestCaseName);
    }


    public static void reportFlush() {

        Report.flush();
    }

}

