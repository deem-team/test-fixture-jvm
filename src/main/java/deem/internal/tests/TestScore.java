package deem.internal.tests;

public class TestScore {

    private TestType testType;
    private int testWeight;
    private String testSignal;

    public TestScore(TestType testType, int testWeight, String testSignal) {
        this.testType = testType;
        this.testWeight = testWeight;
        this.testSignal = testSignal;
    }

    public TestType getTestType() {
        return testType;
    }

    public int getTestWeight() {
        return testWeight;
    }

    public String getTestSignal() {
        return testSignal;
    }

    @Override
    public String toString() {
        return "TestScore{" +
                "testType=" + testType +
                ", testWeight=" + testWeight +
                ", testSignal='" + testSignal + '\'' +
                '}';
    }
}
