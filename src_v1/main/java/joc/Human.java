package joc;
//no tiene bonificaciones de defensa o ataque
public class Human extends Player{
  public Human(String name, int attackPoints, int defensePoints, int life)
  {
    super(name, attackPoints, defensePoints, life);
    System.out.println("Creando humano...");
  }

  public Human()
  {
    super();
    System.out.println("Creando humano...");
  }


}
