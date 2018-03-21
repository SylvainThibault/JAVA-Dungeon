package dungeon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Character> Characters = new ArrayList<>();

        Walkthrough newGame = new Walkthrough();
        int startMenuChoice = 0;


        do {
            switch (startMenuChoice) {
                case 0:
                    startMenuChoice = newGame.startMenu();
                    break;
                case 1:
                    String newCharacterType = newGame.chooseTypeOfCharacter();
                    String newCharacterName = newGame.chooseNameOfCharacter();
                    Integer newCharacterStrength = newGame.setRandomCharacterStrength();

                    switch (newCharacterType) {
                        case "Warrior":
                            Warrior newWarrior = new Warrior(newCharacterName, newCharacterStrength);
                            HashMap newWarriorWeapon = newGame.chooseNameOfWeapon();
                            newWarrior.setWeapons(newWarriorWeapon);
                            String newWarriorShield = newGame.addShield();
                            newWarrior.setShield(newWarriorShield);
                            while (newGame.addAnotherShield()) {
                                if (newWarrior.getShieldCount() < 3) {
                                    newWarriorShield = newGame.addShield();
                                    newWarrior.setShield(newWarriorShield);
                                } else {
                                    System.out.println("Yo baggo'shields is full, yo! \n");
                                    break;
                                }
                            }
                            Characters.add(newWarrior);
                            break;
                        case "Magician":
                            Magician newMagician = new Magician(newCharacterName, newCharacterStrength);
                            HashMap newMagicianSpell = newGame.chooseNameOfWeapon();
                            newMagician.setSpells(newMagicianSpell);
                            String newMagicianPhilter = newGame.addPhilter();
                            newMagician.setPhilter(newMagicianPhilter);
                            while (newGame.addAnotherPhilter()) {
                                if (newMagician.getPhilterCount() < 3) {
                                    newMagicianPhilter = newGame.addPhilter();
                                    newMagician.setPhilter(newMagicianPhilter);
                                } else {
                                    System.out.println("Yo baggo'Philters is full, yo! \n");
                                    break;
                                }
                            }
                            Characters.add(newMagician);
                            break;
                    }
                    startMenuChoice = 0;
                    break;

                case 2:
                    if (!Characters.isEmpty()) {
                        for (Character Character : Characters) {
                            Character.displayCharacter();
                        }
                    } else {
                        System.out.println("There is no Character to display \n");
                        startMenuChoice = 0;
                        break;
                    }
                    startMenuChoice = 0;
                    break;

                case 3:
                    Character CharacterToEdit = null;
                    if (!Characters.isEmpty()) {
                        System.out.println("Which character do you want to edit ?");
                        for (int i = 0; i < Characters.size(); i++) {
                            System.out.println(Characters.get(i).getName());
                        }
                        System.out.println("Type in the Name of the Character you want to edit :");
                        Scanner sc = new Scanner(System.in);
                        String characterToEdit = sc.nextLine();
                        for (int i = 0; i < Characters.size(); i++) {
                            if (characterToEdit.equals(Characters.get(i).getName())) {
                                CharacterToEdit = Characters.get(i);
                            }
                        }
                        if (CharacterToEdit != null) {
                            CharacterToEdit.editCharacter();
                        }
                    } else {
                        System.out.println("There is no Character to edit \n");
                        startMenuChoice = 0;
                        break;
                    }
                    startMenuChoice = 0;
                    break;
            }
        } while (startMenuChoice != 4);
    }
}
