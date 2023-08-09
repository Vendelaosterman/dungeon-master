package noroff.dungeon.items.armor;
import noroff.dungeon.items.Item;
import noroff.dungeon.items.Slot;
import noroff.dungeon.util.HeroAttribute;

public class Armor extends Item {

   private ArmorType armorType;
   private HeroAttribute ArmorAttribute;
   private int requiredLevel;

   // Constructor to create an Armor instance with specified properties
    public Armor(String name, ArmorType armorType, int requiredLevel, Slot slot, HeroAttribute ArmorAttribute){ 
        super(name, slot, requiredLevel); 
        this.armorType = armorType;
        this.requiredLevel = requiredLevel;
        this.ArmorAttribute = ArmorAttribute;
    }

    // Get the armor type of the Armor instance
    public ArmorType getArmorType(){
        return armorType;
    }

    // Get the required level to equip the Armor instance
    public int getRequiredLevel(){
        return requiredLevel;
    }

    // Get the armor attributes by the Armor instance
    public HeroAttribute getArmorAttributes(){
        return ArmorAttribute;
    }
}
