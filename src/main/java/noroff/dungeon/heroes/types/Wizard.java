package noroff.dungeon.heroes.types;
import noroff.dungeon.heroes.Hero;
import noroff.dungeon.util.HeroAttribute;

public class Wizard extends Hero {

    public Wizard(String name){
        super(name);
        levelAttributes = new HeroAttribute(1, 1, 8);
    }

    public static void main(String[] args){

    }

    @Override
    public void levelUp(){
        super.levelUp();
        levelAttributes.increaseAttributes(1, 1, 5);
    }
}