package noroff.dungeon.heroes.types;

import java.util.Arrays;

import noroff.dungeon.heroes.Hero;
import noroff.dungeon.items.armor.ArmorType;
import noroff.dungeon.items.weapon.WeaponType;
import noroff.dungeon.util.HeroAttribute;

public class Barbarian extends Hero {

    public Barbarian(String name){
        super(name);
        levelAttributes = new HeroAttribute(5, 2, 1);
        validWeaponTypes = Arrays.asList(WeaponType.HATCHETS, WeaponType.MACES, WeaponType.SWORDS);
        validArmorTypes = Arrays.asList(ArmorType.MAIL, ArmorType.PLATE);
    }

    public static void main(String[] args){

    }

    @Override
    public void levelUp(){
        this.level++;
        levelAttributes.increaseAttributes(3, 2, 1);
    }
}