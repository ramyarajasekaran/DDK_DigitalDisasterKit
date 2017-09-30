package hackuta.disasterprep;

import android.location.Location;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Arrays;


import hackuta.disasterprep.model.*;

/**
 * Created by sdarnell on 9/30/2017.
 */

public class MainController {

    private DatabaseHelper dbHelper = DatabaseHelper(this);



    public static ArrayList<Item> getList(Location loc){
        //returns applicable disaster kit for location
        return null;
    }

    public static boolean ChangeItemCount(int listId, Item item){
        return false;
    }

    public static boolean AddItem(int listId, Item item){
        return false;
    }

    public static boolean RemoveItem(int listId, String item){
        return false;
    }

    public static boolean AddList(int listId, ArrayList<Item> items){
        return false;
    }

    public static boolean RemoveList(int listId){
        return false;
    }


}
