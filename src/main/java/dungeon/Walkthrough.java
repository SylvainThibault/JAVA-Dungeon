package dungeon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Walkthrough {

    public int startMenu() {
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

    public String chooseTypeOfCharacter() {
        System.out.println("Choose your type of Character : 1. Warrior 2. Magician");
        Scanner sc = new Scanner(System.in);
        Byte step1Choice = sc.nextByte();
        switch (step1Choice) {
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
        return "";
    }

    public String chooseNameOfCharacter() {
        System.out.println("Enter the name of your Character : ");
        Scanner sc = new Scanner(System.in);
        String nameOfCharacter = sc.nextLine();
        System.out.println("Your Character is called : " + nameOfCharacter);
        return nameOfCharacter;
    }

    public Integer setRandomCharacterStrength() {
        Integer randomNum = ThreadLocalRandom.current().nextInt(0, 6);
        System.out.println("Your Character has the random strength of : " + randomNum + "\n");
        return randomNum;
    }

    public boolean addAnotherWeapon() {
        System.out.println("Do you want to add a weapon or spell ? (y/n)");
        Scanner sc = new Scanner(System.in);
        char answerWeapon = sc.nextLine().charAt(0);
        if (answerWeapon == 'y') {
            return true;
        }
        return false;
    }

    public String addShield() {
        System.out.println("Enter the name of your new Shield : ");
        Scanner sc = new Scanner(System.in);
        String nameOfShield = sc.nextLine();
        System.out.println("Your new Shield is : " + nameOfShield + "\n");

        return nameOfShield;
    }

    public boolean addAnotherShield() {
        System.out.println("Do you want to add a shield ? (y/n)");
        Scanner sc = new Scanner(System.in);
        char answerShield = sc.nextLine().charAt(0);
        if (answerShield == 'y') {
            return true;
        }
        return false;
    }

    public String addPhilter() {
        System.out.println("Enter the name of your new protection Philter : ");
        Scanner sc = new Scanner(System.in);
        String nameOfPhilter = sc.nextLine();
        System.out.println("Your new protection Philter is : " + nameOfPhilter + "\n");

        return nameOfPhilter;
    }

    public boolean addAnotherPhilter() {
        System.out.println("Do you want to add a Philter ? (y/n)");
        Scanner sc = new Scanner(System.in);
        char answerPhilter = sc.nextLine().charAt(0);
        return (answerPhilter == 'y');
    }

}
