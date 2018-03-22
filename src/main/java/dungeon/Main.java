package dungeon;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        ArrayList<Character> Characters = new ArrayList<>();

        Walkthrough newGame = new Walkthrough();
        int startMenuChoice = 0;


        do {
            switch (startMenuChoice) {
                case 0:
                    startMenuChoice = newGame.startMenu();
                    break;
                case 1: // Create Character
                    String newCharacterType = newGame.chooseTypeOfCharacter();
                    String newCharacterName = newGame.chooseNameOfCharacter();
                    Integer newCharacterStrength = newGame.setRandomCharacterStrength();

                    switch (newCharacterType) {
                        case "Warrior":
                            Warrior newWarrior = new Warrior(newCharacterName, newCharacterStrength);
                            newWarrior.addWeapon();
                            while (newGame.addAnotherWeapon()) {
                                newWarrior.addWeapon();
                            }
                            String newWarriorShield = newGame.addShield();
                            newWarrior.setShield(newWarriorShield);
                            while (newGame.addAnotherShield()) {
                                if (newWarrior.getShieldCount() < 3) {
                                    newWarriorShield = newGame.addShield();
                                    newWarrior.setShield(newWarriorShield);
                                } else {
                                    System.out.println("Yo baggo'shields is full, yo!");
                                    break;
                                }
                            }
                            Characters.add(newWarrior);
                            break;
                        case "Magician":
                            Magician newMagician = new Magician(newCharacterName, newCharacterStrength);
                            newMagician.addSpell();
                            while (newGame.addAnotherWeapon()) {
                                newMagician.addSpell();
                            }
                            String newMagicianPhilter = newGame.addPhilter();
                            newMagician.setPhilter(newMagicianPhilter);
                            while (newGame.addAnotherPhilter()) {
                                if (newMagician.getPhilterCount() < 3) {
                                    newMagicianPhilter = newGame.addPhilter();
                                    newMagician.setPhilter(newMagicianPhilter);
                                } else {
                                    System.out.println("Yo baggo'Philters is full, yo!");
                                    break;
                                }
                            }
                            Characters.add(newMagician);
                            break;
                    }
                    startMenuChoice = 0;
                    break;

                case 2: // Display Character
                    if (!Characters.isEmpty()) {
                        for (Character Character : Characters) {
                            Character.displayCharacter();
                        }
                    } else {
                        System.out.println("There is no Character to display");
                        startMenuChoice = 0;
                        break;
                    }
                    startMenuChoice = 0;
                    break;

                case 3: // Edit Character
                    Character CharacterToEdit = null;
                    if (!Characters.isEmpty()) {
                        System.out.println("Which character do you want to Edit ? (type the number of the character)");
                        for (int i = 0; i < Characters.size(); i++) {
                            int indexOfCharacter = Characters.indexOf(Characters.get(i));
                            System.out.println(indexOfCharacter + ". " + Characters.get(i).getName());
                        }
                        Scanner sc = new Scanner(System.in);
                        int editChoice = sc.nextInt();
                        CharacterToEdit = Characters.get(editChoice);
                        if (CharacterToEdit != null) {
                            
                            CharacterToEdit.editCharacter();
                        }
                    } else {
                        System.out.println("There is no Character to edit");
                        startMenuChoice = 0;
                        break;
                    }
                    startMenuChoice = 0;
                    break;
                case 4: // Delete Character
                    if (!Characters.isEmpty()) {
                        System.out.println("Which character do you want to Delete ? (type the number of the character)");
                        for (int i = 0; i < Characters.size(); i++) {
                            int indexOfCharacter = Characters.indexOf(Characters.get(i));
                            System.out.println(indexOfCharacter + ". " + Characters.get(i).getName());
                        }
                        Scanner sc = new Scanner(System.in);
                        int deleteChoice = sc.nextInt();
                        Character deletedWarrior = Characters.get(deleteChoice);
                        Characters.remove(deleteChoice);
                        System.out.println("you deleted " + deletedWarrior.getName());
                    }
                    startMenuChoice = 0;
                    break;
            }
        } while (startMenuChoice != 5);
    }
}
