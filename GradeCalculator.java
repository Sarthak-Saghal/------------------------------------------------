import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt user for the number of courses
        System.out.print("Enter the number of courses: ");
        int numCourses = sc.nextInt();

        if (numCourses <= 0) {
            System.out.println("The number of courses must be greater than zero.");
            return;
        }

        double totalGrade = 0;

        // Input grades for each course
        for (int i = 1; i <= numCourses; i++) {
            System.out.print("Enter grade for course " + i + " (as a percentage): ");
            double grade = sc.nextDouble();
            
            // Validate the grade
            if (grade < 0 || grade > 100) {
                System.out.println("Invalid grade. Please enter a value between 0 and 100.");
                i--; // Repeat this iteration
                continue;
            }

            totalGrade += grade;
        }

        // Calculate average grade
        double averageGrade = totalGrade / numCourses;
        String letterGrade = calculateLetterGrade(averageGrade);

        // Output the final grade
        System.out.printf("Average percentage: %.2f%%\n", averageGrade);
        System.out.println("Final letter grade: " + letterGrade);
    }

    public static String calculateLetterGrade(double averageGrade) {
        if (averageGrade >= 90) {
            return "A";
        } else if (averageGrade >= 80) {
            return "B";
        } else if (averageGrade >= 70) {
            return "C";
        } else if (averageGrade >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
