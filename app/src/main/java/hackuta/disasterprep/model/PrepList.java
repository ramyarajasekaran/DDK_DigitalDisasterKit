package hackuta.disasterprep.model;

import java.util.ArrayList;

/**
 * Created by sdarnell on 9/30/2017.
 */

public class PrepList {

    ArrayList<Item> necesaryItems = populateNecessaryItem();
    ArrayList<Item> extendedItems = populateExtendedItem();

    public ArrayList<Item> populateNecessaryItem(){
        ArrayList<Item> necessaryItems = new ArrayList<Item>();

        necessaryItems.add(new ExpirableItem("Water"));
        necessaryItems.add(new ExpirableItem("Canned Food"));
        necessaryItems.add(new Item("Flashlight"));
        necessaryItems.add(new Item("Whistle"));
        necessaryItems.add(new Item("Emergency Blanket"));
        necessaryItems.add(new Item("Cash / Local Currency"));
        necessaryItems.add(new ExpirableItem("Batteries"));
        necessaryItems.add(new Item("Battery Powered Radio"));
        necessaryItems.add(new Item("Multi-purpose Tool"));
        necessaryItems.add(new Item("Hand Sanitizer"));
        necessaryItems.add(new Item("Soap"));
        necessaryItems.add(new Item("Medication List Copy"));
        necessaryItems.add(new Item("Proof of Address"));
        necessaryItems.add(new Item("Home Deed/Lease"));
        necessaryItems.add(new Item("Passports"));
        necessaryItems.add(new Item("Birth Certificate Copy"));
        necessaryItems.add(new Item("Insurance Policy Copy"));
        necessaryItems.add(new Item("Local Map"));
        necessaryItems.add(new Item("Contact Information Copy"));
        necessaryItems.add(new Item("Matches (in waterproof storage)"));
        necessaryItems.add(new Item("Towels"));
        necessaryItems.add(new Item("Scissors"));
        return necessaryItems;
    }

    public ArrayList<Item> populateExtendedItem(){
        ArrayList<Item> necessaryItems = new ArrayList<Item>();

        necessaryItems.add(new Item("Hearing Aids"));
        necessaryItems.add(new ExpirableItem("Contact Solution"));
        necessaryItems.add(new Item("Spare House Key"));
        necessaryItems.add(new ExpirableItem("Baby Food"));
        necessaryItems.add(new Item("Diapers"));
        necessaryItems.add(new ExpirableItem("Bottles"));
        necessaryItems.add(new Item("Formula"));
        necessaryItems.add(new Item("Two-way Radio"));
        necessaryItems.add(new Item("Manual Can Opener"));
        necessaryItems.add(new Item("Rain Coat"));
        necessaryItems.add(new Item("Work Gloves"));
        necessaryItems.add(new Item("Duct Tape"));
        necessaryItems.add(new Item("Plastic Sheeting"));
        necessaryItems.add(new Item("Liquid Bleach"));
        necessaryItems.add(new Item("Sleeping Bags"));
        necessaryItems.add(new Item("Pillows"));

        return necessaryItems;
    }
}
