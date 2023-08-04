package noroff.dungeon.heroes.types;

import java.util.Arrays;

import noroff.dungeon.heroes.Hero;
import noroff.dungeon.items.armor.ArmorType;
import noroff.dungeon.items.weapon.WeaponType;
import noroff.dungeon.util.HeroAttribute;

public class Swashbuckler extends Hero {

    public Swashbuckler(String name){
        super(name);
        levelAttributes = new HeroAttribute(2, 6, 1);
        validWeaponTypes = Arrays.asList(WeaponType.DAGGERS, WeaponType.SWORDS);
        validArmorTypes = Arrays.asList(ArmorType.LEATHER, ArmorType.MAIL);
    }

    public static void main(String[] args){

    }

    @Override
    public void levelUp(){
        this.level++;
        levelAttributes.increaseAttributes(1, 4, 1);
    }
}
