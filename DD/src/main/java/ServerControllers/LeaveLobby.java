package ServerControllers;

import DAO.LobbyDAO;
import controllers.LobbyController;
import controllers.UserController;
import models.Lobby;
import models.User;
import org.json.simple.JSONObject;

import java.util.List;

public class LeaveLobby {
    public static JSONObject leaveLobby(JSONObject object) {

        String roomName, playerName;
        try {
            roomName = object.get("ROOM_NAME").toString();
            playerName = object.get("PLAYER_NAME").toString();
        } catch (Exception e) {
            return exceptionHandler();
        }
        Lobby lobby = LobbyController.findByName(roomName);
        User user =lobby.findUser(playerName);
        lobby.removeUser(user);
        LobbyController.update(lobby);
        return succes();
    }

    static private JSONObject exceptionHandler() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("PROTOCOL", "LEAVE_LOBBY");
        jsonObject.put("SUCCESS", 0);
        jsonObject.put("ANSWER", "INVALID DATA");
        return jsonObject;
    }
    static private JSONObject succes() {
        JSONObject json = new JSONObject();
        json.put("PROTOCOL", "LEAVE_LOBBY");
        json.put("SUCCESS", "1");
        json.put("ANSWER", "Tasked failed succesfully");
        return json;
    }
}
