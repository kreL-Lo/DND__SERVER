package ServerControllers.gameProtocols.combat;

import com.mongodb.util.JSON;
import controllers.LobbyController;
import models.Character;
import models.DM;
import models.Lobby;
import models.NPC;
import org.json.simple.JSONObject;
import sun.security.ssl.HandshakeInStream;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class AttackProtocol {
    public static JSONObject attackProtocol(JSONObject jsonObject){
        System.out.println("HERERERE");
        JSONObject obj=null;
        int attacker;
        try{

            attacker = Integer.valueOf (jsonObject.get("ATTACKER").toString());
        }catch (Exception e){
            return failed();
        }

        try {
            if (attacker == 1){//player turn
                System.out.println("PLAYER");
                obj = attacker_PLAYER(jsonObject);
                if(obj==null){
                    throw  null;
                }
            }
            else {
                System.out.println("DM");
                obj=  attacker_NPC(jsonObject);
                if(obj==null){
                    throw  null;
                }
            }

        }
        catch (Exception e ){
            return serverError();
        }

        System.out.println(obj.toJSONString());
        return success(obj);
    }


    static JSONObject success(JSONObject object){
        object.put("PROTOCOL","ATTACK_PROTOCOL");
        object.put("ANSWER","ATTACK DONE ");
        object.put("SUCCESS",1);
        return object;
    }


    static JSONObject failed(){
        JSONObject object= new JSONObject();
        object.put("PROTOCOL","ATTACK_PROTOCOL");
        object.put("ANSWER","BAD INPUT");
        object.put("SUCCESS",0);
        return object;
    }

    static JSONObject serverError (){
        JSONObject object= new JSONObject();
        object.put("PROTOCOL","ATTACK_PROTOCOL");
        object.put("ANSWER","SOME ERROR WITH CODE");
        object.put("SUCCESS",0);
        return object;
    }









    private static JSONObject attacker_NPC(JSONObject jsonObject){//adica dm
        JSONObject object = new JSONObject();
        String playerName, roomName,target;
        try {
            playerName = jsonObject.get("PLAYER_NAME").toString();//dm
            roomName = jsonObject.get("ROOM_NAME").toString();
            target = jsonObject.get("TARGET").toString();//player
        }
        catch (Exception e){
            return  null;
        }
        System.out.println("NPCC_1111");
        try{
            Lobby l = LobbyController.findByName(roomName);

            DM dm = l.getDm();
            List<NPC> npcList = dm.getNpcs();
            NPC npc=null;
            for(NPC np: npcList){
                if(np.getId().compareTo(playerName)==0){
                    npc =np;
                    break;
                }
            }
            int dice = 1 + (int)(Math.random()*20) +1;
            Character c= l.getUserFromList(target).getCharacter();
            int hitpoints = c.getHitPointMaximum();
            System.out.println(hitpoints);
            if(dice<c.getArmourClass()){
                JSONObject ob = new JSONObject();
                ob.put("TARGET",playerName);
                ob.put("HITPOINTS", hitpoints);
                ob.put("ROLL",dice);
                ob.put("HIT",0);
                return ob;
            }
            hitpoints =hitpoints-dice;
            c.setHitPointMaximum(hitpoints);
            JSONObject ob = new JSONObject();
            ob.put("TARGET",playerName);
            ob.put("HITPOINTS", hitpoints);
            ob.put("ROLL",dice);
            ob.put("HIT",1);
            return ob;

        }catch (
                Exception e
        ){
            return null;
        }
    }


    private static JSONObject attacker_PLAYER(JSONObject jsonObject){
        JSONObject object = new JSONObject();
        String playerName, roomName,target;
        try {
            playerName = jsonObject.get("PLAYER_NAME").toString();
            roomName = jsonObject.get("ROOM_NAME").toString();
            target = jsonObject.get("TARGET").toString();//the mob
        }
        catch (Exception e){
            return  null;
        }
        System.out.println("PLAYER_1111");

        try{
            Lobby l = LobbyController.findByName(roomName);
            l.findUser(playerName);
            DM dm = l.getDm();
            List<NPC> npcList = dm.getNpcs();
            NPC npc=null;
            for(NPC np: npcList){
                if(np.getId().compareTo(target)==0){
                    npc =np;
                    break;
                }
            }


            int dice = 1 + (int)(Math.random()*20) +1;
            int hitpoints = npc.getHitPoints();
            if(dice<npc.getArmourClass()){
                JSONObject ob = new JSONObject();
                ob.put("TARGET",target);
                ob.put("HITPOINTS", hitpoints);
                ob.put("ROLL",dice);
                ob.put("HIT",0);
                return ob;
            }
            System.out.println("ffff");
            hitpoints = hitpoints-dice;
            if(hitpoints<1){
                npcList.remove(npc);
            }
            npc.setHitPoints(hitpoints);
            dm.setNpcs(npcList);
            l.setDm(dm);
            LobbyController.update(l);
            System.out.println(hitpoints);
            JSONObject send = new JSONObject();
            send.put("HIT",1);
            send.put("TARGET",target);
            send.put("HITPOINTS", hitpoints);
            send.put("ROLL",dice);
            return  send;
        }catch (Exception e){
            return  null;
        }

    }
}



