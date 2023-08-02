package noroff.dungeon.heroes.types;

import noroff.dungeon.heroes.Hero;
import noroff.dungeon.util.HeroAttribute;

public class Barbarian extends Hero {

    public Barbarian(String name){
        super(name);
        levelAttributes = new HeroAttribute(5, 2, 1);
    }

    public static void main(String[] args){

    }

    @Override
    public void levelUp(){
        this.level++;
        levelAttributes.increaseAttributes(3, 2, 1);
    }
}