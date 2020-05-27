package models;
import java.util.ArrayList;
import java.util.List;

public class Lobby {
    String name;
    String id;
    DM dm;
    String dungeonMaster;
    int maxPlayersLimit;
    int nrPlayers = 0;
    List<User> userList= new ArrayList<User>();

    public void setDm(DM dm) {
        this.dm = dm;
    }

    public DM getDm() {
        return dm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDungeonMaster() {
        return dungeonMaster;
    }

    public void setDungeonMaster(String dungeonMaster) {
        this.dungeonMaster = dungeonMaster;
    }

    public int getMaxPlayersLimit() {
        return maxPlayersLimit;
    }

    public void setMaxPlayersLimit(int maxPlayersLimit) {
        this.maxPlayersLimit = maxPlayersLimit;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void setNrPlayers(int nrPlayers) {
        this.nrPlayers = nrPlayers;
    }

    public int getNrPlayers() {
        return nrPlayers;
    }

    public User findUser(String name){
        for(User user : userList){
            if(user.getUsername().compareTo(name)==0){
                return user;
            }
        }
        return null;
    }
    public void removeUser(User user){
        userList.remove(user);
    }
    public User getUserFromList(String name){
        for (User usr : userList){
            if(usr.getUsername().compareTo(name)==0){
                return usr;
            }
        }
        return null;
    }
}