package noroff.dungeon.heroes;
import noroff.dungeon.util.HeroAttribute;

import java.util.ArrayList;
import java.util.List;

public abstract class Hero {

    public String name;
    protected int level = 1;
    protected HeroAttribute levelAttributes;
    //Equipment equipment;
    protected List<String> validWeaponTypes;
    protected List<String> validArmorTypes;
    protected HeroAttribute attribute;

    public Hero(String name){
        this.name = name;

        //this.attribute = attributes;
        //this.equipment = new Equipment();
        //this.validWeaponTypes = new ArrayList<>();
        //this.validArmorTypes = new ArrayList<>();
    }

    public void levelUp(){
        level++;
    }

    public void equip(){

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
    }

     /*public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
    }*/
}

