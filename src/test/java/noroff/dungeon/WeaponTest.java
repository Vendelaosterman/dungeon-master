package noroff.dungeon;
import org.junit.Test;

import noroff.dungeon.exceptions.InvalidWeaponException;
import noroff.dungeon.heroes.types.Wizard;
import noroff.dungeon.items.Slot;
import noroff.dungeon.items.weapon.Weapon;
import noroff.dungeon.items.weapon.WeaponType;
import static org.junit.Assert.assertEquals;

public class WeaponTest {

         /**
     * Testing name, required level, slot, weapon type and damage for Weapon creation 
     */

    Weapon staff = new Weapon("staff", WeaponType.STAFFS, 5, 22);

    @Test
    public void test_correct_name_weapon(){
        String expectedName = "staff";
        assertEquals(expectedName, staff.getName());
       
    }

    @Test
    public void test_correct_requiredLevel_weapon() {
        int expectedRequiredLevel = 5;
        assertEquals(expectedRequiredLevel, staff.getRequiredLevel());
    }

    @Test
    public void test_correct_slot_weapon() {
        Slot expectedSlot = Slot.WEAPON;
        assertEquals(expectedSlot, staff.getSlot());

    }

    @Test
    public void test_correct_WeaponType_weapon() {
        WeaponType expectedWeaponType = WeaponType.STAFFS;
        assertEquals(expectedWeaponType, staff.getWeaponType());
    }

    @Test
    public void test_correct_damage_weapon() {
        int expectedWeaponDamage = 22;
        assertEquals(expectedWeaponDamage, staff.getWeaponDamage());
    }

}
