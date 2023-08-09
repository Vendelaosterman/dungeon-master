package noroff.dungeon.items.weapon;

import noroff.dungeon.items.Item;
import noroff.dungeon.items.Slot;

public class Weapon extends Item {

    private WeaponType weaponType;
    private int requiredLevel;
    private int weaponDamage;

    // Constructor to create an Weapon instance with specified properties
    public Weapon(String name, WeaponType weaponType, int requiredLevel, int weaponDamage){ 
        super(name, Slot.WEAPON, requiredLevel); 
        this.weaponType = weaponType;
        this.requiredLevel = requiredLevel;
        this.weaponDamage = weaponDamage;
    }

    // Get the weapon type of the weapon instance
    public WeaponType getWeaponType(){
        return weaponType;
    }

    // Get the required level of the weapon instance
    public int getRequiredLevel(){
        return requiredLevel;
    }

    // Get the weapon damage of the weapon instance
    public int getWeaponDamage(){
        return weaponDamage;
    }
}
