/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import observer.WaterLevelObserver;
import view.AlarmWindow;
import view.WaterLevelStter;

/**
 *
 * @author niroth
 */
public class WaterLevelObserverImpl extends UnicastRemoteObject implements WaterLevelObserver{
    private WaterLevelStter waterLevelStter;
    public WaterLevelObserverImpl(WaterLevelStter waterLevelStter) throws RemoteException{
        this.waterLevelStter=waterLevelStter;
    }
   @Override
    public void update(int waterLevel) throws RemoteException {
            waterLevelStter.setWaterLevel(waterLevel);
    }
}
