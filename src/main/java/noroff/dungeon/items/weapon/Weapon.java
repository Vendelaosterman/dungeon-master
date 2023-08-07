package noroff.dungeon.items.weapon;

import noroff.dungeon.items.Item;
import noroff.dungeon.items.Slot;

public class Weapon extends Item {

    private WeaponType weaponType;
    private int requiredLevel;
    private int weaponDamage;

    public Weapon(String name, WeaponType weaponType, int requiredLevel, int weaponDamage){ 
        super(name, Slot.WEAPON, requiredLevel); 
        this.weaponType = weaponType;
        this.requiredLevel = requiredLevel;
        this.weaponDamage = weaponDamage;
    }

    public WeaponType getWeaponType(){
        return weaponType;
    }

    public int getRequiredLevel(){
        return requiredLevel;
    }

    public int getWeaponDamage(){
        return weaponDamage;
    }
}
