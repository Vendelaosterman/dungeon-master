package noroff.dungeon;
import noroff.dungeon.heroes.types.Wizard;

public class Main {
    
    public static void main(String[] args){
        Wizard wiz = new Wizard("Arthur");
        wiz.levelUp();
        wiz.display();

    }
}
