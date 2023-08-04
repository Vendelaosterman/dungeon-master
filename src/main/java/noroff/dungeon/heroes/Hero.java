package noroff.dungeon.heroes;
import noroff.dungeon.items.Slot;
import noroff.dungeon.util.HeroAttribute;
import noroff.dungeon.items.Item;
import noroff.dungeon.items.weapon.Weapon;
import noroff.dungeon.items.weapon.WeaponType;
import noroff.dungeon.exceptions.InvalidWeaponException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Hero {

    public String name;
    protected int level = 1;
    protected HeroAttribute levelAttributes;
    //Equipment equipment;
    protected List<WeaponType> validWeaponTypes;
    protected List<String> validArmorTypes;
    protected HeroAttribute attribute;
    private Map<Slot, Item> equipment;

    public Hero(String name){
        this.name = name;
        initializeEquipment();

        //this.attribute = attributes;
        //this.equipment = new Equipment();
        //this.validWeaponTypes = new ArrayList<>();
        //this.validArmorTypes = new ArrayList<>();
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

    public void equip(Weapon weapon){

        if(weapon.requiredLevel() > this.level){
            throw new InvalidWeaponException("Hero level is too low to equip this item");
        }else if(!this.validWeaponTypes.contains(weapon.getWeaponType())){
             throw new InvalidWeaponException("Wrong weapon type");
        }  
        equipment.put(weapon.getSlot(), weapon);
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

