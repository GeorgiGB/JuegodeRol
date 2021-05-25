package joc;

import io.Utilidades;

public abstract class Player
{
  //Atributos
  private String name;
  private int attackPoints;
  private int defensePoints;
  private int life;

  //Constructor general
  public Player(String name, int attackPoints, int defensePoints, int life)
  {
    this.name = name;
    this.attackPoints = attackPoints;
    this.defensePoints = defensePoints;
    this.life = life;
  }

  //Constructor vacio
  public Player()
  {
    this.setName("No name");
    this.setAttackPoints(0);
    this.setDefensePoints(0);
    this.setLife(0);

  }

  //Metodos
  @Override
  public String toString()
  {
    return name + " PA " + attackPoints + " / " + " PD " + defensePoints + " PV " + life;
  }

  public String getName()
  {
    return name;
  }

  public int getAttackPoints()
  {
    return attackPoints;
  }

  public int getDefensePoints()
  {
    return defensePoints;
  }

  public int getLife()
  {
    return life;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setAttackPoints(int attackPoints)
  {
    this.attackPoints = attackPoints;
  }

  public void setDefensePoints(int defensePoints)
  {
    this.defensePoints = defensePoints;
  }

  public void setLife(int life)
  {
    this.life = life;
  }

  //Metodo atacar
  public void attack(Player p)
  {
    //Abans del attack
    System.out.println(" ");
    Utilidades.linia(25);

    //Atacante
    System.out.println("// Abans del attack");
    System.out.println("Atacant: "
            + this.getName()
            + " PA:"
            + this.attackPoints
            + " / "
            + " PD:" + this.defensePoints
            + " /"
            + " PV:" + this.life);

    //Atacado
    System.out.println("Atacat: "
            + p.getName()
            + " PA:"
            + p.attackPoints
            + " / "
            + " PD:" + p.defensePoints
            + " / "
            + " PV:" + p.life);
    System.out.println(" ");
    Utilidades.linia(25);

    //Atac
    System.out.println("// Atac:");
    p.hit(this.getAttackPoints());
    if (p.getLife() > 0)
    {
      this.hit(p.getAttackPoints());
    } else
    {
      System.out.println(p.getName() + " esta muerto: no puede atacar a " + this.getName());
    }

    //Despues del ataque:
    System.out.println("Despues del ataque:"
            + "\n" + "Atacante: "
            + this
            + ","
            + "\nAtacado:  " + p);
  }

  //Metodo golpear
  protected void hit(int attackPoints)
  {
    int bLife = getLife(); //basic life

    if (attackPoints > getDefensePoints()) //si los puntos de ataque son mayores que los de defensa se cumple y resta vida
      bLife = bLife - (this.attackPoints - getDefensePoints());
    if (bLife < 0)
    {//si la vida llega a 0 ponemos la vida a 0
      setLife(0);
      System.out.println("El jugador no le queda vida");
    }

    //informacion del ataque
    int info = attackPoints - getDefensePoints(); //informacion
    if (info < 0)
    {
      info = 0;//si la vida cae a 0 se lo indicamos
    }
    System.out.println(getName() + " es golpeado con " + attackPoints + " puntos y se defiende con " + getDefensePoints() + " .Vidas: " + bLife + " - " + info + " = " + getLife());
  }
}
