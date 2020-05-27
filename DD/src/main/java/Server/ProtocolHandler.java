package Server;

import ServerControllers.gameProtocols.combat.AttackProtocol;
import ServerControllers.gameProtocols.combat.SpawnEntity;
import ServerControllers.gameProtocols.dice.AttackRoll;
import ServerControllers.gameProtocols.player.GetCharacterSheet;
import org.json.simple.JSONObject;
import ServerControllers.*;

import java.net.Socket;

public class ProtocolHandler {
    //TAKES THE DATA AND PICKS A PROTOCOL ACCORDINGLY
    //returns a number for each protocol detected

    public static JSONObject parse(JSONObject object, Socket s) {
        //DEFINESTI PROTOCOALE
        String protocol = object.get("PROTOCOL").toString();
        System.out.println(object);
        if (protocol.compareTo("CREATE_LOBBY") == 0) {
            return CreateLobby.createLobby(object);
        } else if (protocol.compareTo("JOIN_LOBBY") == 0) {
            return JoinLobby.joinLobby(object);
        } else if (protocol.compareTo("SHOW_LOBBIES") == 0) {
            return new ShowLobbies().showLobbies(object);
        } else if (protocol.compareTo("SET_DM") == 0) {
            return setDM.setDM(object);
        } else if (protocol.compareTo("START_GAME") == 0) {
            return StartGame.start(object);
        }else if(protocol.compareTo("SET_CHARACTER")==0) {
            return SetCharacter.setCharacter(object);
        }else if(protocol.compareTo("ACTION_ROLL")==0){
            return AttackRoll.rollDice(object);
        }else if(protocol.compareTo("LEAVE_LOBBY")==0){
            return LeaveLobby.leaveLobby(object);
        }
        else if(protocol.compareTo("ATTACK_PROTOCOL")==0){
            return AttackProtocol.attackProtocol(object);
        }
        else if(protocol.compareTo("SPAWN_ENTITY")==0){
            return SpawnEntity.spawnEntity(object);
        }
        else if(protocol.compareTo("GET_CHARACTER_SHEET")==0){
            return GetCharacterSheet.getCharacterSheet(object);
        }
        return FailureResponse.unknown();
    }

}