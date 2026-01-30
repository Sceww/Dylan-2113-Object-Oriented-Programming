import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create PremiumStudent
        PremiumStudent john = new PremiumStudent();
        john.name = "John"; // public
        john.studentID = "S123"; // public
        john.enrollCourse("Java Programming"); // enroll course
        john.enrollCourse("Data Structures"); // enroll another course
        john.setSubscriptionEndDate("31-12-2025"); // set subscription end
        john.login();
        john.accessPremiumContent();
        john.showSubscriptionEnd();
        john.logout();

        System.out.println();

        // Create Instructor
        Instructor sarah = new Instructor();
        sarah.name = "Sarah"; // public
        sarah.instructorID = "I456"; // public
        sarah.login();
        sarah.createCourse("Python Basics");
        sarah.gradeStudent("John", "Java Programming");
        sarah.logout();
    }
}