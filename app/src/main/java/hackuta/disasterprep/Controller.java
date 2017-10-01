package hackuta.disasterprep;

import android.content.Context;
import android.location.Location;

import java.util.ArrayList;


import hackuta.disasterprep.model.*;

/**
 * Created by sdarnell on 9/30/2017.
 */

public class Controller {
    private DatabaseHelper dbHelper;

    public Controller(Context context){
        dbHelper = new DatabaseHelper(context);
    }

    public ArrayList<Item> getList(Location loc){
        //returns applicable disaster kit for location
        return null;
    }

    public boolean ChangeItemCount(int listId, Item item){
        return false;
    }

    public boolean AddItem(int listId, Item item){
        return false;
    }

    public boolean RemoveItem(int listId, String item){
        return false;
    }

    public boolean AddList(int listId, ArrayList<Item> items){
        return false;
    }

    public boolean RemoveList(int listId){
        return false;
    }


}
