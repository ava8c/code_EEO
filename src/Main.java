import helper.InputParser;
import model.Demon;
import model.Player;
import model.Ricarica;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final Path currentRelativePath = Paths.get("");
    private static final Path current_path = currentRelativePath.toAbsolutePath();

    private static List<Demon> demoniInput = new ArrayList<>();
    private static Player player = new Player();
    private static List<Integer> demoniOutput = new ArrayList<>();
    private static List<Ricarica> ricarica = new ArrayList<>();

    private static String inputFile = "00-example.txt";

    private static Integer turnoCorrente = 0;
    private static Integer numeroTurni;
    private static Integer numeroTurniRimanenti;

    public static void main(String[] args) throws IOException {

        player = InputParser.getPlayer(inputFile);
        demoniInput = InputParser.getDemonsList(inputFile);

	    System.out.println("Inizio gioco");
        numeroTurni = player.getNumeriTurni();
        numeroTurniRimanenti = player.getNumeriTurni();

        while(numeroTurni > 0) {
            //addStamina();
            Demon nextDemone = selectDemon();
            affrontaDemone(nextDemone);
            ricarica.removeIf(r -> r.getTurniRimanentiAllaRicarica() == 0);
            aggiornaTurno();
        }
    }

    public static void aggiornaTurno() {
        numeroTurniRimanenti--;
        addStamina();
    }

    public static void addStamina() {

        for(Ricarica ric : ricarica) {
            ric.setTurniRimanentiAllaRicarica(ric.getTurniRimanentiAllaRicarica() - 1);
            if(ric.getTurniRimanentiAllaRicarica() == 0) {
                player.setStamina(player.getStamina() + ric.getStaminaRicaricata());
                ric.setStaminaRicaricata(0);
                if(player.getStamina() > player.getStaminaMax())
                    player.setStamina(player.getStaminaMax());
            }
        }
    }

    public static void affrontaDemone(Demon demone) {
        player.setStamina(player.getStamina() - demone.getStaminaPersa());
        player.setNumeriTurni(player.getNumeriTurni()-1);
        Ricarica addRicarica = new Ricarica();
        addRicarica.setStaminaRicaricata(demone.getStaminaRestituita());
        addRicarica.setTurniRimanentiAllaRicarica(demone.getNumeroTurniPerStamina());
        ricarica.add(addRicarica);
    }

    static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
	    //System.out.println("StaminaMax: "+player.getStaminaMax());
    }

    public void sortDemons(List<Demon> demons) {

    }

    public static Demon selectDemon() {

        int staminaRimanente = player.getStamina();
        List<Demon> affrontabili = demoniInput.stream().filter(d -> d.getStaminaPersa() <= staminaRimanente && !d.isAffrontato()).collect(Collectors.toList());

        if(affrontabili.isEmpty()) {
            aggiornaTurno();
            if(numeroTurniRimanenti == 0)
                return null;
            selectDemon();
        }

        int turniRimanenti = numeroTurni - turnoCorrente;

        Demon bestDemon = affrontabili.stream().max(Comparator.comparing(demon -> demon.getFrammentiRestituitiPerTurno().get(turniRimanenti-1))).get();

        bestDemon.setAffrontato(true);

        demoniOutput.add(bestDemon.getId());

        return bestDemon;
    }

}
