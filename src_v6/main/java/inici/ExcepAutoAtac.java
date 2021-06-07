package inici;

public class ExcepAutoAtac extends Exception{
    /**
     * Un jugador no se puede atacar a si mismo
     * @param msg
     */
    public ExcepAutoAtac(String msg) {
        super(msg);
    }
}
