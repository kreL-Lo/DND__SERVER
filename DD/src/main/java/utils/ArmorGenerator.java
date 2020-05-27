package utils;

import javafx.application.Application;
import javafx.stage.Stage;

public class ArmorGenerator {
    public static models.Armor generatePadded(String id){
        models.Armor padded = new models.Armor("padded", "Light Armour", id, 50, 11, "dex modifier", 0, 8 );
        return padded;
    }
    public static models.Armor generateLeather(String id){
        models.Armor leather = new models.Armor("leather", "Light Armour", id, 100, 11, "dex modifier", 0, 10 );
        return leather;
    }
    public static models.Armor generateStuddedLeather(String id){
        models.Armor studdedLeather = new models.Armor("studded leather", "Light Armour", id, 450, 12, "dex modifier", 0, 13 );
        return studdedLeather;
    }
    public static models.Armor generateHide(String id){
        models.Armor hide = new models.Armor("hide", "Medium Armour", id, 100, 12, "dex modifier-max2", 0, 12 );
        return hide;
    }
    public static models.Armor generateChainShirt(String id){
        models.Armor chainShirt = new models.Armor("chain shirt", "Medium Armour", id, 500, 13, "dex modifier-max2", 0, 20 );
        return chainShirt;
    }
    public static models.Armor generateBreastPlate(String id){
        models.Armor breastPlate = new models.Armor("breast plate", "Medium Armour", id, 4000, 14, "dex modifier-max2", 0, 20 );
        return breastPlate;
    }
    public static models.Armor generateHalfPlate(String id){
        models.Armor halfPlate = new models.Armor("half plate", "Medium Armour", id, 7500, 15, "dex modifier-max2", 0, 40 );
        return halfPlate;
    }
    public static models.Armor generateRingMail(String id){
        models.Armor ringMail = new models.Armor("ring mail", "Heavy Armour", id, 300, 14, " ", 0, 40 );
        return ringMail;
    }
    public static models.Armor generatePlate(String id){
        models.Armor plate = new models.Armor("plate", "Heavy Armour", id, 150000, 18, " ", 15, 65 );
        return plate;
    }
    public static models.Armor generateSplint(String id){
        models.Armor splint = new models.Armor("splint", "Heavy Armour", id, 2000, 17, " ", 15, 60 );
        return splint;
    }
    public static models.Armor generateShield(String id){
        models.Armor shield = new models.Armor("shield", "Shield", id, 100, 2, " ", 0, 6);
        return shield;
    }

}
