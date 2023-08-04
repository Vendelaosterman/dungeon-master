package noroff.dungeon.heroes.types;

import noroff.dungeon.heroes.Hero;
import noroff.dungeon.items.armor.ArmorType;
import noroff.dungeon.items.weapon.WeaponType;
import noroff.dungeon.util.HeroAttribute;

import java.util.Arrays;

public class Archer extends Hero {

    public Archer(String name){
        super(name);
        levelAttributes = new HeroAttribute(1, 7, 1);
        validWeaponTypes = Arrays.asList(WeaponType.BOWS);
        validArmorTypes = Arrays.asList(ArmorType.LEATHER, ArmorType.MAIL);
    }

    public static void main(String[] args){

    }

    @Override
    public void levelUp(){
        this.level++;
        levelAttributes.increaseAttributes(1, 5, 1);
    }
}
