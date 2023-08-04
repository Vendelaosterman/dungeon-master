package noroff.dungeon.items.armor;

import noroff.dungeon.items.Item;
import noroff.dungeon.items.Slot;
//import noroff.dungeon.items.armor.ArmorType;

public class Armor extends Item {

   private ArmorType armorType;
   private int requiredLevel;

    public Armor(String name, ArmorType armorType, int requiredLevel, Slot slot){ 
        super(name, slot, requiredLevel); 
        this.armorType = armorType;
        this.requiredLevel = requiredLevel;
    }

    public ArmorType getWeaponType(){
        return armorType;
    }

    public int getRequiredLevel(){
        return requiredLevel;
    }
}
