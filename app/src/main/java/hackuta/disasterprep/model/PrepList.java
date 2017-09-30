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

        necessaryItems.add(new Item("Water: 14 gallons per person"));
        necessaryItems.add(new ExpirableItem("CannedFood"));
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

        necessaryItems.add(new Item("Contact Information Copy"));
        return necessaryItems;
    }
}




/*
Water - one gallon of water per person per day for at least three days, for drinking and sanitation
Food - at least a three-day supply of non-perishable food
Battery-powered or hand crank radio and a NOAA Weather Radio with tone alert
Flashlight
First aid kit
Extra batteries
Whistle to signal for help
Dust mask to help filter contaminated air and plastic sheeting and duct tape to shelter-in-place
Moist towelettes, garbage bags and plastic ties for personal sanitation
Wrench or pliers to turn off utilities
Manual can opener for food
Local maps
Cell phone with chargers and a backup battery
Download the Recommended Supplies List (PDF)

Prescription medications
Non-prescription medications such as pain relievers, anti-diarrhea medication, antacids or laxatives
Glasses and contact lense solution
Infant formula, bottles, diapers, wipes, diaper rash cream
Pet food and extra water for your pet
Cash or traveler's checks
Important family documents such as copies of insurance policies, identification and bank account records saved electronically or in a waterproof, portable container
Sleeping bag or warm blanket for each person
Complete change of clothing appropriate for your climate and sturdy shoes
Household chlorine bleach and medicine dropper to disinfect water
Fire extinguisher
Matches in a waterproof container
Feminine supplies and personal hygiene items
Mess kits, paper cups, plates, paper towels and plastic utensils
Paper and pencil
Books, games, puzzles or other activities for children
 */