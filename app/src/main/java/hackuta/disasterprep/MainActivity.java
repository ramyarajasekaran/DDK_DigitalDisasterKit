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

/**
 * Created by ramya on 10/1/2017.
 */

public class MainActivity extends AppCompatActivity implements  ErrorListener{

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    protected Controller controller;
    final Context context = this;
    DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ControllerFactory.SetContext(this);
        controller = ControllerFactory.getController();
        controller.ListenForError(this);

        //writing defaults to database

        String options[] = {"FLOOD", "FIRE", "EARTHQUAKE", "EXTENDED"};

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_list_item, options);
        final ListView listView = (ListView) findViewById(R.id.MenuList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String selectedFromList = (listView.getItemAtPosition(position)).toString();

                Intent intent = new Intent(getIntent());

                intent.putExtra(EXTRA_MESSAGE, selectedFromList);
                startActivity(intent);

            }
        });

    }



    public void handleError(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

