package ServerControllers.gameProtocols.combat;

import models.Armor;
import models.Weapons;
import org.json.simple.JSONObject;
import utils.ArmorGenerator;
import utils.WeaponsGenerator;

public class SetWeaponArmor {
    public static JSONObject setWeaponArmor(JSONObject object){
        String id=null;
        String name = null;
        int type =0;
        String player =null;
        String roomname = null;
        JSONObject out= new JSONObject();
        try{
            id  =object.get("ID").toString();
            type =Integer.valueOf( object.get("TYPE").toString());
            name= object.get("NAME").toString();
            roomname = object.get("ROOM_NAME").toString();
            player = object.get("PLAYER_NAME").toString();
        }catch (Exception e ){
            taskFailled();
        }
        Weapons weapons =null;
        Armor armor = null;
        if(type==1){
            if(name.compareTo("DAGGER")==0){
                weapons=WeaponsGenerator.generateDagger(id);
            }else if (name.compareTo("CROSSBOW")==0){
                weapons =WeaponsGenerator.generateCrossbowLight(id);
            }else if (name.compareTo("DART")==0){
                weapons = WeaponsGenerator.generateDart(id);
            }else if (name.compareTo("SLING")==0){
                weapons = WeaponsGenerator.generateSling(id);
            }else if (name.compareTo("AXE")==0){
                weapons =WeaponsGenerator.generateBattleaxe(id);
            }else if (name.compareTo("GREATE_SWORD")==0){
                weapons=WeaponsGenerator.generateGreatSword(id);
            }else if (name.compareTo("LONG_SWORD")==0){
                weapons = WeaponsGenerator.generateLongsword(id);
            }else if (name.compareTo("HALBERD")==0){
                weapons =WeaponsGenerator.generateHalberd(id);
            }else if (name.compareTo("GUN")==0){
                weapons = WeaponsGenerator.generateBlowgun(id);
            }
            out.put("WEAPONS",weapons);
        }else{//padded, lader, studed_lader, hide, change_shirt, breast plate, half plate, ring male, plate, plint shield
            if(name.compareTo("PADDED")==0){
                armor = ArmorGenerator.generatePadded(id);
            }else if(name.compareTo("STUDDED_LEATHER")==0){
                armor = ArmorGenerator.generateStuddedLeather(id);
            }else if(name.compareTo("HIDE")==0){
                armor  = ArmorGenerator.generateHide(id);
            }else if(name.compareTo("CHAIN_SHIRT")==0){
                armor = ArmorGenerator.generateChainShirt(id);
            }else if(name.compareTo("BREAST_PLATE")==0){
                armor = ArmorGenerator.generateBreastPlate(id);
            }else if(name.compareTo("HALF_PLATE")==0){
                armor = ArmorGenerator.generateHalfPlate(id);
            }else if(name.compareTo("RING_MAIL")==0){
                armor = ArmorGenerator.generateRingMail(id);
            }else if(name.compareTo("PLATE")==0){
                armor = ArmorGenerator.generatePlate(id);
            }else if(name.compareTo("SPLINT")==0){
                armor = ArmorGenerator.generateSplint(id);
            }else if(name.compareTo("SHIELD")==0){
                armor = ArmorGenerator.generateShield(id);
            }
            out.put("ARMOR",armor);
        }//armor

        out.put("PROTOCOL","SPAWN_ENTITY");
        out.put("ANSWER","NPC UPDATED");
        out.put("SUCCESS",1);
        return out;
    }

    static JSONObject success(){
        JSONObject object= new JSONObject();
        object.put("PROTOCOL","SPAWN_ENTITY");
        object.put("ANSWER","NPC UPDATED");
        object.put("SUCCESS",1);
        return object;
    }
    static JSONObject taskFailled(){
        JSONObject object= new JSONObject();
        object.put("PROTOCOL","SPAWN_ENTITY");
        object.put("ANSWER","TASK FAILED SUCCESSFULLY");
        object.put("SUCCESS",0);
        return object;
    }

}
