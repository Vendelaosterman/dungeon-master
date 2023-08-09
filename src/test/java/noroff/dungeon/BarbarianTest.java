package noroff.dungeon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import noroff.dungeon.exceptions.InvalidArmorException;
import noroff.dungeon.exceptions.InvalidWeaponException;
import noroff.dungeon.heroes.types.Barbarian;
import noroff.dungeon.items.Slot;
import noroff.dungeon.items.armor.Armor;
import noroff.dungeon.items.armor.ArmorType;
import noroff.dungeon.items.weapon.Weapon;
import noroff.dungeon.items.weapon.WeaponType;
import noroff.dungeon.util.HeroAttribute;

public class BarbarianTest {

    /**
     * Testing correct name, level and attributes
     */

    @Test
    public void test_correct_name(){
        Barbarian barb = new Barbarian("Billie");
        String expectedName = "Billie";
        assertEquals(expectedName, barb.name);
    }

    @Test
    public void test_correct_level(){
        Barbarian barb = new Barbarian("Billie");
        int expectedLevel = 1;
        assertEquals(expectedLevel, barb.level);
    }

    @Test
    public void test_correct_init_strength(){
        Barbarian barb = new Barbarian("Billie");
        int expectedStrength = 5;
        assertEquals(expectedStrength, barb.totalAttributes().getStrength());
    }

    @Test
    public void test_correct_init_dexterity(){
        Barbarian barb = new Barbarian("Billie");
        int expectedDexterity = 2;
        assertEquals(expectedDexterity, barb.totalAttributes().getDexterity());
    }

    @Test
    public void test_correct_init_intelligence(){
        Barbarian barb = new Barbarian("Billie");
        int expectedIntelligence = 1;
        assertEquals(expectedIntelligence, barb.totalAttributes().getIntelligence());
    }

    /**
     * Testing expected level when leveling up 
     */

     @Test
    public void test_level_increase(){
        Barbarian barb = new Barbarian("Billie");
        int expectedLevel = 2;
        barb.levelUp();
        assertEquals(expectedLevel, barb.level);
    }

    /**
     * Testing attributes when leveling up 
     */

     @Test
    public void test_correct_levelUp_strength(){
        Barbarian barb = new Barbarian("Billie");
        barb.levelUp();
        int expectedStrength = 8;
        assertEquals(expectedStrength, barb.totalAttributes().getStrength());
    }

    @Test
    public void test_correct_levelUp_dexterity(){
        Barbarian barb = new Barbarian("Billie");
        barb.levelUp();
        int expectedDexterity = 4;
        assertEquals(expectedDexterity, barb.totalAttributes().getDexterity());
    }

    @Test
    public void test_correct_levelUp_intelligence(){
        Barbarian barb = new Barbarian("Billie");
        barb.levelUp();
        int expectedIntelligence = 2;
        assertEquals(expectedIntelligence, barb.totalAttributes().getIntelligence());
    }

             /**
     * Testing if InvalidWeaponException is thrown when required weapon level is too high with valid weapon type
     */

     @Test(expected = InvalidWeaponException.class) 
     public void invalid_level_equip_weapon_wizard(){
        Barbarian barb = new Barbarian("Billie");
        Weapon validWeaponInvalidLevel = new Weapon("staff", WeaponType.HATCHETS, 5, 22);
         barb.equip(validWeaponInvalidLevel);
     }
 
              /**
      * Testing if InvalidWeaponException is thrown width valid level and invalid weapon type
      */
 
     @Test(expected = InvalidWeaponException.class) 
     public void invalid_weapon_equip_weapon_wizard(){
        Barbarian barb = new Barbarian("Billie");
        Weapon validLevelInvalidWeapon = new Weapon("staff", WeaponType.DAGGERS, 0, 22);
         barb.equip(validLevelInvalidWeapon);
     }


                       /**
     * Testing if InvalidArmorException is thrown when required armor level is too high with valid armor type
     */

    @Test(expected = InvalidArmorException.class) 
    public void invalid_level_equip_armor(){
        Barbarian barb = new Barbarian("Billie");
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
        Armor validArmorInvalidLevel = new Armor("mail", ArmorType.PLATE, 5, Slot.BODY, armorAtt);
        barb.equip(validArmorInvalidLevel);
    }

         /**
     * Testing if InvalidArmorException is thrown with wrong ArmorType and right required level for all heros
     */

    @Test(expected = InvalidArmorException.class) 
    public void invalid_armor_equip_armor(){
        Barbarian barb = new Barbarian("Billie");
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
        Armor validLevelInvalidAmor = new Armor("mail", ArmorType.CLOTH, 0, Slot.BODY, armorAtt);
        barb.equip(validLevelInvalidAmor);
    }

          /**
     * Testing if hero can equip weapon with valid weapon type 
     */

    @Test
    public void valid_weaponType_equip(){
        Barbarian barb = new Barbarian("Billie");
        Weapon expectedWeapon = new Weapon("staff", WeaponType.HATCHETS, 0, 22);
        barb.equip(expectedWeapon);
        assertEquals(expectedWeapon, barb.getEquippedWeapon(Slot.WEAPON));
    }

        /**
     * Testing if hero can equip armor with valid armor type 
     */

     @Test
    public void valid_armorType_equip(){
        Barbarian barb = new Barbarian("Billie");
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
        Armor expectedArmor = new Armor("mail", ArmorType.MAIL, 0, Slot.BODY, armorAtt);
        barb.equip(expectedArmor);
        assertEquals(expectedArmor, barb.getEquippedWeapon(Slot.BODY));
    }

        /**
     * Testing correct calculation of attributes with one armor
     */

     @Test
     public void total_strength_calculation_one_armor(){
        Barbarian barb = new Barbarian("Billie");
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
        Armor armor = new Armor("mail", ArmorType.MAIL, 0, Slot.BODY, armorAtt);
        int expectedStrength = 5 + 5;
        barb.equip(armor);
        assertEquals(expectedStrength, barb.totalAttributes().getStrength());
     }
 
     @Test
     public void total_dexterity_calculation_one_armor(){
        Barbarian barb = new Barbarian("Billie");
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
        Armor armor = new Armor("mail", ArmorType.MAIL, 0, Slot.BODY, armorAtt);
        int expectedDexterity = 2 + 4;
        barb.equip(armor);
        assertEquals(expectedDexterity, barb.totalAttributes().getDexterity());
     }
 
     @Test
     public void total_intelligence_calculation_one_armor(){
        Barbarian barb = new Barbarian("Billie");
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
        Armor armor = new Armor("mail", ArmorType.MAIL, 0, Slot.BODY, armorAtt);
        int expectedIntelligence = 1 + 3;
        barb.equip(armor);
        assertEquals(expectedIntelligence, barb.totalAttributes().getIntelligence());
     }

       /**
     * Testing correct calculation of attributes with two pieces of armor
     */

     @Test
    public void total_strength_calculation_two_armor(){
        Barbarian barb = new Barbarian("Billie");
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
        Armor armor1 = new Armor("mail", ArmorType.MAIL, 0, Slot.BODY, armorAtt);
        Armor armor2 = new Armor("mail", ArmorType.MAIL, 0, Slot.HEAD, armorAtt);
        int expectedStrength = 5 + 5 + 5;
        barb.equip(armor1);
        barb.equip(armor2);
        assertEquals(expectedStrength, barb.totalAttributes().getStrength());
    }

     @Test
    public void total_dexterity_calculation_two_armor(){
        Barbarian barb = new Barbarian("Billie");
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
        Armor armor1 = new Armor("mail", ArmorType.MAIL, 0, Slot.BODY, armorAtt);
        Armor armor2 = new Armor("mail", ArmorType.MAIL, 0, Slot.HEAD, armorAtt);
        int expectedDexterity = 2 + 4 + 4;
        barb.equip(armor1);
        barb.equip(armor2);
        assertEquals(expectedDexterity, barb.totalAttributes().getDexterity());
    }

    @Test
    public void total_intelligence_calculation_two_armor(){
        Barbarian barb = new Barbarian("Billie");
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
        Armor armor1 = new Armor("mail", ArmorType.MAIL, 0, Slot.BODY, armorAtt);
        Armor armor2 = new Armor("mail", ArmorType.MAIL, 0, Slot.HEAD, armorAtt);
        int expectedIntelligence = 1 + 3 + 3;
        barb.equip(armor1);
        barb.equip(armor2);
        assertEquals(expectedIntelligence, barb.totalAttributes().getIntelligence());
    }

    /**
     * Testing correct calculation of attributes with replaced piece of armor
     */

     @Test
    public void total_strength_calculation_replaced_armor(){
        Barbarian barb = new Barbarian("Billie");
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
        Armor armor1 = new Armor("mail", ArmorType.MAIL, 0, Slot.BODY, armorAtt);
        Armor armor2 = new Armor("mail", ArmorType.MAIL, 0, Slot.BODY, armorAtt);
        int expectedStrength = 5 + 5;
        barb.equip(armor1);
        barb.equip(armor2);
        assertEquals(expectedStrength, barb.totalAttributes().getStrength());
    }

     @Test
    public void total_dexterity_calculation_replaced_armor(){
        Barbarian barb = new Barbarian("Billie");
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
        Armor armor1 = new Armor("mail", ArmorType.MAIL, 0, Slot.BODY, armorAtt);
        Armor armor2 = new Armor("mail", ArmorType.MAIL, 0, Slot.BODY, armorAtt);
        int expectedDexterity = 2 + 4;
        barb.equip(armor1);
        barb.equip(armor2);
        assertEquals(expectedDexterity, barb.totalAttributes().getDexterity());
    }

     @Test
    public void total_intelligence_calculation_replaced_armor(){
        Barbarian barb = new Barbarian("Billie");
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
        Armor armor1 = new Armor("mail", ArmorType.MAIL, 0, Slot.BODY, armorAtt);
        Armor armor2 = new Armor("mail", ArmorType.MAIL, 0, Slot.BODY, armorAtt);
        int expectedIntelligence = 1 + 3;
        barb.equip(armor1);
        barb.equip(armor2);
        assertEquals(expectedIntelligence, barb.totalAttributes().getIntelligence());
    }

        /**
     * Testing calculation of hero damage 
     */

     @Test
     public void calculating_correct_hero_damage_no_equipments(){
        Barbarian barb = new Barbarian("Billie");
         double expectedDamage = 1;
         double delta = 0.0001;
         assertEquals(expectedDamage, barb.damage(), delta);
     }
 
       @Test
     public void calculating_correct_hero_damage_weapon_equipped(){
        Barbarian barb = new Barbarian("Billie");
         Weapon weapon = new Weapon("staff", WeaponType.HATCHETS, 0, 22);
         double expectedDamage = 23.1;
         barb.equip(weapon);
         double delta = 0.01;
         assertEquals(expectedDamage, barb.damage(), delta);
     }
 
       @Test
     public void calculating_correct_hero_damage_weapon_replaced(){
        Barbarian barb = new Barbarian("Billie");
         Weapon weapon1 = new Weapon("staff", WeaponType.HATCHETS, 0, 22);
         Weapon weapon2 = new Weapon("staff", WeaponType.HATCHETS, 0, 35);
         double expectedDamage = 36.75;
         barb.equip(weapon1);
         barb.equip(weapon2);
         double delta = 0.01;
         assertEquals(expectedDamage, barb.damage(), delta);
     }
 
       @Test
     public void calculating_correct_hero_damage_weapon_armor_equipped(){
        Barbarian barb = new Barbarian("Billie");
        HeroAttribute armorAtt = new HeroAttribute(5, 4, 3);
         Weapon weapon = new Weapon("staff", WeaponType.HATCHETS, 0, 22);
         Armor armor = new Armor("mail", ArmorType.MAIL, 0, Slot.BODY, armorAtt);
         double expectedDamage = 24.2;
         barb.equip(weapon);
         barb.equip(armor);
         double delta = 0.01;
         assertEquals(expectedDamage, barb.damage(), delta);
     }
    
}
