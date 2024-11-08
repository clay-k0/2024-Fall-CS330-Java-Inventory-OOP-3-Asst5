package edu.odu.cs.cs330.items;

import java.util.Objects;

/**
 * This class represents one piece of armour--as found in most video games.
 * This includes boots and helmets.
 *
 * Armour may not be stacked.
 */
@SuppressWarnings({
        "PMD.CloneMethodReturnTypeMustMatchClassName",
        "PMD.CloneThrowsCloneNotSupportedException",
        "PMD.LawOfDemeter",
        "PMD.OnlyOneReturn",
        "PMD.ProperCloneImplementation",
        "PMD.MethodArgumentCouldBeFinal",
        "PMD.LocalVariableCouldBeFinal"
})
public class Armour extends Equippable {
    /**
     * Format used to generate a printable representation.
     */
    public static final String FMT_STR = String.join(
            "",
            "  Nme: %s%n",
            "  Dur: %s%n",
            "  Def: %d%n",
            "  Mtl: %s%n",
            "  Mdr: %s (Lvl %d)%n",
            "  Emt: %s%n");

    /**
     * The amount of damage that can be negated.
     */
    protected int defense;

    /**
     * Default to a armour with a defense of zero.
     */
    public Armour() {
        super();

        this.defense = 0;
    }

    /**
     * Retrieve armour defense.
     *
     * @return total defense provided
     */
    public int getDefense() {
        return this.defense;
    }

    /**
     * Update defense.
     *
     * @param def replacement getDefense()
     */
    public void setDefense(int def) {
        this.defense = def;
    }

    @Override
    public int requiredNumberOfValues() {
        return 7; // length of FMT_STR
    }

    @Override
    public void fromTokens(String[] tokens) {
        this.setName(tokens[0]);
        this.setMaterial(tokens[1]);
        this.setDurability(Integer.parseInt(tokens[2]));
        this.setDefense(Integer.parseInt(tokens[3]));
        this.setModifier(tokens[4]);
        this.setModifierLevel(Integer.parseInt(tokens[5]));
        this.setElement(tokens[6]);
    }

    /**
     * Clone--i.e., copy--this Armour.
     */
    @Override
    public Item clone() {
        Armour cpy = new Armour();

        cpy.setName(this.getName());
        cpy.setMaterial(this.getMaterial());
        cpy.setDurability(this.getDurability());
        cpy.setDefense(this.getDefense());
        cpy.setModifier(this.getModifier());
        cpy.setModifierLevel(this.getModifierLevel());
        cpy.setElement(this.getElement());

        return cpy;
    }

    /**
     * Check for logical equivalence--based on name, material, modifier,
     * modifierLevel, element, and defense.
     *
     * @param rhs object for which a comparison is desired
     */
    @Override
    public boolean equals(Object rhs) {
        if (!(rhs instanceof Armour)) {
            return false;
        }

        Armour rhsItem = (Armour) rhs;

        return this.getName().equals(rhsItem.getName())
                && this.getMaterial().equals(rhsItem.getMaterial())
                && this.getModifier().equals(rhsItem.getModifier())
                && this.getModifierLevel() == rhsItem.getModifierLevel()
                && this.getElement().equals(rhsItem.getElement())
                && this.getDefense() == rhsItem.getDefense();
    }

    /**
     * Compute hashCode based on name, material, modifier, modifierLevel,
     * element, and defense.
     */
    @Override
    public int hashCode() {
        // This **already completed** function is a hint... use it as a
        // reference for the other two classes.
        return Objects.hash(
                this.getName(),
                this.getMaterial(),
                this.getModifier(),
                this.getModifierLevel(),
                this.getElement(),
                this.getDefense());
    }

    /**
     * *Print* one Armour.
     */
    @Override
    public String toString() {
        return String.format(FMT_STR, this.getName(), this.getDurability(), this.getDefense(), this.getMaterial(),
                this.getModifier(), this.getModifierLevel(), this.getElement());
    }
}
