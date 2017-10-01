package hackuta.disasterprep.model;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sdarnell on 9/30/2017.
 */

public class ExpirableItem extends Item{
    String expirDate;
   // private static DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    int amountPerPerson;
    String unitOfAmount;
    String updateMessage;

    public int getAmountPerPerson() {
        return amountPerPerson;
    }

    public void setAmountPerPerson(int amountPerPerson) {
        this.amountPerPerson = amountPerPerson;
    }

    public String getUnitOfAmount() {
        return unitOfAmount;
    }

    public void setUnitOfAmount(String unitOfAmount) {
        this.unitOfAmount = unitOfAmount;
    }

    public String getUpdateMessage() {
        return updateMessage;
    }

    public void setUpdateMessage(String updateMessage) {
        this.updateMessage = updateMessage;
    }



    public ExpirableItem(String name, String unit, String message) {
        super(name);
        unitOfAmount = unit;
        updateMessage = message;
        try {
            setExpirDate("03/10/2005");
        }
        catch(ParseException e){

        }
        setAmountPerPerson(0);

    }

    public void setExpirDate(String date)throws ParseException{
        expirDate = date;//formatter.parse(date);
    }

    public String/*Date*/ getExpirDate(){
        return this.expirDate;
    }
}