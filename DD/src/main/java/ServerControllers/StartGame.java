package ServerControllers;

import DAO.DMDAO;
import controllers.CharacterController;
import controllers.LobbyController;
import controllers.UserController;
import models.Character;
import models.DM;
import models.Lobby;
import models.User;
import org.bson.types.ObjectId;
import org.json.simple.JSONObject;

import java.util.List;

public class StartGame {

    public static JSONObject start(JSONObject object) {
        String roomName=null;
        String playerName=null;
        try {
            roomName = object.get("ROOM_NAME").toString();
            playerName = object.get("PLAYER_NAME").toString();
        }catch (Exception e){
            return exceptionHandler();
        }

        Lobby l = LobbyController.findByName(roomName);
        l.setDungeonMaster(playerName);
        List<User> playerList = l.getUserList();
        for(User p : playerList){
            System.out.println(p.getCharacterName());
            Character c = CharacterController.createCharacter(p.getCharacterName());
            p.setCharacter(c);
        }
        l.setUserList(playerList);
        DM dm = new DM();
        dm.setUsername(l.getDungeonMaster());
        l.setDm(dm);
        LobbyController.update(l);

        JSONObject json = new JSONObject();
        json.put("PROTOCOL", "START_GAME");
        json.put("SUCCESS", 1);
        json.put("ANSWER", "GAME STARTED");
        //SendToPlayers.sendToMore(playerList,json);
        return json;
    }


    static JSONObject noDungeonMaster(){
        JSONObject json = new JSONObject();
        json.put("PROTOCOL", "START_GAME");
        json.put("SUCCESS", 0);
        json.put("ANSWER", "NO SET DUNGEON MASTER");
        return json;
    }
    static JSONObject invalidDungeonMaster(){
        JSONObject json = new JSONObject();
        json.put("PROTOCOL", "START_GAME");
        json.put("SUCCESS", 0);
        json.put("ANSWER", "NO VALID DUNGEON MASTER");
        return json;
    }



    static ObjectId parseCharacter(String character) {
        if(character.compareTo("Barabarian")==0){
            return CharacterController.createCharacterBarbarian();
        }
        else if(character.compareTo("Cleric")==0)
        {
            return CharacterController.createCharacterCleric();
        }
        else if(character.compareTo("Fighter")==0)
        {
            return CharacterController.createCharacterFighter();
        }
        else if(character.compareTo("Paladin")==0)
        {
            return CharacterController.createCharacterPaladin();
        }
        else if(character.compareTo("Warlock")==0)
        {
            return CharacterController.createCharacterWarlock();
        }
        return null;
    }
    static public JSONObject nullError(){
        JSONObject json = new JSONObject();
        json.put("PROTOCOL","START_GAME");
        json.put("SUCCES",0);
        json.put("ANSWER","NOT ALL USERS HAVE SET THEIR CLASS");
        return json;
    }
    static JSONObject exceptionHandler() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("PROTOCOL", "START_GAME");
        jsonObject.put("SUCCESS", 0);
        jsonObject.put("ANSWER", "EXCEPTION ");
        return jsonObject;
    }
}




