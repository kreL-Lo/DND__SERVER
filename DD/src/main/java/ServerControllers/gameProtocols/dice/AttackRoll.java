package ServerControllers.gameProtocols.dice;

import com.google.gson.internal.$Gson$Preconditions;
import com.mongodb.util.JSON;
import controllers.CharacterController;
import controllers.LobbyController;
import controllers.UserController;
import jdk.nashorn.internal.parser.JSONParser;
import models.Character;
import models.Lobby;
import models.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import utils.DiceRoll;

import static ServerControllers.gameProtocols.dice.Dice.sumDice;

/*

DICE + ACTION => RESULT
 MODIFIER: STR / DEX
 PLAYER_ID:id_player
 MONSTER_ID:monster_id
 WEAPON:
 */
public class AttackRoll {
    public static JSONObject rollDice(JSONObject object){
        JSONArray jsonArray=null;
        String modifier=null;
        String id_player=null ;
        String roomName=null;
        try {
            jsonArray = (JSONArray) object.get("DICES");
            modifier = object.get("MODIFIER").toString();
            id_player = object.get("PLAYER_NAME").toString();
            roomName = object.get("ROOM_NAME").toString();
        }
        catch (Exception e) {
            return  failed();
        }
        Lobby lobby= LobbyController.findByName(roomName);
        User user = lobby.findUser(id_player);
        Character character = user.getCharacter();
        int sum=0;
        try {
            sum = sumDice(jsonArray);
        }
        catch (Exception e){
            return failed();
        }
        System.out.println(sum);
        int d=0 ;
        if(modifier.compareTo("STR")==0){
            d = character.getStrength();
        }
        else if(modifier.compareTo("DEX")==0){
            d=character.getDexterity();
        }
        sum+=(d-10)/2;
        //ACION ,
        return success(sum);
    }



    /*
    INPUT :{PROTOCOL
    DICES:[{n:1},{n:2},{n:3}],
            id_player:"some_id",
            ,monster_id:""
            actiune:"some_id",

    }
    ACTIUNI : OUT_OF_COMBAT
     */
    static JSONObject success(int sum){
        JSONObject object= new JSONObject();
        object.put("PROTOCOL","ACTION_ROLL");
        object.put("DICE_ROLL",sum);
        object.put("ANSWER","ROLLED SUCCESFULLY");
        object.put("SUCCESS",1);

        return object;
    }
    static JSONObject failed(){
        JSONObject object= new JSONObject();
        object.put("PROTOCOL","ACTION_ROLL");
        object.put("ANSWER","EXCEPTION, WRONG INPUT");
        object.put("SUCCESS",0);
        return object;
    }
}
