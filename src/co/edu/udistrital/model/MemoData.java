package co.edu.udistrital.model;

public class MemoData {

    private long heapUsed;
    private long heapMax;
    private long nonHeapUsed;
    private String timestamp;

    public MemoData(long heapUsed, long heapMax, long nonHeapUsed, String timestamp) {
        this.heapUsed = heapUsed;
        this.heapMax = heapMax;
        this.nonHeapUsed = nonHeapUsed;
        this.timestamp = timestamp;
    }

    public long getHeapUsed() {
        return heapUsed;
    }

    public long getHeapMax() {
        return heapMax;
    }

    public long getNonHeapUsed() {
        return nonHeapUsed;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
