package joc;

import io.Utilidades;

//Tiene bonificaciones en cada ataque pero tiene penalizacion en defensa
public class Alien extends Player
{
  //Constructores
  public Alien(String name, int attackPoints, int defensePoints, int life)
  {
    super(name, attackPoints, defensePoints, life);
    System.out.println("Creando alien...");
  }

  //Constructor vacio
  public Alien()
  {
    super();
    System.out.println("Creando alien...");
  }

  //Metodos

  @Override
  public void attack(Player p)
  {
    //Abans del attack
    System.out.println(" ");
    Utilidades.linia(25);

    //Atacante
    System.out.println("// Abans del attack");
    // Atac del Alien
    System.out.println("Atacant: "
            + this.getName()
            + " PA:"
            + this.attackPoints
            + " / "
            + " PD:" + this.defensePoints
            + " /"
            + " PV:" + this.life);

    //Enloquecer del Alien
    if (this.getLife() > 20)
    {
      this.setAttackPoints(this.getAttackPoints() + 3);//subida de ataque
      this.setDefensePoints(this.getAttackPoints() - 3);//bajada de defensa
    }
    //se mantienen las caracteristicas

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


}
