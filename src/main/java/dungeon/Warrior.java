package dungeon;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Warrior extends Character {

    private ArrayList<HashMap<String, Integer>> weapons = new ArrayList();
    private String shields[] = new String[3];
    private int shieldCount = 0;

    public int getShieldCount() {
        return shieldCount;
    }

    public ArrayList getWeapons() {
        return weapons;
    }

    public void setWeapons(HashMap newWeapon) {
        this.weapons.add(newWeapon);
    }

    public String[] getShields() {
        return shields;
    }

    public void setShield(String shieldType) {
        if (this.shieldCount < 3) {
            this.shields[this.shieldCount] = shieldType;
            this.shieldCount++;
        }
    }

    Warrior(String name, /*String image,*/ Integer strength) {
        setName(name);
        //setImage(image);
        setLife();
        setStrength(strength);
    }

    @Override
    public void displayCharacter() {
        super.displayCharacter();
        // Display weapons in the weapons Array
        System.out.println("\n***** Warrior's weapon *****");
        for (HashMap weapon : weapons) {
            Set<Map.Entry<String, Integer>> entrySet = weapon.entrySet();
            for (Map.Entry entry : entrySet) {
                System.out.println("Your weapon's name is : " + entry.getKey());
                System.out.println("Your weapon strength : " + entry.getValue());
            }
        }
        // Display Shields in the shields Array
        System.out.println("\n***** Warrior's shields *****");
        for (int i = 0; i < shields.length; i++) {
            if (shields[i] != null) {
                System.out.println(shields[i]);
            }
        }
        System.out.println("\n");
    }
}
