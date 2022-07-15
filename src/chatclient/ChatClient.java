/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chatclient;

import chat.ChatInterface;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import view.Login;

/**
 *
 * @author shenugayana
 */
public class ChatClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {        
            Registry registry = LocateRegistry.getRegistry("localhost", 9999);
            ChatInterface chat = (ChatInterface)registry.lookup("chatServer");  //getting a remote reference       
            new Login(chat);  //pass the reference as a parameter 
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
    
}
