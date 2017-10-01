package hackuta.disasterprep;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import hackuta.disasterprep.model.Item;
import hackuta.disasterprep.model.PrepList;

import static android.R.id.message;
import static hackuta.disasterprep.R.id.fab;


public class MainActivity extends AppCompatActivity implements ErrorListener{
    protected Controller controller;
    DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
  //      setSupportActionBar(toolbar);
        ControllerFactory.SetContext(this);
        controller = ControllerFactory.getController();
        controller.ListenForError(this);

        //writing defaults to database

        PrepList example =  new PrepList();
        db.writeItemList(example.populateNecessaryItem());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           //     Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
             //           .setAction("Action", null).show();

                CustomDialog customDialog =new CustomDialog(this);
                customDialog .show();

            }
        });



        /*
        ListView list = (ListView)(findViewById(R.id.list_view));
        ArrayAdapter<Item> itemArrayAdapter = new ArrayAdapter<Item>(this, android.R.layout.simple_expandable_list_item_1, controller.getList());
        list.setAdapter(itemArrayAdapter); */

        refreshScreen();


    }

    public void onAddItem(View v) {

        EditText NewItem = (EditText) findViewById(R.id.addNewItem);
        String itemText = NewItem.getText().toString();
        if(itemText != null) {
            Item newitem = new Item(itemText);

            db.additem(newitem);

            refreshScreen();
        }
        else{
            Toast.makeText(this, "Please enter a new item to be added.", Toast.LENGTH_SHORT).show();
        }
        NewItem.setText("");
    }

    public void refreshScreen(){
        // Create the adapter to convert the array to views
        ItemAdapter adapter = new ItemAdapter(this, controller.getList());
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }



    public void handleError(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
