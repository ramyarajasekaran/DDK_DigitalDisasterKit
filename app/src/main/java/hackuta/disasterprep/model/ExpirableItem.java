package hackuta.disasterprep.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sdarnell on 9/30/2017.
 */

public class ExpirableItem extends Item{
    Date expirDate;
    private static DateFormat formatter = new SimpleDateFormat("d-MMM-yyyy,HH:mm:ss aaa");

    public ExpirableItem(String name) {
        super(name);
    }

    public void setExpirDate(String date)throws ParseException{
        expirDate = formatter.parse(date);
    }
}