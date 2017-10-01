package hackuta.disasterprep;

import android.app.Activity;
import android.app.Dialog;
import android.opengl.EGLDisplay;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;

import hackuta.disasterprep.model.ExpirableItem;
import hackuta.disasterprep.model.Item;

import static android.R.string.no;
import static android.R.string.yes;

/**
 * Created by ramya on 10/1/2017.
 */

public class CustomDialog extends Dialog {

    public Activity activity;
    public Dialog dialog;
    public Button submit;

    public CustomDialog(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.activity = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog);

        submit = (Button) findViewById(R.id.btn_submit);

        submit.setOnClickListener(new OnClickListener() {
            public void onClick(View v)
            {
                EditText item_name = (EditText) v.findViewById(R.id.NewItem);
                EditText item_amount = (EditText) v.findViewById(R.id.NewAmount);
                EditText item_app = (EditText) v.findViewById(R.id.NewAmountPerPerson);
                EditText item_uofamt = (EditText) v.findViewById(R.id.NewunitofAmount);
                EditText item_msg = (EditText) v.findViewById(R.id.NewMessage);
                EditText item_exp = (EditText) v.findViewById(R.id.Newexp);

                Item item = (item_exp == null)? new Item(item_name.toString()) : new ExpirableItem(item_name.toString(),item_amount.toString(),item_msg.toString());

                if(item.getClass().equals(ExpirableItem.class)) {
                    try {
                        ((ExpirableItem) item).setExpirDate(item_exp.toString()); // 2
                    }
                    catch(ParseException e){

                    }
                    ((ExpirableItem) item).setAmountPerPerson(Integer.parseInt(item_app.toString()); // 3
                }

                DatabaseHelper db = new DatabaseHelper(this);
                db.additem(item);
                db.close();
            }
        });

        }


}
