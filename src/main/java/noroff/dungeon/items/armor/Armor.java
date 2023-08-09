package noroff.dungeon.items.armor;
import noroff.dungeon.items.Item;
import noroff.dungeon.items.Slot;
import noroff.dungeon.util.HeroAttribute;

public class Armor extends Item {

   private ArmorType armorType;
   private HeroAttribute ArmorAttribute;
   private int requiredLevel;

    public Armor(String name, ArmorType armorType, int requiredLevel, Slot slot, HeroAttribute ArmorAttribute){ 
        super(name, slot, requiredLevel); 
        this.armorType = armorType;
        this.requiredLevel = requiredLevel;
        this.ArmorAttribute = ArmorAttribute;
    }

    public ArmorType getArmorType(){
        return armorType;
    }

    public int getRequiredLevel(){
        return requiredLevel;
    }

    public HeroAttribute getArmorAttributes(){
        return ArmorAttribute;
    }
}
