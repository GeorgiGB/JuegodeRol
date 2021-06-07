package joc;

import io.Utilidades;

//puede aguantar mas daño
public class Warrior extends Human {
    //Constructores

    /**
     * @param name          nombre de la clase Guerrero
     * @param attackPoints  numero de puntos para el Guerrero
     * @param defensePoints numero de puntos de defensa para el Guerrero
     * @param life          puntos de vida para el Guerrero
     */
    public Warrior(String name, int attackPoints, int defensePoints, int life) {
        super(name, attackPoints, defensePoints, life);
        System.out.println("Creando Guerrero...");
    }

    //Constructor vacio
    public Warrior() {
        super();
        System.out.println("Creando Guerrero...");
    }

    /**
     * @param p Metodo override de Players con sus propios metodos
     */
    @Override
    public void attack(Player p) {
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

        //Atac
        System.out.println("// Atac:");
        p.hit(this.getAttackPoints());
        if (p.getLife() > 0) {
            this.hit(p.getAttackPoints());
        } else {
            System.out.println(p.getName() + " esta muerto: no puede atacar a " + this.getName());
        }

        if (p.getAttackPoints() < 5) {
            p.hit(0);
        }

        //Despues del ataque:
        System.out.println("Despues del ataque: "
                + "\n" + "Atacante: "
                + this
                + ","
                + "\nAtacado:  " + p);
    }

}
