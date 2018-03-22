package dungeon;

import java.util.Scanner;

/**
 * The type Character.
 */
public abstract class Character {

    /**
     * Declaration des variables
     */
    private String name;
    //private String image;
    private Integer life;
    private Integer strength;


    /**
     * Declaration des getters et setters
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }

    /**
     * Gets life.
     *
     * @return the life
     */
    public Integer getLife() {
        return life;
    }

    /**
     * Sets life.
     */
    public void setLife() {
        this.life = 100;
    }

    /**
     * Sets life.
     *
     * @param life the life
     */
    public void setLife(int life) {
        this.life = life;
    }

    /**
     * Gets strength.
     *
     * @return the strength
     */
    public Integer getStrength() {
        return strength;
    }

    /**
     * Sets strength.
     *
     * @param strength the strength
     */
    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    /**
     * Fonctions du Character
     */
    public void displayCharacter() {
        System.out.println(this.toString());
    }

    public String toString() {
        return
                "\n***** " + this.getName() + " *****" +
                        "\nYour character's name is : " + this.getName() +
                        "\nYour character's life is : " + this.getLife() +
                        "\nYour character's strength is : " + this.getStrength();
    }


    /**
     * Edit character.
     */
    public void editCharacter() {
        Walkthrough editMenu = new Walkthrough();
        int stuffToEdit = editMenu.editMenu();

        do {
            switch (stuffToEdit) {
                case 0:
                    stuffToEdit = editMenu.editMenu();
                    break;
                case 1:
                    System.out.println("\nEnter a new Name :");
                    Scanner sc = new Scanner(System.in);
                    String newName = sc.nextLine();
                    this.setName(newName);
                    System.out.println("Your character's new Name is : " + newName + "\n");
                    stuffToEdit = 0;
                    break;
                case 2:
                    System.out.println("\nSet a new Life :");
                    Scanner sc2 = new Scanner(System.in);
                    int newLife = sc2.nextInt();
                    this.setLife(newLife);
                    System.out.println("Your character's new Life is set to : " + newLife + "\n");
                    stuffToEdit = 0;
                    break;
                case 3:
                    System.out.println("\nSet a new Strength :");
                    Scanner sc3 = new Scanner(System.in);
                    int newStrength = sc3.nextInt();
                    this.setStrength(newStrength);
                    System.out.println("Your character's new Strength is set to : " + newStrength + "\n");
                    stuffToEdit = 0;
                    break;
            }
        } while (stuffToEdit != 4);
    }

}
