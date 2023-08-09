package noroff.dungeon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import noroff.dungeon.exceptions.InvalidArmorException;
import noroff.dungeon.exceptions.InvalidWeaponException;
import noroff.dungeon.heroes.types.Wizard;
import noroff.dungeon.items.Slot;
import noroff.dungeon.items.armor.Armor;
import noroff.dungeon.items.armor.ArmorType;
import noroff.dungeon.items.weapon.Weapon;
import noroff.dungeon.items.weapon.WeaponType;
import noroff.dungeon.util.HeroAttribute;

public class WizardTest {

    /**
     * Testing correct name, level and attributes for Archer
     */

    @Test
    public void test_correct_name(){
        Wizard wiz = new Wizard("Mia");
        String expectedName = "Mia";
        assertEquals(expectedName, wiz.name);
    }

    @Test
    public void test_correct_level(){
        Wizard wiz = new Wizard("Mia");
        int expectedLevel = 1;
        assertEquals(expectedLevel, wiz.level);
    }

    @Test
    public void test_correct_init_strength(){
        Wizard wiz = new Wizard("Mia");
        int expectedStrength = 1;
        assertEquals(expectedStrength, wiz.totalAttributes().getStrength());
    }

    @Test
    public void test_correct_init_dexterity(){
        Wizard wiz = new Wizard("Mia");
        int expectedDexterity = 1;
        assertEquals(expectedDexterity, wiz.totalAttributes().getDexterity());
    }

    @Test
    public void test_correct_init_intelligence(){
        Wizard wiz = new Wizard("Mia");
        int expectedIntelligence = 8;
        assertEquals(expectedIntelligence, wiz.totalAttributes().getIntelligence());
    }

    /**
     * Testing expected level when leveling up 
     */

     @Test
    public void test_level_increase(){
        Wizard wiz = new Wizard("Mia");
        int expectedLevel = 2;
        wiz.levelUp();
        assertEquals(expectedLevel, wiz.level);
    }

    /**
     * Testing attributes when leveling up 
     */

     @Test
    public void test_correct_levelUp_strength(){
        Wizard wiz = new Wizard("Mia");
        wiz.levelUp();
        int expectedStrength = 2;
        assertEquals(expectedStrength, wiz.totalAttributes().getStrength());
    }

    @Test
    public void test_correct_levelUp_dexterity(){
        Wizard wiz = new Wizard("Mia");
        wiz.levelUp();
        int expectedDexterity = 2;
        assertEquals(expectedDexterity, wiz.totalAttributes().getDexterity());
    }

    @Test
    public void test_correct_levelUp_intelligence(){
        Wizard wiz = new Wizard("Mia");
        wiz.levelUp();
        int expectedIntelligence = 13;
        assertEquals(expectedIntelligence, wiz.totalAttributes().getIntelligence());
    }

             /**
     * Testing if InvalidWeaponException is thrown when required weapon level is too high with valid weapon type
     */

    @Test(expected = InvalidWeaponException.class) 
    public void invalid_level_equip_weapon_wizard(){
        Wizard wiz = new Wizard("Mia");
        Weapon validWeaponInvalidLevel = new Weapon("staff", WeaponType.STAFFS, 5, 22);
        wiz.equip(validWeaponInvalidLevel);
    }

             /**
     * Testing if InvalidWeaponException is thrown width valid level and invalid weapon type
     */

    @Test(expected = InvalidWeaponException.class) 
    public void invalid_weapon_equip_weapon_wizard(){
        Wizard wiz = new Wizard("Mia");
        Weapon validLevelInvalidWeapon = new Weapon("staff", WeaponType.DAGGERS, 0, 22);
        wiz.equip(validLevelInvalidWeapon);
    }

          /**
     * Testing if InvalidArmorException is thrown when required armor level is too high with valid armor type
     */

    @Test(expected = InvalidArmorException.class) 
    public void invalid_level_equip_armor(){
        Wizard wiz = new Wizard("Mia");
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
        Armor validArmorInvalidLevel = new Armor("mail", ArmorType.CLOTH, 5, Slot.BODY, armorAtt);
        wiz.equip(validArmorInvalidLevel);
    }

         /**
     * Testing if InvalidArmorException is thrown with wrong ArmorType and right required level for all heros
     */

    @Test(expected = InvalidArmorException.class) 
    public void invalid_armor_equip_armor(){
        Wizard wiz = new Wizard("Mia");
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
        Armor validLevelInvalidAmor = new Armor("mail", ArmorType.MAIL, 0, Slot.BODY, armorAtt);
        wiz.equip(validLevelInvalidAmor);
    }

        /**
     * Testing if hero can equip weapon with valid weapon type 
     */

     @Test
     public void valid_weaponType_equip(){
        Wizard wiz = new Wizard("Mia");
         Weapon expectedWeapon = new Weapon("staff", WeaponType.STAFFS, 0, 22);
         wiz.equip(expectedWeapon);
         assertEquals(expectedWeapon, wiz.getEquippedWeapon(Slot.WEAPON));
     }
 
         /**
      * Testing if hero can equip armor with valid armor type 
      */
 
      @Test
     public void valid_armorType_equip(){
        Wizard wiz = new Wizard("Mia");
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
         Armor expectedArmor = new Armor("mail", ArmorType.CLOTH, 0, Slot.BODY, armorAtt);
         wiz.equip(expectedArmor);
         assertEquals(expectedArmor, wiz.getEquippedWeapon(Slot.BODY));
     }

                  /**
     * Testing correct calculation of attributes with one armor
     */

     @Test
     public void total_strength_calculation_one_armor(){
        Wizard wiz = new Wizard("Mia");
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
         Armor armor = new Armor("mail", ArmorType.CLOTH, 0, Slot.BODY, armorAtt);
         int expectedStrength = 1 + 5;
         wiz.equip(armor);
         assertEquals(expectedStrength, wiz.totalAttributes().getStrength());
     }
 
     @Test
     public void total_dexterity_calculation_one_armor(){
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
        Wizard wiz = new Wizard("Mia");
         Armor armor = new Armor("mail", ArmorType.CLOTH, 0, Slot.BODY, armorAtt);
         int expectedDexterity = 1 + 4;
         wiz.equip(armor);
         assertEquals(expectedDexterity, wiz.totalAttributes().getDexterity());
     }
 
     @Test
     public void total_intelligence_calculation_one_armor(){
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
        Wizard wiz = new Wizard("Mia");
         Armor armor = new Armor("mail", ArmorType.CLOTH, 0, Slot.BODY, armorAtt);
         int expectedIntelligence = 8 + 3;
         wiz.equip(armor);
         assertEquals(expectedIntelligence, wiz.totalAttributes().getIntelligence());
     }

                 /**
     * Testing correct calculation of attributes with two pieces of armor
     */

     @Test
    public void total_strength_calculation_two_armor(){
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
        Wizard wiz = new Wizard("Mia");
        Armor armor1 = new Armor("mail", ArmorType.CLOTH, 0, Slot.BODY, armorAtt);
        Armor armor2 = new Armor("mail", ArmorType.CLOTH, 0, Slot.HEAD, armorAtt);
        int expectedStrength = 1 + 5 + 5;
        wiz.equip(armor1);
        wiz.equip(armor2);
        assertEquals(expectedStrength, wiz.totalAttributes().getStrength());
    }

     @Test
    public void total_dexterity_calculation_two_armor(){
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
        Wizard wiz = new Wizard("Mia");
        Armor armor1 = new Armor("mail", ArmorType.CLOTH, 0, Slot.BODY, armorAtt);
        Armor armor2 = new Armor("mail", ArmorType.CLOTH, 0, Slot.HEAD, armorAtt);
        int expectedDexterity = 1 + 4 + 4;
        wiz.equip(armor1);
        wiz.equip(armor2);
        assertEquals(expectedDexterity, wiz.totalAttributes().getDexterity());
    }

         @Test
    public void total_intelligence_calculation_two_armor(){
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
        Wizard wiz = new Wizard("Mia");
        Armor armor1 = new Armor("mail", ArmorType.CLOTH, 0, Slot.BODY, armorAtt);
        Armor armor2 = new Armor("mail", ArmorType.CLOTH, 0, Slot.HEAD, armorAtt);
        int expectedIntelligence = 8 + 3 + 3;
        wiz.equip(armor1);
        wiz.equip(armor2);
        assertEquals(expectedIntelligence, wiz.totalAttributes().getIntelligence());
    }

    /**
     * Testing correct calculation of attributes with replaced piece of armor
     */

     @Test
    public void total_strength_calculation_replaced_armor(){
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
        Wizard wiz = new Wizard("Mia");
        Armor armor1 = new Armor("mail", ArmorType.CLOTH, 0, Slot.BODY, armorAtt);
        Armor armor2 = new Armor("mail", ArmorType.CLOTH, 0, Slot.BODY, armorAtt);
        int expectedStrength = 1 + 5;
        wiz.equip(armor1);
        wiz.equip(armor2);
        assertEquals(expectedStrength, wiz.totalAttributes().getStrength());
    }

     @Test
    public void total_dexterity_calculation_replaced_armor(){
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
        Wizard wiz = new Wizard("Mia");
        Armor armor1 = new Armor("mail", ArmorType.CLOTH, 0, Slot.BODY, armorAtt);
        Armor armor2 = new Armor("mail", ArmorType.CLOTH, 0, Slot.BODY, armorAtt);
        int expectedDexterity = 1 + 4;
        wiz.equip(armor1);
        wiz.equip(armor2);
        assertEquals(expectedDexterity, wiz.totalAttributes().getDexterity());
    }

     @Test
    public void total_intelligence_calculation_replaced_armor(){
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
        Wizard wiz = new Wizard("Mia");
        Armor armor1 = new Armor("mail", ArmorType.CLOTH, 0, Slot.BODY, armorAtt);
        Armor armor2 = new Armor("mail", ArmorType.CLOTH, 0, Slot.BODY, armorAtt);
        int expectedIntelligence = 8 + 3;
        wiz.equip(armor1);
        wiz.equip(armor2);
        assertEquals(expectedIntelligence, wiz.totalAttributes().getIntelligence());
    }

                /**
     * Testing calculation of hero damage 
     */

     @Test
     public void calculating_correct_hero_damage_no_equipments(){
        Wizard wiz = new Wizard("Mia");
         double expectedDamage = 1;
         double delta = 0.0001;
         assertEquals(expectedDamage, wiz.damage(), delta);
     }
 
       @Test
     public void calculating_correct_hero_damage_weapon_equipped(){
        Wizard wiz = new Wizard("Mia");
         Weapon weapon = new Weapon("staff", WeaponType.STAFFS, 0, 22);
         double expectedDamage = 23.76;
         wiz.equip(weapon);
         double delta = 0.01;
         assertEquals(expectedDamage, wiz.damage(), delta);
     }
 
       @Test
     public void calculating_correct_hero_damage_weapon_replaced(){
        Wizard wiz = new Wizard("Mia");
         Weapon weapon1 = new Weapon("staff", WeaponType.STAFFS, 0, 22);
         Weapon weapon2 = new Weapon("staff", WeaponType.STAFFS, 0, 35);
         double expectedDamage = 37.8;
         wiz.equip(weapon1);
         wiz.equip(weapon2);
         double delta = 0.01;
         assertEquals(expectedDamage, wiz.damage(), delta);
     }
 
       @Test
     public void calculating_correct_hero_damage_weapon_armor_equipped(){
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
        Wizard wiz = new Wizard("Mia");
         Weapon weapon = new Weapon("staff", WeaponType.STAFFS, 0, 22);
         Armor armor = new Armor("mail", ArmorType.CLOTH, 0, Slot.BODY, armorAtt);
         double expectedDamage = 24.42;
         wiz.equip(weapon);
         wiz.equip(armor);
         double delta = 0.01;
         assertEquals(expectedDamage, wiz.damage(), delta);
     }
    
}
