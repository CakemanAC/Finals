import java.util.Scanner;

public class StudentScores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] scores = new int[50];
        int numStudents = 0;

        while (true) {
            System.out.print("Enter the number of students (1-50): ");
            numStudents = scanner.nextInt();
            if (numStudents >= 1 && numStudents <= 50) {
                break;
            }
            System.out.println("Invalid input. Please enter a number between 1 and 50.");
        }

        for (int i = 0; i < numStudents; i++) {
            while (true) {
                System.out.print("Enter score for Student " + (i + 1) + " (0-100): ");
                int inputScore = scanner.nextInt();
                if (inputScore >= 0 && inputScore <= 100) {
                    scores[i] = inputScore;
                    break;
                }
                System.out.println("Invalid score. Please enter a value between 0 and 100.");
            }
        }

        int sum = 0;
        int highest = scores[0];
        int lowest = scores[0];
        int passingCount = 0;
        int failingCount = 0;

        for (int i = 0; i < numStudents; i++) {
            int current = scores[i];
            sum += current;

            if (current > highest) {
                highest = current;
            }
            if (current < lowest) {
                lowest = current;
            }

            if (current >= 75) {
                passingCount++;
            } else {
                failingCount++;
            }
        }

        double average = (double) sum / numStudents;

        System.out.printf("\nAverage Score: %.2f\n", average);
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);
        System.out.println("Passing Scores (>= 75): " + passingCount);
        System.out.println("Failing Scores (< 75): " + failingCount);
        System.out.print("Student number(s) with highest score: ");
        for (int i = 0; i < numStudents; i++) {
            if (scores[i] == highest) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();

        scanner.close();
    }
}
