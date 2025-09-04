
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GradeServiceTest {

    private GradeService service;
    private Student alice;
    private Course prog2;
    private Exam exam1;
    private Exam exam2;

    @BeforeEach
    public void setup() {
        service = new GradeService();

        Tutor parent = new Tutor(1, "Doe", "Parent", LocalDate.of(1980,1,1),
                "parent@example.com", "0600000000", "Père");

        alice = new Student(1, "Doe", "Alice", LocalDate.of(2005,5,5),
                "alice@example.com", "0700000000", "K1-A", parent);

        Teacher prof = new Teacher(1, "Smith", "John", LocalDate.of(1975,3,3),
                "jsmith@example.com", "0102030405", "back-end");

        prog2 = new Course(10, "PROG2", 6, prof);

        exam1 = new Exam(100, "Partiel 1", prog2, LocalDateTime.of(2025,1,10,9,0), 2);
        exam2 = new Exam(101, "Partiel 2", prog2, LocalDateTime.of(2025,2,20,9,0), 3);

        service.addExam(exam1);
        service.addExam(exam2);
    }

    @Test
    public void testExamGradeSimple() {
        Note note = new Note(1, alice, exam1, 12.0, Instant.parse("2025-01-11T10:00:00Z"));
        service.addNote(note);

        double grade = service.getExamGrade(exam1, alice, Instant.parse("2025-01-12T00:00:00Z"));
        assertEquals(12.0, grade, 0.0001);
    }

    @Test
    public void testCourseGradeSimpleAverage() {
        Note n1 = new Note(1, alice, exam1, 10.0, Instant.parse("2025-01-11T10:00:00Z"));
        Note n2 = new Note(2, alice, exam2, 15.0, Instant.parse("2025-02-21T10:00:00Z"));
        service.addNote(n1);
        service.addNote(n2);

        double grade = service.getCourseGrade(prog2, alice, Instant.parse("2025-02-25T00:00:00Z"));
        // moyenne pondérée : (10*2 + 15*3) / 5 = 13
        assertEquals(13.0, grade, 0.0001);
    }

    @Test
    public void testNoNote() {
        double grade = service.getExamGrade(exam1, alice, Instant.parse("2025-01-01T00:00:00Z"));
        assertEquals(0.0, grade, 0.0001);
    }
}
