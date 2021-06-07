package joc;

import inici.ExcepRepTeam;
import io.Utilidades;

import java.util.ArrayList;

public class Team
{
    //Atributo
    private String name;
    private ArrayList<Player> players;

    //Constructor

    /**
     * @param name constructor basico
     */
    public Team(String name)
    {
        this.setName(name);
        this.players = new ArrayList<>();
    }


    //Metodos

    /**
     * @return metodo Override de Players con sus excepciones
     */
    @Override
    public String toString()
    {

        StringBuilder res = new StringBuilder("Equipo " + getName());

        for (Player player : players)//desde el primer jugador hasta el ultimo en la lista
        {
            Utilidades.linia(25);
            res.append("\n Jugador: ").append(player);
            Utilidades.linia(25);
        }
        res.append("\n");

        return res.toString();
    }

    public void getMembers()
    {
        ArrayList<Player> p = new ArrayList<>();
    }

    //Añadir jugadores

    /**
     * Permite añadir jugadores a un equipo
     *
     * @param p
     */
    public void add(Player p) throws ExcepRepTeam
    {
        if (this.players.contains(p))
        {
            throw new ExcepRepTeam("No se pueden repetir Equipos");
        }
        //para no repetir jugadores
        //si el jugador no esta en el equipo, se añadira
        if (!players.contains(p))
        {
            players.add(p);
            p.addTeam(this);
        }
    }

    //Eliminar jugadores

    /**
     * Permite eliminar jugadores de un equipo
     *
     * @param p
     */
    public void remove(Player p)
    {//para no repetir jugdores
        //si el equipo esta t, se eliminara
        if (!players.contains(p))
            players.remove(p);
        p.removeTeam(this);
    }

    //comparar jugadores en los equipos

    /**
     * @param t
     * @return true o false
     */
    public boolean equals(Team t)
    {
        return this.getName().equals(t.getName()) && this.getPlayers().equals(t.getPlayers());
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public ArrayList<Player> getPlayers()
    {
        return players;
    }

    public void setPlayers(ArrayList<Player> players)
    {
        this.players = players;
    }
}
