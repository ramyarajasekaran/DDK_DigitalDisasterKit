package hackuta.disasterprep;

import android.content.Context;
import android.location.Location;

import java.text.ParseException;
import java.util.ArrayList;


import hackuta.disasterprep.model.*;

/**
 * Created by sdarnell on 9/30/2017.
 */

public class Controller {
    private DatabaseHelper dbHelper;
    public Event<String> RaistToast;

    public Controller(Context context){
        dbHelper = new DatabaseHelper(context);
    }

    public ArrayList<Item> getList(){
        return dbHelper.getAllItems();
    }

    public boolean ChangeItemCount(Item item){
        try {
            dbHelper.upgradeitem(item);
        }catch(ParseException){

        }
    }

    public void AddItem(Item item){
        dbHelper.additem(item);
    }

    public void RemoveItem(Item item){
        dbHelper.deleteitem(item);
    }
}
