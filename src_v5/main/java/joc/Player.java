package joc;

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
  @Override
  public String toString()
  {
    return name + " PA "
            + attackPoints + " / " + " PD "
            + defensePoints + " PV "
            + life
            + " y pertenece a " + getTeam().size() + "equipo/s";
  }

  //Metodo atacar
  public void attack(Player p)
  {
    //Abans del attack
    Utilidades.liniaart(25);

    //Atacante
    System.out.println("// Abans del attack");
    System.out.println("Atacant: "
            + this.getName()
            + " PA:"
            + this.getAttackPoints()
            + " / "
            + " PD:" + this.getDefensePoints()
            + " /"
            + " PV:" + this.life + "(pertenece a +" + getTeam() + " equipo/s)");

    //Atacado
    System.out.println("Atacat: "
            + p.getName()
            + " PA:" + p.attackPoints
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
    int defense = this.getDefensePoints();
    //para poder aplicarle el bonus con los "ITEMS"

    for(Items i: this.items){
      defense+=i.getDefenseBonus();
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
    int info = attackPoints - getDefensePoints(); //informacion
    if (info < 0)
    {
      info = 0;//si la vida cae a 0 se lo indicamos
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
  public void addTeam(Team t)
  {
    //si el jugador no esta en el equipo, se añadira
    this.getTeam().add(t);
    t.getPlayers().add(this);
  }

  //Eliminar del team
  public void removeTeam(Team t)
  {
    //si en la lista de equipos el jugador existe, se borrara
    this.getTeam().remove(t);
    t.getPlayers().remove(this);
  }

  //comparar equipos de los jugadores
  public boolean equals(Player p)
  {
    return this.getName().equals(p.getName()) && this.getTeam().equals(p.getTeam());
  }

  //Metodos ITEMS
  //Metodo añadir ITEMS
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
