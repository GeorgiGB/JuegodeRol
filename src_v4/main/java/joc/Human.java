package joc;

import java.util.ArrayList;

//no tiene bonificaciones de defensa o ataque
public class Human extends Player
{
  //Constructores
  public Human(String name, int attackPoints, int defensePoints, int life)
  {
    super(name, attackPoints, defensePoints, life);
    if (this.getLife() > 100)
    {
      this.setLife(100);
    }
    System.out.println("Creando humano...");
  }



  //constructor vacio
  public Human()
  {
    super();
    if (this.getLife() > 100)
    {
      this.setLife(100);
    }
    System.out.println("Creando humano...");
  }

}
