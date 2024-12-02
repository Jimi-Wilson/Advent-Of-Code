import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day01 {
    private int[] leftSide;
    private int[] rightSide;
    private int totalDistance = 0;
    private int totalSimularityScore = 0;

    public void readInputs(String inputPath) {
        try {
            File file = new File(inputPath);
            Scanner reader = new Scanner(file);

            this.leftSide = new int[(int) file.length()];
            this.rightSide = new int[(int) file.length()];
            int counter = 0;
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] numbers = data.split("\\s+");

                this.leftSide[counter] = Integer.parseInt(numbers[0]);
                this.rightSide[counter] = Integer.parseInt(numbers[1]);

                counter++;
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }

    public int solvePart1() {
        Arrays.sort(this.leftSide);
        Arrays.sort(this.rightSide);

        for (int i = 0; i < leftSide.length; i++) {
            int difference = Math.abs(this.leftSide[i] - this.rightSide[i]);
            this.totalDistance += difference;
        }

        return this.totalDistance;
    }

    public int solvePart2() {
        Arrays.sort(this.leftSide);
        Arrays.sort(this.rightSide);

        int counter = 0;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i : this.leftSide) {
            if (map.containsKey(i)) {
                this.totalSimularityScore += i * map.get(i);
                continue;
            }
            for (int j : this.rightSide) {
                if (i == j) {
                    counter++;
                }
            }
            map.put(i, counter);
            this.totalSimularityScore += i * counter;
            counter = 0;
        }

        return totalSimularityScore;
    }

    public static void main(String[] args) {
        Day01 program = new Day01();
        program.readInputs("input.txt");
        System.out.println(program.solvePart1());
        System.out.println(program.solvePart2());

    }
}