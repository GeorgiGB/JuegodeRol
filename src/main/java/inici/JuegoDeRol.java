package inici;

import io.Utilidades;
import joc.Alien;
import joc.Human;
import joc.Warrior;

public class JuegoDeRol {
  public static void main(String[] args) {
    provaFase();
  }

  public static void provaFase() {
    Utilidades.linia(22);
    //crear humano
    Human madMax = new Human();
    System.out.println("    Humano creado");
    Utilidades.linia(22);

    //crear warrior
    Warrior kratos = new Warrior();
    System.out.println("   Guerrero creado");

    //crear alien
    Utilidades.linia(22);
    Alien roger = new Alien();
    System.out.println("    Alien creado");
    Utilidades.linia(22);
  }
}
