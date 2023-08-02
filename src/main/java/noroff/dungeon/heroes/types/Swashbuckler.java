package noroff.dungeon.heroes.types;

import noroff.dungeon.heroes.Hero;
import noroff.dungeon.util.HeroAttribute;

public class Swashbuckler extends Hero {

    public Swashbuckler(String name){
        super(name);
        levelAttributes = new HeroAttribute(2, 6, 1);
    }

    public static void main(String[] args){

    }

    @Override
    public void levelUp(){
        this.level++;
        levelAttributes.increaseAttributes(1, 4, 1);
    }
}
