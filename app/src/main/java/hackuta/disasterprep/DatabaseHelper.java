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
import static android.icu.lang.UCharacter.GraphemeClusterBreak.EXTEND;
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
    public void additem(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_NAME, item.getName());   // 0
        values.put(KEY_NUM, item.getAmount());  // 1

        if(item.getClass().equals(ExpirableItem.class)) {

              values.put(KEY_expirDate, ((ExpirableItem) item).getExpirDate().toString()); // 2
              values.put(KEY_amountPerPerson, (((ExpirableItem) item).getAmountPerPerson())); // 3
              values.put(KEY_unitOfAmount, ((ExpirableItem) item).getUnitOfAmount());  // 4
              values.put(KEY_updateMessage, ((ExpirableItem) item).getUpdateMessage()); // 5

        }else{
            values.put(KEY_expirDate, (String)null);
            values.put(KEY_amountPerPerson, (String)null);
            values.put(KEY_unitOfAmount, (String)null);
            values.put(KEY_updateMessage, (String)null);
        }

        // Inserting Row
        db.insert(TABLE_ITEMS, null, values);
        db.close(); // Closing database connection
    }

    // WRITING A LIST OF ITEMS
    public void writeItemList(ArrayList<Item> itemList){
        SQLiteDatabase db = this.getWritableDatabase();
        for(Item item : itemList){
                additem(item);
        }
    }
    // GETTING ALL ITEMS

    public ArrayList<Item> getAllItems() {
        ArrayList<Item> itemList = new ArrayList<Item>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ITEMS + ";";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        cursor.moveToFirst();

        // looping through all rows and adding to list
        while (!cursor.isAfterLast()) {

                Item item = (cursor.getString(2) == null) ? new Item(cursor.getString(0)) : new ExpirableItem(cursor.getString(0),cursor.getString(4),cursor.getString(5));
                item.setAmount(Integer.parseInt(cursor.getString(1)));

            // Only if item belongs to Expirableitem class do we extract ExpirDate/Unit/Amtperperson/Message
              if(item.getClass().equals(ExpirableItem.class)) {
                  try {
                    ((ExpirableItem) item).setExpirDate(cursor.getString(2));   // 2
                      ((ExpirableItem) item).setAmountPerPerson(Integer.parseInt(cursor.getString(3)));   // 3
                  }
                catch(ParseException exception){
                        // exception never thrown as all Expirable Items in DB have valid Expir Dates + AmountPerPerson
                }
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
    public void upgradeitem(Item new_item) throws ParseException{

        SQLiteDatabase db = this.getReadableDatabase();

        deleteitem(new_item);   //deleting old item with the same name

        additem(new_item);  //adding new item to db

        db.close();
    }

    // DELETING SINGLE ITEM
    public void deleteitem(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ITEMS, KEY_NAME + " = ?",
                new String[] { String.valueOf(item.getName())});
        db.close();
    }
}

