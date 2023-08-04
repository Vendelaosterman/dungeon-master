package noroff.dungeon;
import noroff.dungeon.heroes.types.Wizard;
import noroff.dungeon.items.weapon.Weapon;
import noroff.dungeon.items.weapon.WeaponType;

public class Main {
    
    public static void main(String[] args){
        Wizard wiz = new Wizard("Arthur");
        Weapon hatchet = new Weapon("hatchet", WeaponType.STAFFS, 0);
        //wiz.levelUp();
        wiz.equip(hatchet);
        wiz.display();


    }
}
