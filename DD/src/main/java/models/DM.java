package models;

import java.util.ArrayList;
import java.util.List;

public class DM {
    String username;
    CombatMode combatMode;
    List<NPC> npcs = new ArrayList<>();
    public void setCombatMode(CombatMode combatMode) {
        this.combatMode = combatMode;
    }

    public CombatMode getCombatMode() {
        return combatMode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNpcs(List<NPC> npcs) {
        this.npcs = npcs;
    }

    public List<NPC> getNpcs() {
        return npcs;
    }
    public NPC findNpc(String id){
        for (NPC npc : npcs) {
            if (npc.getId().compareTo( id)==0) {
                return npc;
            }
        }
        return null;
    }
}
