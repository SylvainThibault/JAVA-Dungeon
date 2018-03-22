package dungeon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The type Walkthrough.
 */
public class Walkthrough {

    /**
     * Start menu int.
     *
     * @return the int
     */
    public int startMenu() {
        System.out.println("\n*********************************");
        System.out.println("What do you want to do ?");
        System.out.println("1. Create Character");
        System.out.println("2. Display Character(s)");
        System.out.println("3. Edit Character");
        System.out.println("4. Delete Character");
        System.out.println("5. Exit this awesome game");
        Scanner sc = new Scanner(System.in);
        Byte startChoice = sc.nextByte();
        switch (startChoice) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
        }
        return 0;
    }

    /**
     * Choose type of character string.
     *
     * @return the string
     */
    public String chooseTypeOfCharacter() {
        System.out.println("\nChoose your type of Character : 1. Warrior 2. Magician");
        Scanner sc = new Scanner(System.in);
        Integer typeOfCharacterChoice = sc.nextInt();
        if (typeOfCharacterChoice instanceof Integer) {
            switch (typeOfCharacterChoice) {
                case 1:
                    System.out.println("You chose : Warrior");
                    return "Warrior";
                case 2:
                    System.out.println("You chose : Magician");
                    return "Magician";
                default:
                    System.out.println("Wrong Choice.");
                    this.chooseTypeOfCharacter();
            }
        } else {
            System.out.println("Wrong Choice.");
            this.chooseTypeOfCharacter();
        }
        return "";
    }

    /**
     * Choose name of character string.
     *
     * @return the string
     */
    public String chooseNameOfCharacter() {
        System.out.println("\nEnter the name of your Character : ");
        Scanner sc = new Scanner(System.in);
        String nameOfCharacter = sc.nextLine();
        System.out.println("Your Character is called : " + nameOfCharacter);
        return nameOfCharacter;
    }

    /**
     * Sets random character strength.
     *
     * @return the random character strength
     */
    public Integer setRandomCharacterStrength() {
        Integer randomNum = ThreadLocalRandom.current().nextInt(0, 6);
        System.out.println("Your Character has the random strength of : " + randomNum);
        return randomNum;
    }

    /**
     * Add another weapon boolean.
     *
     * @return the boolean
     */
    public boolean addAnotherWeapon() {
        System.out.println("\nDo you want to add a weapon or spell ? (y/n)");
        Scanner sc = new Scanner(System.in);
        char answerWeapon = sc.nextLine().charAt(0);
        if (answerWeapon == 'y') {
            return true;
        }
        return false;
    }

    /**
     * Add shield string.
     *
     * @return the string
     */
    public String addShield() {
        System.out.println("\nEnter the name of your new Shield : ");
        Scanner sc = new Scanner(System.in);
        String nameOfShield = sc.nextLine();
        System.out.println("Your new Shield is : " + nameOfShield);

        return nameOfShield;
    }

    /**
     * Add another shield boolean.
     *
     * @return the boolean
     */
    public boolean addAnotherShield() {
        System.out.println("\nDo you want to add a shield ? (y/n)");
        Scanner sc = new Scanner(System.in);
        char answerShield = sc.nextLine().charAt(0);
        if (answerShield == 'y') {
            return true;
        }
        return false;
    }

    /**
     * Add philter string.
     *
     * @return the string
     */
    public String addPhilter() {
        System.out.println("\nEnter the name of your new protection Philter : ");
        Scanner sc = new Scanner(System.in);
        String nameOfPhilter = sc.nextLine();
        System.out.println("Your new protection Philter is : " + nameOfPhilter);

        return nameOfPhilter;
    }

    /**
     * Add another philter boolean.
     *
     * @return the boolean
     */
    public boolean addAnotherPhilter() {
        System.out.println("\nDo you want to add a Philter ? (y/n)");
        Scanner sc = new Scanner(System.in);
        char answerPhilter = sc.nextLine().charAt(0);
        return (answerPhilter == 'y');
    }

    /**
     * Edit menu int.
     *
     * @return the int
     */
    public int editMenu() {
        System.out.println("\nWhat do you want to edit ?");
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
