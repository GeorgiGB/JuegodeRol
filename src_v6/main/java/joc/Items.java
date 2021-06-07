package joc;

import java.util.ArrayList;

public class Items
{
  //Atributos
  private String name;
  private int attackBonus;
  private int defenseBonus;

  private ArrayList<Items> items;
  private ArrayList<Player> players;


  //Constructor
  public Items(String name, int attackBonus, int defenseBonus)
  {
    this.name = name;
    this.attackBonus = attackBonus;
    this.defenseBonus = defenseBonus;
  }

  //Constructor vacio
  public Items(){
    this.name="No name";
    this.attackBonus = 0;
    this.defenseBonus = 0;

  }

  //Metodos


  @Override
  public String toString()
  {
    return "-" + name +" : "+
            ", BA=" + getAttackBonus()+
            ", BD=" + getDefenseBonus();
  }

  public ArrayList<Items> getItems()
  {
    return items;
  }

  public void setItems(ArrayList<Items> items)
  {
    this.items = items;
  }

  public ArrayList<Player> getPlayers()
  {
    return players;
  }

  public void setPlayers(ArrayList<Player> players)
  {
    this.players = players;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public int getAttackBonus()
  {
    return attackBonus;
  }

  public void setAttackBonus(int attackBonus)
  {
    this.attackBonus = attackBonus;
  }

  public int getDefenseBonus()
  {
    return defenseBonus;
  }

  public void setDefenseBonus(int defenseBonus)
  {
    this.defenseBonus = defenseBonus;
  }
}
