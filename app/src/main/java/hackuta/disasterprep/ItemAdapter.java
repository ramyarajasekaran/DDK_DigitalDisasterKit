package hackuta.disasterprep;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

import hackuta.disasterprep.model.Item;

/**
 * Created by ramya on 10/1/2017.
 */

public class ItemAdapter extends ArrayAdapter<Item> {

    public ItemAdapter(Context context, ArrayList<Item> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        Item item = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_item_each, parent, false);
        }
        // Lookup view for data population
        TextView item_name = (TextView) convertView.findViewById(R.id.item_name);
        CheckBox check_box = (CheckBox) convertView.findViewById(R.id.checkBox);

        // Populate the data into the template view using the data object
        item_name.setText(item.getName());

        // Return the completed view to render on screen
        return convertView;
    }

}
