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
        setDefaultCharacters(Characters);

        Walkthrough newGame = new Walkthrough();
        int startMenuChoice = 0;

        do {
            switch (startMenuChoice) {
                case 0:
                    startMenuChoice = newGame.startMenu();
                    break;

                case 1: // Create Character
                    menuCreate(Characters, newGame);
                    startMenuChoice = 0;
                    break;

                case 2: // Display Character
                    menuDisplay(Characters);
                    startMenuChoice = 0;
                    break;

                case 3: // Edit Character
                    EditClass editClass = new EditClass(Characters, newGame).invoke();
                    if (editClass.is()) break;
                    startMenuChoice = 0;
                    break;

                case 4: // Delete Character
                    DeleteClass deleteClass = new DeleteClass(Characters, newGame).invoke();
                    if (deleteClass.is()) break;
                    startMenuChoice = 0;
                    break;

                case 5: // Fight
                    Fight Fight = new Fight();
                    Character player1;
                    Character player2;
                    Weapon weapon1 = null;
                    Weapon weapon2 = null;
                    try {
                        player1 = Characters.get(newGame.chooseCharacter(Characters));
                    } catch(CharacterIndexException e) {
                        startMenuChoice = 0;
                        break;
                    }
                    try {
                        player2 = Characters.get(newGame.chooseCharacter(Characters));
                    } catch(CharacterIndexException e) {
                        startMenuChoice = 0;
                        break;
                    }

                    if(player1 instanceof Warrior) {weapon1 = ((Warrior) player1).getWeapon(0);}
                    if(player2 instanceof Warrior) {weapon2 = ((Warrior) player2).getWeapon(0);}

                    while(player1.getLife() > 0 && player2.getLife() > 0) {
                        Scanner sc = new Scanner(System.in);
                        sc.nextLine();
                        Fight.fight(player1,weapon1, player2, weapon2);
                    }

                    if (player1.getLife() > 0 || player1.getLife() > player2.getLife()) {
                        System.out.println("\n" + player1.getName() + " WON THE GAME !!!!");
                    } else if (player2.getLife() > 0 || player2.getLife() > player1.getLife()) {
                        System.out.println("\n" + player2.getName() + " WON THE GAME !!!!");
                    } else {
                        System.out.println("There's a horse in my soup !");
                    }

                    startMenuChoice = 0;
                    break;
            }
        } while (startMenuChoice != 6);
    }

    /*
    /////////////// METHODS //////////////////////////////////////////////////////////////////
     */

    /**
     * Sets default characters.
     *
     * @param characters the characters
     */
    public static void setDefaultCharacters(ArrayList<Character> characters) {
        // Default Characters
        Warrior Wally = new Warrior("Wally", 3);
        Weapon Fourchette = new Weapon("Fourchette", 5);
        Wally.setWeapons(Fourchette);
        Wally.setShield("Shield");
        characters.add(Wally);

        Warrior Merlin = new Warrior("Merlin", 3);
        Weapon Finger = new Weapon("Finger", 5);
        Merlin.setWeapons(Finger);
        Merlin.setShield("Philter");
        characters.add(Merlin);
        // end of default characters
    }

    /**
     * Menu create.
     *
     * @param characters the characters
     * @param newGame    the new game
     */
    public static void menuCreate(ArrayList<Character> characters, Walkthrough newGame) {
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
                newWarrior.addShield();
                while (newGame.addAnotherShield()) {
                    newWarrior.addShield();
                }
                characters.add(newWarrior);
                break;

            case "Magician":
                Magician newMagician = new Magician(newCharacterName, newCharacterStrength);
                newMagician.addSpell();
                while (newGame.addAnotherWeapon()) {
                    newMagician.addSpell();
                }
                newMagician.addPhilter();
                while (newGame.addAnotherPhilter()) {
                    newMagician.addPhilter();
                }
                characters.add(newMagician);
                break;
        }
    }

    /**
     * Menu display.
     *
     * @param characters the characters
     */
    public static void menuDisplay(ArrayList<Character> characters) {
        if (!characters.isEmpty()) {
            for (Character Character : characters) {
                Character.displayCharacter();
            }
        } else {
            System.out.println("There is no Character to display");
        }
    }


    private static class DeleteClass {
        private boolean myResult;
        private ArrayList<Character> characters;
        private Walkthrough newGame;
        private int startMenuChoice;

        /**
         * Instantiates a new Delete class.
         *
         * @param characters the characters
         * @param newGame    the new game
         */
        public DeleteClass(ArrayList<Character> characters, Walkthrough newGame) {
            this.characters = characters;
            this.newGame = newGame;
        }

        /**
         * Is boolean.
         *
         * @return the boolean
         */
        boolean is() {
            return myResult;
        }

        /**
         * Gets start menu choice.
         *
         * @return the start menu choice
         */
        public int getStartMenuChoice() {
            return startMenuChoice;
        }

        /**
         * Invoke delete class.
         *
         * @return the delete class
         */
        public DeleteClass invoke() {
            try {
                int characterChoice = newGame.chooseCharacter(characters);
                Character deletedWarrior = characters.get(characterChoice);
                characters.remove(characterChoice);
                System.out.println("you deleted " + deletedWarrior.getName());
            } catch (CharacterIndexException e) {
                startMenuChoice = 4;
                myResult = true;
                return this;
            }
            myResult = false;
            return this;
        }
    }

    private static class EditClass {
        private boolean myResult;
        private ArrayList<Character> characters;
        private Walkthrough newGame;
        private int startMenuChoice;

        /**
         * Instantiates a new Edit class.
         *
         * @param characters the characters
         * @param newGame    the new game
         */
        public EditClass(ArrayList<Character> characters, Walkthrough newGame) {
            this.characters = characters;
            this.newGame = newGame;
        }

        /**
         * Is boolean.
         *
         * @return the boolean
         */
        boolean is() {
            return myResult;
        }

        /**
         * Gets start menu choice.
         *
         * @return the start menu choice
         */
        public int getStartMenuChoice() {
            return startMenuChoice;
        }

        /**
         * Invoke edit class.
         *
         * @return the edit class
         */
        public EditClass invoke() {
            Character CharacterToEdit = null;

            // Choose Character to edit
            if (!characters.isEmpty()) {
                try {
                    int characterChoice = newGame.chooseCharacter(characters);
                    CharacterToEdit = characters.get(characterChoice);
                    System.out.println("You chose : " + CharacterToEdit.getName());
                } catch (CharacterIndexException e) {
                    startMenuChoice = 3;
                    myResult = true;
                    return this;
                }

                // Edit Character
                if (CharacterToEdit != null) {
                    Walkthrough editMenu = new Walkthrough();
                    String characterName = CharacterToEdit.getName();
                    int stuffToEdit = editMenu.editMenu(characterName);

                    do {
                        switch (stuffToEdit) {
                            case 0: // Reload Menu
                                stuffToEdit = editMenu.editMenu(characterName);
                                break;
                            case 1: // Edit Name
                                CharacterToEdit.newName();
                                stuffToEdit = 0;
                                break;
                            case 2: // Add Weapon
                                if (CharacterToEdit instanceof Warrior) {
                                    ((Warrior) CharacterToEdit).addWeapon();
                                }
                                if (CharacterToEdit instanceof Magician) {
                                    ((Magician) CharacterToEdit).addSpell();
                                }
                                stuffToEdit = 0;
                                break;
                            case 3: // Remove Weapon
                                if (CharacterToEdit instanceof Warrior) {
                                    ((Warrior) CharacterToEdit).removeWeapon(characterName);
                                }
                                if (CharacterToEdit instanceof Magician) {
                                    ((Magician) CharacterToEdit).removeSpell(characterName);
                                }
                                stuffToEdit = 0;
                                break;
                            case 4:
                                if (CharacterToEdit instanceof Warrior) {
                                    ((Warrior) CharacterToEdit).addShield();
                                }
                                if (CharacterToEdit instanceof Magician) {
                                    ((Magician) CharacterToEdit).addPhilter();
                                }
                                stuffToEdit = 0;
                                break;
                        }
                    } while (stuffToEdit != 5);
                }
            } else {
                System.out.println("There is no Character to edit");
                startMenuChoice = 0;
                myResult = true;
                return this;
            }
            myResult = false;
            return this;
        }
    }
}
