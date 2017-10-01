package hackuta.disasterprep;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.ParseException;

import hackuta.disasterprep.model.ExpirableItem;
import hackuta.disasterprep.model.Item;
import hackuta.disasterprep.model.PrepList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;


public class SecondActivity extends AppCompatActivity implements ErrorListener{
    protected Controller controller;
    final Context context = this;
    DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Intent intent = getIntent();
        final String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        ControllerFactory.SetContext(this);
        controller = ControllerFactory.getController();
        controller.ListenForError(this);

        //writing defaults to database
        PrepList example =  new PrepList(message);

        db.writeItemList(example.getNecesaryItems());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           //     Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
             //           .setAction("Action", null).show();

                // get prompts.xml view
                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.custom_dialog, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                final EditText item_name = (EditText) promptsView.findViewById(R.id.NewItem);
                final EditText item_amount = (EditText) promptsView.findViewById(R.id.NewAmount);
                final EditText item_app = (EditText) promptsView.findViewById(R.id.NewAmountPerPerson);
                final EditText item_uofamt = (EditText) promptsView.findViewById(R.id.NewunitofAmount);
                final EditText item_msg = (EditText) promptsView.findViewById(R.id.NewMessage);
                final EditText item_exp = (EditText) promptsView.findViewById(R.id.Newexp);


                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);

                // set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("Submit",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        // get user input and set it to result
                                        // edit text

                                        Item item = (item_exp == null)? new Item(item_name.getText().toString()) : new ExpirableItem(item_name.getText().toString(),item_amount.getText().toString(),item_msg.getText().toString());

                                        item.setDisaster(message);

                                        if(item.getClass().equals(ExpirableItem.class)) {
                                            try {
                                                ((ExpirableItem) item).setExpirDate(item_exp.getText().toString()); // 2
                                            }
                                            catch(ParseException e){

                                            }
                                            ((ExpirableItem) item).setAmountPerPerson(Integer.parseInt(item_app.getText().toString())); // 3
                                        }

                                        DatabaseHelper db = new DatabaseHelper(context);
                                        db.additem(item);
                                        db.close();
                                    }
                                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
              alertDialog.show();

            }

        });

          refreshScreen();

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
