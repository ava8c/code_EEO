import helper.InputParser;
import model.Demon;
import model.Player;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final Path currentRelativePath = Paths.get("");
    private static final Path current_path = currentRelativePath.toAbsolutePath();

    private static List<Demon> demoniInput = new ArrayList<>();
    private static Player player = new Player();
    private static List<Integer> demoniOutput = new ArrayList<>();

    private static String inputFile = "00-example.txt";

    private static Integer turnoCorrente = 0;
    private static Integer numeroTurni;
    private static Integer[][] ricarica;



    public static void main(String[] args) throws IOException {

        player = InputParser.getPlayer(inputFile);
        demoniInput = InputParser.getDemonsList(inputFile);



	    System.out.println("Inizio gioco");

        numeroTurni = player.getNumeriTurni();
        ricarica = new Integer[numeroTurni][2];
        
        /*
        aggiungiStamina();
        selectDemon();
        affronta();
        scartaDemone();
        RicompensaStamina();
        aggiornaTurno();
        REPEAT
        */
    }

    public 

    static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
	    //System.out.println("StaminaMax: "+player.getStaminaMax());
    }

    public void sortDemons(List<Demon> demons) {

    }

    public Demon selectDemon( Player yone) {

        int staminaRimanente = yone.getStamina();
        List<Demon> affrontabili = demoniInput.stream().filter(d -> d.getStaminaPersa() <= staminaRimanente && !d.isAffrontato()).collect(Collectors.toList());

        int turniRimanenti = numeroTurni - turnoCorrente;

        Demon bestDemon = affrontabili.stream().max(Comparator.comparing(demon -> demon.getFrammentiRestituitiPerTurno().get(turniRimanenti-1))).get();

        bestDemon.setAffrontato(true);

        demoniOutput.add(bestDemon.getId());
        
        return bestDemon;
    }

}
