package inici;

public class ExcepDelTeam extends Exception{
    /**
     * No se puede eliminar un jugador de un equipo que no pertene
     * @param msg
     */
    public ExcepDelTeam(String msg) {
        super(msg);
    }
}
