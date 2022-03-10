import helper.InputParser;
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
    private static List<Integer> demoniOutput = new ArrayList<>();

    private static String inputFile = "00-example.txt";



    public static void main(String[] args) throws IOException {

        player = InputParser.getPlayer(inputFile);
        demoniInput = InputParser.getDemonsList(inputFile);



	    System.out.println("StaminaMax: "+player.getStaminaMax());
    }
}
