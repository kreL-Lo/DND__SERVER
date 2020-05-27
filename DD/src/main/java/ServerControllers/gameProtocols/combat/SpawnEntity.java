package ServerControllers.gameProtocols.combat;

import com.sun.org.apache.regexp.internal.RE;
import controllers.LobbyController;
import controllers.NPCController;
import models.DM;
import models.Lobby;
import models.NPC;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

public class SpawnEntity {
    //SPAWN_ENTITY
    public static JSONObject spawnEntity(JSONObject object){
        //chibi golem skeleton imp parca
        String entity= null;
        String roomName=null;
        String idMob=null;
        int health=0;
        int dmg = 0;
        try {
            idMob= object.get("ID").toString();
            entity= object.get("ENTITY").toString();//CH
            roomName = object.get("ROOM_NAME").toString();
            health = Integer.valueOf(object.get("HEALTH").toString());
        }catch (Exception e){
            return  failed();
        }
        try {
            Lobby l = LobbyController.findByName(roomName);

            NPC npc = null;
            if (entity.compareTo("IMP") == 0) {
                npc = NPCController.createNPCImp();
            } else if (entity.compareTo("SKELETON") == 0) {
                npc = NPCController.createNPCSkeleton();
            } else if (entity.compareTo("GOLEMN") == 0) {//GOLEMN= GOLEM CUZ BUGS FROM FRONT
                npc = NPCController.createNPCIronGolem();
            } else if (entity.compareTo("CHIBI") == 0) {
                npc = NPCController.createNPCIronGolem();
            }
            npc.setId(idMob);
            npc.setHitPoints(health);
            DM dm = l.getDm();
            List<NPC> npcList = dm.getNpcs();
            npcList.add(npc);
            dm.setNpcs(npcList);
            l.setDm(dm);
            LobbyController.update(l);
        }
        catch (Exception e){
            return taskFailled();
        }

        return success();
    }


    static JSONObject failed(){
        JSONObject object= new JSONObject();
        object.put("PROTOCOL","SPAWN_ENTITY");
        object.put("ANSWER","EXCEPTION, WRONG INPUT");
        object.put("SUCCESS",0);
        return object;
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
