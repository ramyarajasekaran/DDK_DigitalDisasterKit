package hackuta.disasterprep.model;


/**
 * Created by sdarnell on 9/30/2017.
 */

public class Item {
    String name;
    int num;

    public Item(String name){
        this.name = name;
        num=0;
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


