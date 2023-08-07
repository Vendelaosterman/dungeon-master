package noroff.dungeon;
import noroff.dungeon.heroes.types.Wizard;
import noroff.dungeon.items.weapon.Weapon;
import noroff.dungeon.items.weapon.WeaponType;
import noroff.dungeon.util.HeroAttribute;
import noroff.dungeon.items.armor.Armor;
import noroff.dungeon.items.armor.ArmorType;
import noroff.dungeon.items.Slot;

public class Main {
    
    public static void main(String[] args){
        Wizard wiz = new Wizard("Arthur");
        //Weapon hatchet = new Weapon("hatchet", WeaponType.HATCHETS, 0);
        //Weapon staff = new Weapon("staff", WeaponType.STAFFS, 0, 5);
        HeroAttribute newAtt = new HeroAttribute(5, 4, 3);
        Armor cloth = new Armor("cloth", ArmorType.CLOTH, 0, Slot.BODY, newAtt);
        //Weapon wand = new Weapon("wand", WeaponType.WANDS, 0);
        //wiz.levelUp();

        wiz.display();
 
        wiz.equip(cloth);
        //wiz.equip(wand);
        //wiz.levelUp();
        wiz.display();


    }
}
