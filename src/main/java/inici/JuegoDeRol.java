package inici;

import io.Utilidades;
import joc.Alien;
import joc.Human;
import joc.Warrior;

public class JuegoDeRol
{
  public static void main(String[] args)
  {
    provaFase();

  }

  public static void provaFase()
  {
    Utilidades.linia(22);
    //crear humano
    Human john_smith = new Human("John Smith", 13, 8, 39);
    System.out.println("    Humano creado");

    //crear alien
    Utilidades.linia(22);
    Alien martian_pk = new Alien("Martian PK", 27, 2, 32);
    System.out.println("    Alien creado");
    Utilidades.linia(22);

    //crear warrior
    Warrior kratos = new Warrior("Kratos", 17, 5, 35);
    System.out.println("   Guerrero creado");

    john_smith.attack(martian_pk);
    martian_pk.attack(john_smith);
    kratos.attack(john_smith);

  }
}
