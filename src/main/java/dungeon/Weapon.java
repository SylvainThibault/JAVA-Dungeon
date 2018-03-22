package dungeon;

/**
 * The type Weapon.
 */
public class Weapon {

    private String weaponName;
    private Integer weaponStrength;

    /**
     * Instantiates a new Weapon.
     *
     * @param nameOfWeapon   the name of weapon
     * @param weaponStrength the weapon strength
     */
    public Weapon(String nameOfWeapon, Integer weaponStrength) {
        this.weaponName = nameOfWeapon;
        this.weaponStrength = weaponStrength;
    }

    /**
     * Gets weapon name.
     *
     * @return the weapon name
     */
    public String getWeaponName() {
        return weaponName;
    }

    /**
     * Gets weapon strength.
     *
     * @return the weapon strength
     */
    public Integer getWeaponStrength() {
        return weaponStrength;
    }

    @Override
    public String toString() {
        return weaponName + " (strength : " + weaponStrength + ")";
    }
}
