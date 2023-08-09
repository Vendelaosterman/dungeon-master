package noroff.dungeon.util;

public class HeroAttribute {

    private int strength;
    private int dexterity;
    private int intelligence;

    // Constructor to create an instance with specified attribute values
    public HeroAttribute(int strength, int dexterity, int intelligence){
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    // Method to increase attribute values by specified amounts
    public void increaseAttributes(int strengthGain, int dexterityGain, int intelligenceGain){
        this.strength += strengthGain;
        this.dexterity += dexterityGain;
        this.intelligence += intelligenceGain;
    }

    // returns the value of the strength attribute
    public int getStrength() {
        return strength;
    }

    // returns the value of the dexterity attribute
    public int getDexterity() {
        return dexterity;
    }

    // returns the value of the intelligence attribute
    public int getIntelligence() {
        return intelligence;
    }


}
