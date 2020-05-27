package ServerControllers.gameProtocols.player;

import com.google.gson.Gson;
import controllers.LobbyController;
import models.Character;
import models.Lobby;
import models.User;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class GetCharacterSheet {
    static public JSONObject getCharacterSheet(JSONObject object){
        JSONObject json = new JSONObject();
        String playerId,roomName;
        try{
            playerId = object.get("PLAYER_NAME").toString();
            roomName = object.get("ROOM_NAME").toString();
        }catch (Exception e){
            return exception();
        }
        Lobby l = LobbyController.findByName(roomName);

        User u = l.getUserFromList(playerId);
        Character c = u.getCharacter();


        JSONObject object1 = new JSONObject();
        int atributes[]= new int[6];
        atributes[0]=c.getStrength();
        atributes[1]=c.getDexterity();
        atributes[2]=c.getConstitution();
        atributes[3]=c.getWisdom();
        atributes[4]=c.getIntelligence();
        atributes[5]=c.getCharisma();
        for(int i =0;i<6;i++){
            atributes[i]=(atributes[i]-10)/2;
        }
        try {
            object1.put("STR", atributes[0]);
            object1.put("DEX", atributes[1]);
            object1.put("CON", atributes[2]);
            object1.put("WIS", atributes[3]);
            object1.put("INT", atributes[4]);
            object1.put("CHA", atributes[5]);
            object1.put("ARMOR_CLASS", c.getArmourClass());
            object1.put("HITPOINTS", c.getHitPointMaximum());
            object1.put("SPEED", c.getSpeed());
            object1.put("USERNAME", playerId);
            object.put("RACE", c.getRace());
            object.put("CLASS", u.getCharacterName());
            object.put("LEVEL", c.getLevel());
        }
        catch (Exception e ){
            return exceptionParse();
        }
        return succes(object1);
    }

    static private JSONObject succes(JSONObject obj){
        JSONObject json = new JSONObject();
        json.put("PROTOCOL", "GET_CHARACHTER_SHEET");
        json.put("SUCCESS", 1);
        json.put("ANSWER", "Dungeon Master Set Successfully");
        json.put("CHARACTER",obj);
        return json;
    }

    static private JSONObject exception(){
        JSONObject json = new JSONObject();
        json.put("PROTOCOL", "GET_CHARACHTER_SHEET");
        json.put("SUCCESS", 0);
        json.put("ANSWER", "BAD INPUT");
        return json;
    }
    static private JSONObject exceptionParse(){
        JSONObject json = new JSONObject();
        json.put("PROTOCOL", "SOME ERROR FOR DATA");
        json.put("SUCCESS", 0);
        json.put("ANSWER", "BAD INPUT");
        return json;
    }

}
