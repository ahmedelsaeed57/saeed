/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oem
 */
public class Team {
    private String name;
    Coache coache ;
    Players player;
    public void setName(String x){
        name=x;
}
    public String getName(){
        return name;
    }
    public Team(Coache c){
        coache=c;
        player=new Players();
    }
}
