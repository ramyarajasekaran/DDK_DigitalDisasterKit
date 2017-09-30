package hackuta.disasterprep;

import android.location.Location;

import java.util.ArrayList;
import java.util.Arrays;

import hackuta.disasterprep.model.*;

/**
 * Created by sdarnell on 9/30/2017.
 */

public class MainController {
    private static ArrayList<Item> defaultList;

    public static ArrayList<Item> getList(){
        if(defaultList == null){
            setUpDefaultList();
        }
        //return default list
        return null;
    }

    private static void setUpDefaultList() {
        defaultList = new ArrayList<Item>();
        defaultList.add(new Item("item1"));
        defaultList.add(new ExpirableItem("item2"));
    }

    public static ArrayList<Item> getList(Location loc){
        //returns applicable disaster kit for location
        return null;
    }


}
