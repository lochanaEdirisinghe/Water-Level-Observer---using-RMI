/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observable;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import observer.WaterLevelObserver;

/**
 *
 * @author niroth
 */
public class WaterLevelObservable {
    private ArrayList<WaterLevelObserver> observers = new ArrayList<>();
    private int waterLevel;

    public void addWaterLevelObserver(WaterLevelObserver waterLevelObserver){
        observers.add(waterLevelObserver);
    }
    public void removeWaterLevelObserver(WaterLevelObserver waterLevelObserver){
        observers.remove(waterLevelObserver);
    }

    public void setWaterLevel(int waterLevel) throws RemoteException {
        if (this.waterLevel != waterLevel) {
            this.waterLevel = waterLevel;
            notifyWaterLevelObservers();
        }
    }
    private void notifyWaterLevelObservers() throws RemoteException {
        for (WaterLevelObserver observer : observers) {
            new Thread(){
                public void run(){
                    try {
                        observer.update(waterLevel);
                    } catch (RemoteException ex) {
                        Logger.getLogger(WaterLevelObservable.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
        }
    }
}
