package deem.internal.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BaseTest {

    private static List<TestResult> testResults = new ArrayList<>();

    @Rule
    public TestWatcher watchman = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            testResults.add(produceTestResult(description, e));
        }
        @Override
        protected void succeeded(Description description) {
            testResults.add(produceTestResult(description, null));
        }
    };

    protected TestResult produceTestResult(Description description, Throwable e) {
        TestStatus status;
        if (e == null) {
            status = TestStatus.Passed;
        } else if (e instanceof AssertionError) {
            status = TestStatus.Failed;
        } else {
            status = TestStatus.Error;
        }

        return new TestResult(
            description.getClassName(),
            description.getMethodName(),
            System.currentTimeMillis(),
            status
        );
    }

    @BeforeClass
    public static void resetTestResults() {
        testResults.clear();
    }

    @AfterClass
    public static void reportTestResults() {
        File resultsDir = new File(new File("build/.deem").getAbsolutePath());
        if (!resultsDir.exists() && !resultsDir.mkdirs()) {
            throw new RuntimeException("Unable to mkdirs on " + resultsDir);
        }

        File resultsFile = new File(resultsDir, "0" + System.currentTimeMillis() + "-deem-test.json");
        ObjectMapper jackson = new ObjectMapper();
        try {
            jackson.writeValue(resultsFile, testResults);
        } catch (IOException e) {
            throw new RuntimeException("Error while writing test results", e);
        }
    }

}
