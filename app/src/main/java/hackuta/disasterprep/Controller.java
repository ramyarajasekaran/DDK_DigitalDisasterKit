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
    public ArrayList<ErrorListener> listeners = new ArrayList<ErrorListener>();

    public Controller(Context context){
        dbHelper = new DatabaseHelper(context);
    }

    public ArrayList<Item> getList(){
        return dbHelper.getAllItems();
    }

    public void ChangeItemCount(Item item){
        try {
            dbHelper.upgradeitem(item);
        }catch(ParseException exc){
            AlertListeners("Invalid date time encountered.");
        }
    }

    public void AddItem(Item item){
        dbHelper.additem(item);
    }

    public void RemoveItem(Item item){
        dbHelper.deleteitem(item);
    }

    public void ListenForError(ErrorListener listener){
        listeners.add(listener);
    }

    public void StopListeningForError(ErrorListener listener){
        listeners.remove(listener);
    }

    protected void AlertListeners(String message){
        for(ErrorListener listener : listeners){
            listener.handleError(message);
        }
    }
}
