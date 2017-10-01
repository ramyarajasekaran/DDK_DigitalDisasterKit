package hackuta.disasterprep;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import hackuta.disasterprep.model.ExpirableItem;
import hackuta.disasterprep.model.Item;

import static android.R.attr.id;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.provider.Contacts.SettingsColumns.KEY;

/**
 * Created by ramya on 9/30/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "PrepList";

    // PrepList table name
    private static final String TABLE_ITEMS = "items";

    // PrepList Column names

    private static final String KEY_NAME = "name";
    private static final String KEY_NUM = "num";
    private static final String KEY_expirDate = "expirDate";
    private static final String KEY_amountPerPerson = "amountPerPerson";
    private static final String KEY_unitOfAmount="unitOfAmount";
    private static final String KEY_updateMessage = "updateMessage";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);
        String CREATE_ITEMS_TABLE = "CREATE TABLE " + TABLE_ITEMS + "("
                + KEY_NAME + " TEXT PRIMARY KEY,"
                + KEY_NUM + " INTEGER," + KEY_expirDate + " DATE, "+ KEY_amountPerPerson +
                " TEXT, "+ KEY_unitOfAmount +" TEXT, "+KEY_updateMessage+" TEXT"+")";
        db.execSQL(CREATE_ITEMS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);

        // Create tables again
        onCreate(db);
    }

    //CRUD OPERATIONS

    //ADDING AN ITEM
    public void additem(ExpirableItem item) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, item.getName());   // 0
        values.put(KEY_NUM, item.getAmount());  // 1
        values.put(KEY_expirDate,(item.getExpirDate().toString())); // 2

        values.put(KEY_amountPerPerson,(item.getAmountPerPerson())); // 3
        values.put(KEY_unitOfAmount,(item.getUnitOfAmount()));  // 4
        values.put(KEY_updateMessage,(item.getUpdateMessage()));   //5


        // Inserting Row
        db.insert(TABLE_ITEMS, null, values);
        db.close(); // Closing database connection
    }

    // GETTING ALL ITEMS

    public ArrayList<ExpirableItem> getAllItems() {
        ArrayList<ExpirableItem> itemList = new ArrayList<ExpirableItem>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ITEMS + ";";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        cursor.moveToFirst();

        // looping through all rows and adding to list
        while (!cursor.isAfterLast()) {

            ExpirableItem item = new ExpirableItem(cursor.getString(0),cursor.getString(4),cursor.getString(5));
                                                    // NAME           ,  UNIT             ,    MESSAGE
            item.setAmount(Integer.parseInt(cursor.getString(1)));  // AMOUNT

            try {
                item.setExpirDate(cursor.getString(2)); //DATE
            }   // date must be in a certain format
            catch(ParseException exception){

            }
            // Adding item to list
            itemList.add(item);
            cursor.moveToNext();

        }

        cursor.close();
        db.close();

        // return items list
        return itemList;
    }
    //UPDATING SINGLE ITEM
    public void upgradeitem(ExpirableItem old_item) throws ParseException{

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_ITEMS, new String[] { KEY_NAME,
                        KEY_NUM, KEY_expirDate,KEY_amountPerPerson,KEY_unitOfAmount,KEY_updateMessage },
                        KEY_NAME + "=?",
                new String[] { String.valueOf(old_item.getName()) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        ExpirableItem new_item = new ExpirableItem(cursor.getString(0),cursor.getString(4),cursor.getString(5));
                                                // NAME           ,  UNIT             ,    MESSAGE
        new_item.setAmount(Integer.parseInt(cursor.getString(1)));  // AMOUNT

        try {
            new_item.setExpirDate(cursor.getString(2)); //DATE
        }   // date must be in a certain format
        catch(ParseException exception){

        }

        deleteitem(old_item);   //deleting old item

        additem(new_item);  //adding new item to db

        db.close();
    }

    // DELETING SINGLE ITEM
    public void deleteitem(ExpirableItem item) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ITEMS, KEY_NAME + " = ?",
                new String[] { String.valueOf(item.getName())});
        db.close();
    }
}

