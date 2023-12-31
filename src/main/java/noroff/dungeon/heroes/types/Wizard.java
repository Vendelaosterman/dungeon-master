package noroff.dungeon.heroes.types;
import java.util.Arrays;

import noroff.dungeon.heroes.Hero;
import noroff.dungeon.items.weapon.WeaponType;
import noroff.dungeon.items.armor.ArmorType;
import noroff.dungeon.util.HeroAttribute;

public class Wizard extends Hero {

    // Constructor for creating an Archer hero with specified name
    public Wizard(String name){
        super(name);
        levelAttributes = new HeroAttribute(1, 1, 8); // Set initial attributes
        validWeaponTypes = Arrays.asList(WeaponType.STAFFS, WeaponType.WANDS);
        validArmorTypes = Arrays.asList(ArmorType.CLOTH);
    }

    public static void main(String[] args){

    }

    // Override the levelUp() method to customize attribute increase on level up
    @Override
    public void levelUp(){
        super.levelUp();
        levelAttributes.increaseAttributes(1, 1, 5);
    }
}