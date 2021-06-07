package joc;

import inici.ExcepAutoAtac;
import inici.ExcepJugDead;
import inici.ExcepRepTeam;
import io.Utilidades;

import java.util.ArrayList;

public abstract class Player
{
    //Atributos

    private String name;
    private int attackPoints;
    private int defensePoints;
    private int life;

    private ArrayList<Team> team;
    private ArrayList<Items> items;

    //Constructor general

    /**
     * @param name          Nombre del jugador
     * @param attackPoints  Numero de puntos de ataque al jugador
     * @param defensePoints Numero de puntos de defensa al jugador
     * @param life          Numero de puntos de vida del jugador
     */
    public Player(String name, int attackPoints, int defensePoints, int life)
    {
        this.name = name;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.life = life;
        setTeam(new ArrayList<>());
        setItems(new ArrayList<>());
    }

    //Constructor vacio
    public Player()
    {
        this.setName("No name");
        this.setAttackPoints(1);
        this.setDefensePoints(1);
        this.setLife(1);
        setTeam(new ArrayList<>());
        setItems(new ArrayList<>());
    }

    //Metodos

    /**
     * @return Devuelve los datos basicos del jugador
     */
    @Override
    public String toString()
    {
        String objetos = "";
        for (Items i : items)
        {
            objetos += "   " + i + "\n";
        }
        return name + " PA "
                + attackPoints + " / " + " PD "
                + defensePoints + " PV "
                + life
                + " y pertenece a "
                + getTeam().size()
                + " equipo/s"
                + " y tiene los items "
                + objetos;
    }

    /**
     * @param p metodo para el ataque del jugador
     */
    //Metodo atacar
    public void attack(Player p) throws ExcepJugDead, ExcepAutoAtac
    {
        /**
         * Comparar el jugador por si se ataca a si mismo
         */
        if (this.equals(p))
        {
            throw new ExcepAutoAtac("El player no puede atacarse a si mismo");
        }
        //Abans del attack
        Utilidades.liniaart(25);
        //Atacante
        System.out.println("// Abans del attack");
        System.out.println("Atacant: "
                + this.getName()
                + " PA:" + this.getAttackPoints() + " / "
                + " PD:" + this.getDefensePoints() + " /"
                + " PV:" + this.life + "(pertenece a +"
                + getTeam().size() + " equipo/s)");

        //Atacado
        System.out.println("Atacat: "
                + p.getName()
                + " PA:" + p.attackPoints + " / "
                + " PD:" + p.defensePoints + " / "
                + " PV:" + p.life);
        System.out.println(" ");
        Utilidades.linia(25);

        int Atack1j = this.getAttackPoints();
        int Atack2j = p.getAttackPoints();
        if (this.items.size() > 0)
        {
            for (Items i : this.items)
            {
                Atack1j += i.getAttackBonus();
            }
        }
        if (p.items.size() > 0)
        {
            for (Items i : p.items)
            {
                Atack2j += i.getAttackBonus();
            }
        }
        //Attack
        System.out.println("// Attack:");
        p.hit(this.getAttackPoints());
        if (p.getLife() > 0)
        {
            this.hit(p.getAttackPoints());
        } else
        {
            throw new ExcepJugDead(p.getName()
                    + " esta muerto: no puede atacar a "
                    + this.getName());
        }

        //Despues del ataque:
        System.out.println("Despues del ataque:"
                + "\n" + "Atacante: "
                + this
                + ","
                + "\nAtacado:  " + p);
    }

    /**
     * @param attackPoints el golpear a otro jugador
     */

    //Metodo golpear
    protected void hit(int attackPoints)
    {
        int bLife = getLife(); //basic life
        int defense = this.getDefensePoints();
        //para poder aplicarle el bonus con los "ITEMS"

        for (Items i : this.items)
        {
            defense += i.getDefenseBonus();
        }

        if (attackPoints > getDefensePoints())
            //si los puntos de ataque son mayores que los de defensa se cumple y resta vida
            bLife = bLife - (this.attackPoints - defense);
        if (bLife < 0)
        {//si la vida llega a 0 ponemos la vida a 0
            setLife(0);
            System.out.println("El jugador no le queda vida");
        }

        //informacion del ataque
        int info = attackPoints - defense; //informacion
        int infoFinal = bLife - info;
        if (infoFinal < 0)
        {
            infoFinal = 0;//si la vida cae a 0 se lo indicamos
        }
        System.out.println(getName()
                + " es golpeado con " + attackPoints
                + " puntos y se defiende con "
                + getDefensePoints() + " .Vidas: "
                + bLife + " - "
                + info + " = " + getLife());
    }

    //Metodos Team
    //Añadir al team

    /**
     * @param t permite añadir a un jugador a un equipo
     */
    public void addTeam(Team t) throws ExcepRepTeam
    {
        if (this.team.contains(t))
        {
            throw new ExcepRepTeam("No se pueden repetir jugadores");
        }
        //si el jugador no esta en el equipo, se añadira
        if (!team.contains(t))
        {
            this.getTeam().add(t);
            t.add(this);
        }
    }

    //Eliminar del team

    /**
     * @param t permite eliminar un jugador de un equipo
     */
    public void removeTeam(Team t)
    {
        //si en la lista de equipos el jugador existe, se borrara
        this.getTeam().remove(t);
        t.getPlayers().remove(this);
    }

    //comparar equipos de los jugadores

    /**
     * @param p comparar dos jugadores
     * @return devuelve true o false
     */
    public boolean equals(Player p)
    {
        return this.getName().equals(p.getName()) && this.getTeam().equals(p.getTeam());
    }

    //Metodos ITEMS
    //Metodo añadir ITEMS

    /**
     * @param i añadir objetos al jugador
     */
    public void addItems(Items i)
    {
        //comprobar si el jugador ya tiene un objeto de antes,
        // para que no sea necesario añadir "items" innecesarios
        //añadir items al jugador
        if (!this.items.contains(i))
            System.out.println("Añadiendo objeto...");
        items.add(i);
    }

    //Metodo remove ITEMS

    /**
     * @param i permite eliminar objetos del jugador
     */
    public void removeItems(Items i)
    {
        if (this.items.contains(i))
            System.out.println("Quitando objeto...");
        this.items.remove(i);
    }

    public ArrayList<Items> getItems()
    {
        return items;
    }

    public void setItems(ArrayList<Items> items)
    {
        this.items = items;
    }

    //Getters y Setters de Arraylists
    public ArrayList<Team> getTeam()
    {
        return team;
    }

    public void setTeam(ArrayList<Team> team)
    {
        this.team = team;
    }

    //Metodos Generales
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

}
