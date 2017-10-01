package hackuta.disasterprep.model;

import java.util.ArrayList;

/**
 * Created by sdarnell on 9/30/2017.
 */

public class PrepList {

    ArrayList<Item> necesaryItems = populateNecessaryItem();
    ArrayList<Item> extendedItems = populateExtendedItem();
    ArrayList<Item> floodItems = populateFloodItem();
    ArrayList<Item> carItems = populateCarItem();
    ArrayList<Item> earthquakeItems = populateEarthquakeItem();
    ArrayList<Item> fireItems = populateFireItem();

    public ArrayList<Item> populateNecessaryItem(){
        ArrayList<Item> necessaryItems = new ArrayList<Item>();

        necessaryItems.add(new ExpirableItem("Water", "gallons", "Replace water every 6 months")); //6 months
        necessaryItems.add(new ExpirableItem("Canned Food", "cans", "Check label for expiration date"));
        necessaryItems.add(new Item("Flashlight"));
        necessaryItems.add(new Item("Whistle"));
        necessaryItems.add(new Item("Emergency Blanket"));
        necessaryItems.add(new Item("Cash / Local Currency"));
        necessaryItems.add(new ExpirableItem("Batteries", "batteries", "Check battery for use by year"));
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
        necessaryItems.add(new ExpirableItem("Matches", "boxes", "Check for degradation every year"));
        necessaryItems.add(new Item("Candles"));
        necessaryItems.add(new Item("Scissors"));

        return necessaryItems;
    }

    public ArrayList<Item> populateExtendedItem(){
        ArrayList<Item> necessaryItems = new ArrayList<Item>();
        necessaryItems.add(new Item("Toilet Paper"));
        necessaryItems.add(new Item("Toothbrush and Toothpaste"));
        necessaryItems.add(new Item("Hearing Aids"));
        necessaryItems.add(new ExpirableItem("Contact Solution", "bottles", "Check label for expiration date"));
        necessaryItems.add(new Item("Spare House Key"));
        necessaryItems.add(new ExpirableItem("Baby Food", "jars", "Check label for expiration date"));
        necessaryItems.add(new Item("Diapers"));
        necessaryItems.add(new Item("Bottles"));
        necessaryItems.add(new ExpirableItem("Formula", "packages", "Check label for use by date"));
        necessaryItems.add(new Item("Two-way Radio"));
        necessaryItems.add(new Item("Manual Can Opener"));
        necessaryItems.add(new Item("Rain Coat"));
        necessaryItems.add(new Item("Work Gloves"));
        necessaryItems.add(new Item("Duct Tape"));
        necessaryItems.add(new Item("Plastic Sheeting"));
        necessaryItems.add(new Item("Liquid Bleach"));
        necessaryItems.add(new Item("Sleeping Bags"));
        necessaryItems.add(new Item("Pillows"));
        necessaryItems.add(new Item("Tampons"));
        necessaryItems.add(new Item("Maxi Pads"));
        necessaryItems.add(new ExpirableItem("Pet Food", "pounds", "Check label for expiration date"));
        necessaryItems.add(new Item("Dog Poop Bags"));

        return necessaryItems;
    }

    public ArrayList<Item> populateCarItem(){
        ArrayList<Item> necessaryItems = new ArrayList<Item>();
        necessaryItems.add(new Item("Jumper Cables"));
        necessaryItems.add(new Item("Small Mirror"));
        necessaryItems.add(new Item("Paper Towels"));
        necessaryItems.add(new Item("Emergency Signal Device"));
        necessaryItems.add(new Item("Road Flare"));
        necessaryItems.add(new Item("Ice Scraper"));
        necessaryItems.add(new Item("Battery Powered Fan"));
        return necessaryItems;
    }

    public ArrayList<Item> populateFloodItem(){
        ArrayList<Item> necessaryItems = new ArrayList<Item>();

        necessaryItems.add(new Item("Rain Gear"));
        necessaryItems.add(new Item("Plastic Bags"));
        necessaryItems.add(new Item("Manual Car Key"));
        necessaryItems.add(new Item("Trash Bags"));
        necessaryItems.add(new Item("Tarp"));
        necessaryItems.add(new Item("Thermometer"));
        necessaryItems.add(new Item("Rope"));
        necessaryItems.add(new Item("Axe"));
        return necessaryItems;
    }

    public ArrayList<Item> populateEarthquakeItem(){
        ArrayList<Item> necessaryItems = new ArrayList<Item>();

        necessaryItems.add(new Item("Sunscreen"));
        necessaryItems.add(new Item("Sunglasses"));
        necessaryItems.add(new Item("Signal Flare"));
        necessaryItems.add(new Item("Bandage Strips"));
        necessaryItems.add(new Item("Adhesive Tape"));
        necessaryItems.add(new Item("Splinting Materials"));
        necessaryItems.add(new Item("Shovel"));

        return necessaryItems;
    }

    public ArrayList<Item> populateFireItem(){
        ArrayList<Item> necessaryItems = new ArrayList<Item>();

        necessaryItems.add(new Item("Fire Extinguisher: ABC Type"));
        necessaryItems.add(new Item("Flame Retardant Blanket"));
        necessaryItems.add(new Item("Fire Escape Ladder"));
        
        return necessaryItems;
    }
}
