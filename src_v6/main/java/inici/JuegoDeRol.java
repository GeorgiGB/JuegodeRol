package inici;

import io.Utilidades;
import joc.*;

import java.util.ArrayList;

/***
 * @author Georgi Georgiev
 * @version 1.5
 */
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
    /**
     * @param args
     */
    public static void main(String[] args) throws ExcepJugDead, ExcepAutoAtac
    {
        //Arraylist para los jugadores, armas y equipos
        ArrayList<Items> items = new ArrayList<>();
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Team> teams = new ArrayList<>();

        int opc1,
                raza,//Alien, Guerrero y Humano
                atackP = 100,
                defP = 100,
                lifeP,
                pDefensa,
                pAtac;

        String nom, delPlayer //Seleccionar jugador
                , addP_T //Añadir un jugador a al equipo1
                , addP_T_2 //Añadir un jugador al equipo2
                , eleItem //Gestionar Items
                , ponerItem_P //Gestionar Items a los jugadores
                , nomEq //Poner nombre al equipo
                , delEq //Borrar el equipo
                , nomItem //Nombre del Item
                , delItem; //Eliminar el Item
        boolean continuar = true;
        do
        {
            //Menú joc de rol
            Utilidades.liniaart(30);
            System.out.println("|        Juego de ROL        |");
            Utilidades.liniaart(30);
            System.out.println("1. Configuración.            |");
            System.out.println("2. Jugar.                    |");
            System.out.println("3. Salir.                    |");
            Utilidades.liniaart(30);
            opc1 = Utilidades.leerEntero("Elige una opción: ");
            switch (opc1)
            {
                case 1 -> {
                    Utilidades.liniaart(40);
                    System.out.println("|        Configuración Principal        |");
                    Utilidades.liniaart(40);
                    System.out.println("1.1 Gestionar jugadores.                |");
                    System.out.println("1.2 Gestionar equipos.                  |");
                    System.out.println("1.3 Gestionar objectos.                 |");
                    System.out.println("1.4 Volver al menu                      |");
                    Utilidades.liniaart(25);
                    opc1 = Utilidades.leerEntero("Elige una opción: ");
                    switch (opc1)
                    {
                        case 1 -> {
                            Utilidades.menuJug();
                            System.out.println("1.1.1 Crear jugador.                       |");
                            System.out.println("1.1.2 Mostrar jugadores.                   |");
                            System.out.println("1.1.3 Eliminar jugadores.                  |");
                            System.out.println("1.1.4 Gestionar jugadores en los equipos.  |");
                            System.out.println("1.1.5 Añadir un objecto a un jugador.      |");
                            System.out.println("1.1.6 Volver al menu anterior.             |");
                            Utilidades.liniaart(35);
                            opc1 = Utilidades.leerEntero("Elige una opción: ");
                            switch (opc1)
                            {
                                case 1:
                                    Utilidades.liniadoble(25);
                                    System.out.println("1. Alien.     |");
                                    System.out.println("2. Guerrero.  |");
                                    System.out.println("3. Humano.    |");
                                    Utilidades.liniadoble(25);
                                    raza = Utilidades.leerEntero("Elige una raza: ");
                                    switch (raza)
                                    {
                                        //Alien
                                        case 1 -> {
                                            System.out.println("Has elegido la raza Alien!");
                                            nom = Utilidades.leerTexto("Nombre del alien: ");
                                            atackP = Utilidades.leerEntero("Los puntos de ataque tienen que ser entre 1 y 100: ");
                                            while (atackP < 1 || atackP > 100)
                                            {
                                                atackP = Utilidades.leerEntero("Por favor, introduzca los puntos de ataque: ");
                                            }
                                            defP = Utilidades.leerEntero("Los puntos de defensa tienen que ser hasta de 100: ");
                                            while (defP < 0 || defP > 100)
                                            {
                                                defP = Utilidades.leerEntero("Por favor, introduzca los puntos de de defensa: ");
                                            }
                                            lifeP = Utilidades.leerEntero("Los puntos de vida deben de ser entre 50 y 100: ");
                                            while (lifeP < 50 || lifeP > 100)
                                            {
                                                lifeP = Utilidades.leerEntero("Por favor, introduzca puntos de vida: ");
                                            }

                                            //Creacion del alien
                                            Alien alien = new Alien(nom, atackP, defP, lifeP);
                                            players.add(alien);
                                        }

                                        //Guerrero
                                        case 2 -> {
                                            System.out.println("Has elegido la raza Guerrero!");
                                            nom = Utilidades.leerTexto("Nombre del Guerrero: ");
                                            atackP = Utilidades.leerEntero("Los puntos de ataque deben de ser entre 1 y 100: ");
                                            while (atackP < 1 || atackP > 100)
                                            {
                                                atackP = Utilidades.leerEntero("Por favor, introduzca los puntos de ataque correctamente: ");
                                            }
                                            defP = Utilidades.leerEntero("Los puntos de defensa, deben de ser hasta 100: ");
                                            while (defP < 0 || defP > atackP - 1)
                                            {
                                                defP = Utilidades.leerEntero("Por favor, introduzca los puntos de defensa correctamente: ");
                                            }
                                            lifeP = Utilidades.leerEntero("Los puntos de vida deben de ser entre 50 y 100: ");
                                            while (lifeP < 50 || lifeP > 100)
                                            {
                                                lifeP = Utilidades.leerEntero("Por favor, introduzca los puntos de vida correctamente: ");
                                            }
                                            //Guerrero creado y añadido a la lista de players
                                            Warrior warrior = new Warrior(nom, atackP, defP, lifeP);
                                            players.add(warrior);
                                        }

                                        //Humano
                                        case 3 -> {
                                            System.out.println("Has elegido la raza Humano!");
                                            nom = Utilidades.leerTexto("Nombre del humano: ");
                                            atackP = Utilidades.leerEntero("Los puntos de ataque deben de ser entre 1 y 100: ");
                                            while (atackP < 1 || atackP > 100)
                                            {
                                                atackP = Utilidades.leerEntero("Por favor, introduzca los puntos de ataque correctamente: ");
                                            }
                                            defP = Utilidades.leerEntero("Los puntos de defensa tienen que ser entre 1 y 100: ");
                                            while (defP < 0 || defP > atackP - 1)
                                            {
                                                defP = Utilidades.leerEntero("Por favor, introduzca los puntos de defensa correctamente: ");
                                            }
                                            lifeP = Utilidades.leerEntero("Los puntos de vida, tienen que ser entre 50 y 100: ");
                                            while (lifeP < 50 || lifeP > 100)
                                            {
                                                lifeP = Utilidades.leerEntero("Un humano no puede tener mas de 100 puntos de vida, por favor introduzca los puntos de nuevo");
                                            }
                                            //Humano creado y añadido a la lista de players
                                            Human human = new Human(nom, atackP, defP, lifeP);
                                            players.add(human);
                                        }
                                        default -> {
                                            Utilidades.liniaart(25);
                                            System.out.println("Opción incorrecta");
                                        }
                                    }
                                    break;

                                case 2:
                                    System.out.println("Has elegido enseñar a los jugadores");
                                    //Recorremos el array de jugadores para poder enseñar la informacion de los jugadores
                                    for (Player player : players)
                                    {
                                        System.out.println(player.toString());
                                    }
                                    break;

                                case 3:
                                    //En el caso de que el array de jugadores no este vacio
                                    if (!players.isEmpty())
                                    {
                                        Utilidades.menuJug();
                                        //lista de players
                                        for (Player player : players)
                                        {
                                            System.out.println(player.toString());
                                        }
                                        Utilidades.liniaart(30);
                                        //Elegir un jugador para borrarlo
                                        delPlayer = Utilidades.leerTexto("Que jugador quieres borrar? ");
                                        for (int i = 0; i < players.size(); i++)//recorrer la lista de players para eliminar el jugador seleccionado
                                        {
                                            if (players.get(i).getName().equalsIgnoreCase(delPlayer))
                                            {
                                                Player jugEle = players.get(i);
                                                players.remove(jugEle);
                                            }
                                        }
                                    } else
                                    {
                                        System.out.println("No hay ningún jugador seleccionado.");
                                    }
                                case 4:
                                    if (!players.isEmpty() && !teams.isEmpty())
                                    {
                                        //Llistem els jugadors
                                        Utilidades.menuJug();
                                        for (Player player : players)
                                        {
                                            System.out.println(player);
                                        }
                                        Utilidades.liniaart(15);
                                        addP_T = Utilidades.leerTexto("A que jugador quieres asignar a un equipo?");
                                        for (int i = 0; i < players.size(); i++)
                                        {
                                            if (players.get(i).getName().equalsIgnoreCase(addP_T))
                                            {
                                                Player jugEle = players.get(i);
                                                //Listar equipos
                                                Utilidades.menuEq();
                                                for (Team team : teams)
                                                {
                                                    System.out.println(team);
                                                }
                                                System.out.println();
                                                addP_T_2 = Utilidades.leerTexto("A que equipo se lo quieres añadir?");
                                                for (int j = 0; j < teams.size(); j++)
                                                {
                                                    if (teams.get(i).getName().equalsIgnoreCase(addP_T_2))
                                                    {
                                                        teams.get(i).getPlayers().add(jugEle);
                                                    }
                                                }
                                            }
                                        }
                                        System.out.println();
                                    } else
                                    {//si se selecciona algo que no existe
                                        System.out.println("Es necesario que exista al menos un jugador y un equipo");
                                    }
                                    break;

                                case 5:
                                    for (int i = 0; i < items.size(); i++)
                                    {
                                        if (!items.isEmpty())
                                        {
                                            Utilidades.menuObj();
                                            for (Items item : items)
                                            {
                                                System.out.println(item);
                                            }
                                            Utilidades.liniaart(25);
                                            eleItem = Utilidades.leerTexto("Dime el nombre del objeto que quieres seleccionar");
                                            for (int j = 0; j < items.size(); j++)
                                            {
                                                if (items.get(i).getName().equalsIgnoreCase(eleItem))
                                                {
                                                    if (!players.isEmpty())
                                                    {
                                                        Utilidades.menuJug();
                                                        for (Player value : players)
                                                        {
                                                            System.out.println(value);
                                                        }
                                                        Utilidades.liniaart(25);
                                                        ponerItem_P = Utilidades.leerTexto("¿A que jugador quieres ponerle el objeto?");
                                                        for (Player player : players)
                                                        {
                                                            if (player.getName().equalsIgnoreCase(ponerItem_P))
                                                            {
                                                                //
                                                            }
                                                        }
                                                    } else
                                                    {//comprobador
                                                        System.out.println("Para poder añadirle un objeto a un jugador, primero tiene que estar creado");
                                                    }
                                                } else
                                                {
                                                    System.out.println("Objeto incorrecto/inexistente");
                                                }
                                            }
                                        } else
                                        {
                                            System.out.println("No hay ningun objeto, tiene que crearlo primero");
                                        }
                                    }
                                    break;

                                case 6:
                                    Utilidades.liniaart(25);
                                    System.out.println("Fin del programa.");
                                    break;

                                default:
                                    Utilidades.liniaart(25);
                                    System.out.println("Opción incorrecta.");
                            }
                        }
                        case 2 -> {
                            Utilidades.menuEq();
                            System.out.println("1.2.1 Crear un equipo.                    |");
                            System.out.println("1.2.2 Mostrar equipos.                    |");
                            System.out.println("1.2.3 Borrar un equipo.                   |");
                            System.out.println("1.2.4 Seleccionar un equipo a un jugador. |");
                            System.out.println("1.2.5 Salir                               |");
                            Utilidades.liniaart(40);
                            opc1 = Utilidades.leerEntero("Elige una opción: ");
                            switch (opc1)
                            {
                                case 1:
                                    nomEq = Utilidades.leerTexto("Dime el nombre del equipo: ");
                                    Team equip = new Team(nomEq);
                                    teams.add(equip);
                                    System.out.println("Creado correctamente.");
                                    break;
                                case 2:
                                    if (!teams.isEmpty())
                                    {
                                        Utilidades.menuEq();
                                        for (Team team : teams)
                                        {
                                            System.out.println(team);
                                        }
                                        Utilidades.liniaart(30);
                                    } else
                                    {
                                        Utilidades.liniaart(30);
                                        System.out.println("No existe ese equipo");
                                        Utilidades.liniaart(30);
                                    }
                                    break;
                                case 3:
                                    if (!teams.isEmpty())
                                    {
                                        Utilidades.menuEq();
                                        for (Team team : teams)
                                        {
                                            System.out.println(team);
                                        }
                                        Utilidades.liniaart(30);

                                        delEq = Utilidades.leerTexto("Dime el nombre del equipo que quieres borrar: ");
                                        //recorrer arraylist de teams
                                        for (Team team : teams)
                                        {
                                            if (team.getName().equalsIgnoreCase(delEq))
                                            {
                                                Team selEq = team;
                                                players.remove(delEq);//ELIMINAR EQUIPO
                                            } else
                                            {
                                                System.out.println("Nombre incorrecto/inexistente");//SI EL EQUIPO NO EXISTE
                                                Utilidades.linia(30);
                                            }
                                        }
                                    } else
                                    {
                                        Utilidades.liniaart(30);
                                        System.out.println("Antes de borrar un equipo que no existe, al menos crealo");
                                        Utilidades.liniaart(30);
                                    }
                                    break;
                                case 4:
                                    if (!players.isEmpty() && !teams.isEmpty())
                                    {
                                        //Listamos a los players
                                        Utilidades.menuJug();
                                        for (int i = 0; i < players.size(); i++)
                                        {
                                            System.out.println(players.get(i));
                                        }
                                        Utilidades.liniaart(30);
                                        addP_T = Utilidades.leerTexto("Dime a que jugador lo quieres añadir a un equipo: ");
                                        for (int i = 0; i < players.size(); i++)
                                        {
                                            if (players.get(i).getName().equalsIgnoreCase(addP_T))
                                            {
                                                Player jugEle = players.get(i);
                                                //Llistem els equips
                                                Utilidades.menuJug();
                                                for (int j = 0; j < teams.size(); j++)
                                                {
                                                    System.out.println(teams.get(j));
                                                }
                                                Utilidades.linia(30);
                                                addP_T_2 = Utilidades.leerTexto("Elige un equipo para añadirlo: ");
                                                for (int j = 0; j < teams.size(); j++)
                                                {
                                                    if (teams.get(i).getName().equalsIgnoreCase(addP_T_2))
                                                    {
                                                        teams.get(i).getPlayers().add(jugEle);
                                                    } else
                                                    {
                                                        System.out.println("Nombre incorrecto/inexistente");
                                                    }
                                                }
                                            }
                                        }
                                        System.out.println();
                                    } else
                                    {
                                        Utilidades.liniaart(30);
                                        System.out.println("Es necesario que al menos exista un jugador y un equipo");
                                        Utilidades.liniaart(30);
                                    }
                                    break;
                                case 5:
                                    System.out.println("Fin del programa.");
                                    break;
                                default:
                                    System.out.println("Opción incorrecta, elija una opción entre las indicadas");
                            }
                        }
                        case 3 -> {
                            Utilidades.menuObj();
                            System.out.println("1.3.1 Crear un objecto.             |");
                            System.out.println("1.3.2 Mostrar los objetos.          |");
                            System.out.println("1.3.3 Borrar objetos.               |");
                            System.out.println("1.3.4 Añadir un objeto a un jugador.|");
                            System.out.println("1.3.5 Volver.                       |");
                            Utilidades.liniaart(30);
                            opc1 = Utilidades.leerEntero("Elige una opción: ");
                            switch (opc1)
                            {
                                case 1:
                                    nomItem = Utilidades.leerTexto("|__Nombre del objeto: |");
                                    pAtac = Utilidades.leerEntero("|__Puntos de ataque extra: |");
                                    pDefensa = Utilidades.leerEntero("|__Puntos de defensa extra: |");
                                    Items objecte = new Items(nomItem, pAtac, pDefensa);
                                    items.add(objecte);
                                    break;
                                case 2:
                                    if (!items.isEmpty())
                                    {
                                        Utilidades.menuObj();
                                        for (Items item : items)
                                        {
                                            System.out.println(item);
                                        }
                                        Utilidades.linia(30);
                                    } else
                                    {
                                        System.out.println("No existe el objeto");
                                    }
                                    break;
                                case 3:
                                    if (!items.isEmpty())
                                    {
                                        Utilidades.menuObj();
                                        for (int j = 0; j < items.size(); j++)
                                        {
                                            System.out.println(items.get(j));
                                        }
                                        Utilidades.linia(35);
                                        delItem = Utilidades.leerTexto("Nombre del objeto que quieras borrar/eliminar: ");
                                        for (int i = 0; i < items.size(); i++)
                                        {
                                            if (items.get(i).getName().equalsIgnoreCase(delItem))
                                            {
                                                Items eleObj = items.get(i);
                                                items.remove(eleObj);
                                            } else
                                            {
                                                Utilidades.liniaart(35);
                                                System.out.println("Nombre incorrecto/inexistente");
                                                Utilidades.liniaart(35);
                                            }
                                        }
                                    } else
                                    {
                                        System.out.println("Almenos si vas a borrar un objeto, primero crealo");
                                    }
                                    break;
                                case 4:
                                    if (!players.isEmpty())
                                    {
                                        if (!items.isEmpty())
                                        {
                                            Utilidades.menuObj();
                                            for (int i = 0; i < items.size(); i++)
                                            {
                                                System.out.println(items.get(i));
                                            }
                                            Utilidades.linia(45);
                                            nomItem = Utilidades.leerTexto("Dime el nombre del objeto al que se lo quieres añadir al jugador ");
                                            for (int i = 0; i < items.size(); i++)
                                            {
                                                if (items.get(i).getName().equalsIgnoreCase(nomItem))
                                                {
                                                    Items itemEle = items.get(i);
                                                    Utilidades.menuJug();
                                                    for (int j = 0; j < players.size(); j++)
                                                    {
                                                        System.out.println(players.get(j));
                                                    }
                                                    Utilidades.linia(45);
                                                    nom = Utilidades.leerTexto("Nombre del jugador: ");
                                                    for (int j = 0; j < players.size(); j++)
                                                    {
                                                        if (players.get(i).getName().equalsIgnoreCase(nom))
                                                        {
                                                        } else
                                                        {
                                                            System.out.println("Nombre incorrecto/inexistente, linea 514");
                                                        }
                                                    }
                                                }
                                            }
                                        } else
                                        {
                                            System.out.println("Primero deberias de crear el objeto/item");
                                        }
                                    } else
                                    {
                                        System.out.println("Primero deberias de crear un jugador.");
                                    }
                                    break;
                                case 5:
                                    System.out.println("Fin del programa.");
                                    break;
                                default:
                                    System.out.println("Opción incorrecta");
                            }
                        }
                        default -> System.out.println("Opción incorrecta");
                    }
                }
                case 2 -> {
                    //Menu Jugar

                    Utilidades.menuJugar();
                    do
                    {
                        for (Player player : players)
                        {
                            if (player.getLife() != 0)
                                player.attack(players.get((int) (Math.random() * players.size() - 1)));
                        }
                        // Comprobar final de partida para declarar al vencedor
                        int cont = 0;
                        for (Player jug2 : players)
                        {
                            if (jug2.getLife() == 0)
                                cont++;
                        }
                        if (cont == players.size() || cont == players.size() - 1)
                        {
                            Utilidades.linia(35);
                            System.out.println("Solo ha sobrevivido uno y es... ");
                            Utilidades.linia(35);
                            for (Player jug : players)
                            {
                                if (jug.getLife() != 0)
                                    System.out.println("¡¡¡" + jug + "!!!");
                                System.out.println("Enhorabuena");
                            }
                            continuar = false;
                        }
                        break;
                    } while (continuar);
                }
                case 3 -> {
                    System.out.println("Has elegido salir del programa...");
                    System.out.println("Adios!");
                    continuar = false;
                }
                default -> System.out.println("Opción incorrecta");
            }
        } while (opc1 != 3);

    }
/*
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
    System.out.println("El equipo " + stabilo + " esta formado por: ");
    System.out.println(john_smith.getTeam());

    //Equipo num2
    Utilidades.liniaart(30);
    System.out.println("El equipo " + golosets + " esta formado por: ");
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
 */
}
