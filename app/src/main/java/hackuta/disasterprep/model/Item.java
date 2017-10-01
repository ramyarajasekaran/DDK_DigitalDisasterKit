package hackuta.disasterprep.model;


/**
 * Created by sdarnell on 9/30/2017.
 */

public class Item {
    String name;
    int amount;

    public Item(String name){
        this.name = name;
        this.amount = 0;
    }

    public void editItemName(String newname){
        this.name = newname;
    }

    public void editItemAmount(int num){
        if((this.amount + num) < 1){ this.amount = 0; }
        else{
            this.amount += num;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}


