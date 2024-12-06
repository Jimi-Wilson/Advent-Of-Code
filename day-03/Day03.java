import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;
;

public class Day03 {
    
    public void readInput(String inputPath) {
        try {
            File file = new File(inputPath);
            Scanner reader = new Scanner(file);
            Pattern pattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)");
            while (reader.hasNextLine()) {
                Matcher matcher = pattern.matcher(reader.nextLine());
                
            }
            reader.close();
        } catch(FileNotFoundException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}