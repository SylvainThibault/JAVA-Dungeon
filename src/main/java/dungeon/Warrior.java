package dungeon;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The type Warrior.
 */
public class Warrior extends Character {

    /**
     * The Weapons.
     */
    private ArrayList<Weapon> weapons = new ArrayList<>();

    private String shields[] = new String[3];
    private int shieldCount = 0;
    /**
     * Sets weapons.
     *
     * @param weapon the weapon
     */
    public void setWeapons(Weapon weapon) {
        this.weapons.add(weapon);
    }

    public Weapon getWeapon(int indexOfWeapon) {
        return weapons.get(indexOfWeapon);
    }

    /**
     * Gets shield count.
     *
     * @return the shield count
     */
    public int getShieldCount() {
        return shieldCount;
    }

    /**
     * Get shields string [ ].
     *
     * @return the string [ ]
     */
    public String[] getShields() {
        return shields;
    }

    /**
     * Sets shield.
     *
     * @param shieldType the shield type
     */
    public void setShield(String shieldType) {
        if (this.shieldCount < 3) {
            this.shields[this.shieldCount] = shieldType;
            this.shieldCount++;
        }
    }

    /**
     * Instantiates a new Warrior.
     *
     * @param name     the name
     * @param strength the strength
     */
    Warrior(String name, /*String image,*/ Integer strength) {
        setName(name);
        //setImage(image);
        setLife();
        setStrength(strength);
    }

    /**
     * Add weapon.
     */
    public void addWeapon() {
        System.out.println("\nEnter the name of your Weapon : ");
        Scanner sc = new Scanner(System.in);
        String nameOfWeapon = sc.nextLine();

        Integer randomNum = ThreadLocalRandom.current().nextInt(1, 10);
        System.out.println("Your " + nameOfWeapon + " has the random strength of : " + randomNum);

        Weapon weapon = new Weapon(nameOfWeapon, randomNum);
        weapons.add(weapon);
    }

    /**
     * Add shield.
     */
    public void addShield() {
        if (this.getShieldCount() < 3) {
            System.out.println("\nEnter the name of your Shield : ");
            Scanner sc = new Scanner(System.in);
            String nameOfShield = sc.nextLine();
            System.out.println("Your new Shield is : " + nameOfShield);

            this.setShield(nameOfShield);
        } else {
            System.out.println("Yo baggo'shields is full, yo!");
        }
    }

    public void removeWeapon(String characterName) {
        // Display Weapons
        System.out.println("\n>>>> " + characterName + "'s weapons");
        for (int i = 0; i < weapons.size(); i++) {
            Weapon weaponItem = weapons.get(i);
            int indexOfWeapon = weapons.indexOf(weaponItem);
            System.out.println("\t" + indexOfWeapon + ". " + weaponItem.toString());
        }
        System.out.println("\nWhich Weapon do you want to remove ? ( Type in the number of the weapon )");
        Scanner sc = new Scanner(System.in);
        try {
            int weaponChoice = sc.nextInt();
            sc.nextLine();
            Weapon deletedWeapon = weapons.get(weaponChoice);
            weapons.remove(weaponChoice);
            System.out.println("You removed " + deletedWeapon.getWeaponName() + " from the bag.");
        } catch(IndexOutOfBoundsException e){
            System.out.println("Come ooooooooon...");
        }
    }

    @Override
    public void displayCharacter() {
        super.displayCharacter();

        // Display Weapons
        System.out.println("\n***** Warrior's weapons *****");
        for (Weapon weapon : weapons) {
            System.out.println(weapon.toString());
        }
        // Display Shields in the shields Array
        System.out.println("\n***** Warrior's Shields *****");
        for (int i = 0; i < shields.length; i++) {
            if (shields[i] != null) {
                System.out.println(shields[i]);
            }
        }
        System.out.println("\n");
    }
}
