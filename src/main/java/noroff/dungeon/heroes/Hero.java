package noroff.dungeon.heroes;
import noroff.dungeon.items.Slot;
import noroff.dungeon.items.armor.Armor;
import noroff.dungeon.items.armor.ArmorType;
import noroff.dungeon.util.HeroAttribute;
import noroff.dungeon.items.Item;
import noroff.dungeon.items.weapon.Weapon;
import noroff.dungeon.items.weapon.WeaponType;
import noroff.dungeon.exceptions.InvalidArmorException;
import noroff.dungeon.exceptions.InvalidWeaponException;
import noroff.dungeon.heroes.types.Archer;
import noroff.dungeon.heroes.types.Barbarian;
import noroff.dungeon.heroes.types.Swashbuckler;
import noroff.dungeon.heroes.types.Wizard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Hero {

    public String name;
    public int level = 1;
    protected HeroAttribute levelAttributes;
    protected List<WeaponType> validWeaponTypes;
    protected List<ArmorType> validArmorTypes;
    protected HeroAttribute attribute;
    private Map<Slot, Item> equipment;

    public Hero(String name){
        this.name = name;
        initializeEquipment();
    }

    private void initializeEquipment() {
        equipment = new HashMap<>();
        equipment.put(Slot.HEAD, null);
        equipment.put(Slot.BODY,null);
        equipment.put(Slot.LEGS,null);
        equipment.put(Slot.WEAPON,null);
    }


    public void levelUp(){
        level++;
    }

    public void equip(Item item){

        if(item instanceof Weapon){
            Weapon weapon = (Weapon) item;
            if (!this.validWeaponTypes.contains(weapon.getWeaponType())) {
                throw new InvalidWeaponException("Wrong weapon type");
            }else if(item.requiredLevel() > this.level){
                throw new InvalidWeaponException("Hero level is too low to equip this item");
            }
        }

        if(item instanceof Armor){
            Armor armor = (Armor) item;
            if (!this.validArmorTypes.contains(armor.getArmorType())) {
                throw new InvalidArmorException("Wrong weapon type");
            }else if(item.requiredLevel() > this.level){
                throw new InvalidArmorException("Hero level is too low to equip this item");
            }
        }

        equipment.put(item.getSlot(), item);
    }

    public HeroAttribute totalAttributes(){
        int totalStrength = levelAttributes.getStrength();
        int totalDexterity = levelAttributes.getDexterity();
        int totalIntelligence = levelAttributes.getIntelligence();
    
        for (Item item : equipment.values()) {
            if (item instanceof Armor) {
                Armor armor = (Armor) item;
                HeroAttribute armorAttributes = armor.getArmorAttributes();
                totalStrength += armorAttributes.getStrength();
                totalDexterity += armorAttributes.getDexterity();
                totalIntelligence += armorAttributes.getIntelligence();
            }
        }
    
        return new HeroAttribute(totalStrength, totalDexterity, totalIntelligence);
    }

    public double damage(){
        double weaponDamage = 0.0;
        double damagingAttribute = 0.0;
        double totalDamage;

        Item equippedWeapon = equipment.get(Slot.WEAPON);
   
        if (equippedWeapon instanceof Weapon) {
            Weapon weapon = (Weapon) equippedWeapon;
            weaponDamage = weapon.getWeaponDamage();
        }

        HeroAttribute attributes = totalAttributes();
        if (this instanceof Barbarian) {
            damagingAttribute = attributes.getStrength();
        } else if (this instanceof Wizard) {
            damagingAttribute = attributes.getIntelligence();
        } else if (this instanceof Archer || this instanceof Swashbuckler) {
            damagingAttribute = attributes.getDexterity();
        }

        if(equippedWeapon == null){
           totalDamage = 1;
        }else{
           totalDamage = weaponDamage * (1 + damagingAttribute / 100);
        }


        return totalDamage;
    }

    public Item getEquippedWeapon(Slot slot) {
        return equipment.get(slot);
    }

    public void display(){
        System.out.println("Name: " + this.name);
        System.out.println("Class: " + this.getClass().getSimpleName());
        System.out.println("Level: " + this.level);
        System.out.println("Equipments: " + equipment);
        System.out.println("Total attributes: ");
        System.out.println("Strength: " + totalAttributes().getStrength());
        System.out.println("Dexterity: " + totalAttributes().getDexterity());
        System.out.println("Intelligence: " + totalAttributes().getIntelligence());
        System.out.println("Damage: " + damage());
    }
}

