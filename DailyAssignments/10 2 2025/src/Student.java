import java.util.ArrayList;

public class Student extends User {
    public String studentID;
    protected ArrayList<String> enrolledCourses = new ArrayList<>();

    public void enrollCourse(String course) {
        enrolledCourses.add(course);
        System.out.printf("Student %s enrolled in %s.\n", name, course);
    }
    
}
