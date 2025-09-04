

import java.time.LocalDateTime;

public class Exam {
    private int id;
    private String title;
    private Course course;
    private LocalDateTime dateTime;
    private int coefficient;

    public Exam() {
    }

    public Exam(int id, String title, Course course, LocalDateTime dateTime, int coefficient) {
        this.id = id;
        this.title = title;
        this.course = course;
        this.dateTime = dateTime;
        this.coefficient = coefficient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }
}
