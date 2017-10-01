package hackuta.disasterprep;

import android.graphics.Typeface;
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


public class MainActivity /*extends AhoyOnboarderActivity*/ extends AppCompatActivity implements ErrorListener{
    protected Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        /*AhoyOnboarderCard ahoyOnboarderCard1 = new AhoyOnboarderCard("Contact us!", "Call these 24 hour hotlines for assistance", R.drawable.ic_phone);
        ahoyOnboarderCard1.setBackgroundColor(R.color.black_transparent);
        ahoyOnboarderCard1.setTitleColor(R.color.white);
        ahoyOnboarderCard1.setDescriptionColor(R.color.grey_200);
        ahoyOnboarderCard1.setTitleTextSize(dpToPixels(10, this));
        ahoyOnboarderCard1.setDescriptionTextSize(dpToPixels(8, this));
        ahoyOnboarderCard1.setIconLayoutParams(200, 400, 15, 10, 10, 10);

        AhoyOnboarderCard ahoyOnboarderCard2 = new AhoyOnboarderCard("Survival Kit", "Here's all the info you need to build your own survival kit", R.drawable.ic_list);
        ahoyOnboarderCard2.setBackgroundColor(R.color.black_transparent);
        ahoyOnboarderCard2.setTitleColor(R.color.white);
        ahoyOnboarderCard2.setDescriptionColor(R.color.grey_200);
        ahoyOnboarderCard2.setTitleTextSize(dpToPixels(10, this));
        ahoyOnboarderCard2.setDescriptionTextSize(dpToPixels(8, this));
        ahoyOnboarderCard2.setIconLayoutParams(200, 400, 15, 10, 10, 10);
        //iconWidth, iconHeight, marginTop, marginLeft, marginRight, marginBottom

        List<AhoyOnboarderCard> pages = new ArrayList<>();
        pages.add(ahoyOnboarderCard1);
        pages.add(ahoyOnboarderCard2);

        setOnboardPages(pages);

        setGradientBackground();
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        setFont(face);
*/
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
/*
    public void onFinishButtonPressed(){
        //literally don't know why we need to add this
        }
*/
    public void handleError(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
