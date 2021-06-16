package Garage;

public class HiringPool {

    private String[] names = {"Ryan", "Alex", "David","Sarah","Amanda","Michael","Robert","Kayla","Rebecca","Lauren","Taylor"};
    private int nameCounter = 0;

    // Return a name from the names list. If the internal counter is at the length of the array reset it. 
    public String getName ()
    {
        String to_return = this.names [this.nameCounter];
        this.nameCounter++;
        if (this.nameCounter >= this.names.length) this.nameCounter = 0;
        return to_return;
    }

}
