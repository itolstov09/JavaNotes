import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class FilesNote {
    public static void main(String[] args) {
        Path textFilePath = Paths.get(System.getProperty("user.dir"), "\\notes\\Resources\\textFile.txt");
        try {
            List<String> textReadAllLines = Files.readAllLines(textFilePath);
            Stream<String> textLines = Files.lines(textFilePath);

            byte[] bytesReadAllBytes = Files.readAllBytes(textFilePath);
            System.out.println(new String(bytesReadAllBytes));

            System.out.println(textReadAllLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

}
