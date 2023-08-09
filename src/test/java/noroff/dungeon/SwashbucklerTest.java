package noroff.dungeon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import noroff.dungeon.exceptions.InvalidArmorException;
import noroff.dungeon.exceptions.InvalidWeaponException;
import noroff.dungeon.heroes.types.Swashbuckler;
import noroff.dungeon.items.Slot;
import noroff.dungeon.items.armor.Armor;
import noroff.dungeon.items.armor.ArmorType;
import noroff.dungeon.items.weapon.Weapon;
import noroff.dungeon.items.weapon.WeaponType;
import noroff.dungeon.util.HeroAttribute;

public class SwashbucklerTest {

    /**
     * Testing correct name, level and attributes for Archer
     */

    @Test
    public void test_correct_name(){
        Swashbuckler swash = new Swashbuckler("Henry");
        String expectedName = "Henry";
        assertEquals(expectedName, swash.name);
    }

    @Test
    public void test_correct_level(){
        Swashbuckler swash = new Swashbuckler("Henry");
        int expectedLevel = 1;
        assertEquals(expectedLevel, swash.level);
    }

    @Test
    public void test_correct_init_strength(){
        Swashbuckler swash = new Swashbuckler("Henry");
        int expectedStrength = 2;
        assertEquals(expectedStrength, swash.totalAttributes().getStrength());
    }

    @Test
    public void test_correct_init_dexterity(){
        Swashbuckler swash = new Swashbuckler("Henry");
        int expectedDexterity = 6;
        assertEquals(expectedDexterity, swash.totalAttributes().getDexterity());
    }

    @Test
    public void test_correct_init_intelligence(){
        Swashbuckler swash = new Swashbuckler("Henry");
        int expectedIntelligence = 1;
        assertEquals(expectedIntelligence, swash.totalAttributes().getIntelligence());
    }

    /**
     * Testing expected level when leveling up 
     */

     @Test
    public void test_level_increase(){
        Swashbuckler swash = new Swashbuckler("Henry");
        int expectedLevel = 2;
        swash.levelUp();
        assertEquals(expectedLevel, swash.level);
    }

    /**
     * Testing attributes when leveling up 
     */

     @Test
    public void test_correct_levelUp_strength(){
        Swashbuckler swash = new Swashbuckler("Henry");
        swash.levelUp();
        int expectedStrength = 3;
        assertEquals(expectedStrength, swash.totalAttributes().getStrength());
    }

    @Test
    public void test_correct_levelUp_dexterity(){
        Swashbuckler swash = new Swashbuckler("Henry");
        swash.levelUp();
        int expectedDexterity = 10;
        assertEquals(expectedDexterity, swash.totalAttributes().getDexterity());
    }

    @Test
    public void test_correct_levelUp_intelligence(){
        Swashbuckler swash = new Swashbuckler("Henry");
        swash.levelUp();
        int expectedIntelligence = 2;
        assertEquals(expectedIntelligence, swash.totalAttributes().getIntelligence());
    }

             /**
     * Testing if InvalidWeaponException is thrown when required weapon level is too high with valid weapon type
     */

    @Test(expected = InvalidWeaponException.class) 
    public void invalid_level_equip_weapon_wizard(){
        Swashbuckler swash = new Swashbuckler("Henry");
        Weapon validWeaponInvalidLevel = new Weapon("staff", WeaponType.DAGGERS, 5, 22);
        swash.equip(validWeaponInvalidLevel);
    }

      /**
     * Testing if InvalidWeaponException is thrown width valid level and invalid weapon type
     */

    @Test(expected = InvalidWeaponException.class) 
    public void invalid_weapon_equip_weapon_wizard(){
        Swashbuckler swash = new Swashbuckler("Henry");
        Weapon validLevelInvalidWeapon = new Weapon("staff", WeaponType.MACES, 0, 22);
        swash.equip(validLevelInvalidWeapon);
    }

      /**
     * Testing if InvalidArmorException is thrown when required armor level is too high with valid armor type
     */

    @Test(expected = InvalidArmorException.class) 
    public void invalid_level_equip_armor(){
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
        Armor validArmorInvalidLevel = new Armor("mail", ArmorType.MAIL, 5, Slot.BODY, armorAtt);
        Swashbuckler swash = new Swashbuckler("Henry");
        swash.equip(validArmorInvalidLevel);
    }

         /**
     * Testing if InvalidArmorException is thrown with wrong ArmorType and right required level for all heros
     */

    @Test(expected = InvalidArmorException.class) 
    public void invalid_armor_equip_armor(){
        Swashbuckler swash = new Swashbuckler("Henry");
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
        Armor validLevelInvalidAmor = new Armor("mail", ArmorType.CLOTH, 0, Slot.BODY, armorAtt);
        swash.equip(validLevelInvalidAmor);
    }

              /**
     * Testing if hero can equip weapon with valid weapon type 
     */

     @Test
     public void valid_weaponType_equip(){
        Swashbuckler swash = new Swashbuckler("Henry");
         Weapon expectedWeapon = new Weapon("staff", WeaponType.DAGGERS, 0, 22);
         swash.equip(expectedWeapon);
         assertEquals(expectedWeapon, swash.getEquippedWeapon(Slot.WEAPON));
     }
 
         /**
      * Testing if hero can equip armor with valid armor type 
      */
 
      @Test
     public void valid_armorType_equip(){
        Swashbuckler swash = new Swashbuckler("Henry");
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
         Armor expectedArmor = new Armor("mail", ArmorType.LEATHER, 0, Slot.BODY, armorAtt);
         swash.equip(expectedArmor);
         assertEquals(expectedArmor, swash.getEquippedWeapon(Slot.BODY));
     }

             /**
     * Testing correct calculation of attributes with one armor
     */

     @Test
     public void total_strength_calculation_one_armor(){
        Swashbuckler swash = new Swashbuckler("Henry");
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
         Armor armor = new Armor("mail", ArmorType.LEATHER, 0, Slot.BODY, armorAtt);
         int expectedStrength = 2 + 5;
         swash.equip(armor);
         assertEquals(expectedStrength, swash.totalAttributes().getStrength());
     }
 
 
     @Test
     public void total_dexterity_calculation_one_armor(){
        Swashbuckler swash = new Swashbuckler("Henry");
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
         Armor armor = new Armor("mail", ArmorType.LEATHER, 0, Slot.BODY, armorAtt);
         int expectedDexterity = 6 + 4;
         swash.equip(armor);
         assertEquals(expectedDexterity, swash.totalAttributes().getDexterity());
     }
 
     @Test
     public void total_intelligence_calculation_one_armor(){
        Swashbuckler swash = new Swashbuckler("Henry");
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
         Armor armor = new Armor("mail", ArmorType.LEATHER, 0, Slot.BODY, armorAtt);
         int expectedIntelligence = 1 + 3;
         swash.equip(armor);
         assertEquals(expectedIntelligence, swash.totalAttributes().getIntelligence());
     }

            /**
     * Testing correct calculation of attributes with two pieces of armor
     */

     @Test
    public void total_strength_calculation_two_armor(){
        Swashbuckler swash = new Swashbuckler("Henry");
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
        Armor armor1 = new Armor("mail", ArmorType.LEATHER, 0, Slot.BODY, armorAtt);
        Armor armor2 = new Armor("mail", ArmorType.LEATHER, 0, Slot.HEAD, armorAtt);
        int expectedStrength = 2 + 5 + 5;
        swash.equip(armor1);
        swash.equip(armor2);
        assertEquals(expectedStrength, swash.totalAttributes().getStrength());
    }

     @Test
    public void total_dexterity_calculation_two_armor(){
        Swashbuckler swash = new Swashbuckler("Henry");
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
        Armor armor1 = new Armor("mail", ArmorType.LEATHER, 0, Slot.BODY, armorAtt);
        Armor armor2 = new Armor("mail", ArmorType.LEATHER, 0, Slot.HEAD, armorAtt);
        int expectedDexterity = 6 + 4 + 4;
        swash.equip(armor1);
        swash.equip(armor2);
        assertEquals(expectedDexterity, swash.totalAttributes().getDexterity());
    }

         @Test
    public void total_intelligence_calculation_two_armor(){
        Swashbuckler swash = new Swashbuckler("Henry");
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
        Armor armor1 = new Armor("mail", ArmorType.LEATHER, 0, Slot.BODY, armorAtt);
        Armor armor2 = new Armor("mail", ArmorType.LEATHER, 0, Slot.HEAD, armorAtt);
        int expectedIntelligence = 1 + 3 + 3;
        swash.equip(armor1);
        swash.equip(armor2);
        assertEquals(expectedIntelligence, swash.totalAttributes().getIntelligence());
    }

    /**
     * Testing correct calculation of attributes with replaced piece of armor
     */

     @Test
    public void total_strength_calculation_replaced_armor(){
        Swashbuckler swash = new Swashbuckler("Henry");
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
        Armor armor1 = new Armor("mail", ArmorType.LEATHER, 0, Slot.BODY, armorAtt);
        Armor armor2 = new Armor("mail", ArmorType.LEATHER, 0, Slot.BODY, armorAtt);
        int expectedStrength = 2 + 5;
        swash.equip(armor1);
        swash.equip(armor2);
        assertEquals(expectedStrength, swash.totalAttributes().getStrength());
    }

     @Test
    public void total_dexterity_calculation_replaced_armor(){
        Swashbuckler swash = new Swashbuckler("Henry");
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
        Armor armor1 = new Armor("mail", ArmorType.LEATHER, 0, Slot.BODY, armorAtt);
        Armor armor2 = new Armor("mail", ArmorType.LEATHER, 0, Slot.BODY, armorAtt);
        int expectedDexterity = 6 + 4;
        swash.equip(armor1);
        swash.equip(armor2);
        assertEquals(expectedDexterity, swash.totalAttributes().getDexterity());
    }

     @Test
    public void total_intelligence_calculation_replaced_armor(){
        Swashbuckler swash = new Swashbuckler("Henry");
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
        Armor armor1 = new Armor("mail", ArmorType.LEATHER, 0, Slot.BODY, armorAtt);
        Armor armor2 = new Armor("mail", ArmorType.LEATHER, 0, Slot.BODY, armorAtt);
        int expectedIntelligence = 1 + 3;
        swash.equip(armor1);
        swash.equip(armor2);
        assertEquals(expectedIntelligence, swash.totalAttributes().getIntelligence());
    }

            /**
     * Testing calculation of hero damage 
     */

     @Test
     public void calculating_correct_hero_damage_no_equipments(){
        Swashbuckler swash = new Swashbuckler("Henry");
         double expectedDamage = 1;
         double delta = 0.0001;
         assertEquals(expectedDamage, swash.damage(), delta);
     }
 
       @Test
     public void calculating_correct_hero_damage_weapon_equipped(){
        Swashbuckler swash = new Swashbuckler("Henry");
         Weapon weapon = new Weapon("staff", WeaponType.DAGGERS, 0, 22);
         double expectedDamage = 23.32;
         swash.equip(weapon);
         double delta = 0.01;
         assertEquals(expectedDamage, swash.damage(), delta);
     }
 
       @Test
     public void calculating_correct_hero_damage_weapon_replaced(){
        Swashbuckler swash = new Swashbuckler("Henry");
         Weapon weapon1 = new Weapon("staff", WeaponType.DAGGERS, 0, 22);
         Weapon weapon2 = new Weapon("staff", WeaponType.DAGGERS, 0, 35);
         double expectedDamage = 37.1;
         swash.equip(weapon1);
         swash.equip(weapon2);
         double delta = 0.01;
         assertEquals(expectedDamage, swash.damage(), delta);
     }
 
       @Test
     public void calculating_correct_hero_damage_weapon_armor_equipped(){
        Swashbuckler swash = new Swashbuckler("Henry");
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
         Weapon weapon = new Weapon("staff", WeaponType.DAGGERS, 0, 22);
         Armor armor = new Armor("mail", ArmorType.LEATHER, 0, Slot.BODY, armorAtt);
         double expectedDamage = 24.2;
         swash.equip(weapon);
         swash.equip(armor);
         double delta = 0.01;
         assertEquals(expectedDamage, swash.damage(), delta);
     }
    
}
