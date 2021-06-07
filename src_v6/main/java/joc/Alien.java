package joc;

import inici.ExcepAutoAtac;
import inici.ExcepJugDead;
import io.Utilidades;

//Tiene bonificaciones en cada ataque pero tiene penalizacion en defensa
public class Alien extends Player
{
  //Constructores

  /**
   * heredaciones de la clase "Player"
   * @param name del alien
   * @param attackPoints puntos de ataque del alien
   * @param defensePoints puntos de defensa del alien
   * @param life puntos de vida del alien
   */
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

  /**
   *
   * @param p metodo que se repite en player pero con excepciones del alien
   */
  @Override
  public void attack(Player p) throws ExcepJugDead, ExcepAutoAtac
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
            + this.getAttackPoints()
            + " / "
            + " PD:" + this.getDefensePoints()
            + " /"
            + " PV:" + this.getLife());

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
            + p.getAttackPoints()
            + " / "
            + " PD:" + p.getDefensePoints()
            + " / "
            + " PV:" + p.getLife());
    System.out.println(" ");
    Utilidades.linia(25);

    //Atack
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
