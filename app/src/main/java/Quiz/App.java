package Quiz;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.PrintStream;

public class App {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;

        ArrayList<Integer> grades = new ArrayList<>();

        String response = "yes";

        while (!response.startsWith("n")) {
            out.print("Please enter a grade: ");
            Integer newGrade = in.nextInt();
            grades.add(newGrade);

            out.print("Would you like to enter another grade (Y/n)? ");
            in.nextLine(); // NOTE This line is a hack that seems to be needed, at least with my terminal.
            response = in.nextLine().toLowerCase();
        }

        Integer highest = Collections.max(grades);
        Integer lowest = Collections.min(grades);

        double avg = grades.stream().mapToInt(x->x).average().orElse(Double.NaN);

        long numA = grades.stream()
            .filter(g -> g >= 90)
            .count();
        long numB = grades.stream()
            .filter(g -> g >= 80 && g <= 89)
            .count();
        long numC = grades.stream()
            .filter(g -> g >= 70 && g <= 79)
            .count();
        long numFailed = grades.stream()
            .filter(g -> g <= 69)
            .count();

        out.printf("""

            highest score: %d
            lowest score: %d
            mean of the scores: %.2f
            count of A scores: %d
            count of B scores: %d
            count of C scores: %d
            count of failing scores: %d\n""",
            highest,
            lowest,
            avg,
            numA,
            numB,
            numC,
            numFailed
        );

        in.close();
    }
}
