package dungeon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Magician extends Character {

    private ArrayList<HashMap<String, Integer>> spells = new ArrayList<>();
    private String philters[] = new String[3];
    private int philterCount = 0;

    public int getPhilterCount() {
        return philterCount;
    }

    public ArrayList getSpells() {
        return spells;
    }

    public void setSpells(HashMap newSpell) {
        this.spells.add(newSpell);
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

    @Override
    public void displayCharacter() {
        super.displayCharacter();
        // Display weapons in the weapons Array
        System.out.println("\n***** Magic Spells *****");
        for (HashMap spell : spells) {
            Set<Map.Entry<String, Integer>> entrySet = spell.entrySet();
            for (Map.Entry entry : entrySet) {
                System.out.println("Your spell's name is : " + entry.getKey());
                System.out.println("Your spell strength : " + entry.getValue());
            }
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


