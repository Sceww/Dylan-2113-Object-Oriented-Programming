import java.util.ArrayList;

/**
 * 
 */
public class StudentManager {
    private static ArrayList<String> studentList = new ArrayList<>();

    /**
     * @param student - The name of the student to add.
     */
    private static void add(String student) {
        studentList.add(student);
    }
    private static void remove(int idx) {
        studentList.remove(idx);
    }
    /**
     * removes a specified student.
     * @param student
     */
    private static void remove(String student) {
        int idx = search(student);
        if (idx < 0) {
            return;
        } else {
            remove(idx);
        }
    }

    /**
     * 
     * @param student - The name of the student to search
     * @return the index of the student if found. If not found, returns -1.
     */
    private static int search(String student) {
        student = student.toLowerCase();
        for (int idx = 0; idx < studentList.size(); idx++) {
            String searchStudent = studentList.get(idx).toLowerCase();
            if (student.equals(searchStudent)) {
                return idx;
            }
        }
        return -1; // The student wasn't found.
    }
    /**
     * sets the index of the arraylist to a string.
     * @param idx index to search
     * @param student
     */
    private static void replace(int idx, String student) {
        studentList.set(idx, student);
    }
    /**
     * Searches for the student, and replaces it with another String
     * @param studentToReplace
     * @param student
     */
    private static void replace(String studentToReplace, String student) {
        int idx = search(studentToReplace);
        if (idx < 0) { 
            return;
        } else { 
            replace(idx, student); 
        }
    } 
    /** sorts studentList by alphabetical order */
    private static void sort() {
        for (int i = 1; i < studentList.size(); i++) {
            String value = studentList.get(i);
            int j = i - 1;
            while (j >= 0 && studentList.get(j).toLowerCase().charAt(0) > value.toLowerCase().charAt(0)) {
                studentList.set(j + 1, studentList.get(j));
                j--;
            }
            studentList.set(j + 1, value);
        }
    }

    /** Prints the students in the class. */
    private static void printClass() {
        System.out.println("Roll No.\tName");
        for (int idx = 0; idx < studentList.size(); idx++) {
            String student = studentList.get(idx);
            System.out.printf("%d\t%s\n", idx+1, student);
        }
    }
    public static void main(String[] args) {
        add("Diana");
        add("Alice");
        add("Charlie");
        add("Ethan");
        add("Bob");
        add("InvalidStudent");
        printClass();

        // Replace test
        replace("Bob", "Frank");
        printClass();

        // Remove student
        remove("InvalidStudent");

        //Sort test
        sort();
        printClass();

        // Search tests
        if (search("Diana") < 0) {
            System.out.println("Not Found");
        } else {System.out.println("Found");}
        if (search("George") < 0) {
            System.out.println("Not Found");
        } else {System.out.println("Found");}

        // print string
        String charlie = studentList.get(search("charlie"));
        System.out.printf("Normal print:\t%s\n"   , charlie);
        System.out.printf("Uppercase:\t%s\n"      , charlie.toUpperCase());
        System.out.printf("Lowercase:\t%s\n"      , charlie.toLowerCase());
        System.out.printf("Length of name:\t%d\n" , charlie.length());
        System.out.printf("1st three:\t%s\n"      , charlie.substring(0, 3));
    }
}