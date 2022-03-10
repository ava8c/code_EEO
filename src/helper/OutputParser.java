package helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class OutputParser {
    private static final Path currentRelativePath = Paths.get("");
    private static final Path current_path = currentRelativePath.toAbsolutePath();

    public static void writeResult(List<Integer> demonsList, String outputFileString) throws IOException {

        System.out.println("Scrittura risultati in " + outputFileString);

        Path path = Paths.get(current_path.toString(), "output", outputFileString + ".txt");

        String str = (demonsList.stream().map(String::valueOf)
                .collect(Collectors.joining("\n")));
        Files.write(path, str.getBytes());
    }
}
