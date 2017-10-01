package hackuta.disasterprep;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import hackuta.disasterprep.model.Item;

public class MainActivity extends AppCompatActivity implements ErrorListener {

    protected Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ControllerFactory.SetContext(this);
        controller = ControllerFactory.getController();
        controller.ListenForError(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ListView list = (ListView)(findViewById(R.id.list_view));
        ArrayAdapter<Item> itemArrayAdapter = new ArrayAdapter<Item>(this, android.R.layout.simple_expandable_list_item_1, controller.getList());
        list.setAdapter(itemArrayAdapter);


    }

    public void handleError(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
