package noroff.dungeon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import noroff.dungeon.exceptions.InvalidWeaponException;
import noroff.dungeon.exceptions.InvalidArmorException;
import noroff.dungeon.heroes.types.Archer;
import noroff.dungeon.items.weapon.Weapon;
import noroff.dungeon.items.weapon.WeaponType;
import noroff.dungeon.util.HeroAttribute;
import noroff.dungeon.items.Slot;
import noroff.dungeon.items.armor.Armor;
import noroff.dungeon.items.armor.ArmorType;

/**
 * Unit test for simple App.
 */
public class ArcherTest 

{
    Archer arch = new Archer("Arthur");
    Weapon validWeaponInvalidLevel = new Weapon("staff", WeaponType.BOWS, 5, 22);
    Weapon validLevelInvalidWeapon = new Weapon("staff", WeaponType.DAGGERS, 0, 22);

    HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
    Armor validArmorInvalidLevel = new Armor("mail", ArmorType.LEATHER, 5, Slot.BODY, armorAtt);
    Armor validLevelInvalidAmor = new Armor("mail", ArmorType.CLOTH, 0, Slot.BODY, armorAtt);


    /**
     * Testing correct name, level and attributes for Archer
     */

    @Test
    public void test_correct_name(){
        String expectedName = "Arthur";
        assertEquals(expectedName, arch.name);
    }

    @Test
    public void test_correct_level(){
        int expectedLevel = 1;
        assertEquals(expectedLevel, arch.level);
    }

    @Test
    public void test_correct_init_strength(){
        int expectedStrength = 1;
        assertEquals(expectedStrength, arch.totalAttributes().getStrength());
    }

    @Test
    public void test_correct_init_dexterity(){
        int expectedDexterity = 7;
        assertEquals(expectedDexterity, arch.totalAttributes().getDexterity());
    }

    @Test
    public void test_correct_init_intelligence(){
        int expectedIntelligence = 1;
        assertEquals(expectedIntelligence, arch.totalAttributes().getIntelligence());
    }

    /**
     * Testing expected level when leveling up 
     */

     @Test
    public void test_level_increase(){
        int expectedLevel = 2;
        arch.levelUp();
        assertEquals(expectedLevel, arch.level);
    }

    /**
     * Testing attributes when leveling up 
     */

     @Test
    public void test_correct_levelUp_strength(){
        arch.levelUp();
        int expectedStrength = 2;
        assertEquals(expectedStrength, arch.totalAttributes().getStrength());
    }

    @Test
    public void test_correct_levelUp_dexterity(){
        arch.levelUp();
        int expectedDexterity = 12;
        assertEquals(expectedDexterity, arch.totalAttributes().getDexterity());
    }

    @Test
    public void test_correct_levelUp_intelligence(){
        arch.levelUp();
        int expectedIntelligence = 2;
        assertEquals(expectedIntelligence, arch.totalAttributes().getIntelligence());
    }

             /**
     * Testing if InvalidWeaponException is thrown when required weapon level is too high with valid weapon type
     */

     @Test(expected = InvalidWeaponException.class) 
     public void invalid_level_equip_weapon(){
         arch.equip(validWeaponInvalidLevel);
     }
 
              /**
      * Testing if InvalidWeaponException is thrown width valid level and invalid weapon type
      */
 
     @Test(expected = InvalidWeaponException.class) 
     public void invalid_weapon_equip_weapon(){
         arch.equip(validLevelInvalidWeapon);
     }

                  /**
     * Testing if InvalidArmorException is thrown when required armor level is too high with valid armor type
     */

    @Test(expected = InvalidArmorException.class) 
    public void invalid_level_equip_armor(){
        arch.equip(validArmorInvalidLevel);
    }

         /**
     * Testing if InvalidArmorException is thrown with wrong ArmorType and right required level for all heros
     */

    @Test(expected = InvalidArmorException.class) 
    public void invalid_armor_equip_armor(){
        arch.equip(validLevelInvalidAmor);
    }

      /**
     * Testing if hero can equip weapon with valid weapon type 
     */

    @Test
    public void valid_weaponType_equip(){
        Weapon expectedWeapon = new Weapon("staff", WeaponType.BOWS, 0, 22);
        arch.equip(expectedWeapon);
        assertEquals(expectedWeapon, arch.getEquippedWeapon(Slot.WEAPON));
    }

        /**
     * Testing if hero can equip armor with valid armor type 
     */

     @Test
    public void valid_armorType_equip(){
        Armor expectedArmor = new Armor("mail", ArmorType.LEATHER, 0, Slot.BODY, armorAtt);
        arch.equip(expectedArmor);
        assertEquals(expectedArmor, arch.getEquippedWeapon(Slot.BODY));
    }

        /**
     * Testing correct calculation of attributes with one armor
     */

    @Test
    public void total_strength_calculation_one_armor(){
        Armor armor = new Armor("mail", ArmorType.LEATHER, 0, Slot.BODY, armorAtt);
        int expectedStrength = 1 + 5;
        arch.equip(armor);
        assertEquals(expectedStrength, arch.totalAttributes().getStrength());
    }

    @Test
    public void total_dexterity_calculation_one_armor(){
        Armor armor = new Armor("mail", ArmorType.LEATHER, 0, Slot.BODY, armorAtt);
        int expectedDexterity = 7 + 4;
        arch.equip(armor);
        assertEquals(expectedDexterity, arch.totalAttributes().getDexterity());
    }

    @Test
    public void total_intelligence_calculation_one_armor(){
        Armor armor = new Armor("mail", ArmorType.LEATHER, 0, Slot.BODY, armorAtt);
        int expectedIntelligence = 1 + 3;
        arch.equip(armor);
        assertEquals(expectedIntelligence, arch.totalAttributes().getIntelligence());
    }

      /**
     * Testing correct calculation of attributes with two pieces of armor
     */

     @Test
    public void total_strength_calculation_two_armor(){
        Armor armor1 = new Armor("mail", ArmorType.LEATHER, 0, Slot.BODY, armorAtt);
        Armor armor2 = new Armor("mail", ArmorType.LEATHER, 0, Slot.HEAD, armorAtt);
        int expectedStrength = 1 + 5 + 5;
        arch.equip(armor1);
        arch.equip(armor2);
        assertEquals(expectedStrength, arch.totalAttributes().getStrength());
    }

     @Test
    public void total_dexterity_calculation_two_armor(){
        Armor armor1 = new Armor("mail", ArmorType.LEATHER, 0, Slot.BODY, armorAtt);
        Armor armor2 = new Armor("mail", ArmorType.LEATHER, 0, Slot.HEAD, armorAtt);
        int expectedDexterity = 7 + 4 + 4;
        arch.equip(armor1);
        arch.equip(armor2);
        assertEquals(expectedDexterity, arch.totalAttributes().getDexterity());
    }

         @Test
    public void total_intelligence_calculation_two_armor(){
        Armor armor1 = new Armor("mail", ArmorType.LEATHER, 0, Slot.BODY, armorAtt);
        Armor armor2 = new Armor("mail", ArmorType.LEATHER, 0, Slot.HEAD, armorAtt);
        int expectedIntelligence = 1 + 3 + 3;
        arch.equip(armor1);
        arch.equip(armor2);
        assertEquals(expectedIntelligence, arch.totalAttributes().getIntelligence());
    }

    /**
     * Testing correct calculation of attributes with replaced piece of armor
     */

     @Test
    public void total_strength_calculation_replaced_armor(){
        Armor armor1 = new Armor("mail", ArmorType.LEATHER, 0, Slot.BODY, armorAtt);
        Armor armor2 = new Armor("mail", ArmorType.LEATHER, 0, Slot.BODY, armorAtt);
        int expectedStrength = 1 + 5;
        arch.equip(armor1);
        arch.equip(armor2);
        assertEquals(expectedStrength, arch.totalAttributes().getStrength());
    }

     @Test
    public void total_dexterity_calculation_replaced_armor(){
        Armor armor1 = new Armor("mail", ArmorType.LEATHER, 0, Slot.BODY, armorAtt);
        Armor armor2 = new Armor("mail", ArmorType.LEATHER, 0, Slot.BODY, armorAtt);
        int expectedDexterity = 7 + 4;
        arch.equip(armor1);
        arch.equip(armor2);
        assertEquals(expectedDexterity, arch.totalAttributes().getDexterity());
    }

     @Test
    public void total_intelligence_calculation_replaced_armor(){
        Armor armor1 = new Armor("mail", ArmorType.LEATHER, 0, Slot.BODY, armorAtt);
        Armor armor2 = new Armor("mail", ArmorType.LEATHER, 0, Slot.BODY, armorAtt);
        int expectedIntelligence = 1 + 3;
        arch.equip(armor1);
        arch.equip(armor2);
        assertEquals(expectedIntelligence, arch.totalAttributes().getIntelligence());
    }

    /**
     * Testing calculation of hero damage 
     */

      @Test
    public void calculating_correct_hero_damage_no_equipments(){
        double expectedDamage = 1;
        double delta = 0.0001;
        assertEquals(expectedDamage, arch.damage(), delta);
    }

      @Test
    public void calculating_correct_hero_damage_weapon_equipped(){
        Weapon weapon = new Weapon("staff", WeaponType.BOWS, 0, 22);
        //totalDamage = weaponDamage * (1 + damagingAttribute / 100);
        double expectedDamage = 23.54;
        arch.equip(weapon);
        double delta = 0.01;
        assertEquals(expectedDamage, arch.damage(), delta);
    }

      @Test
    public void calculating_correct_hero_damage_weapon_replaced(){
        Weapon weapon1 = new Weapon("staff", WeaponType.BOWS, 0, 22);
        Weapon weapon2 = new Weapon("staff", WeaponType.BOWS, 0, 35);
        double expectedDamage = 37.45;
        arch.equip(weapon1);
        arch.equip(weapon2);
        double delta = 0.01;
        assertEquals(expectedDamage, arch.damage(), delta);
    }

      @Test
    public void calculating_correct_hero_damage_weapon_armor_equipped(){
        Weapon weapon = new Weapon("staff", WeaponType.BOWS, 0, 22);
        Armor armor = new Armor("mail", ArmorType.LEATHER, 0, Slot.BODY, armorAtt);
        double expectedDamage = 24.42;
        arch.equip(weapon);
        arch.equip(armor);
        double delta = 0.01;
        assertEquals(expectedDamage, arch.damage(), delta);
    }

}
