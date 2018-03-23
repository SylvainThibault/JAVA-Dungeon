package dungeon;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
        System.out.println("5. FIIIIIIIIIIIIIIGHT !!!");
        System.out.println("6. Exit this awesome game");
        Scanner sc = new Scanner(System.in);
        try {
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
                case 6:
                    return 6;
                default:
                    System.out.println("Please type a Number between 1 and 6, moron...");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please type a Number, moron...");
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
        try {
            Integer typeOfCharacterChoice = sc.nextInt();
            switch (typeOfCharacterChoice) {
                case 1:
                    System.out.println("You chose : Warrior");
                    return "Warrior";
                case 2:
                    System.out.println("You chose : Magician");
                    return "Magician";
                default:
                    System.out.println("Please type 1 or 2, moron...");
                    this.chooseTypeOfCharacter();
            }
        } catch (InputMismatchException e) {
            System.out.println("Please type 1 or 2, dick...");
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
        Integer randomNum = ThreadLocalRandom.current().nextInt(1, 10);
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
    public int editMenu(String characterName) {
        System.out.println("\nWhat do you want to do with this poor " + characterName + " bastard ?");
        System.out.println("1. Edit Name");
        System.out.println("2. Add Weapon / Spell");
        System.out.println("3. Remove Weapon / Spell");
        System.out.println("4. Add Shield / Philter");
        System.out.println("5. Exit this menu");
        Scanner sc = new Scanner(System.in);
        try {
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
                case 5:
                    return 5;
            }
        } catch (InputMismatchException e) {
            System.out.println("Please type a Number, jackass...");
        }
        return 0;
    }

    public int chooseCharacter(ArrayList Characters)
    throws CharacterIndexException {
        int characterChoice ;
        System.out.println("\nWhich character do you want to Edit / Delete ? (type the number of the character)");
        for (int i = 0; i < Characters.size(); i++) {
            Object characterItem = Characters.get(i);
            int indexOfCharacter = Characters.indexOf(characterItem);
            if (characterItem instanceof Character) {
                System.out.println(indexOfCharacter + ". " + ((Character) characterItem).getName());
            }
        }
        Scanner sc = new Scanner(System.in);
        try {
            characterChoice = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Mismatch");
            return this.chooseCharacter(Characters);
        }

        if (characterChoice > Characters.size()){
            throw new CharacterIndexException();
        } else {
            return characterChoice;
        }
    }
}
