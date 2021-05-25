/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oem
 */
public class Main {
    public static void main(String[] args){
        Coache coache=new Coache();
        Team team=new Team(coache);
        Players player=new Players();
        Medal medal =new Medal();
        Game game=new Game(coache);
        
    }
}
