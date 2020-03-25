package deem.internal.tests;

import org.junit.Before;
import org.junit.runner.Description;

public class ScoredTest extends BaseTest {

    protected TestType testType;
    protected int testWeight;
    protected String testSignal;

    @Before
    public void resetTestScoring() {
        testType = TestType.Public;
        testWeight = 0;
        testSignal = null;
    }

    @Override
    protected TestResult produceTestResult(Description description, Throwable e) {
        TestResult testResult = super.produceTestResult(description, e);
        testResult.setScore(new TestScore(testType, testWeight, testSignal));
        return testResult;
    }

}
