package inici;

import io.Utilidades;
import joc.*;
/*
1. Creación de personajes.
2. Creación de los equipos.
3. Asignar jugadores a los equipos.
4. Mostrar los equipos.
5. Quitar jugadores de los equipos.
6. Probar el metodo equals.
7. Añadir items y probarlos.
 */


public class JuegoDeRol
{
  public static void main(String[] args)
  {
    System.out.println("Juego de ROL");

    provaFase();

  }

  public static void provaFase()
  {

    //1. CREACION DE PERSONAJES
    Utilidades.liniaart(22);
    //crear humano
    Human john_smith = new Human("John Smith", 13, 8, 39);
    System.out.println("    Humano creado");

    Human georgi = new Human("Georgi", 9, 15, 110);
    System.out.println("    Humano creado");

    Human alfred = new Human("Alfred", 22, 18, 26);
    System.out.println("    Humano creado");

    //crear alien
    Utilidades.liniaart(22);
    Alien martian_pk = new Alien("Martian PK", 27, 2, 32);
    System.out.println("    Alien creado");

    Alien rubyx = new Alien("Rubyx", 15, 30, 18);
    System.out.println("    Alien creado");


    //Crear warrior
    Utilidades.liniaart(22);
    Warrior kratos = new Warrior("Kratos", 17, 5, 35);
    System.out.println("   Guerrero creado");

    Warrior angi = new Warrior("Àngels", 28, 16, 23);
    System.out.println("   Guerrero creado");

    //2.Creacion de Equipos
    Team stabilo = new Team("Stabilos");
    Team golosets = new Team("Els Golosets");

    //3.Añadir jugadores a los equipos
    //equipo 1
    stabilo.add(john_smith);
    stabilo.add(georgi);
    stabilo.add(alfred);
    //equipo 22
    golosets.add(martian_pk);
    golosets.add(rubyx);
    golosets.add(kratos);
    golosets.add(angi);

    Utilidades.liniaart(30);
    System.out.print("Asignando los personajes a sus equipos..."
            + stabilo + "\n"
            + golosets + "\n"
            + "Equipos."
    );

    //Equipo num1
    Utilidades.liniaart(30);
    System.out.println("El equipo "+ stabilo +" esta formado por: ");
    System.out.println(john_smith.getTeam());

    //Equipo num2
    Utilidades.liniaart(30);
    System.out.println("El equipo "+ golosets +" esta formado por: ");
    System.out.println(martian_pk.getTeam());

    //4. Quitar personajes de los equipos
    kratos.removeTeam(stabilo);
    System.out.println();
    Utilidades.liniaart(30);
    System.out.print("Quitar miembro/s del equipo"
            + stabilo + "\n");

    //5. Comprobar los metodos equals
    Utilidades.liniadoble(30);
    System.out.println("\nEs el jugador Kratos igual a Martian PK? " + kratos.equals(martian_pk));
    System.out.println("Es el jugador Kratos igual a si mismo? " + kratos.equals(kratos));
    System.out.println("\nEs el equip Perdedores igual al equipo de Ganadores? " + stabilo.equals(golosets));
    System.out.println("Es el equip Perdedores igual a si mismo? " + stabilo.equals(stabilo));

    //6. Comprobar el añadir Items
    Items espada = new Items("Espada", 5, 0);
    Items escudo = new Items("Escudo", -2, 7);

    //Añadir Items a los personajes y problarlos.
    martian_pk.addItems(espada);
    john_smith.addItems(escudo);

    //7.Ataques con objetos
    john_smith.attack(martian_pk);
    martian_pk.attack(john_smith);
    kratos.attack(john_smith);
  }
}
