package helper;

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

public class InputParser {

    private static final Path currentRelativePath = Paths.get("");
    private static final Path current_path = currentRelativePath.toAbsolutePath();

    public static List<Demon> getDemonsList(String inputFileString) throws IOException{

        String fileName = Paths.get(current_path.toString(), "input", inputFileString + ".txt").toString();

        String inputFile = readFile(fileName, StandardCharsets.UTF_8);

        String line;
        Scanner scanner = new Scanner(inputFile);

        int count = 0;

        List<Demon> demoniInput = new ArrayList<>();

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();

            String[] splittedLine = line.split(" ");

            if (count != 0) {
                Demon demon = new Demon(count-1);
                demon.setStaminaPersa(Integer.parseInt(splittedLine[0]));
                demon.setNumeroTurniPerStamina(Integer.parseInt(splittedLine[1]));
                demon.setStaminaRestituita(Integer.parseInt(splittedLine[2]));
                demon.setTurniFrammenti(Integer.parseInt(splittedLine[3]));
                ArrayList<Integer> frammentiRestituiti = new ArrayList<>();
                Integer gemma = 0;
                for (int i = 4; i < splittedLine.length - 1; i++) {
                    gemma += Integer.parseInt(splittedLine[i]);
                    frammentiRestituiti.add(gemma);
                }
                demon.setFrammentiRestituitiPerTurno(frammentiRestituiti);
                assert demon.getFrammentiRestituitiPerTurno().size() == demon.getTurniFrammenti();
                demoniInput.add(demon);
            }
            count++;
        }

        return demoniInput;
    }

    public static Player getPlayer(String inputFileString) throws IOException {
        String fileName = Paths.get(current_path.toString(), "input", inputFileString + ".txt").toString();

        String inputFile = readFile(fileName, StandardCharsets.UTF_8);

        String line;
        Scanner scanner = new Scanner(inputFile);

        int count = 0;

        Player player = new Player();

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();

            String[] splittedLine = line.split(" ");

            if (count == 0) {
                player.setStamina(Integer.parseInt(splittedLine[0]));
                player.setStaminaMax(Integer.parseInt(splittedLine[1]));
                player.setNumeriTurni(Integer.parseInt(splittedLine[2]));
                player.setNumeroDemoniDaBattere(Integer.parseInt(splittedLine[3]));
            }

            count++;
        }

        return player;
    }


    static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

}
