package inici;

public class ExcepRepTeam extends Exception{
    /**
     * No se pueden repetir Jugadores en un mismo equipo
     * @param message
     */
    public ExcepRepTeam(String message) {
        super(message);
    }
}
