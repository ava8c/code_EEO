package model;

import java.util.List;

public class Demon {
    private int id;
    private int staminaPersa;
    private int numeroTurniPerStamina;
    private int staminaRestituita;
    private int turniFrammenti;
    private List<Integer> frammentiRestituitiPerTurno;
    private boolean affrontato = false;

    public Demon(int id) {
        this.id = id;
    }

    public int getStaminaPersa() {
        return staminaPersa;
    }

    public void setStaminaPersa(int staminaPersa) {
        this.staminaPersa = staminaPersa;
    }

    public int getNumeroTurniPerStamina() {
        return numeroTurniPerStamina;
    }

    public void setNumeroTurniPerStamina(int numeroTurniPerStamina) {
        this.numeroTurniPerStamina = numeroTurniPerStamina;
    }

    public int getStaminaRestituita() {
        return staminaRestituita;
    }

    public void setStaminaRestituita(int staminaRestituita) {
        this.staminaRestituita = staminaRestituita;
    }

    public int getTurniFrammenti() {
        return turniFrammenti;
    }

    public void setTurniFrammenti(int turniFrammenti) {
        this.turniFrammenti = turniFrammenti;
    }

    public List<Integer> getFrammentiRestituitiPerTurno() {
        return frammentiRestituitiPerTurno;
    }

    public void setFrammentiRestituitiPerTurno(List<Integer> frammentiRestituitiPerTurno) {
        this.frammentiRestituitiPerTurno = frammentiRestituitiPerTurno;
    }

    public boolean isAffrontato() {
        return affrontato;
    }

    public void setAffrontato(boolean affrontato) {
        this.affrontato = affrontato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
