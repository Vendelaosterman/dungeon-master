package noroff.dungeon;
import noroff.dungeon.heroes.types.Wizard;
import noroff.dungeon.items.weapon.Weapon;
import noroff.dungeon.items.weapon.WeaponType;
import noroff.dungeon.items.armor.Armor;
import noroff.dungeon.items.armor.ArmorType;
import noroff.dungeon.items.Slot;

public class Main {
    
    public static void main(String[] args){
        Wizard wiz = new Wizard("Arthur");
        //Weapon hatchet = new Weapon("hatchet", WeaponType.HATCHETS, 0);
        Armor cloth = new Armor("cloth", ArmorType.CLOTH, 0, Slot.LEGS);
        //wiz.levelUp();
        wiz.equip(cloth);
        wiz.display();


    }
}
