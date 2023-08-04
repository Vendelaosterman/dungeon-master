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

    public String getName(){
        return name;
    }

    public Slot getSlot(){
        return slot;
    }

    public int requiredLevel(){
        return requiredLevel;
    }
}
