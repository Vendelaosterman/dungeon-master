package noroff.dungeon.items.weapon;

import noroff.dungeon.items.Item;
import noroff.dungeon.items.Slot;

public class Weapon extends Item {

    private WeaponType weaponType;
    private int requiredLevel;

    public Weapon(String name, WeaponType weaponType, int requiredLevel){ 
        super(name, Slot.WEAPON, requiredLevel); 
        this.weaponType = weaponType;
        this.requiredLevel = requiredLevel;
    }

    public WeaponType getWeaponType(){
        return weaponType;
    }

    public int getRequiredLevel(){
        return requiredLevel;
    }
}
