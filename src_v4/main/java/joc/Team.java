package joc;

import io.Utilidades;

import java.util.ArrayList;

public class Team
{
  //Atributo
  private String name;
  private ArrayList<Player> players;

  //Constructor

  public Team(String name)
  {
    this.setName(name);
    this.players = new ArrayList<>();
  }


  //Metodos
  @Override
  public String toString()
  {

    StringBuilder res = new StringBuilder("Equip " + getName() + ":");

    for (Player player : players)//desde el primer jugador hasta el ultimo en la lista
    {
      Utilidades.linia(15);
      res.append("\n Jugador: ").append(player);
      Utilidades.linia(15);
    }
    res.append("\n");

    return res.toString();
  }

  public void getMembers()
  {
    ArrayList<Player> Player = new ArrayList<>();
  }

  //Añadir jugadores
  public void add(Player p)
  {
    //si el jugador no esta en el equipo, se añadira
    if (!players.contains(p))
      players.add(p);
    p.add(this);
  }

  //Eliminar jugadores
  public void remove(Player p)
  {
    //si el equipo esta t, se eliminara
    if (!players.contains(p))
      players.remove(p);
    p.remove(this);
  }

  //comparar jugadores en los equipos
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
