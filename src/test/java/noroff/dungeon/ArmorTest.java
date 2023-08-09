package noroff.dungeon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import noroff.dungeon.items.Slot;
import noroff.dungeon.items.armor.Armor;
import noroff.dungeon.items.armor.ArmorType;
import noroff.dungeon.items.weapon.WeaponType;
import noroff.dungeon.util.HeroAttribute;

public class ArmorTest {

         /**
     * Testing name, required level, slot, armor type and armor attributes for Armor creation 
     */

    @Test
    public void test_correct_name_armor(){
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
        Armor cloth = new Armor("cloth", ArmorType.CLOTH, 10, Slot.BODY, armorAtt);
        String expectedName = "cloth";
        assertEquals(expectedName, cloth.getName());
    }

    @Test
    public void test_correct_requiredLevel_armor() {
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
        Armor cloth = new Armor("cloth", ArmorType.CLOTH, 10, Slot.BODY, armorAtt);
        int expectedRequiredLevel = 10;
        assertEquals(expectedRequiredLevel, cloth.getRequiredLevel());
    }

    @Test
    public void test_correct_slot_armor() {
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
        Armor cloth = new Armor("cloth", ArmorType.CLOTH, 10, Slot.BODY, armorAtt);
        Slot expectedSlot = Slot.BODY;
        assertEquals(expectedSlot, cloth.getSlot());
    }

    @Test
    public void test_correct_ArmorType_armor() {
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
        Armor cloth = new Armor("cloth", ArmorType.CLOTH, 10, Slot.BODY, armorAtt);
        ArmorType expectedArmorType = ArmorType.CLOTH;
        assertEquals(expectedArmorType, cloth.getArmorType());
    }

    @Test
    public void test_correct_armorAtt_armor() {
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
        Armor cloth = new Armor("cloth", ArmorType.CLOTH, 10, Slot.BODY, armorAtt);
        HeroAttribute expectedArmorAtt = armorAtt;
        assertEquals(expectedArmorAtt, cloth.getArmorAttributes());
    }

}
