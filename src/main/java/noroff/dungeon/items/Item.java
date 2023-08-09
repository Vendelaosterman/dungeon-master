package noroff.dungeon.items;

public abstract class Item {
    private String name;
    private int requiredLevel;
    private Slot slot;

    public Item(String name, Slot slot, int requiredLevel){
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.slot = slot;
    }

    //return name
    public String getName(){
        return name;
    }

    //return slot
    public Slot getSlot(){
        return slot;
    }

    //return required level 
    public int requiredLevel(){
        return requiredLevel;
    }
}
