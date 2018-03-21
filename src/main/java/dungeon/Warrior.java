package dungeon;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Warrior extends Character {

    ArrayList<Weapon> weapons = new ArrayList<>();
    private String shields[] = new String[3];
    private int shieldCount = 0;

    public int getShieldCount() {
        return shieldCount;
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

    public void addWeapon() {
        System.out.println("Enter the name of your Weapon : ");
        Scanner sc = new Scanner(System.in);
        String nameOfWeapon = sc.nextLine();

        Integer randomNum = ThreadLocalRandom.current().nextInt(0, 11);
        System.out.println("Your " + nameOfWeapon + " has the random strength of : " + randomNum + "\n");

        Weapon weapon = new Weapon(nameOfWeapon, randomNum);
        weapons.add(weapon);
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
