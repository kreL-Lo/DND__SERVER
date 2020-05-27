package ServerControllers;

import com.google.gson.JsonObject;
import com.mongodb.util.JSON;
import controllers.LobbyController;
import controllers.UserController;
import models.Lobby;
import models.User;
import org.json.simple.JSONObject;

public class SetCharacter {
    public static JSONObject setCharacter(JSONObject object){
        String playerName=null,character = null,roomName=null;
        try{
            playerName = object.get("PLAYER_NAME").toString();
            character = object.get("CHARACTER_NAME").toString();
            roomName= object.get("ROOM_NAME").toString();
        }
        catch (Exception e){
            return exception();
        }
        System.out.println(playerName);
        System.out.println(character);
        System.out.println(roomName);
        if(parseCharacter(character)==-1){
            return unkownClass();
        }
        Lobby lobby= LobbyController.findByName(roomName);
        User user = lobby.findUser(playerName);
        user.setCharacterName(character);
        LobbyController.update(lobby);
        JSONObject json = new JSONObject();
        json.put("PROTOCOL","SET_CHARACTER");
        json.put("ANSWER","CLASS HAS BEEN SET");
        json.put("SUCCES",1);
        return json;
    }




    static int parseCharacter(String character){
        if(character.compareTo("BARBAR")==0){
            return 1;
        }
        else if(character.compareTo("CLERIC")==0)
        {
            return 2;
        }
        else if(character.compareTo("FIGHTER")==0)
        {
            return 3;
        }
        else if(character.compareTo("PALADIN")==0)
        {
            return 4;
        }
        else if(character.compareTo("WARLOCK")==0)
        {
            return 5;
        }
        else if(character.compareTo("BARD")==0){
            return 6;
        }else if(character.compareTo("ROGUE")==0){
            return 7;
        }else if(character.compareTo("KNIGHT")==0) {
            return 8;
        }
        return -1;
    }


    public static JSONObject unkownClass(){
        JSONObject json = new JSONObject();
        json.put("PROTOCOL","SET_CHARACTER");
        json.put("SUCCES",0);
        json.put("ANSWER","NO KNOWN CHARACTER");
        return json;
    }
    static JSONObject unknowPlayer(){
        JSONObject json = new JSONObject();
        json.put("PROTOCOL","SET_CHARACTER");
        json.put("SUCCES",0);
        json.put("ANSWER","NO KNOWN PLAYER");
        return json;
    }
    static JSONObject exception(){
        JSONObject json = new JSONObject();
        json.put("PROTOCOL","SET_CHARACTER");
        json.put("SUCCES",0);
        json.put("ANSWER","EXCEPTION");
        return json;
    }
}
