/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oem
 */

public class OlympicDelegation {
    private String name;
    private int id;
    Players player ;
    Coache coache;
    public void setName(String x){
        name=x;
}
    public String getName(){
        return name;
    }
    public OlympicDelegation(Coache c){
         player = new Players();
         coache=c;
        
    }

}
