package noroff.dungeon.util;

public class HeroAttribute {

    private int strength;
    private int dexterity;
    private int intelligence;

    public HeroAttribute(int strength, int dexterity, int intelligence){
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public void increaseAttributes(int strengthGain, int dexterityGain, int intelligenceGain){
        this.strength += strengthGain;
        this.dexterity += dexterityGain;
        this.intelligence += intelligenceGain;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }


}
