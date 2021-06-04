package joc;
//puede aguantar mas daño
public class Warrior extends Player{
  public Warrior(String name, int attackPoints, int defensePoints, int life)
  {
    super(name, attackPoints, defensePoints, life);
    System.out.println("Creando Guerrero...");
  }

  public Warrior()
  {
    super();
    System.out.println("Creando Guerrero...");
  }

}
