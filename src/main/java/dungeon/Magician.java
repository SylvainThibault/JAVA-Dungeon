package dungeon;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Magician extends Character {

    private ArrayList<Spell> spells = new ArrayList<>();
    private String philters[] = new String[3];
    private int philterCount = 0;

    public int getPhilterCount() {
        return philterCount;
    }

    public String[] getPhilters() {
        return philters;
    }

    public void setPhilter(String philterType) {
        if (this.philterCount < 3) {
            this.philters[this.philterCount] = philterType;
            this.philterCount++;
        }
    }

    Magician(String name, /*String image,*/ Integer strength) {
        setName(name);
        //setImage(image);
        setLife();
        setStrength(strength);
    }

    public void addSpell() {
        System.out.println("Enter the name of your Spell : ");
        Scanner sc = new Scanner(System.in);
        String nameOfSpell = sc.nextLine();

        Integer randomNum = ThreadLocalRandom.current().nextInt(0, 11);
        System.out.println("Your " + nameOfSpell + " has the random strength of : " + randomNum + "\n");

        Spell spell = new Spell(nameOfSpell, randomNum);
        spells.add(spell);
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


