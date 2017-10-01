package hackuta.disasterprep.model;


/**
 * Created by sdarnell on 9/30/2017.
 */

public class Item {
    String name;
    int amount;
    String disaster;

    public String getDisaster() {
        return disaster;
    }

    public void setDisaster(String disaster) {
        this.disaster = disaster;
    }



    public Item(String name){
        this.name = name;
        this.amount = 0;
        this.disaster = "necessary";
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
