
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Note {
    private int id;
    private Student student;
    private Exam exam;
    private double initialValue;
    private Instant createdAt;
    private List<NoteChange> changes = new ArrayList<>();

    public Note() {
    }

    public Note(int id, Student student, Exam exam, double initialValue, Instant createdAt) {
        this.id = id;
        this.student = student;
        this.exam = exam;
        this.initialValue = initialValue;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public double getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(double initialValue) {
        this.initialValue = initialValue;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public List<NoteChange> getChanges() {
        return changes;
    }

    public void setChanges(List<NoteChange> changes) {
        this.changes = changes;
    }

    public double getValueAt(Instant t) {
        double v = initialValue;
        for (NoteChange c : changes) {
            if (c.getAt() != null && !c.getAt().isAfter(t)) {
                v = c.getValue();
            }
        }
        return v;
    }
}
