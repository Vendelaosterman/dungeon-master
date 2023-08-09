package noroff.dungeon;
import noroff.dungeon.heroes.types.Swashbuckler;

// Entry point of the application

public class Main {
    
    public static void main(String[] args){
        Swashbuckler swash = new Swashbuckler("Arthur");
        swash.display();
    }
}
