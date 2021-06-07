package inici;

public class ExcepJugDead extends Exception {
    /**
     * No se puede atacar a un jugador muerto ni ser atacado por el
     * @param msg
     */
    public ExcepJugDead(String msg) {
        super(msg);
    }
}
