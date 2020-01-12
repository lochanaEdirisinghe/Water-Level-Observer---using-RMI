/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connector;

import controller.WaterLevelController;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author Lochana
 */
public class ServerConnector {
    private WaterLevelController waterLevelController;
    private static  ServerConnector serverConnector;
    private ServerConnector() throws NotBoundException, MalformedURLException, RemoteException{
        waterLevelController=(WaterLevelController) Naming.lookup("rmi://localhost:5051/WaterLevelServer");
    }
    
    public static  ServerConnector getInstance() throws NotBoundException, MalformedURLException, RemoteException{
        if(serverConnector==null){
            serverConnector=new ServerConnector();
        }
        return serverConnector;
    }
    public WaterLevelController getWaterLevelController(){
        return waterLevelController;
    } 
}
