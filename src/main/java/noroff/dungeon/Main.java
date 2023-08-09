package noroff.dungeon;
import noroff.dungeon.heroes.types.Swashbuckler;
import noroff.dungeon.heroes.types.Wizard;
import noroff.dungeon.items.weapon.Weapon;
import noroff.dungeon.items.weapon.WeaponType;
import noroff.dungeon.util.HeroAttribute;
import noroff.dungeon.items.armor.Armor;
import noroff.dungeon.items.armor.ArmorType;
import noroff.dungeon.items.Slot;

public class Main {
    
    public static void main(String[] args){
        Swashbuckler swash = new Swashbuckler("Arthur");
        swash.display();
    }
}
