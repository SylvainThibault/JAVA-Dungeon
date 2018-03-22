package dungeon;

/**
 * The type Spell.
 */
public class Spell {

    private String spellName;
    private Integer spellStrength;

    /**
     * Instantiates a new Spell.
     *
     * @param nameOfSpell   the name of spell
     * @param spellStrength the spell strength
     */
    public Spell(String nameOfSpell, Integer spellStrength) {
        this.spellName = nameOfSpell;
        this.spellStrength = spellStrength;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getspellName() {
        return spellName;
    }

    /**
     * Gets strength.
     *
     * @return the strength
     */
    public Integer getspellStrength() {
        return spellStrength;
    }

    @Override
    public String toString() {
        return spellName + " (strength : " + spellStrength + ")";
    }
}
