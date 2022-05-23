import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileMenager {
    String readTextFromFile(String fileName) {
        String text = "";
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                text += scanner.nextLine();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return text;
    }
}
