package Lab2;

import java.util.Random;

public class ClassPeriod {
    public static void main(String[] args) {
        // Create a Random object
        Random random = new Random(System.currentTimeMillis());

        // Define arrays for subjects and teachers
        String[] subjects = {"Mathematics", "Physics", "Chemistry", "Biology", "Computer Science", "English"};
        String[] teachers = {"Mr. Smith", "Mrs. Johnson", "Dr. Brown", "Ms. Lee", "Prof. White", "Mr. Green"};

        // Randomly select a subject and a teacher
        int randomSubjectIndex = random.nextInt(subjects.length);
        int randomTeacherIndex = random.nextInt(teachers.length);

        // Display the class period details
        System.out.println("Class Period Details:");
        System.out.println("Subject: " + subjects[randomSubjectIndex]);
        System.out.println("Teacher: " + teachers[randomTeacherIndex]);
    }
}
