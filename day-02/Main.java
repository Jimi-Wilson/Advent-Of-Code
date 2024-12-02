
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
    
    public void readData(String filePath) {
        try {
            File file = new File(filePath);
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {

            } reader.close();


        } catch (FileNotFoundException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }

    }
    
    public static void main(String[] args) {
        
    }
}