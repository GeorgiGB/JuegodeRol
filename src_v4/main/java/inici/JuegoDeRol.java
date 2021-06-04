package inici;

import io.Utilidades;
import joc.*;

import java.util.ArrayList;

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

    Human georgi = new Human("Georgi", 9, 15, 110);
    System.out.println("    Humano creado");

    Human alfred = new Human("Alfred", 22, 18, 26);
    System.out.println("    Humano creado");

    //crear alien
    Utilidades.linia(22);
    Alien martian_pk = new Alien("Martian PK", 27, 2, 32);
    System.out.println("    Alien creado");
    Alien roger_jr = new Alien("Roger JR", 40, 2, 46);
    System.out.println("    Alien creado");
    Alien rubyx = new Alien("Rubyx", 15, 30, 18);
    System.out.println("    Alien creado");
    Utilidades.linia(22);

    //crear warrior
    Warrior kratos = new Warrior("Kratos", 17, 5, 35);
    System.out.println("   Guerrero creado");
    Warrior odin = new Warrior("Odin", 32, 13, 45);
    System.out.println("   Guerrero creado");
    Warrior zeus = new Warrior("Zeus", 28, 16, 23);
    System.out.println("   Guerrero creado");

    //Equipos
    Team Perdedores = new Team("Perdedores");

    //añadir jugadores a los equipos

    Perdedores.add(john_smith);
    Perdedores.add(georgi);
    Perdedores.add(alfred);


    john_smith.attack(martian_pk);
    martian_pk.attack(john_smith);
    kratos.attack(john_smith);

  }
}
