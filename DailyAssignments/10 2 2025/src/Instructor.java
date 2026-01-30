import java.util.ArrayList;

public class Instructor extends User {
    public String instructorID;
    protected ArrayList<String> coursesTeaching = new ArrayList<>();

    public void createCourse(String course) {
        coursesTeaching.add(course);
        System.out.printf("Instructor %s created %s\n", name, course);
    }

    public void gradeStudent(String studentName, String courseName) {
        System.out.printf("Instructor %s graded %s in %s\n", name, studentName, courseName);
    }
}