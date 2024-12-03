
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day02 {
    private int totalSafeReports = 0;

    public int solvePart1(String filePath) {
        try {
            File file = new File(filePath);
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] numbers = data.split("\\s+");

                boolean isSafe = this.reportClassification(numbers);

                if (isSafe) {
                    this.totalSafeReports++;
                }
            }
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
        return this.totalSafeReports;
    }

    public boolean reportClassification(String[] numbers) {
        boolean increasing = false;
        boolean decreasing = false;
        boolean isSafe = true;

        for (int i = 0; i < numbers.length - 1; i++) {
            int diff = Integer.parseInt(numbers[i]) - Integer.parseInt(numbers[i + 1]);

            if (diff >= 0) {
                decreasing = true;
            }
            if (diff <= 0) {
                increasing = true;

            }
            if (Math.abs(diff) > 3) {
                isSafe = false;
            }
        }
        if (increasing && decreasing)
            isSafe = false;
        return isSafe;
    }

    public static void main(String[] args) {
        Day02 program = new Day02();
        System.out.println(program.solvePart1("input.txt"));
    }
}