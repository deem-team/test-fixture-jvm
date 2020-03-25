package deem.internal.tests;

public class TestResult {

    private String className;
    private String methodName;
    private long timestamp;
    private TestStatus status;
    private TestScore score;

    public TestResult(String className, String methodName, long timestamp, TestStatus status, TestScore score) {
        this.className = className;
        this.methodName = methodName;
        this.timestamp = timestamp;
        this.status = status;
        this.score = score;
    }

    public TestResult(String className, String methodName, long timestamp, TestStatus status) {
        this(className, methodName, timestamp, status, null);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public TestStatus getStatus() {
        return status;
    }

    public void setStatus(TestStatus status) {
        this.status = status;
    }

    public TestScore getScore() {
        return score;
    }

    public void setScore(TestScore score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", timestamp=" + timestamp +
                ", status=" + status +
                ", score=" + score +
                '}';
    }
}
