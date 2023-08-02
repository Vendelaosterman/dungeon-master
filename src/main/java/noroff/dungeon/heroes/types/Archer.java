package noroff.dungeon.heroes.types;

import noroff.dungeon.heroes.Hero;
import noroff.dungeon.util.HeroAttribute;

public class Archer extends Hero {

    public Archer(String name){
        super(name);
        levelAttributes = new HeroAttribute(1, 7, 1);
    }

    public static void main(String[] args){

    }

    @Override
    public void levelUp(){
        this.level++;
        levelAttributes.increaseAttributes(1, 5, 1);
    }
}
