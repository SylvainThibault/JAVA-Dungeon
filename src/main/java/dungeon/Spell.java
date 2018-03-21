package dungeon;

public class Spell {

    private String spellName;
    private Integer spellStrength;

    public Spell(String nameOfSpell, Integer spellStrength) {
        this.spellName = nameOfSpell;
        this.spellStrength = spellStrength;
    }

    public String getspellName() {
        return spellName;
    }

    public Integer getspellStrength() {
        return spellStrength;
    }

    @Override
    public String toString() {
        return spellName + " (strength : " + spellStrength + ")";
    }
}
