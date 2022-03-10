package model;

import java.util.List;

public class Context {
    Integer numeroTurni;
    Integer[][] ricarica = new Integer[numeroTurni][2];
    Player player;
    List<Demon> demons;

    public Integer getNumeroTurni() {
        return numeroTurni;
    }

    public void setNumeroTurni(Integer numeroTurni) {
        this.numeroTurni = numeroTurni;
    }

    public Integer[][] getRicarica() {
        return ricarica;
    }

    public void setRicarica(Integer[][] ricarica) {
        this.ricarica = ricarica;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Demon> getDemons() {
        return demons;
    }

    public void setDemons(List<Demon> demons) {
        this.demons = demons;
    }
}
