package dungeon;

import java.util.Scanner;

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
     */

    public String getName() {
        return name;
    }

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

    public Integer getLife() {
        return life;
    }

    public void setLife() {
        this.life = 100;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public Integer getStrength() {
        return strength;
    }

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

    public void editCharacter() {
        int stuffToEdit = this.editMenu();
        do {
            switch (stuffToEdit) {
                case 0:
                    stuffToEdit = this.editMenu();
                    break;
                case 1:
                    System.out.println("Enter a new Name :");
                    Scanner sc = new Scanner(System.in);
                    String newName = sc.nextLine();
                    this.setName(newName);
                    System.out.println("Your character's new Name is : " + newName + "\n");
                    stuffToEdit = 0 ;
                    break;
                case 2:
                    System.out.println("Set a new Life :");
                    Scanner sc2 = new Scanner(System.in);
                    int newLife = sc2.nextInt();
                    this.setLife(newLife);
                    System.out.println("Your character's new Life is set to : " + newLife + "\n");
                    stuffToEdit = 0 ;
                    break;
                case 3:
                    System.out.println("Set a new Strength :");
                    Scanner sc3 = new Scanner(System.in);
                    int newStrength = sc3.nextInt();
                    this.setStrength(newStrength);
                    System.out.println("Your character's new Strength is set to : " + newStrength + "\n");
                    stuffToEdit = 0 ;
                    break;
            }
        } while (stuffToEdit != 4);
    }

    private int editMenu() {
        System.out.println("What do you want to edit ?");
        System.out.println("1. Edit Name");
        System.out.println("2. Edit Life");
        System.out.println("3. Edit strength");
        System.out.println("4. Exit");
        Scanner sc = new Scanner(System.in);
        Byte editChoice = sc.nextByte();
        switch (editChoice) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
        }
        return 0;
    }
}
