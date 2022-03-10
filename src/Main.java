import model.Demon;
import model.Player;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Path currentRelativePath = Paths.get("");
    private static final Path current_path = currentRelativePath.toAbsolutePath();

    private static List<Demon> demoniInput = new ArrayList<>();
    private static Player player = new Player();
    private static List<Demon> demoniOutput = new ArrayList<>();

    private static String inputFile = "00-example.txt";

    public static void main(String[] args) throws IOException {

        String fileName = Paths.get(current_path.toString(), "input", inputFile).toString();

        String inputFile = readFile(fileName, StandardCharsets.UTF_8);

        String line;
        Scanner scanner = new Scanner(inputFile);

        int count = 0;

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();

            if (count == 0) {
                
            }

            count++;
        }

	    System.out.println("prova");
    }

    static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
