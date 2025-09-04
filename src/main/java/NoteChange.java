

import java.time.Instant;

public class NoteChange {
    private Instant at;
    private double value;
    private String reason;

    public NoteChange() {
    }

    public NoteChange(Instant at, double value, String reason) {
        this.at = at;
        this.value = value;
        this.reason = reason;
    }

    public Instant getAt() {
        return at;
    }

    public void setAt(Instant at) {
        this.at = at;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
