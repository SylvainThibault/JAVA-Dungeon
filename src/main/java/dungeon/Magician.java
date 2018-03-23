package dungeon;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The type Magician.
 */
public class Magician extends Character {

    private ArrayList<Spell> spells = new ArrayList<>();
    private String philters[] = new String[3];
    private int philterCount = 0;

    /**
     * Sets spells.
     *
     * @param spell the spell
     */
    public void setSpells(Spell spell) {
        this.spells.add(spell);
    }

    public Spell getSpell(int indexOfSpell) {
        return spells.get(indexOfSpell);
    }

    /**
     * Gets philter count.
     *
     * @return the philter count
     */
    public int getPhilterCount() {
        return philterCount;
    }

    /**
     * Get philters string [ ].
     *
     * @return the string [ ]
     */
    public String[] getPhilters() {
        return philters;
    }

    /**
     * Sets philter.
     *
     * @param philterType the philter type
     */
    public void setPhilter(String philterType) {
        if (this.philterCount < 3) {
            this.philters[this.philterCount] = philterType;
            this.philterCount++;
        }
    }

    /**
     * Instantiates a new Magician.
     *
     * @param name     the name
     * @param strength the strength
     */
    Magician(String name, /*String image,*/ Integer strength) {
        setName(name);
        //setImage(image);
        setLife();
        setStrength(strength);
    }

    /**
     * Add spell.
     */
    public void addSpell() {
        System.out.println("\nEnter the name of your Spell : ");
        Scanner sc = new Scanner(System.in);
        String nameOfSpell = sc.nextLine();

        Integer randomNum = ThreadLocalRandom.current().nextInt(1, 10);
        System.out.println("Your " + nameOfSpell + " has the random strength of : " + randomNum);

        Spell spell = new Spell(nameOfSpell, randomNum);
        spells.add(spell);
    }

    public void addPhilter() {
        if (this.getPhilterCount() < 3) {
            System.out.println("\nEnter the name of your new protection Philter : ");
            Scanner sc = new Scanner(System.in);
            String nameOfPhilter = sc.nextLine();
            System.out.println("Your new protection Philter is : " + nameOfPhilter);

            this.setPhilter(nameOfPhilter);
        } else {
            System.out.println("Yo baggo'philter is full, yo!");
        }
    }

    public void removeSpell(String characterName) {
        // Display Spells
        System.out.println("\n>>>> " + characterName + "'s Spells");
        for (int i = 0; i < spells.size(); i++) {
            Spell SpellItem = spells.get(i);
            int indexOfSpell = spells.indexOf(SpellItem);
            System.out.println("\t" + indexOfSpell + ". " + SpellItem.toString());
        }
        System.out.println("\nWhich Spell do you want to remove ? ( Type in the number of the Spell )");
        Scanner sc = new Scanner(System.in);
        try {
            int SpellChoice = sc.nextInt();
            sc.nextLine();
            Spell deletedSpell = spells.get(SpellChoice);
            spells.remove(SpellChoice);
            System.out.println("You removed " + deletedSpell.getspellName() + " from the bag.");
        } catch(IndexOutOfBoundsException e){
            System.out.println("Come ooooooooon...");
        }
    }

    @Override
    public void displayCharacter() {
        super.displayCharacter();
        // Display spells in the spells Array
        System.out.println("\n***** Magician's Spells *****");
        for (Spell spell : spells) {
            System.out.println(spell.toString());
        }
        // Display Shields in the shields Array
        System.out.println("\n***** Magic Philters *****");
        for (int i = 0; i < philters.length; i++) {
            if (philters[i] != null) {
                System.out.println(philters[i]);
            }
        }
        System.out.println("\n");
    }
}


