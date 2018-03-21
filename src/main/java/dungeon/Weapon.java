package dungeon;

public class Weapon {

    private String weaponName;
    private Integer weaponStrength;

    public Weapon(String nameOfWeapon, Integer weaponStrength) {
        this.weaponName = nameOfWeapon;
        this.weaponStrength = weaponStrength;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public Integer getWeaponStrength() {
        return weaponStrength;
    }

    @Override
    public String toString() {
        return weaponName + " (strength : " + weaponStrength + ")";
    }
}
