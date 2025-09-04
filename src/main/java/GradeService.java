

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class GradeService {
    private List<Note> notes = new ArrayList<>();
    private List<Exam> exams = new ArrayList<>();

    public void addNote(Note n) {
        notes.add(n);
    }

    public void addExam(Exam e) {
        exams.add(e);
    }

    public double getExamGrade(Exam exam, Student student, Instant t) {
        double grade = 0.0;
        Instant last = null;
        for (Note n : notes) {
            if (n.getExam() == exam && n.getStudent() == student) {
                if (n.getCreatedAt() != null && !n.getCreatedAt().isAfter(t)) {
                    if (last == null || n.getCreatedAt().isAfter(last)) {
                        grade = n.getValueAt(t);
                        last = n.getCreatedAt();
                    }
                }
            }
        }
        return grade;
    }

    public double getCourseGrade(Course course, Student student, Instant t) {
        double sum = 0.0;
        int sumCoef = 0;
        for (Exam e : exams) {
            if (e.getCourse() == course) {
                double g = getExamGrade(e, student, t);
                if (g > 0.0) {
                    sum += g * e.getCoefficient();
                    sumCoef += e.getCoefficient();
                }
            }
        }
        if (sumCoef == 0)
            return 0.0;
        return sum / sumCoef;
    }
}
