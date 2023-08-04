package noroff.dungeon.heroes;
import noroff.dungeon.items.Slot;
import noroff.dungeon.items.armor.Armor;
import noroff.dungeon.items.armor.ArmorType;
import noroff.dungeon.util.HeroAttribute;
import noroff.dungeon.items.Item;
import noroff.dungeon.items.weapon.Weapon;
import noroff.dungeon.items.weapon.WeaponType;
import noroff.dungeon.exceptions.InvalidWeaponException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Hero {

    public String name;
    protected int level = 1;
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
            if (!this.validArmorTypes.contains(armor.getWeaponType())) {
                throw new InvalidWeaponException("Wrong weapon type");
            }else if(item.requiredLevel() > this.level){
                throw new InvalidWeaponException("Hero level is too low to equip this item");
            }
        }

        equipment.put(item.getSlot(), item);
    }

    public void damage(){

    }

    public void totalAttributes(){

    }

    public void display(){
        System.out.println("Name: " + this.name);
        System.out.println("Level: " + this.level);
        System.out.println("Strength: " + levelAttributes.getStrength());
        System.out.println("Dexterity: " + levelAttributes.getDexterity());
        System.out.println("Intelligence: " + levelAttributes.getIntelligence());
        System.out.println("Equipments: " + equipment);
    }

     /*public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
    }*/
}

