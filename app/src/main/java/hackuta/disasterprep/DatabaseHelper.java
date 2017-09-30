package hackuta.disasterprep;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Date;

import hackuta.disasterprep.model.ExpirableItem;
import hackuta.disasterprep.model.Item;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by ramya on 9/30/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "PrepList";

    // PrepList table name
    private static final String TABLE_ITEMS = "items";

    // PrepList Column names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_NUM = "num";
    private static final String KEY_expirDate = "expirDate";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);
        String CREATE_ITEMS_TABLE = "CREATE TABLE " + TABLE_ITEMS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_NUM + " INTEGER," + KEY_expirDate + "DATE"+ ")";
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
        values.put(KEY_NAME, item.getName());
        values.put(KEY_NUM, item.getNum());
        values.put(KEY_expirDate,(item.getExpirDate().toString()));


        // Inserting Row
        db.insert(TABLE_ITEMS, null, values);
        db.close(); // Closing database connection
    }

    //GETTING A SINGLE ITEM
    public Todo getSingleItem(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NOTES, new String[] { KEY_ID,
                        KEY_TODO, KEY_TAG }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Todo todo = new Todo(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return contact

        return todo ;
    }

    // GETTING ALL ITEMS

    public ArrayList<ExpirableItem> getAllItems(String tag) {
        ArrayList<ExpirableItem> itemList = new ArrayList<ExpirableItem>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ITEMS + ";";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        cursor.moveToFirst();

        // looping through all rows and adding to list
        while (!cursor.isAfterLast()) {

            ExpirableItem item = new ExpirableItem();
            item.set_id(Integer.parseInt(cursor.getString(0)));
            todo.setNote(cursor.getString(1));
            todo.setTag(cursor.getString(2));

            // Adding contact to list
            noteList.add(todo);
            cursor.moveToNext();

        }

        cursor.close();
        // return contact list
        return noteList;
    }

    // Deleting single todo
    public void deletetodo(Todo todo) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NOTES, KEY_ID + " = ?",
                new String[] { String.valueOf(todo.get_id())});
        db.close();
    }
}
}
