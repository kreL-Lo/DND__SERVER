package ServerControllers.gameProtocols.dice;

import DAO.UserDAO;
import models.Character;
import models.User;
import netscape.javascript.JSObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import static ServerControllers.gameProtocols.dice.Dice.sumDice;

/*
DICE + ACTION => RESULT
 MODIFIER:

 */
public class AbilityCheck {
    public static JSONObject checkRoll(JSONObject object){
        JSONArray jsonArray=null;
        String ability=null;
        String username=null;
        try {
            jsonArray = (JSONArray) object.get("DICES");
            ability= object.get("ABILITY").toString();
            username=object.get("USERNAME").toString();
        }
        catch (Exception e) {
            return exceptionHandler();
        }
        int sum = sumDice(jsonArray);
        System.out.println(jsonArray);
        User user = UserDAO.findUser(username);
        Character character = user.getCharacter();
        ////action
        int mod=0;
        if(ability.compareTo("STR")==0){

            mod = character.getStrength();
        }else if( ability.compareTo("DEX")==0){
            mod =character.getDexterity();
        }else if( ability.compareTo("CON")==0) {
            mod =character.getConstitution();
        }else if( ability.compareTo("INT")==0){
            mod =character.getIntelligence();
        }else if( ability.compareTo("WIS")==0) {
            mod =character.getWisdom();
        }else if( ability.compareTo("CHA")==0) {
            mod =character.getCharisma();
        }
        sum += (mod-10)/2;
        return success(sum);
    }
    static JSONObject success(int value){
        JSONObject object= new JSONObject();

        object.put("PROTOCOL","ABILITY_CHECK");
        object.put("SUCCESS",1);
        return object;
    }
    static private JSONObject exceptionHandler() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("PROTOCOL", "ABILITY_CHECK");
        jsonObject.put("SUCCESS", 0);
        return jsonObject;
    }
}